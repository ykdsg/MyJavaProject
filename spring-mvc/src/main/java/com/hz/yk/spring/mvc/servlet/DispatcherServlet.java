package com.hz.yk.spring.mvc.servlet;

import com.hz.yk.spring.mvc.annotation.Autowired;
import com.hz.yk.spring.mvc.annotation.Controller;
import com.hz.yk.spring.mvc.annotation.RequestMapping;
import com.hz.yk.spring.mvc.annotation.RequestParam;
import com.hz.yk.spring.mvc.annotation.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName DispatcherServlet
 * Description DispatcherServlet
 * Author xiaoshami
 * Date 2018/8/9 下午4:51
 **/
public class DispatcherServlet extends HttpServlet {

    private static final long       serialVersionUID = -5472999334387491873L;
    private              Properties properties       = new Properties();

    private List<String> classNames = new ArrayList<String>();

    // IOC容器， 说到底是一个Map
    private Map<String, Object> ioc = new HashMap<String, Object>();

    // 存放handlerMapping
    private List<Handler> handlerMapping = new ArrayList<Handler>();

    // 初始化阶段调用的方法
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("------ DispatcherServlet init -------");

        // 1、加载配置文件
        doLoad(config.getInitParameter("contextConfigLocation"));

        // 2、根据配置文件扫描所有的相关的类
        doScanner(properties.getProperty("scanPackage"));

        // 3、初始化所有的相关的类的实例，并且将其放入到IOC容器中，也就是Map
        doInstance();

        // 4、自动实现依赖注入
        doAutowrited();

        // 5、初始化HandlerMapping
        initHandlerMapping();
    }

    // 1、建立 客户端(浏览器等等) 输入的url与controller中方法的映射关系
    private void initHandlerMapping() {
        // 判断ioc容器是否为空
        if (ioc.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            // 获取类对应的Class实例
            Class<?> clazz = entry.getValue().getClass();
            // 如果不是一个controller的话
            if (!clazz.isAnnotationPresent(Controller.class)) {
                continue;
            }
            // 如果Controller存在被RequestMapping注解的话
            String baseUrl = "";
            if (clazz.isAnnotationPresent(RequestMapping.class)) {
                RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
                baseUrl = requestMapping.value();
            }
            // 获取所有方法
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                // 判断方法有没有被RequestMapping注解修饰
                if (!method.isAnnotationPresent(RequestMapping.class)) {
                    continue;
                }

                // 映射url
                RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                // 封装url(在Spring中，这里还可以是正则)
                String regix = ("/" + baseUrl + requestMapping.value()).replaceAll("/+", "/");
                Pattern pattern = Pattern.compile(regix);
                handlerMapping.add(new Handler(pattern, entry.getValue(), method));
                System.out.println("mapping " + regix + "," + method);
            }

        }
    }

    // 依赖注入 (获取ioc容器中的每一个类中的所有字段 判断是不是用Autowrited注解声明 如果声明，则将字段的属性设置成该字段对应的实例)
    private void doAutowrited() {
        // 如果IOC为空的话
        if (ioc.isEmpty()) {
            return;
        }
        // 遍历IOC容器中所有的对象
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            // 1、第一步首先要获取到所有的字段 fields
            // 获取所有字段 无论是用private修饰的还是protected修饰的还是default修饰的
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(Autowired.class)) { // 如果不是Autowrited
                    continue;
                }

                Autowired autowired = field.getAnnotation(Autowired.class);
                String beanName = autowired.value().trim();
                if ("".equals(beanName)) { // 如果是默认值的话，那么只可能是接口
                    beanName = field.getType().getName();
                }

                // 要想访问到私有的，或者受保护的，那么需要强制授权访问
                field.setAccessible(true);

                try {
                    // entry.getValue(): 应该修改字段的对象  value: 字段的新值
                    field.set(entry.getValue(), ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }

    }

    // 初始化IOC容器 (利用反射 将之间扫描到的类都实例化，并放入到IOC容器中 前提是得用指定接口声明)
    private void doInstance() {
        // 如果文件为空, 则什么都不做
        if (classNames.isEmpty()) {
            return;
        }

        // 如果不为空，利用反射机制，将刚刚扫描进来的所有的className全部初始化
        try {
            for (String className : classNames) {
                Class<?> clazz = Class.forName(className);

                // 进行Bean的实例化,初始化IOC容器
                // 如果不是用注解声明的类，则不做初始化

                // IOC容器规则:
                // 1、key的话默认用类名首字母小写
                // 2、如果注解使用了自定义名字，那么要优先选择用自定义名字
                // 3、如果是接口的话，可以用接口的类型作为key (要点)

                // 判断是不是被Controller注解修饰了
                if (clazz.isAnnotationPresent(Controller.class)) {
                    String beanName = lowerFristCase(clazz.getSimpleName());
                    // 实例化(存入到IOC容器中)
                    ioc.put(beanName, clazz.newInstance());
                } else if (clazz.isAnnotationPresent(Service.class)) {
                    Service service = clazz.getAnnotation(Service.class);
                    String beanName = service.value();

                    // 如果注解使用了自定义名字，那么要优先选择用自定义名字
                    if ("".equals(beanName.trim())) { // 如果是默认值
                        beanName = lowerFristCase(clazz.getSimpleName());
                    }
                    // 实例化(存入到IOC容器中)
                    Object instance = clazz.newInstance();
                    ioc.put(beanName, instance);

                    // 如果类实现了接口的话
                    Class<?>[] interfaces = clazz.getInterfaces();
                    for (Class<?> i : interfaces) {
                        // 将接口的类型作为key
                        // 因为在Controller中，会使用 @Autowrited XXService xxService 这样的方式 所以我们要对接口类型也注入对应的实现类
                        ioc.put(i.getName(), instance);
                    }
                } else {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 把字符串的首字母小写
    private String lowerFristCase(String str) {
        char[] chars = str.toCharArray();
        // 把首字母变成大写，再放回去
        chars[0] += 32;
        return String.valueOf(chars);
    }

    // 递归扫描指定包下面的所有文件，并且存入到classNames中去
    private void doScanner(String packageName) {
        // 进行递归扫描
        URL url = this.getClass().getResource("/" + packageName.replaceAll("\\.", "/"));
        // 得到文件夹
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            // 如果是一个文件夹的话，继续递归
            if (file.isDirectory()) {
                doScanner(packageName + "." + file.getName());
            } else {
                // 如果是一个文件的话
                String className = packageName + "." + file.getName().replace(".class", "");
                classNames.add(className);
            }
        }
    }

    // 加载配置文件
    private void doLoad(String location) {

        InputStream in = this.getClass().getClassLoader().getResourceAsStream(location);
        // 将所有的信息都存入到properties中
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 让浏览器用utf-8来解析返回的数据
        resp.setContentType("text/html;charset=UTF-8");
        // 让servlet用UTF-8转码，而不是用默认的ISO8859
        resp.setCharacterEncoding("UTF-8");
        this.doPost(req, resp);
    }

    // 6、等待请求，进入运行阶段
    // 运行时阶段调用的方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            // 如果匹配信息出现异常，那么将异常信息打印出去
            resp.getWriter().write("500 Exception Details: \r\n"
                                   + Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]", "").replaceAll(",\\s", "\r\n"));
        }

    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        try {
            Handler hander = getHandler(req);

            // 如果没有匹配到 并且不是根路径
            if (hander == null) {
                // 如果没有匹配上，返回404错误
                resp.getWriter().write("404 NOT FOUND");
                return;
            }

            // 获取方法的参数列表
            Class<?>[] paramTypes = hander.method.getParameterTypes();

            // 保存所有需要自动赋值的参数值
            Object[] paramValues = new Object[paramTypes.length];

            // 这是属于J2EE中的内容
            Map<String, String[]> params = req.getParameterMap();

            for (Map.Entry<String, String[]> param : params.entrySet()) {
                String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "");

                // 如果找到匹配的对象，则开始充填参数值
                if (!hander.paramIndexMapping.containsKey(param.getKey())) {
                    continue;
                }
                int index = hander.paramIndexMapping.get(param.getKey());
                paramValues[index] = convert(paramTypes[index], value);
            }

            // 设置方法中的request 和 response 对象
            int reqIndex = hander.paramIndexMapping.get(HttpServletRequest.class.getName());
            paramValues[reqIndex] = req;
            int respIndex = hander.paramIndexMapping.get(HttpServletResponse.class.getName());
            paramValues[respIndex] = resp;

            hander.method.invoke(hander.controller, paramValues);

        } catch (Exception e) {
            throw e;
        }

    }

    private Object convert(Class<?> paramType, String value) {

        if (Integer.class == paramType) {
            return Integer.valueOf(value);
        }

        return value;
    }

    private Handler getHandler(HttpServletRequest req) throws Exception {

        if (handlerMapping.isEmpty()) {
            return null;
        }

        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        // 获取相对路径
        url = url.replace(contextPath, "").replaceAll("/+", "/");

        for (Handler handler : handlerMapping) {
            try {
                Matcher matcher = handler.pattern.matcher(url);
                // 如果没有匹配上继续下一个匹配
                if (!matcher.matches()) {
                    continue;
                }
                return handler;
            } catch (Exception e) {
                throw e;
            }
        }
        return null;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    // 内部类 记录Controller中的RequestMapping和Method的对应关系
    private class Handler {

        protected Object               controller; // 保存方法对应的实例 也就是xxController实例
        protected Method               method; // 保存映射方法
        protected Pattern              pattern; // url(包括正则表达式)
        protected Map<String, Integer> paramIndexMapping; // 参数顺序

        /**
         * 构造一个Handler基本的参数
         *
         * @param pattern
         * @param controller
         * @param method
         */
        protected Handler(Pattern pattern, Object controller, Method method) {
            this.pattern = pattern;
            this.controller = controller;
            this.method = method;

            paramIndexMapping = new HashMap<String, Integer>();
            putparamIndexMapping(method);
        }

        private void putparamIndexMapping(Method method) {

            // 提取方法中加了注解的参数
            Annotation[][] pa = method.getParameterAnnotations();
            for (int i = 0; i < pa.length; i++) {
                for (Annotation annotation : pa[i]) {
                    if (annotation instanceof RequestParam) {
                        String paramName = ((RequestParam) annotation).value();
                        if (!"".equals(paramName.trim())) {
                            paramIndexMapping.put(paramName, i);
                        }
                    }
                }
            }

            // 提取方法中的request和response参数
            Class<?>[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                Class<?> type = paramTypes[i];
                if (type == HttpServletRequest.class || type == HttpServletResponse.class) {
                    paramIndexMapping.put(type.getName(), i);
                }
            }
        }
    }

}

