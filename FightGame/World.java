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
	 * JPanel是Java图形用户界面工具包swing中的面板容器类,包含在java.swing包中
	 * 是一个轻量级容器,可以加入到JFrame窗体中(相框)
	 */
	
	//声明一个窗口的宽度和高度
	public static final int WIDTH=450;//窗口的宽度
	public static final int HEIGHT=650;//窗口的高度
	private Sky sky=new Sky();//天空
	private FlyingObject[] enemies={};//敌机
	private Hero hero=new Hero();//英雄机
	private Bullet[] bullets={};//子弹数组
	private int score=0;//分数
	private Boss boss=new Boss();//Boss
	private BossBullet[] middleBullets={};//Boss中部发射的子弹
	private BossBullet[] leftBullets={};//Boss左侧发射的子弹
	private BossBullet[] rightBullets={};//Boss右侧发射的子弹
	public static BufferedImage start;//启动图片
	public static BufferedImage pause;//暂停图片
	public static BufferedImage gameOver;//死亡图片
	public static BufferedImage victory;//胜利图片
	public static final int START=0;//开始状态
	public static final int PAUSE=1;//暂停状态
	public static final int RUNNING=2;//运行状态
	public static final int GAME_OVER=3;//游戏结束状态
	public static final int VICTORY=4;//胜利状态
	public int state=START;//默认为启动状态
	private static long bossTime=0;//计时,即到一个时间点boss出现
	public static final int bossActionTime=10;//Boss出场的时间
	private long timeIndex=0;//统计秒数
	private int bangCount=0;//英雄机子弹碰撞Boss的次数
	
	static{//初始化
		start=FlyingObject.loadImage("start.png");
		pause=FlyingObject.loadImage("pause.png");
		gameOver=FlyingObject.loadImage("gameover.png");
		victory=FlyingObject.loadImage("victory.png");
	}
	
	/**生成敌人*/
	private FlyingObject nextOne(){
		Random random=new Random();
		int n=random.nextInt(21);//随机生成数
		if(n<8){
			return new Airplane();
		}else if(n<14){
			return new BigAirplane();
		}else{
			return new Helicopter();
		}
	}
	
	/**敌人入场*/
	private int enemiesIndex=0;
	private void enemiesAction(){//每隔400(10*40)毫秒敌人入场一个
		enemiesIndex++;
		if(enemiesIndex%40==0){
			//给enemies数组扩容
			enemies=Arrays.copyOf(enemies, enemies.length+1);
			//生成对象
			FlyingObject f=nextOne();
			//把随机生成的对象放在数组中的最后一个元素
			enemies[enemies.length-1]=f;
		}
		//System.out.println("敌人对象的长度"+enemies.length);
	}
	
	/**子弹入场*/
	private int bulletIndex=0;
	private void bulletAction(){
		bulletIndex++;
		if(bulletIndex%30==0){
			Bullet[] b=hero.shoot();//生成子弹
			bullets=Arrays.copyOf(bullets, bullets.length+b.length);//目标数组扩容
			System.arraycopy(b, 0, bullets, bullets.length-b.length, b.length);
		}		
		//System.out.println("子弹数组的长度"+bullets.length);
	}
	
	/**Boss子弹入场*/
	private int bossBulletIndex=0;
	private void bossBulletAction(){
		bossBulletIndex++;
		//每700(70*10)毫秒,左侧,中部,右侧分别产生一个Boss子弹,并且在1000(10*1000)毫秒时,boss出现,即10秒时
		if(bossBulletIndex%70==0 && bossTime>=bossActionTime && boss.isLife()){
			//Boss中部发射子弹
			BossBullet mb=boss.shoot();
			middleBullets=Arrays.copyOf(middleBullets, middleBullets.length+1);//数组扩容
			middleBullets[middleBullets.length-1]=mb;//把生成的中部子弹放在中部子弹数组的最后一位
			
			//Boss左侧发射子弹
			BossBullet lb=boss.leftShoot();
			leftBullets=Arrays.copyOf(leftBullets, leftBullets.length+1);//数组扩容
			leftBullets[leftBullets.length-1]=lb;//把生成的左侧子弹放在中部子弹数组的最后一位
			
			//Boss右侧发射子弹
			BossBullet rb=boss.rightShoot();
			rightBullets=Arrays.copyOf(rightBullets, rightBullets.length+1);//数组扩容
			rightBullets[rightBullets.length-1]=rb;//把生成的右侧子弹放在中部子弹数组的最后一位
		}
		
	}
	
	/**子弹和敌人相撞*/
	private void bulletBangAction(){
		for(int i=0;i<bullets.length;i++){//遍历所有子弹
			Bullet b=bullets[i];
			for(int j=0;j<enemies.length;j++){//遍历所有敌人
				FlyingObject f=enemies[j];
				if(b.isLife() && f.isLife() && f.hit(b)){//判断每个子弹是否和我们遍历出来的敌人相撞
					f.goDead();//改变敌人状态为死的状态
					b.goDead();//改变子弹状态为死的状态
					//System.out.println("我死了");
					if(f instanceof Award){//判断对象是不是奖励类型
						Award a=(Award)f;
						int type=a.getAwardType();
						//System.out.println("奖励类型"+type);
						//如果type是0则奖励命(Life),是1则奖励火力值40
						switch(type){
						case Award.ZERO://奖励命
							hero.addLife();
							break;
						case Award.ONE://奖励火力值
							hero.addDoubleFire();
							break;
						}	
					}
					
					if(f instanceof Score){//判断对象是否为得分类型
						Score s=(Score)f;
						score+=s.getScore();
						//System.out.println("单个敌机分数:"+score);	
					}
				}
			}
		}		
	}
	
	/**英雄机和敌人相撞*/
	private void heroBangAction(){
		for(int i=0;i<enemies.length;i++){//遍历所有敌人
			FlyingObject f=enemies[i];
			if(hero.isLife() && f.isLife() && f.hit(hero)){//判断英雄机是否和敌人碰撞
				f.goDead();//改变敌人状态为死的状态
				//英雄机减命
				hero.subLife();
				//清空英雄机火力值
				hero.clearDoubleFire();
			}
		}
	}
	
	/**飞行物移动*/
	public void stepAction(){
		//遍历敌人
		for(int i=0;i<enemies.length;i++){
			enemies[i].step();
		}
		
		//遍历子弹
		for(int i=0;i<bullets.length;i++){
			bullets[i].step();
		}
		
		if(bossTime>=bossActionTime){
			boss.step();//boss移动
			//遍历boss中部子弹
			for(int i=0;i<middleBullets.length;i++){
				middleBullets[i].step();
			}
			//遍历boss左侧子弹
			for(int i=0;i<leftBullets.length;i++){
				leftBullets[i].leftStep();
			}
			//遍历boss右侧子弹
			for(int i=0;i<rightBullets.length;i++){
				rightBullets[i].rightStep();
			}
		}	
		
	}
	
	/**检测游戏是否结束,如果结束把状态更换为游戏结束状态*/
	public void checkGameOver(){
		if(hero.getLife()<1){
			state=GAME_OVER;
		}
	}
	
	/**处理飞行物越界问题*/
	public void flyingObjectOutAction(){
		//处理敌人越界问题
		int enemiesLivesIndex=0;
		FlyingObject[] enemiesLives=new FlyingObject[enemies.length];
		for(int i=0;i<enemies.length;i++){//遍历所有敌人(包括越界的和不越界的)
			FlyingObject f=enemies[i];
			if(!f.flyingObjectOut() && !f.isRemove()){//不越界且没有被删除的对象
				enemiesLives[enemiesLivesIndex++]=f;
			}
		}
		enemies=Arrays.copyOf(enemiesLives, enemiesLivesIndex);
		//System.out.println("处理后敌人数组不越界的长度:"+enemies.length);
		
		//处理子弹越界问题
		int bulletsLivesIndex=0;
		Bullet[] bulletsLives=new Bullet[bullets.length];
		for(int i=0;i<bullets.length;i++){//遍历所有子弹(包括越界的和不越界的)
			Bullet b=bullets[i];
			if(!b.flyingObjectOut() && !b.isRemove()){//不越界且没有被删除的对象
				bulletsLives[bulletsLivesIndex++]=b;
			}
		}
		bullets=Arrays.copyOf(bulletsLives, bulletsLivesIndex);
		//System.out.println("处理后子弹的数组不越界的长度:"+bullets.length);
		
		//Boss左侧子弹越界
		int leftBulletsIindex=0;
		BossBullet[] leftBulletsLives=new BossBullet[leftBullets.length];
		leftBulletsLives=Arrays.copyOf(leftBullets, leftBullets.length);//数组复制
		for(int i=0;i<leftBullets.length;i++){//遍历Boss左侧子弹
			BossBullet lb=leftBullets[i];
			if(!lb.flyingObjectOut() && !lb.isRemove()){//为越界,并且不是移除状态
				leftBulletsLives[leftBulletsIindex++]=lb;
			}
		}
		leftBullets=Arrays.copyOf(leftBulletsLives, leftBulletsIindex);
		//System.out.println("处理越界后的Boss左侧子弹:"+leftBullets.length);
		
		//Boss中部子弹越界
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
		//System.out.println("处理越界后的Boss中部子弹:"+middleBullets.length);
		
		//Boss右侧子弹越界
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
		//System.out.println("处理越界后的Boss右侧子弹:"+rightBullets.length);
	}
	
	/**英雄机子弹和Boss子弹相撞*/
	private void heroBulletAndBossBulletBangAction(){
		//英雄机的子弹和Boss左边发射的子弹相撞
		for(int i=0;i<bullets.length;i++){//遍历英雄机子弹
			Bullet b=bullets[i];
			for(int j=0;j<leftBullets.length;j++){//遍历Boss左边发射的子弹
				BossBullet lb=leftBullets[j];
				if(b.isLife() && lb.isLife() && lb.hit(b)){//二者必须是活着的状态才能发生碰撞
					b.goDead();//英雄机子弹去死
					lb.goDead();//Boss子弹去死
				}
			}
		}
		
		//英雄机子弹和Boss中间发射的子弹相撞
		for(int i=0;i<bullets.length;i++){//遍历英雄机子弹
			Bullet b=bullets[i];
			for(int j=0;j<middleBullets.length;j++){//遍历Boss中间发射的子弹
				BossBullet mb=middleBullets[j];
				if(mb.isLife() && b.isLife() && mb.hit(b)){
					b.goDead();//英雄机子弹去死
					mb.goDead();//Boss子弹去死
				}
			}
		}
		
		//英雄机子弹和Boss右侧发射的子弹相撞
		for(int i=0;i<bullets.length;i++){//遍历英雄机子弹
			Bullet b=bullets[i];
			for(int j=0;j<rightBullets.length;j++){//遍历Boss右侧发射的子弹
				BossBullet rb=rightBullets[j];
				if(rb.isLife() && b.isLife() && rb.hit(b)){
					b.goDead();//英雄机子弹去死
					rb.goDead();//Boss子弹去死
				}
			}
		}
		
	}
	
	/**英雄机子弹和Boss相撞*/
	private void heroBulletAndBossBangAction(){
		for(int i=0;i<bullets.length;i++){//遍历英雄机子弹
			Bullet b=bullets[i];
			if(b.isLife() && boss.isLife() && boss.hit(b)){
				b.goDead();//英雄机子弹去死
				bangCount++;
				if(bangCount==21){//英雄机的子弹和Boss碰撞20次Boss去死
					boss.goDead();
					//初始以下飞行物
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
	
	/**英雄机和Boss子弹相撞*/
	private void heroAndBossBulletBangAction(){
		//英雄机和Boss左边子弹相撞
		for(int i=0;i<leftBullets.length;i++){//遍历Boss左边发射的子弹
			BossBullet lb=leftBullets[i];
			if(lb.isLife() && hero.isLife() && lb.hit(hero)){
				lb.goDead();//Boss子弹去死
				hero.subLife();//英雄机减命
				hero.clearDoubleFire();//英雄机清空火力值
			}
		}
		
		//英雄机和Boss中间子弹相撞
		for(int i=0;i<middleBullets.length;i++){
			BossBullet mb=middleBullets[i];
			if(mb.isLife() && hero.isLife() && mb.hit(hero)){
				mb.goDead();
				hero.subLife();
				hero.clearDoubleFire();
			}
		}
		
		//英雄机子弹和Boss右侧子弹相撞
		for(int i=0;i<rightBullets.length;i++){
			BossBullet rb=rightBullets[i];
			if(rb.isLife() && hero.isLife() && rb.hit(hero)){
				rb.goDead();
				hero.subLife();
				hero.clearDoubleFire();
			}
		}
	}
	
	/**英雄机和Boss相撞*/
	private void heroAndBossAction(){
		if(boss.isLife() && hero.isLife() && boss.hit(hero)){
			hero.subLife();//英雄机减命
			hero.clearDoubleFire();//清空英雄机火力值
			bangCount++;//Boss被碰撞次数减小
		}
	}
	
	public void action(){
		//创建鼠标侦听器
		MouseAdapter m=new MouseAdapter(){
			public void mouseMoved(MouseEvent e){
				if(state==RUNNING){
					int x=e.getX();//获取鼠标的x坐标
					int y=e.getY();//获取鼠标的y坐标
					hero.moveStep(x, y);
				}
			}
			
			//鼠标点击事件
			public void mouseClicked(MouseEvent e){
				if(state==START){//如果是启动状态,则把状态更换为运行状态
					bossTime=0;//初始时间
					timeIndex=1;
					score=0;///清理分数
					sky=new Sky();
					boss=new Boss();
					hero=new Hero();
					state=RUNNING;
				}
				if(state==GAME_OVER){//情理现场并把状态更换为启动状态
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
			
			//鼠标移出事件
			public void mouseExited(MouseEvent e) {
				if(state==RUNNING){//如果是运行状态,则把状态更换为暂停状态
					state=PAUSE;
				}
			}
			
			//鼠标移入事件
			public void mouseEntered(MouseEvent e) {
				if(state==PAUSE){//如果是暂停状态,则把状态更换为运行状态
					state=RUNNING;
				}
			}
		};
		this.addMouseListener(m);//处理鼠标操作事件
		this.addMouseMotionListener(m);//处理鼠标滑动事件
		
		//创建定时器
		Timer timer=new Timer();
		int interval=10;
		timer.schedule(new TimerTask(){
			public void run(){//重写TimerTask抽象类中的抽象方法
				if(state==RUNNING){//如果状态为运行状态则执行以下程序
					sky.step();
					stepAction();//飞行物移动
					enemiesAction();//敌人入场
					bulletAction();//子弹入场
					bossBulletAction();//Boss子弹入场
					bulletBangAction();//子弹和敌人相撞
					heroBangAction();//英雄机和敌人相撞
					heroBulletAndBossBulletBangAction();//英雄机子弹和Boss子弹相撞
					heroBulletAndBossBangAction();//英雄机子弹和Boss相撞
					heroAndBossBulletBangAction();//英雄机和Boss子弹相撞
					heroAndBossAction();//英雄机和Boss相撞
					checkGameOver();//检测游戏是否结束
					flyingObjectOutAction();//处理飞行物越界问题
					if(timeIndex++%100==0){//1秒
						bossTime++;
					}
				}
				
				repaint();//repaint()JPanel中的方法 重画,重新调用paint()方法
			}
		}, interval, interval);//第一个interval 10毫秒后开始执行,第二个interval每隔10毫秒要执行一次任务
		
	}
	
	//重写paint方法供setVisible()方法调用,paint方法相当于一个入口
	/**画对象*/
	public void paint(Graphics g){
		sky.paintObject(g);
		hero.paintObject(g);
		for(int i=0;i<enemies.length;i++){//遍历enemies数组,画出数组中的每一个敌机对象
			enemies[i].paintObject(g);
		}
		for(int i=0;i<bullets.length;i++){//遍历bullets数组,画出数组中的每一个子弹对象
			bullets[i].paintObject(g);
		}
		if(bossTime>=bossActionTime){
			boss.paintObject(g);//画BOSS
			for(int i=0;i<middleBullets.length;i++){//遍历middleBullets数组,画出数组中的每一个子弹对象
				middleBullets[i].paintObject(g);
			}
			for(int i=0;i<leftBullets.length;i++){//遍历leftBullets数组,画出数组中的每一个子弹对象
				leftBullets[i].paintObject(g);
			}
			for(int i=0;i<rightBullets.length;i++){//遍历rightBullets数组,画出数组中的每一个子弹对象
				rightBullets[i].paintObject(g);
			}
		}
		Font zi=new Font("楷体",Font.TYPE1_FONT,25);//创建字体大小实例
		g.setFont(zi);//设置字体大小
		g.setColor(Color.RED);//给画笔设置颜色
		g.drawString("LIFE:"+hero.getLife()+"条", 5, 25);//根据x,y坐标画字符串在窗口中
		g.drawString("FIRE:"+hero.getDoubleFire()+"火力", 5, 50);
		g.drawString("SCORE:"+score+"分", 5, 75);
		//g.drawString("TIME:"+bossTime+"秒", 5, 100);
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
		//创建窗口(相框)
		JFrame frame=new JFrame();		
		World world=new World();//面板对象
		frame.add(world);//把面板放入在窗口(相框)中
		frame.setSize(WIDTH, HEIGHT);//设置窗口大小
		frame.setVisible(true);//1.设置窗口可见 2.尽快调用paint()方法
		frame.setLocationRelativeTo(null);//设置窗口居中显示
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口即退出程序
		world.action();
		while(true){//无线播放音乐
			new Music();
		}	
		
	}
	
}
