package platform.exception;

/**
 * Business Exception
 */
public class BusinessException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    String code = "-1";

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
