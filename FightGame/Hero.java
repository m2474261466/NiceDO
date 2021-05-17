package FightGame;

import java.awt.image.BufferedImage;

/**
 * 英雄机
 * @author Lenovo
 *
 */
public class Hero extends FlyingObject{
	private int doubleFire;	//火力值
	private int life;		//命
	public static BufferedImage[] images;//英雄机图片
	
	static{
		images=new BufferedImage[2];
		for(int i=0;i<images.length;i++){
			images[i]=loadImage("hero"+i+".png");
			//System.out.println("英雄机第"+i+"张图片"+images[i]);
		}
	}
	
	public Hero(){
		super(97, 139, 140, 420);
		doubleFire=0;
		life=300;
		//System.out.println(this);
	}
	
	//英雄机的移动是随着鼠标移动而移动
	public void moveStep(int x, int y){
		//将英雄机图片向右上方平移,则鼠标会移动到英雄机中间
		this.x=x-this.width/2;
		this.y=y-this.height/2;
		//System.out.println("鼠标坐标:"+this.x);
	}
	
	//重写父类的抽象方法,由于Hero移动方式特殊需要传鼠标的x,y参数,
	//所以重写此方法只是为了配合父类中的抽象方法,在这里不管它的方法体
	public void step(){
		
	}
	
	/**根据不同的状态获取英雄机不同的图片*/
	int bomsIndex=0;
	public BufferedImage getImage(){
		if(isLife()){
			BufferedImage img=images[bomsIndex++%2];
			//System.out.println("活着");
			return img;
		}else if(isDead()){
			state=REMOVE;
			//System.out.println("移除");
		}
		return null;		
	}
	
	/**英雄机发射子弹*/
	public Bullet[] shoot(){
		/*外挂*/
		/*Bullet[] uf=new Bullet[World.WIDTH];//无限火力
		for(int i=0;i<uf.length;i++){
			uf[i]=new Bullet(i,500);
		}
		return uf;*/
		
		int xStep=this.width/4;
		int yStep=20;
		if(doubleFire>0){//双倍火力
			Bullet[] bullet=new Bullet[2];
			//英雄机的1/4处发射子弹
			bullet[0]=new Bullet(this.x+xStep, this.y-yStep);
			//英雄机的3/4处发射子弹
			bullet[1]=new Bullet(this.x+3*xStep, this.y-yStep);
			doubleFire-=2;//子弹发射一次双倍火力,则火力值减少2
			//System.out.println("火力值:"+doubleFire);
			return bullet;
		}else{
			Bullet[] b=new Bullet[1];
			//在英雄机的1/2处发射子弹
			b[0]=new Bullet(this.x+2*xStep, this.y-yStep);
			//System.out.println("英雄机坐标:"+this.x);
			return b;
		}
		
	}

	/**获取英雄机的命*/
	public int getLife(){
		return life;
	}
	
	/**增加英雄机生命*/
	public void addLife(){
		life++;
	}
	
	/**减少英雄机生命*/
	public void subLife(){
		life--;
	}
	
	/**清空英雄机的火力值*/
	public void clearDoubleFire(){
		doubleFire=0;
	}
	
	/**增加英雄机的火力值*/
	public void addDoubleFire(){
		doubleFire+=40;
	}
	
	/**获取火力值*/
	public int getDoubleFire(){
		return doubleFire;
	}

	/**英雄机不越界*/
	public boolean flyingObjectOut() {
		return false;//不越界
	}
	
}
