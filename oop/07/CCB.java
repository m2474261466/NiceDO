package day07;
/**
 * 在满足银联的规则基础上,添加建设银行发行的卡片功能
 * 增加支付燃气费的功能
 * @author Lenovo
 *
 */
public interface CCB extends UnionPay {
	//支付燃气功能
	public void pay(double number);
}
