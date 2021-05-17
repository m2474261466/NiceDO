package FightGame;

import java.awt.image.BufferedImage;

/**
 * 子弹
 * @author Lenovo
 *
 */
public class Bullet extends FlyingObject{
	private int speed;
	public static BufferedImage image;//子弹图片
	
	static{
		image=loadImage("bullet.png");
		//System.out.println("子弹图片"+image);
	}
	
	public Bullet(int x,int y){
		super(8, 20, x, y);
		speed=3;
	}
	
	//移动
	public void step(){
		y-=speed;
		//System.out.println("子弹移动了"+y);
	}
	
	/**根据不同的状态获取子弹的图片*/
	public BufferedImage getImage(){
		if(isLife()){
			//System.out.println("活着");
			return image;
		}else if(isDead()){
			//System.out.println("移除");
			state=REMOVE;
		}
		return null;
	}

	/**检测子弹是否越界*/
	public boolean flyingObjectOut() {
		return this.y<=-this.height;//越界(y<=子弹负高度)
	}
	
}
