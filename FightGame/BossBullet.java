package FightGame;

import java.awt.image.BufferedImage;

public class BossBullet extends FlyingObject {
	private int leftSpeed;//�ӵ������ƶ����ٶ�
	private int rightSpeed;//�ӵ������ƶ����ٶ�
	private int speed;//�ӵ������ƶ����ٶ�
	private static BufferedImage bossBullet;//Boss�ӵ�ͼƬ
	
	static{
		bossBullet=loadImage("bossBullet.png");
		//System.out.println("BossBullet�ӵ�Ϊ:"+bossBullet);
	}
	
	public BossBullet(int x,int y){
		super(36,36,x,y);
		this.leftSpeed=2;
		this.rightSpeed=2;
		this.speed=2;
	}

	/**Boss�в��ӵ��ƶ�*/
	public void step() {
		y+=speed;
		//System.out.println("BossBullet��x����Ϊ"+x+",BossBullet��y����Ϊ"+y);
	}
	
	/**Boss����ӵ��ƶ�*/
	public void leftStep(){
		y+=speed;
		x-=leftSpeed;
		if(this.x<=0 || this.x>=World.WIDTH-this.width+1){
			leftSpeed*=-1;
		}
		//System.out.println("BossBullet��x����Ϊ"+x+",BossBullet��y����Ϊ"+y);
	}
	
	/**Boss�Ҳ��ӵ��ƶ�*/
	public void rightStep(){
		y+=speed;
		x+=rightSpeed;
		if(this.x<=0 || this.x>=World.WIDTH-this.width+1){
			rightSpeed*=-1;
		}
		//System.out.println("BossBullet��x����Ϊ"+x+",BossBullet��y����Ϊ"+y);
	}
	
	/**����Boss�ӵ���״̬����ȡ��ͬ��ͼƬ*/
	public BufferedImage getImage() {
		if(isLife()){
			BufferedImage b=bossBullet;
			//System.out.println("����");
			return b;
		}else if(isDead()){
			//System.out.println("����");
			state=REMOVE;
		}
		return null;
	}

	/**�ж�Boss�ӵ��Ƿ�Խ��*/
	public boolean flyingObjectOut() {
		return this.y>=World.HEIGHT;//Խ��
	}
}
