package net.zj.hz.yk.listener.awt;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionTest {
	private static JFrame frame; // 定义为静态变量以便main使用
	private static JPanel myPanel; // 该面板用来放置按钮组件
	private JButton button1; // 这里定义按钮组件

	public ActionTest() { // 构造器, 建立图形界面
		// 新建面板
		myPanel = new JPanel();
		// 新建按钮
		button1 = new JButton("按钮1"); // 新建按钮1
		// 建立一个actionlistener让按钮1注册，以便响应事件
		SimpleListener ourListener = new SimpleListener();
		button1.addActionListener(ourListener);
		myPanel.add(button1); // 添加按钮到面板

	}

	public static void main(String s[]) {
		ActionTest gui = new ActionTest(); // 新建Simple1组件
		frame = new JFrame("Simple1"); // 新建JFrame
		// 处理关闭事件的通常方法
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(myPanel);
		frame.pack();
		frame.setVisible(true);
	}
}
