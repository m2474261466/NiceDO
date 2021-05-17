package FightGame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 天空
 * @author Lenovo
 *
 */
public class Sky extends FlyingObject{
	private int y1;
	private int speed;
	public static BufferedImage image;//天空(背景图)
	
	static{
		image=loadImage("bg1.png");
		//System.out.println("天空图片"+image);
	}
	
	public Sky(){
		super(World.WIDTH, World.HEIGHT, 0, 0);
		y1=-this.height;
		speed=1;
	}
	
	public void step(){
		y+=speed;
		y1+=speed;
		if(y>=World.HEIGHT){//y坐标大于窗口高度
			y=-this.height;
		}
		if(y1>=World.HEIGHT){//y1坐标大于窗口高度
			y1=-this.height;
		}
		//System.out.println("天空的y移动了"+y+",天空的y1移动了"+y1);
	}
	
	/**状态获取天空(背景)的图片*/
	public BufferedImage getImage(){
		//System.out.println("存在");
		return image;
	}
	
	/**天空重写方法(目的把y1也要画上)*/
	public void paintObject(Graphics g){
		g.drawImage(getImage(), this.x, this.y, null);
		g.drawImage(getImage(), this.x, this.y1, null);
		
	}

	/**天空不越界*/
	public boolean flyingObjectOut() {
		return false;//不越界
	}
	
	
}
