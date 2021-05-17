package FightGame;

import java.awt.image.BufferedImage;

/**
 * 大敌机
 * @author Lenovo
 *
 */
public class BigAirplane extends FlyingObject implements Score{
	private int speed;
	public static BufferedImage image;//大敌机图片
	public static BufferedImage[] bomsImages;//爆炸后的效果图
	
	static{//加载大敌机图片和爆炸后的效果图
		image=loadImage("BigAriplane.png");
		//System.out.println("大敌机图片"+image);
		
		bomsImages=new BufferedImage[6];
		for(int i=0;i<bomsImages.length;i++){
			bomsImages[i]=loadImage("boms"+i+".png");
			//System.out.println("第"+i+"图片:"+bomsImages[i]);
		}
	}
	
	
	public BigAirplane(){
		super(94, 84);
		speed=2;
	}
	
	//移动
	public void step(){
		y+=speed;
		//System.out.println("大敌机移动了"+y+",x移动了"+x);
	}
	
	/**根据不同的状态获取大敌机不同的图片*/
	int bomsIndex=0;//死掉状态下标
	public BufferedImage getImage(){
		if(isLife()){
			//System.out.println("活着");
			return image;
		}else if(isDead()){
			BufferedImage img=bomsImages[bomsIndex++];
			if(bomsIndex==bomsImages.length){
				state=REMOVE;
				//System.out.println("移除");
			}
			//System.out.println("死掉");
			return img;
		}
		return null;
	}

	public int getScore() {
		return Score.THREE;
	}

	/**检测大敌机是否越界*/
	public boolean flyingObjectOut() {
		return this.y>=World.HEIGHT;//越界
	}
	
}
