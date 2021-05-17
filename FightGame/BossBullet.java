package FightGame;

import java.awt.image.BufferedImage;

public class BossBullet extends FlyingObject {
	private int leftSpeed;//子弹向左移动的速度
	private int rightSpeed;//子弹向右移动的速度
	private int speed;//子弹向下移动的速度
	private static BufferedImage bossBullet;//Boss子弹图片
	
	static{
		bossBullet=loadImage("bossBullet.png");
		//System.out.println("BossBullet子弹为:"+bossBullet);
	}
	
	public BossBullet(int x,int y){
		super(36,36,x,y);
		this.leftSpeed=2;
		this.rightSpeed=2;
		this.speed=2;
	}

	/**Boss中部子弹移动*/
	public void step() {
		y+=speed;
		//System.out.println("BossBullet的x坐标为"+x+",BossBullet的y坐标为"+y);
	}
	
	/**Boss左侧子弹移动*/
	public void leftStep(){
		y+=speed;
		x-=leftSpeed;
		if(this.x<=0 || this.x>=World.WIDTH-this.width+1){
			leftSpeed*=-1;
		}
		//System.out.println("BossBullet的x坐标为"+x+",BossBullet的y坐标为"+y);
	}
	
	/**Boss右侧子弹移动*/
	public void rightStep(){
		y+=speed;
		x+=rightSpeed;
		if(this.x<=0 || this.x>=World.WIDTH-this.width+1){
			rightSpeed*=-1;
		}
		//System.out.println("BossBullet的x坐标为"+x+",BossBullet的y坐标为"+y);
	}
	
	/**根据Boss子弹的状态来获取不同的图片*/
	public BufferedImage getImage() {
		if(isLife()){
			BufferedImage b=bossBullet;
			//System.out.println("活着");
			return b;
		}else if(isDead()){
			//System.out.println("死掉");
			state=REMOVE;
		}
		return null;
	}

	/**判断Boss子弹是否越界*/
	public boolean flyingObjectOut() {
		return this.y>=World.HEIGHT;//越界
	}
}
