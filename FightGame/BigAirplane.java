package FightGame;

import java.awt.image.BufferedImage;

/**
 * ��л�
 * @author Lenovo
 *
 */
public class BigAirplane extends FlyingObject implements Score{
	private int speed;
	public static BufferedImage image;//��л�ͼƬ
	public static BufferedImage[] bomsImages;//��ը���Ч��ͼ
	
	static{//���ش�л�ͼƬ�ͱ�ը���Ч��ͼ
		image=loadImage("BigAriplane.png");
		//System.out.println("��л�ͼƬ"+image);
		
		bomsImages=new BufferedImage[6];
		for(int i=0;i<bomsImages.length;i++){
			bomsImages[i]=loadImage("boms"+i+".png");
			//System.out.println("��"+i+"ͼƬ:"+bomsImages[i]);
		}
	}
	
	
	public BigAirplane(){
		super(94, 84);
		speed=2;
	}
	
	//�ƶ�
	public void step(){
		y+=speed;
		//System.out.println("��л��ƶ���"+y+",x�ƶ���"+x);
	}
	
	/**���ݲ�ͬ��״̬��ȡ��л���ͬ��ͼƬ*/
	int bomsIndex=0;//����״̬�±�
	public BufferedImage getImage(){
		if(isLife()){
			//System.out.println("����");
			return image;
		}else if(isDead()){
			BufferedImage img=bomsImages[bomsIndex++];
			if(bomsIndex==bomsImages.length){
				state=REMOVE;
				//System.out.println("�Ƴ�");
			}
			//System.out.println("����");
			return img;
		}
		return null;
	}

	public int getScore() {
		return Score.THREE;
	}

	/**����л��Ƿ�Խ��*/
	public boolean flyingObjectOut() {
		return this.y>=World.HEIGHT;//Խ��
	}
	
}
