package day09;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * ��˯������״̬ʵ��ͼƬ�л�
 */
public class SleepDemo2 {
	public static void main(String[] args) {
		JFrame rame=new JFrame();//���
		rame.setSize(350,350);//��С
		JPanel panel=new JPanel();//���
		panel.setSize(350,350);
		rame.setContentPane(panel);//�����ŵ������
		rame.setVisible(true);//�������ɼ�
		//����رհ�ťͬʱ�رճ���
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
		//����
		t.start();
	}
}
