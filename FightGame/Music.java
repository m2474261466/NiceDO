package FightGame;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music {
	static{//mp3��ʼ��
		try {
			FileInputStream in=new FileInputStream("src/RISE.mp3");//������
			BufferedInputStream bis=new BufferedInputStream(in);//������
			Player p=new Player(bis);
			//System.out.println("���ڲ���:Victory.mp3...");
			p.play();
		} catch (Exception e) {
			//e.printStackTrace();//��־����
			throw new RuntimeException("��������ʧ��...");
		}
		
	}
	
	/*public static void main(String[] args) {
		new Music();
	}*/
}
