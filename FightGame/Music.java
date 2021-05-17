package FightGame;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music {
	static{//mp3初始化
		try {
			FileInputStream in=new FileInputStream("src/RISE.mp3");//输入流
			BufferedInputStream bis=new BufferedInputStream(in);//缓冲流
			Player p=new Player(bis);
			//System.out.println("正在播放:Victory.mp3...");
			p.play();
		} catch (Exception e) {
			//e.printStackTrace();//日志跟踪
			throw new RuntimeException("加载音乐失败...");
		}
		
	}
	
	/*public static void main(String[] args) {
		new Music();
	}*/
}
