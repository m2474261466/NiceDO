package FightGame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * ���
 * @author Lenovo
 *
 */
public class Sky extends FlyingObject{
	private int y1;
	private int speed;
	public static BufferedImage image;//���(����ͼ)
	
	static{
		image=loadImage("bg1.png");
		//System.out.println("���ͼƬ"+image);
	}
	
	public Sky(){
		super(World.WIDTH, World.HEIGHT, 0, 0);
		y1=-this.height;
		speed=1;
	}
	
	public void step(){
		y+=speed;
		y1+=speed;
		if(y>=World.HEIGHT){//y������ڴ��ڸ߶�
			y=-this.height;
		}
		if(y1>=World.HEIGHT){//y1������ڴ��ڸ߶�
			y1=-this.height;
		}
		//System.out.println("��յ�y�ƶ���"+y+",��յ�y1�ƶ���"+y1);
	}
	
	/**״̬��ȡ���(����)��ͼƬ*/
	public BufferedImage getImage(){
		//System.out.println("����");
		return image;
	}
	
	/**�����д����(Ŀ�İ�y1ҲҪ����)*/
	public void paintObject(Graphics g){
		g.drawImage(getImage(), this.x, this.y, null);
		g.drawImage(getImage(), this.x, this.y1, null);
		
	}

	/**��ղ�Խ��*/
	public boolean flyingObjectOut() {
		return false;//��Խ��
	}
	
	
}
