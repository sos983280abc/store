package cn.tedu.store.service.ex;

/**
 * 拒绝访问，列入尝试访问他人的数据
 * @author soft01
 *
 */
public class AccessDeniedException extends ServiceException{

	private static final long serialVersionUID = 3849396365637118465L;

	public AccessDeniedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccessDeniedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AccessDeniedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccessDeniedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AccessDeniedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
