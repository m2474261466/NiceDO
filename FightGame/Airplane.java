package FightGame;

import java.awt.image.BufferedImage;

/**
 * 小敌机
 * @author Lenovo
 *
 */
public class Airplane extends FlyingObject implements Score{
	private int speed;	//速度
	public static BufferedImage image;//小敌机图片
	public static BufferedImage[] bomsImages;//爆炸后的效果图
	
	static{
		image=loadImage("ariplane.png");
		//System.out.println("小敌机图片"+image);
		
		bomsImages=new BufferedImage[6];
		for(int i=0;i<bomsImages.length;i++){
			bomsImages[i]=loadImage("boms"+i+".png");
			//System.out.println("小敌机第"+i+"张爆炸图片"+bomsImages[i]);
		}
		
	}
	
	public Airplane(){
		super(72, 82);
		speed=2;
	}
	
	//移动
	public void step(){
		y+=speed;
		//System.out.println("小敌机移动了"+y+",x移动了"+x);
	}
	
	/**根据不同的状态获取小敌机不同的图片*/
	int bomsIndex=0;
	public BufferedImage getImage(){
		if(isLife()){
			//System.out.println("活着");
			return image;
		}else if(isDead()){
			BufferedImage img=bomsImages[bomsIndex++];
			if(bomsIndex==bomsImages.length){
				//System.out.println("移除");
				state=REMOVE;
			}
			//System.out.println("死掉");
			return img;
		}	
		return null;
	}

	/**小敌机得分*/
	public int getScore() {
		return Score.ONE;
	}

	/**检测小敌机是否越界*/
	public boolean flyingObjectOut() {
		return this.y>=World.HEIGHT;//越界
	}
	
	
	
}
