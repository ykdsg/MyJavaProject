package com.yk.groovy;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wuzheng.yk on 2017/6/27.
 */
public class DynamicGroovyScript {
    /**
     * 规则集以及每个指标项的计算脚本
     * @return
     */
    private DataObject getRuleset(){
        DataObject ruleSet = new DataObject();

        ruleSet.xput("规则集.基础信息.是否90后", "student.birth >= '1990/01/01'?'是':'否'");
        ruleSet.xput("规则集.基础信息.性别", "student.gender == 'M' ? '男' : '女'");
        ruleSet.xput("规则集.基础信息.注册天数", "to_date(today) - to_date(student.createTime)");
        ruleSet.xput("规则集.基础信息.地区", areaScript());
        ruleSet.xput("规则集.评级.学费档次", "tuitionFee>=60000?'A':(tuitionFee>=40000&&tuitionFee<60000?'B':(tuitionFee>=20000&&tuitionFee<40000)?'C':'D')");
        ruleSet.xput("规则集.评级.收入档次", incomeScript());
        ruleSet.xput("规则集.学习情况.总学时", totalHoursScript());
        ruleSet.xput("规则集.学习情况.迟到次数", delayTimes());
        ruleSet.xput("规则集.学习情况.出勤次数", "student.extra.attendanceLog.size()");
        ruleSet.xput("规则集.学习情况.单门课程最长学时", maxCourseHours());

        return ruleSet;
    }
    /**
     * 业务原始数据
     * @return
     */
    private DataObject getBusinessData(){
        DataObject businessData = new DataObject();

        businessData.xput("collegeName", "EMBA业余大学");
        businessData.xput("tuitionFee", 80000);
        businessData.xput("startDate", "2016/02/01");
        businessData.xput("finishDate", "2016/09/01");
        businessData.xput("today", "2017/01/21");
        //下一层级的学生对象
        businessData.xput("student.id", "E9527");
        businessData.xput("student.name", "于小小");
        businessData.xput("student.gender", "F");
        businessData.xput("student.kind", "EMBA");
        businessData.xput("student.className", "重庆理工大学MBA三年级四班");
        businessData.xput("student.grade", 4);
        businessData.xput("student.birth", "1989/03/02");
        businessData.xput("student.address", "重庆市巴南区红光大道");
        businessData.xput("student.salary", 50000);
        businessData.xput("student.createTime", "2016/01/21 11:31:00");
        businessData.xput("student.courses", getCourses());
        businessData.xput("student.mainInstructor", null);
        businessData.xput("student.extra.attendanceLog", getAttendanceLog());

        return businessData;
    }

    public static void main(String[] args) throws javax.script.ScriptException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("groovy");
        Bindings variables = engine.createBindings();

        DynamicGroovyScript ins = new DynamicGroovyScript();
        DataObject businessData = ins.getBusinessData();
        variables.putAll(businessData);

        DataObject ruleSet = ins.getRuleset();
//		System.out.println(ruleSet.getJSONString());

//		System.out.println(engine.eval("student.birth >= '1990/01/01'?'是':'否'",variables));
        Iterator<String> iterator = ruleSet.xpathKeyIterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            Object value = ruleSet.getObject(key);
            if(!(value instanceof String))continue;
            String script = (String)value;
            if(script == null||script.replaceAll("\\s+", "").length()==0)continue;
            engine.eval(ins.getGlobleScript(""));	//先执行下，把全局函数放进去
//			System.out.println(key+"="+value+" --->值:["+engine.eval(script,variables)+"]");
            System.out.println(key+"="+engine.eval(script,variables));
        }
    }

    private List<String> getAttendanceLog(){
        List<String> list = new ArrayList<String>();

        list.add("2016/02/01 09:00:02");
        list.add("2016/02/03 08:50:03");
        list.add("2016/02/15 09:12:34");
        list.add("2016/04/01 07:30:11");

        return list;
    }

    private DataObject[] getCourses(){
        DataObject[] courses = new  DataObject[]{
                new DataObject(),
                new DataObject(),
                new DataObject(),
                new DataObject(),
                new DataObject(),
                new DataObject(),
        };
        courses[0].xput("id", "GJC");
        courses[0].xput("name", "公共基础");
        courses[0].xput("classHour", 32);

        courses[1].xput("id", "ZXW");
        courses[1].xput("name", "组织行为学");
        courses[1].xput("classHour", 40);

        courses[2].xput("id", "TJX");
        courses[2].xput("name", "统计学");
        courses[2].xput("classHour", 20);

        courses[3].xput("id", "CJR");
        courses[3].xput("name", "财务与金融");
        courses[3].xput("classHour", 60);

        courses[4].xput("id", "JJF");
        courses[4].xput("name", "经济法");
        courses[4].xput("classHour", 48);

        courses[5].xput("id", "JSJ");
        courses[5].xput("name", "计算机技能");
        courses[5].xput("classHour", 16);
        return courses;
    }

    private String areaScript(){
        StringBuilder execScript = new StringBuilder();
        execScript.append("({").append("\n");
        execScript.append("    def province = student.address.subSequence(0,3)").append("\n");
        execScript.append("    def areaMapping = ['西南':['重庆市','四川省','贵州省','云南省'],'江浙沪':['上海市','江苏省','浙江省'],'京津冀':['北京市','天津市','河北省']]").append("\n");
        execScript.append("    def entry = areaMapping.find {key,value -> ").append("\n");
        execScript.append("        value.contains(province)").append("\n");
        execScript.append("    }").append("\n");
        execScript.append("    entry.key").append("\n");
        execScript.append("})()").append("\n");

        return execScript.toString();
    }
    private String incomeScript(){
        StringBuilder execScript = new StringBuilder();
        execScript.append("({").append("\n");
        execScript.append("    if(student.salary>=20000) '高收入'").append("\n");
        execScript.append("    else if(student.salary>=10000) '中等收入'").append("\n");
        execScript.append("    else if(student.salary>=5000) '一般收入'").append("\n");
        execScript.append("    else '低收入'").append("\n");
        execScript.append("})()").append("\n");

        return execScript.toString();
    }
    private String totalHoursScript(){
        StringBuilder execScript = new StringBuilder();
        execScript.append("({").append("\n");
        execScript.append("    int totalHourse = 0;").append("\n");
        execScript.append("    student.courses.each { totalHourse += it.classHour}").append("\n");
        execScript.append("    totalHourse").append("\n");
        execScript.append("})()").append("\n");

        return execScript.toString();
    }
    private String delayTimes(){
        StringBuilder execScript = new StringBuilder();
        execScript.append("({").append("\n");
        execScript.append("    int _count = 0").append("\n");
        execScript.append("    student.extra.attendanceLog.each {").append("\n");
        execScript.append("    Date _date = to_date(it)").append("\n");
        execScript.append("    _count += (_date.hours>=9&&_date.seconds>=1)?1:0").append("\n");
        execScript.append("    }").append("\n");
        execScript.append("    _count").append("\n");
        execScript.append("})()").append("\n");

        return execScript.toString();
    }
    private String maxCourseHours(){
        StringBuilder execScript = new StringBuilder();
        execScript.append("({").append("\n");
        execScript.append("    int maxHour = 0;").append("\n");
        execScript.append("    student.courses.each { maxHour = Math.max(maxHour,it.classHour)}").append("\n");
        execScript.append("    student.courses.find({it.classHour == maxHour}) //默认最后一句为返回值").append("\n");
        execScript.append("})()").append("\n");

        return execScript.toString();
    }


    public String getGlobleScript(String script){
        StringBuilder execScript = new StringBuilder();
        //增加一个日期处理方法
        execScript.append("import java.text.SimpleDateFormat").append("\n");
        execScript.append("import java.text.ParseException").append("\n");

        execScript.append("def to_date(_date){").append("\n");
        execScript.append("    try{").append("\n");
        execScript.append("        return (new SimpleDateFormat(\"yyyy/MM/dd hh:mm:ss\")).parse(_date);").append("\n");
        execScript.append("    }catch(ParseException e){").append("\n");
        execScript.append("        return (new SimpleDateFormat(\"yyyy/MM/dd\")).parse(_date);").append("\n");
        execScript.append("    }").append("\n");
        execScript.append("}").append("\n");

        execScript.append(script);

        return execScript.toString();
    }
}
