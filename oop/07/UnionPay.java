package day07;
/**
 * 编写建设银行接口CCB继承银联接口，并实现该接口
 * 
 * 编写建设银行接口CCB。建设银行接口，
 * 用于描述中国建设银行发行的卡片功能，
 * 在满足银联接口的规则基础上，
 * 增加了支付燃气费的功能。
 *
 * 分析:UnionPay(银联):用于描述银联统一指定的规则(标准)
 * 假如银联有以下功能:
 * 1.查询密码
 * 2.查询余额
 * 3.取钱
 * @author Lenovo
 *
 */
public interface UnionPay {
	//查询密码
	public boolean checkPwd(String input);
	
	//查询余额
	public double getBalance();
	
	//取钱
	public boolean drawMoney(double number);
}
