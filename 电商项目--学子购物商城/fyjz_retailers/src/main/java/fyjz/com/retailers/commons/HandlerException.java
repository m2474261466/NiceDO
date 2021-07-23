package fyjz.com.retailers.commons;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * �����ࣨ�쳣��
 * @author Lenovo
 *
 */
public abstract class HandlerException {
	
	@ExceptionHandler
	@ResponseBody
	public JsonResult<Object> handler(Exception e){
		return new JsonResult<Object>(e);
	}

}
