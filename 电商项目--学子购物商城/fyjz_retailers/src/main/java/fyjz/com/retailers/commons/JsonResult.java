package fyjz.com.retailers.commons;

public class JsonResult<T> {
	private T data;// 正确数据
	private String message;// 返回信息(正确/错误)
	private int state;// 状态
	private static final int ERROR=0;// 错误状态
	private static final int SUCCESS=1;// 正确状态
	
	public JsonResult() {
		this.state=SUCCESS;
		this.message="OK";
	}
	/*
	 * 以json格式返回正确信息
	 */
	public JsonResult(T data){
		System.out.println("正确信息");
		this.data = data;
		this.state=SUCCESS;
		this.message="OK";
	}	
	/*
	 * 获取异常信息
	 */
	public JsonResult(Throwable e){
		this.state=ERROR;
		this.message=e.getMessage()	;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
