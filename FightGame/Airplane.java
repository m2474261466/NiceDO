package FightGame;

import java.awt.image.BufferedImage;

/**
 * С�л�
 * @author Lenovo
 *
 */
public class Airplane extends FlyingObject implements Score{
	private int speed;	//�ٶ�
	public static BufferedImage image;//С�л�ͼƬ
	public static BufferedImage[] bomsImages;//��ը���Ч��ͼ
	
	static{
		image=loadImage("ariplane.png");
		//System.out.println("С�л�ͼƬ"+image);
		
		bomsImages=new BufferedImage[6];
		for(int i=0;i<bomsImages.length;i++){
			bomsImages[i]=loadImage("boms"+i+".png");
			//System.out.println("С�л���"+i+"�ű�ըͼƬ"+bomsImages[i]);
		}
		
	}
	
	public Airplane(){
		super(72, 82);
		speed=2;
	}
	
	//�ƶ�
	public void step(){
		y+=speed;
		//System.out.println("С�л��ƶ���"+y+",x�ƶ���"+x);
	}
	
	/**���ݲ�ͬ��״̬��ȡС�л���ͬ��ͼƬ*/
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

	/**С�л��÷�*/
	public int getScore() {
		return Score.ONE;
	}

	/**���С�л��Ƿ�Խ��*/
	public boolean flyingObjectOut() {
		return this.y>=World.HEIGHT;//Խ��
	}
	
	
	
}
