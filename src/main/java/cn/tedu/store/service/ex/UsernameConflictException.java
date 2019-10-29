package cn.tedu.store.service.ex;

/**
 * 用户名冲突异常，例如：注册时用户名已被注册
 * @author soft01
 *
 */
public class UsernameConflictException extends ServiceException{

	private static final long serialVersionUID = -935760340922600036L;

	public UsernameConflictException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsernameConflictException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UsernameConflictException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UsernameConflictException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UsernameConflictException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
