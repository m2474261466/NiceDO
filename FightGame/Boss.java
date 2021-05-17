package FightGame;

import java.awt.image.BufferedImage;

/**
 * Boss��
 * @author 
 *
 */
public class Boss extends FlyingObject {
	private int speed;//y�����ϵ��ٶ�
	private int xSpeed;//x�����ϵ��ٶ�
	private static BufferedImage boss;//BossͼƬ
	private static BufferedImage[] bomsBoss;//Boss��ըͼƬ
	
	static{
		boss=loadImage("de0.png");
		//System.out.println("BossͼƬΪ:"+boss);
		
		bomsBoss=new BufferedImage[6];
		for(int i=0;i<bomsBoss.length;i++){
			bomsBoss[i]=loadImage("de"+(i+1)+".png");
			//System.out.println("Boss�ĵ�"+i+"�ű�ըͼƬΪ:"+bomsBoss[i]);
		}
	}
	
	public Boss(){
		super(162,153);
		this.speed=1;
		this.xSpeed=1;
	}
	
	/**Boss�ƶ���ʽ*/
	public void step() {
		y+=speed;
		x+=xSpeed;
		if(y>=0){//��Boss��y������ڵ���0ʱ,Boss��������y�������ƶ�
			y=0;
			speed=0;
		}
		if(this.x<=0 || this.x>=World.WIDTH-this.width+1){
			xSpeed*=-1;
		}
		//System.out.println("Boss��x����Ϊ"+x+",Boss��y����Ϊ"+y);
	}
	
	/**���ݲ�ͬ��״̬��ȡBoss��ͼƬ*/
	private int bomsIndex=0;
	public BufferedImage getImage(){
		if(isLife()){
			BufferedImage b=boss;
			//System.out.println("����");
			return b;
		}else if(isDead()){
			BufferedImage b=bomsBoss[bomsIndex++];
			if(bomsIndex==bomsBoss.length){
				state=REMOVE;
				//System.out.println("�Ƴ�");
			}
			//System.out.println("����");
			return b;
		}
		return null;
	}
	
	int xStep=this.width/10;//��Boss��ˮƽ�����Ϸֳ�10��,���������ӵ��ķ���λ��
	int yStep=10;
	/**Boss�в������ӵ�*/
	public BossBullet shoot(){
		BossBullet mb=new BossBullet(this.x+5*xStep, this.y+this.height+yStep);
		return mb;
	}
	
	/**Boss��෢���ӵ�*/
	public BossBullet leftShoot(){
		BossBullet lb=new BossBullet(this.x+2*xStep, this.y+this.height+yStep-20);
		return lb;
	}
	
	/**Boss�Ҳ෢���ӵ�*/
	public BossBullet rightShoot(){
		BossBullet rb=new BossBullet(this.x+8*xStep, this.y+this.height+yStep-20);
		return rb;
	}
	
	/**���Boss�Ƿ�Խ��*/
	public boolean flyingObjectOut() {
		return false;//��Խ��
	}
}
