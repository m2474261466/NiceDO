package FightGame;

import java.awt.image.BufferedImage;

/**
 * 直升机
 * @author Lenovo
 *
 */
public class Helicopter extends FlyingObject implements Award{
	private int xSpeed;
	private int ySpeed;
	public static BufferedImage image;//直升机图片
	public static BufferedImage[] bomsImages;
	public int awardType;//奖励类型
	
	static{
		image=loadImage("helicopter.png");
		//System.out.println("直升机图片"+image);
		
		bomsImages=new BufferedImage[6];
		for(int i=0;i<bomsImages.length;i++){
			bomsImages[i]=loadImage("boms"+i+".png");
			//System.out.println("直升机第"+i+"张爆炸图片"+bomsImages[i]);
		}
	}
	
	public Helicopter(){
		super(61, 69);
		xSpeed=2;
		ySpeed=2;
		awardType=(int)(Math.random()*2);//奖励类型0或者1
	}
	
	//直升机移动
	public void step(){
		x+=xSpeed;
		y+=ySpeed;
		//在屏幕的左右边框之间来回移动
		if(x<=0 || x>=450-this.width){
			xSpeed*=-1;
		}
		//System.out.println("直升机x移动了"+x+",y移动了"+y);
	}
	
	/**根据不同的状态获取大敌机不同的图片*/
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

	/**获取奖励类型*/
	public int getAwardType() {
		return awardType;
	}

	/**检测直升机是否越界*/
	public boolean flyingObjectOut() {	
		return this.y>=World.HEIGHT;//越界
	}
	
	
	
}
