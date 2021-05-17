package FightGame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public abstract class FlyingObject {
	protected int width;		//宽
	protected int height;		//高
	protected int x;			//x坐标
	protected int y;			//y坐标
	public static final int LIFE=0;//活着状态
	public static final int DEAD=1;//死掉状态
	public static final int REMOVE=2;//移除状态
	public int state=LIFE;//默认活着状态
	
	/**小敌机,大敌机,直升机初始化*/
	public FlyingObject(int width,int height){
		this.width=width;
		this.height=height;
		Random random=new Random();
		//敌机x坐标在面板宽度和敌机自身的宽度差(面板宽度-当前敌机的宽度)
		this.x=random.nextInt(World.WIDTH-this.width+1);
		this.y=-this.height;
	}
	
	/**天空,子弹,英雄机初始化*/
	public FlyingObject(int width,int height,int x,int y){
		this.width=width;
		this.height=height;
		this.x=x;
		this.y=y;
	}
	
	/**飞行物移动方法*/
	public abstract void step();//抽象方法
	
	/**读取图片 BufferedImage 是图片类型*/
	public static BufferedImage loadImage(String fileName){
		//try中方法体中如果发生异常将执行catch(捕捉异常)中的语句块,如果没有异常将执行try语句块
		try {
			BufferedImage image=ImageIO.read(FlyingObject.class.getResource(fileName));//同包中读取
			return image;
			
		} catch (Exception e) {
			//e.printStackTrace();//日至跟踪
			throw new RuntimeException("读取图片失败");
		}		
	}
	
	/**判断对象是否活着*/
	public boolean isLife(){
		return state==LIFE;
	}
	
	/**判断对象是否死掉*/
	public boolean isDead(){
		return state==DEAD;
	}
	
	/**判断对象是否移除*/
	public boolean isRemove(){
		return state==REMOVE;
	}
	
	/**根据状态获取图片*/
	public abstract BufferedImage getImage();
	
	/**画对象 g:画笔*/
	public void paintObject(Graphics g){
		g.drawImage(getImage(), this.x, this.y, null);
	}
	
	/**英雄机/子弹和敌人相撞:other代表英雄机/子弹*/
	public boolean hit(FlyingObject other){
		int x=other.x;
		int y=other.y;
		int x1=this.x-other.width;
		int x2=this.x+this.height;
		int y1=this.y-other.height;
		int y2=this.y+this.height;
		return x>=x1 && x<=x2 && y>=y1 && y<=y2;//true表示相撞,否则没有相撞
	}
	
	/**敌人去死*/
	public void goDead(){
		state=DEAD;
	}
	
	/**检测飞行物是否越界*/
	public abstract boolean flyingObjectOut();
	
}
