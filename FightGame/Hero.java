package FightGame;

import java.awt.image.BufferedImage;

/**
 * Ӣ�ۻ�
 * @author Lenovo
 *
 */
public class Hero extends FlyingObject{
	private int doubleFire;	//����ֵ
	private int life;		//��
	public static BufferedImage[] images;//Ӣ�ۻ�ͼƬ
	
	static{
		images=new BufferedImage[2];
		for(int i=0;i<images.length;i++){
			images[i]=loadImage("hero"+i+".png");
			//System.out.println("Ӣ�ۻ���"+i+"��ͼƬ"+images[i]);
		}
	}
	
	public Hero(){
		super(97, 139, 140, 420);
		doubleFire=0;
		life=300;
		//System.out.println(this);
	}
	
	//Ӣ�ۻ����ƶ�����������ƶ����ƶ�
	public void moveStep(int x, int y){
		//��Ӣ�ۻ�ͼƬ�����Ϸ�ƽ��,�������ƶ���Ӣ�ۻ��м�
		this.x=x-this.width/2;
		this.y=y-this.height/2;
		//System.out.println("�������:"+this.x);
	}
	
	//��д����ĳ��󷽷�,����Hero�ƶ���ʽ������Ҫ������x,y����,
	//������д�˷���ֻ��Ϊ����ϸ����еĳ��󷽷�,�����ﲻ�����ķ�����
	public void step(){
		
	}
	
	/**���ݲ�ͬ��״̬��ȡӢ�ۻ���ͬ��ͼƬ*/
	int bomsIndex=0;
	public BufferedImage getImage(){
		if(isLife()){
			BufferedImage img=images[bomsIndex++%2];
			//System.out.println("����");
			return img;
		}else if(isDead()){
			state=REMOVE;
			//System.out.println("�Ƴ�");
		}
		return null;		
	}
	
	/**Ӣ�ۻ������ӵ�*/
	public Bullet[] shoot(){
		/*���*/
		/*Bullet[] uf=new Bullet[World.WIDTH];//���޻���
		for(int i=0;i<uf.length;i++){
			uf[i]=new Bullet(i,500);
		}
		return uf;*/
		
		int xStep=this.width/4;
		int yStep=20;
		if(doubleFire>0){//˫������
			Bullet[] bullet=new Bullet[2];
			//Ӣ�ۻ���1/4�������ӵ�
			bullet[0]=new Bullet(this.x+xStep, this.y-yStep);
			//Ӣ�ۻ���3/4�������ӵ�
			bullet[1]=new Bullet(this.x+3*xStep, this.y-yStep);
			doubleFire-=2;//�ӵ�����һ��˫������,�����ֵ����2
			//System.out.println("����ֵ:"+doubleFire);
			return bullet;
		}else{
			Bullet[] b=new Bullet[1];
			//��Ӣ�ۻ���1/2�������ӵ�
			b[0]=new Bullet(this.x+2*xStep, this.y-yStep);
			//System.out.println("Ӣ�ۻ�����:"+this.x);
			return b;
		}
		
	}

	/**��ȡӢ�ۻ�����*/
	public int getLife(){
		return life;
	}
	
	/**����Ӣ�ۻ�����*/
	public void addLife(){
		life++;
	}
	
	/**����Ӣ�ۻ�����*/
	public void subLife(){
		life--;
	}
	
	/**���Ӣ�ۻ��Ļ���ֵ*/
	public void clearDoubleFire(){
		doubleFire=0;
	}
	
	/**����Ӣ�ۻ��Ļ���ֵ*/
	public void addDoubleFire(){
		doubleFire+=40;
	}
	
	/**��ȡ����ֵ*/
	public int getDoubleFire(){
		return doubleFire;
	}

	/**Ӣ�ۻ���Խ��*/
	public boolean flyingObjectOut() {
		return false;//��Խ��
	}
	
}
