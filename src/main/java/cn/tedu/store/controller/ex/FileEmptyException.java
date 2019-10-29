package cn.tedu.store.controller.ex;

/**
 * 上传的文件为空，或文件为0字节
 * 
 * @author soft01
 *
 */
public class FileEmptyException extends FileUploadException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1241017634099485103L;

	public FileEmptyException() {
		super();
	}

	public FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileEmptyException(String message) {
		super(message);
	}

	public FileEmptyException(Throwable cause) {
		super(cause);
	}

	
}
