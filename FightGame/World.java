package FightGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends JPanel {
	/*
	 * JPanel��Javaͼ���û����湤�߰�swing�е����������,������java.swing����
	 * ��һ������������,���Լ��뵽JFrame������(���)
	 */
	
	//����һ�����ڵĿ�Ⱥ͸߶�
	public static final int WIDTH=450;//���ڵĿ��
	public static final int HEIGHT=650;//���ڵĸ߶�
	private Sky sky=new Sky();//���
	private FlyingObject[] enemies={};//�л�
	private Hero hero=new Hero();//Ӣ�ۻ�
	private Bullet[] bullets={};//�ӵ�����
	private int score=0;//����
	private Boss boss=new Boss();//Boss
	private BossBullet[] middleBullets={};//Boss�в�������ӵ�
	private BossBullet[] leftBullets={};//Boss��෢����ӵ�
	private BossBullet[] rightBullets={};//Boss�Ҳ෢����ӵ�
	public static BufferedImage start;//����ͼƬ
	public static BufferedImage pause;//��ͣͼƬ
	public static BufferedImage gameOver;//����ͼƬ
	public static BufferedImage victory;//ʤ��ͼƬ
	public static final int START=0;//��ʼ״̬
	public static final int PAUSE=1;//��ͣ״̬
	public static final int RUNNING=2;//����״̬
	public static final int GAME_OVER=3;//��Ϸ����״̬
	public static final int VICTORY=4;//ʤ��״̬
	public int state=START;//Ĭ��Ϊ����״̬
	private static long bossTime=0;//��ʱ,����һ��ʱ���boss����
	public static final int bossActionTime=10;//Boss������ʱ��
	private long timeIndex=0;//ͳ������
	private int bangCount=0;//Ӣ�ۻ��ӵ���ײBoss�Ĵ���
	
	static{//��ʼ��
		start=FlyingObject.loadImage("start.png");
		pause=FlyingObject.loadImage("pause.png");
		gameOver=FlyingObject.loadImage("gameover.png");
		victory=FlyingObject.loadImage("victory.png");
	}
	
	/**���ɵ���*/
	private FlyingObject nextOne(){
		Random random=new Random();
		int n=random.nextInt(21);//���������
		if(n<8){
			return new Airplane();
		}else if(n<14){
			return new BigAirplane();
		}else{
			return new Helicopter();
		}
	}
	
	/**�����볡*/
	private int enemiesIndex=0;
	private void enemiesAction(){//ÿ��400(10*40)��������볡һ��
		enemiesIndex++;
		if(enemiesIndex%40==0){
			//��enemies��������
			enemies=Arrays.copyOf(enemies, enemies.length+1);
			//���ɶ���
			FlyingObject f=nextOne();
			//��������ɵĶ�����������е����һ��Ԫ��
			enemies[enemies.length-1]=f;
		}
		//System.out.println("���˶���ĳ���"+enemies.length);
	}
	
	/**�ӵ��볡*/
	private int bulletIndex=0;
	private void bulletAction(){
		bulletIndex++;
		if(bulletIndex%30==0){
			Bullet[] b=hero.shoot();//�����ӵ�
			bullets=Arrays.copyOf(bullets, bullets.length+b.length);//Ŀ����������
			System.arraycopy(b, 0, bullets, bullets.length-b.length, b.length);
		}		
		//System.out.println("�ӵ�����ĳ���"+bullets.length);
	}
	
	/**Boss�ӵ��볡*/
	private int bossBulletIndex=0;
	private void bossBulletAction(){
		bossBulletIndex++;
		//ÿ700(70*10)����,���,�в�,�Ҳ�ֱ����һ��Boss�ӵ�,������1000(10*1000)����ʱ,boss����,��10��ʱ
		if(bossBulletIndex%70==0 && bossTime>=bossActionTime && boss.isLife()){
			//Boss�в������ӵ�
			BossBullet mb=boss.shoot();
			middleBullets=Arrays.copyOf(middleBullets, middleBullets.length+1);//��������
			middleBullets[middleBullets.length-1]=mb;//�����ɵ��в��ӵ������в��ӵ���������һλ
			
			//Boss��෢���ӵ�
			BossBullet lb=boss.leftShoot();
			leftBullets=Arrays.copyOf(leftBullets, leftBullets.length+1);//��������
			leftBullets[leftBullets.length-1]=lb;//�����ɵ�����ӵ������в��ӵ���������һλ
			
			//Boss�Ҳ෢���ӵ�
			BossBullet rb=boss.rightShoot();
			rightBullets=Arrays.copyOf(rightBullets, rightBullets.length+1);//��������
			rightBullets[rightBullets.length-1]=rb;//�����ɵ��Ҳ��ӵ������в��ӵ���������һλ
		}
		
	}
	
	/**�ӵ��͵�����ײ*/
	private void bulletBangAction(){
		for(int i=0;i<bullets.length;i++){//���������ӵ�
			Bullet b=bullets[i];
			for(int j=0;j<enemies.length;j++){//�������е���
				FlyingObject f=enemies[j];
				if(b.isLife() && f.isLife() && f.hit(b)){//�ж�ÿ���ӵ��Ƿ�����Ǳ��������ĵ�����ײ
					f.goDead();//�ı����״̬Ϊ����״̬
					b.goDead();//�ı��ӵ�״̬Ϊ����״̬
					//System.out.println("������");
					if(f instanceof Award){//�ж϶����ǲ��ǽ�������
						Award a=(Award)f;
						int type=a.getAwardType();
						//System.out.println("��������"+type);
						//���type��0������(Life),��1��������ֵ40
						switch(type){
						case Award.ZERO://������
							hero.addLife();
							break;
						case Award.ONE://��������ֵ
							hero.addDoubleFire();
							break;
						}	
					}
					
					if(f instanceof Score){//�ж϶����Ƿ�Ϊ�÷�����
						Score s=(Score)f;
						score+=s.getScore();
						//System.out.println("�����л�����:"+score);	
					}
				}
			}
		}		
	}
	
	/**Ӣ�ۻ��͵�����ײ*/
	private void heroBangAction(){
		for(int i=0;i<enemies.length;i++){//�������е���
			FlyingObject f=enemies[i];
			if(hero.isLife() && f.isLife() && f.hit(hero)){//�ж�Ӣ�ۻ��Ƿ�͵�����ײ
				f.goDead();//�ı����״̬Ϊ����״̬
				//Ӣ�ۻ�����
				hero.subLife();
				//���Ӣ�ۻ�����ֵ
				hero.clearDoubleFire();
			}
		}
	}
	
	/**�������ƶ�*/
	public void stepAction(){
		//��������
		for(int i=0;i<enemies.length;i++){
			enemies[i].step();
		}
		
		//�����ӵ�
		for(int i=0;i<bullets.length;i++){
			bullets[i].step();
		}
		
		if(bossTime>=bossActionTime){
			boss.step();//boss�ƶ�
			//����boss�в��ӵ�
			for(int i=0;i<middleBullets.length;i++){
				middleBullets[i].step();
			}
			//����boss����ӵ�
			for(int i=0;i<leftBullets.length;i++){
				leftBullets[i].leftStep();
			}
			//����boss�Ҳ��ӵ�
			for(int i=0;i<rightBullets.length;i++){
				rightBullets[i].rightStep();
			}
		}	
		
	}
	
	/**�����Ϸ�Ƿ����,���������״̬����Ϊ��Ϸ����״̬*/
	public void checkGameOver(){
		if(hero.getLife()<1){
			state=GAME_OVER;
		}
	}
	
	/**���������Խ������*/
	public void flyingObjectOutAction(){
		//�������Խ������
		int enemiesLivesIndex=0;
		FlyingObject[] enemiesLives=new FlyingObject[enemies.length];
		for(int i=0;i<enemies.length;i++){//�������е���(����Խ��ĺͲ�Խ���)
			FlyingObject f=enemies[i];
			if(!f.flyingObjectOut() && !f.isRemove()){//��Խ����û�б�ɾ���Ķ���
				enemiesLives[enemiesLivesIndex++]=f;
			}
		}
		enemies=Arrays.copyOf(enemiesLives, enemiesLivesIndex);
		//System.out.println("�����������鲻Խ��ĳ���:"+enemies.length);
		
		//�����ӵ�Խ������
		int bulletsLivesIndex=0;
		Bullet[] bulletsLives=new Bullet[bullets.length];
		for(int i=0;i<bullets.length;i++){//���������ӵ�(����Խ��ĺͲ�Խ���)
			Bullet b=bullets[i];
			if(!b.flyingObjectOut() && !b.isRemove()){//��Խ����û�б�ɾ���Ķ���
				bulletsLives[bulletsLivesIndex++]=b;
			}
		}
		bullets=Arrays.copyOf(bulletsLives, bulletsLivesIndex);
		//System.out.println("������ӵ������鲻Խ��ĳ���:"+bullets.length);
		
		//Boss����ӵ�Խ��
		int leftBulletsIindex=0;
		BossBullet[] leftBulletsLives=new BossBullet[leftBullets.length];
		leftBulletsLives=Arrays.copyOf(leftBullets, leftBullets.length);//���鸴��
		for(int i=0;i<leftBullets.length;i++){//����Boss����ӵ�
			BossBullet lb=leftBullets[i];
			if(!lb.flyingObjectOut() && !lb.isRemove()){//ΪԽ��,���Ҳ����Ƴ�״̬
				leftBulletsLives[leftBulletsIindex++]=lb;
			}
		}
		leftBullets=Arrays.copyOf(leftBulletsLives, leftBulletsIindex);
		//System.out.println("����Խ����Boss����ӵ�:"+leftBullets.length);
		
		//Boss�в��ӵ�Խ��
		int middleBulletsIndex=0;
		BossBullet[] middleBulletsLives=new BossBullet[middleBullets.length];
		middleBulletsLives=Arrays.copyOf(middleBullets, middleBullets.length);
		for(int i=0;i<middleBullets.length;i++){
			BossBullet mb=middleBullets[i];
			if(!mb.flyingObjectOut() && !mb.isRemove()){
				middleBulletsLives[middleBulletsIndex++]=mb;
			}
		}
		middleBullets=Arrays.copyOf(middleBulletsLives, middleBulletsIndex);
		//System.out.println("����Խ����Boss�в��ӵ�:"+middleBullets.length);
		
		//Boss�Ҳ��ӵ�Խ��
		int rightBulletsIndex=0;
		BossBullet[] rightBulletsLives=new BossBullet[rightBullets.length];
		rightBulletsLives=Arrays.copyOf(rightBullets, rightBullets.length);
		for(int i=0;i<rightBullets.length;i++){
			BossBullet rb=rightBullets[i];
			if(!rb.flyingObjectOut() && !rb.isRemove()){
				rightBulletsLives[rightBulletsIndex++]=rb;
			}
		}
		rightBullets=Arrays.copyOf(rightBulletsLives, rightBulletsIndex);
		//System.out.println("����Խ����Boss�Ҳ��ӵ�:"+rightBullets.length);
	}
	
	/**Ӣ�ۻ��ӵ���Boss�ӵ���ײ*/
	private void heroBulletAndBossBulletBangAction(){
		//Ӣ�ۻ����ӵ���Boss��߷�����ӵ���ײ
		for(int i=0;i<bullets.length;i++){//����Ӣ�ۻ��ӵ�
			Bullet b=bullets[i];
			for(int j=0;j<leftBullets.length;j++){//����Boss��߷�����ӵ�
				BossBullet lb=leftBullets[j];
				if(b.isLife() && lb.isLife() && lb.hit(b)){//���߱����ǻ��ŵ�״̬���ܷ�����ײ
					b.goDead();//Ӣ�ۻ��ӵ�ȥ��
					lb.goDead();//Boss�ӵ�ȥ��
				}
			}
		}
		
		//Ӣ�ۻ��ӵ���Boss�м䷢����ӵ���ײ
		for(int i=0;i<bullets.length;i++){//����Ӣ�ۻ��ӵ�
			Bullet b=bullets[i];
			for(int j=0;j<middleBullets.length;j++){//����Boss�м䷢����ӵ�
				BossBullet mb=middleBullets[j];
				if(mb.isLife() && b.isLife() && mb.hit(b)){
					b.goDead();//Ӣ�ۻ��ӵ�ȥ��
					mb.goDead();//Boss�ӵ�ȥ��
				}
			}
		}
		
		//Ӣ�ۻ��ӵ���Boss�Ҳ෢����ӵ���ײ
		for(int i=0;i<bullets.length;i++){//����Ӣ�ۻ��ӵ�
			Bullet b=bullets[i];
			for(int j=0;j<rightBullets.length;j++){//����Boss�Ҳ෢����ӵ�
				BossBullet rb=rightBullets[j];
				if(rb.isLife() && b.isLife() && rb.hit(b)){
					b.goDead();//Ӣ�ۻ��ӵ�ȥ��
					rb.goDead();//Boss�ӵ�ȥ��
				}
			}
		}
		
	}
	
	/**Ӣ�ۻ��ӵ���Boss��ײ*/
	private void heroBulletAndBossBangAction(){
		for(int i=0;i<bullets.length;i++){//����Ӣ�ۻ��ӵ�
			Bullet b=bullets[i];
			if(b.isLife() && boss.isLife() && boss.hit(b)){
				b.goDead();//Ӣ�ۻ��ӵ�ȥ��
				bangCount++;
				if(bangCount==21){//Ӣ�ۻ����ӵ���Boss��ײ20��Bossȥ��
					boss.goDead();
					//��ʼ���·�����
					leftBullets=new BossBullet[0];
					middleBullets=new BossBullet[0];
					rightBullets=new BossBullet[0];
					enemies=new FlyingObject[0];
					bullets=new Bullet[0];
					hero=new Hero();
					state=VICTORY;
				}
			}
		}
	}
	
	/**Ӣ�ۻ���Boss�ӵ���ײ*/
	private void heroAndBossBulletBangAction(){
		//Ӣ�ۻ���Boss����ӵ���ײ
		for(int i=0;i<leftBullets.length;i++){//����Boss��߷�����ӵ�
			BossBullet lb=leftBullets[i];
			if(lb.isLife() && hero.isLife() && lb.hit(hero)){
				lb.goDead();//Boss�ӵ�ȥ��
				hero.subLife();//Ӣ�ۻ�����
				hero.clearDoubleFire();//Ӣ�ۻ���ջ���ֵ
			}
		}
		
		//Ӣ�ۻ���Boss�м��ӵ���ײ
		for(int i=0;i<middleBullets.length;i++){
			BossBullet mb=middleBullets[i];
			if(mb.isLife() && hero.isLife() && mb.hit(hero)){
				mb.goDead();
				hero.subLife();
				hero.clearDoubleFire();
			}
		}
		
		//Ӣ�ۻ��ӵ���Boss�Ҳ��ӵ���ײ
		for(int i=0;i<rightBullets.length;i++){
			BossBullet rb=rightBullets[i];
			if(rb.isLife() && hero.isLife() && rb.hit(hero)){
				rb.goDead();
				hero.subLife();
				hero.clearDoubleFire();
			}
		}
	}
	
	/**Ӣ�ۻ���Boss��ײ*/
	private void heroAndBossAction(){
		if(boss.isLife() && hero.isLife() && boss.hit(hero)){
			hero.subLife();//Ӣ�ۻ�����
			hero.clearDoubleFire();//���Ӣ�ۻ�����ֵ
			bangCount++;//Boss����ײ������С
		}
	}
	
	public void action(){
		//�������������
		MouseAdapter m=new MouseAdapter(){
			public void mouseMoved(MouseEvent e){
				if(state==RUNNING){
					int x=e.getX();//��ȡ����x����
					int y=e.getY();//��ȡ����y����
					hero.moveStep(x, y);
				}
			}
			
			//������¼�
			public void mouseClicked(MouseEvent e){
				if(state==START){//���������״̬,���״̬����Ϊ����״̬
					bossTime=0;//��ʼʱ��
					timeIndex=1;
					score=0;///�������
					sky=new Sky();
					boss=new Boss();
					hero=new Hero();
					state=RUNNING;
				}
				if(state==GAME_OVER){//�����ֳ�����״̬����Ϊ����״̬
					sky=new Sky();
					hero=new Hero();
					enemies=new FlyingObject[0];
					bullets=new Bullet[0];
					score=0;
					boss=new Boss();
					middleBullets=new BossBullet[0];
					leftBullets=new BossBullet[0];
					rightBullets=new BossBullet[0];
					bossTime=0;
					timeIndex=0;
					state=START;
				}
				if(state==VICTORY){
					state=START;
				}
			}
			
			//����Ƴ��¼�
			public void mouseExited(MouseEvent e) {
				if(state==RUNNING){//���������״̬,���״̬����Ϊ��ͣ״̬
					state=PAUSE;
				}
			}
			
			//��������¼�
			public void mouseEntered(MouseEvent e) {
				if(state==PAUSE){//�������ͣ״̬,���״̬����Ϊ����״̬
					state=RUNNING;
				}
			}
		};
		this.addMouseListener(m);//�����������¼�
		this.addMouseMotionListener(m);//������껬���¼�
		
		//������ʱ��
		Timer timer=new Timer();
		int interval=10;
		timer.schedule(new TimerTask(){
			public void run(){//��дTimerTask�������еĳ��󷽷�
				if(state==RUNNING){//���״̬Ϊ����״̬��ִ�����³���
					sky.step();
					stepAction();//�������ƶ�
					enemiesAction();//�����볡
					bulletAction();//�ӵ��볡
					bossBulletAction();//Boss�ӵ��볡
					bulletBangAction();//�ӵ��͵�����ײ
					heroBangAction();//Ӣ�ۻ��͵�����ײ
					heroBulletAndBossBulletBangAction();//Ӣ�ۻ��ӵ���Boss�ӵ���ײ
					heroBulletAndBossBangAction();//Ӣ�ۻ��ӵ���Boss��ײ
					heroAndBossBulletBangAction();//Ӣ�ۻ���Boss�ӵ���ײ
					heroAndBossAction();//Ӣ�ۻ���Boss��ײ
					checkGameOver();//�����Ϸ�Ƿ����
					flyingObjectOutAction();//���������Խ������
					if(timeIndex++%100==0){//1��
						bossTime++;
					}
				}
				
				repaint();//repaint()JPanel�еķ��� �ػ�,���µ���paint()����
			}
		}, interval, interval);//��һ��interval 10�����ʼִ��,�ڶ���intervalÿ��10����Ҫִ��һ������
		
	}
	
	//��дpaint������setVisible()��������,paint�����൱��һ�����
	/**������*/
	public void paint(Graphics g){
		sky.paintObject(g);
		hero.paintObject(g);
		for(int i=0;i<enemies.length;i++){//����enemies����,���������е�ÿһ���л�����
			enemies[i].paintObject(g);
		}
		for(int i=0;i<bullets.length;i++){//����bullets����,���������е�ÿһ���ӵ�����
			bullets[i].paintObject(g);
		}
		if(bossTime>=bossActionTime){
			boss.paintObject(g);//��BOSS
			for(int i=0;i<middleBullets.length;i++){//����middleBullets����,���������е�ÿһ���ӵ�����
				middleBullets[i].paintObject(g);
			}
			for(int i=0;i<leftBullets.length;i++){//����leftBullets����,���������е�ÿһ���ӵ�����
				leftBullets[i].paintObject(g);
			}
			for(int i=0;i<rightBullets.length;i++){//����rightBullets����,���������е�ÿһ���ӵ�����
				rightBullets[i].paintObject(g);
			}
		}
		Font zi=new Font("����",Font.TYPE1_FONT,25);//���������Сʵ��
		g.setFont(zi);//���������С
		g.setColor(Color.RED);//������������ɫ
		g.drawString("LIFE:"+hero.getLife()+"��", 5, 25);//����x,y���껭�ַ����ڴ�����
		g.drawString("FIRE:"+hero.getDoubleFire()+"����", 5, 50);
		g.drawString("SCORE:"+score+"��", 5, 75);
		//g.drawString("TIME:"+bossTime+"��", 5, 100);
		switch(state){
		case START:
			g.drawImage(start,0,0,null);
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER:
			g.drawImage(gameOver, 0, 0, null);
			break;
		case VICTORY:
			g.drawImage(victory, 0, -10, null);
			break;
		}
		
	}
	
	public static void main(String[] args) {
		//��������(���)
		JFrame frame=new JFrame();		
		World world=new World();//������
		frame.add(world);//���������ڴ���(���)��
		frame.setSize(WIDTH, HEIGHT);//���ô��ڴ�С
		frame.setVisible(true);//1.���ô��ڿɼ� 2.�������paint()����
		frame.setLocationRelativeTo(null);//���ô��ھ�����ʾ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùرմ��ڼ��˳�����
		world.action();
		while(true){//���߲�������
			new Music();
		}	
		
	}
	
}
