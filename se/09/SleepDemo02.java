package day09;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ��˯������״̬ʵ��ͼƬ�л�
 * @author 24742
 *
 */
public class SleepDemo02 {
     public static void main(String[] args) {
		JFrame frame=new JFrame();//���
		frame.setSize(400, 400);
		JPanel  panel=new JPanel();//���
		panel.setSize(400, 400);
		frame.setContentPane(panel);//�������뵽�����
		frame.setVisible(true);//�������ɼ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����رհ�ťͬʱ�رճ���
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
