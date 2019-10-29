package cn.tedu.store.service.ex;

/**
 * 收货地址数量达到上限异常
 * @author soft01
 *
 */
public class AddressSizeLimitException extends ServiceException{

	private static final long serialVersionUID = -425709025935621121L;

	public AddressSizeLimitException() {
		super();
	}

	public AddressSizeLimitException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AddressSizeLimitException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddressSizeLimitException(String message) {
		super(message);
	}

	public AddressSizeLimitException(Throwable cause) {
		super(cause);
	}
	
	
}
