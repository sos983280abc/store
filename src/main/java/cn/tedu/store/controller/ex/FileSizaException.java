package cn.tedu.store.controller.ex;
/**
 * 文件过大异常
 * @author soft01
 *
 */
public class FileSizaException extends FileUploadException{

	private static final long serialVersionUID = -2682854708878087688L;

	public FileSizaException() {
		super();
	}

	public FileSizaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileSizaException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileSizaException(String message) {
		super(message);
	}

	public FileSizaException(Throwable cause) {
		super(cause);
	}

	
}
