package day09;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 用睡眠阻塞状态实现图片切换
 * @author 24742
 *
 */
public class SleepDemo02 {
     public static void main(String[] args) {
		JFrame frame=new JFrame();//相框
		frame.setSize(400, 400);
		JPanel  panel=new JPanel();//面板
		panel.setSize(400, 400);
		frame.setContentPane(panel);//把面板放入到相框中
		frame.setVisible(true);//设置相框可见性
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击关闭按钮同时关闭程序
		Thread t1=new Thread(){
			public void run(){
				int i=0;
				while(true){
					
					i=i==0?1:0;
					
					try {
						if(i==1){
							panel.setBackground(Color.RED);
						}else{
							panel.setBackground(Color.BLUE);
						}
						Thread.sleep(5000);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
					
				}
			}
		};
		t1.start();
	}
}
