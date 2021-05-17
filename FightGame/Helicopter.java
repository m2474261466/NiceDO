package FightGame;

import java.awt.image.BufferedImage;

/**
 * ֱ����
 * @author Lenovo
 *
 */
public class Helicopter extends FlyingObject implements Award{
	private int xSpeed;
	private int ySpeed;
	public static BufferedImage image;//ֱ����ͼƬ
	public static BufferedImage[] bomsImages;
	public int awardType;//��������
	
	static{
		image=loadImage("helicopter.png");
		//System.out.println("ֱ����ͼƬ"+image);
		
		bomsImages=new BufferedImage[6];
		for(int i=0;i<bomsImages.length;i++){
			bomsImages[i]=loadImage("boms"+i+".png");
			//System.out.println("ֱ������"+i+"�ű�ըͼƬ"+bomsImages[i]);
		}
	}
	
	public Helicopter(){
		super(61, 69);
		xSpeed=2;
		ySpeed=2;
		awardType=(int)(Math.random()*2);//��������0����1
	}
	
	//ֱ�����ƶ�
	public void step(){
		x+=xSpeed;
		y+=ySpeed;
		//����Ļ�����ұ߿�֮�������ƶ�
		if(x<=0 || x>=450-this.width){
			xSpeed*=-1;
		}
		//System.out.println("ֱ����x�ƶ���"+x+",y�ƶ���"+y);
	}
	
	/**���ݲ�ͬ��״̬��ȡ��л���ͬ��ͼƬ*/
	int bomsIndex=0;
	public BufferedImage getImage(){
		if(isLife()){
			//System.out.println("����");
			return image;
		}else if(isDead()){
			BufferedImage img=bomsImages[bomsIndex++];
			if(bomsIndex==bomsImages.length){
				//System.out.println("�Ƴ�");
				state=REMOVE;
			}
			//System.out.println("����");
			return img;
		}		
		return null;
	}

	/**��ȡ��������*/
	public int getAwardType() {
		return awardType;
	}

	/**���ֱ�����Ƿ�Խ��*/
	public boolean flyingObjectOut() {	
		return this.y>=World.HEIGHT;//Խ��
	}
	
	
	
}
