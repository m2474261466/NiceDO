package day09;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * 用睡眠阻塞状态实现图片切换
 */
public class SleepDemo2 {
	public static void main(String[] args) {
		JFrame rame=new JFrame();//相框
		rame.setSize(350,350);//大小
		JPanel panel=new JPanel();//面板
		panel.setSize(350,350);
		rame.setContentPane(panel);//把面板放到相框中
		rame.setVisible(true);//设置相框可见
		//点击关闭按钮同时关闭程序
		rame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread t=new Thread(){
			public void run(){
				int i=0;
				while(true){
					i=i==0?1:0;
					try {
						Thread.sleep(500);
						if(i==0){
							panel.setBackground(Color.BLACK);
						}else{
							panel.setBackground(Color.green);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		//启动
		t.start();
	}
}
