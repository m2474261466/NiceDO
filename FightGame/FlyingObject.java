package FightGame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public abstract class FlyingObject {
	protected int width;		//��
	protected int height;		//��
	protected int x;			//x����
	protected int y;			//y����
	public static final int LIFE=0;//����״̬
	public static final int DEAD=1;//����״̬
	public static final int REMOVE=2;//�Ƴ�״̬
	public int state=LIFE;//Ĭ�ϻ���״̬
	
	/**С�л�,��л�,ֱ������ʼ��*/
	public FlyingObject(int width,int height){
		this.width=width;
		this.height=height;
		Random random=new Random();
		//�л�x����������Ⱥ͵л�����Ŀ�Ȳ�(�����-��ǰ�л��Ŀ��)
		this.x=random.nextInt(World.WIDTH-this.width+1);
		this.y=-this.height;
	}
	
	/**���,�ӵ�,Ӣ�ۻ���ʼ��*/
	public FlyingObject(int width,int height,int x,int y){
		this.width=width;
		this.height=height;
		this.x=x;
		this.y=y;
	}
	
	/**�������ƶ�����*/
	public abstract void step();//���󷽷�
	
	/**��ȡͼƬ BufferedImage ��ͼƬ����*/
	public static BufferedImage loadImage(String fileName){
		//try�з���������������쳣��ִ��catch(��׽�쳣)�е�����,���û���쳣��ִ��try����
		try {
			BufferedImage image=ImageIO.read(FlyingObject.class.getResource(fileName));//ͬ���ж�ȡ
			return image;
			
		} catch (Exception e) {
			//e.printStackTrace();//��������
			throw new RuntimeException("��ȡͼƬʧ��");
		}		
	}
	
	/**�ж϶����Ƿ����*/
	public boolean isLife(){
		return state==LIFE;
	}
	
	/**�ж϶����Ƿ�����*/
	public boolean isDead(){
		return state==DEAD;
	}
	
	/**�ж϶����Ƿ��Ƴ�*/
	public boolean isRemove(){
		return state==REMOVE;
	}
	
	/**����״̬��ȡͼƬ*/
	public abstract BufferedImage getImage();
	
	/**������ g:����*/
	public void paintObject(Graphics g){
		g.drawImage(getImage(), this.x, this.y, null);
	}
	
	/**Ӣ�ۻ�/�ӵ��͵�����ײ:other����Ӣ�ۻ�/�ӵ�*/
	public boolean hit(FlyingObject other){
		int x=other.x;
		int y=other.y;
		int x1=this.x-other.width;
		int x2=this.x+this.height;
		int y1=this.y-other.height;
		int y2=this.y+this.height;
		return x>=x1 && x<=x2 && y>=y1 && y<=y2;//true��ʾ��ײ,����û����ײ
	}
	
	/**����ȥ��*/
	public void goDead(){
		state=DEAD;
	}
	
	/**���������Ƿ�Խ��*/
	public abstract boolean flyingObjectOut();
	
}
