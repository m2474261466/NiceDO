package FightGame;

import java.awt.image.BufferedImage;

/**
 * �ӵ�
 * @author Lenovo
 *
 */
public class Bullet extends FlyingObject{
	private int speed;
	public static BufferedImage image;//�ӵ�ͼƬ
	
	static{
		image=loadImage("bullet.png");
		//System.out.println("�ӵ�ͼƬ"+image);
	}
	
	public Bullet(int x,int y){
		super(8, 20, x, y);
		speed=3;
	}
	
	//�ƶ�
	public void step(){
		y-=speed;
		//System.out.println("�ӵ��ƶ���"+y);
	}
	
	/**���ݲ�ͬ��״̬��ȡ�ӵ���ͼƬ*/
	public BufferedImage getImage(){
		if(isLife()){
			//System.out.println("����");
			return image;
		}else if(isDead()){
			//System.out.println("�Ƴ�");
			state=REMOVE;
		}
		return null;
	}

	/**����ӵ��Ƿ�Խ��*/
	public boolean flyingObjectOut() {
		return this.y<=-this.height;//Խ��(y<=�ӵ����߶�)
	}
	
}
