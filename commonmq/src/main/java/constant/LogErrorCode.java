package constant;

public enum LogErrorCode {

    USER_REQUEST("0001","用户请求"),
    REQUEST_SUCCESS("0002","用户请求成功"),
    REQUEST_FAILURE("0003","用户请求失败"),
    SERIOUS_ERROR("0004","严重错误，需要发送告警通知(邮件/短信)"),
    REQUEST_THRID("0005","请求第三方前日志"),
    RESPONSE_THRID("0006","第三方返回日志"),
    SERVICE_FAILURE("0007","业务逻辑处理失败"),
    SERVICE_NORMAL("0008","正常业务逻辑处理日志"),
    FRAMEWORK_LOG("0009","框架日志");

    private String code;
    private String msg;

    LogErrorCode(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
