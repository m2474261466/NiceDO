package FightGame;

import java.awt.image.BufferedImage;

/**
 * Boss类
 * @author 
 *
 */
public class Boss extends FlyingObject {
	private int speed;//y方向上的速度
	private int xSpeed;//x方向上的速度
	private static BufferedImage boss;//Boss图片
	private static BufferedImage[] bomsBoss;//Boss爆炸图片
	
	static{
		boss=loadImage("de0.png");
		//System.out.println("Boss图片为:"+boss);
		
		bomsBoss=new BufferedImage[6];
		for(int i=0;i<bomsBoss.length;i++){
			bomsBoss[i]=loadImage("de"+(i+1)+".png");
			//System.out.println("Boss的第"+i+"张爆炸图片为:"+bomsBoss[i]);
		}
	}
	
	public Boss(){
		super(162,153);
		this.speed=1;
		this.xSpeed=1;
	}
	
	/**Boss移动方式*/
	public void step() {
		y+=speed;
		x+=xSpeed;
		if(y>=0){//当Boss的y坐标大于等于0时,Boss将不会在y方向上移动
			y=0;
			speed=0;
		}
		if(this.x<=0 || this.x>=World.WIDTH-this.width+1){
			xSpeed*=-1;
		}
		//System.out.println("Boss的x坐标为"+x+",Boss的y坐标为"+y);
	}
	
	/**根据不同的状态获取Boss的图片*/
	private int bomsIndex=0;
	public BufferedImage getImage(){
		if(isLife()){
			BufferedImage b=boss;
			//System.out.println("活着");
			return b;
		}else if(isDead()){
			BufferedImage b=bomsBoss[bomsIndex++];
			if(bomsIndex==bomsBoss.length){
				state=REMOVE;
				//System.out.println("移除");
			}
			//System.out.println("死掉");
			return b;
		}
		return null;
	}
	
	int xStep=this.width/10;//把Boss在水平方向上分成10份,用来设置子弹的发射位置
	int yStep=10;
	/**Boss中部发射子弹*/
	public BossBullet shoot(){
		BossBullet mb=new BossBullet(this.x+5*xStep, this.y+this.height+yStep);
		return mb;
	}
	
	/**Boss左侧发射子弹*/
	public BossBullet leftShoot(){
		BossBullet lb=new BossBullet(this.x+2*xStep, this.y+this.height+yStep-20);
		return lb;
	}
	
	/**Boss右侧发射子弹*/
	public BossBullet rightShoot(){
		BossBullet rb=new BossBullet(this.x+8*xStep, this.y+this.height+yStep-20);
		return rb;
	}
	
	/**检测Boss是否越界*/
	public boolean flyingObjectOut() {
		return false;//不越界
	}
}
