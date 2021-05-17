package FightGame;
/**
 * 奖励接口
 * @author Lenovo
 *
 */
public interface Award {
	public static final int ZERO=0;
	public static final int ONE=1;
	
	/**获取奖励类型*/
	public int getAwardType();
}
