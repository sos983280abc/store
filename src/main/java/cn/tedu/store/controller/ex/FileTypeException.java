package cn.tedu.store.controller.ex;

/**
 * 文件类型不匹配异常
 * 
 * @author soft01
 *
 */
public class FileTypeException extends FileUploadException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4668299874374727452L;

	public FileTypeException() {
		super();
	}

	public FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileTypeException(String message) {
		super(message);
	}

	public FileTypeException(Throwable cause) {
		super(cause);
	}

}
