package cn.tedu.store.controller.ex;
/**
 * 文件可能已经被移动或删除异常
 * @author soft01
 *
 */
public class FileUploadStateException extends FileUploadException{

	private static final long serialVersionUID = 4286991940161762027L;

	public FileUploadStateException() {
		super();
	}

	public FileUploadStateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileUploadStateException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileUploadStateException(String message) {
		super(message);
	}

	public FileUploadStateException(Throwable cause) {
		super(cause);
	}

	
}
