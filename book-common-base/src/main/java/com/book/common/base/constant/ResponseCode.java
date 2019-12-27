package com.book.common.base.constant;

/**
 * Created by Administrator on 2019/12/24 0024.
 */
public enum ResponseCode {
    OK("200", "处理成功"),
    NOT_FOUND("102", "暂无符合条件的相关数据"),
    INVALID_REQUEST("203", "无效的请求参数"),
    FORBIDDEN("403", "没有操作权限"),
    SYSTEM_EXCEPTION("500", "系统异常"),
    BUSINESS_EXCEPTION("900", "业务异常"),
    BUSINESS_PARAMETER_EXCEPTION("905","参数异常"),
    FIND_PASSWORD_FAIL("103", "找回密码失败"),
    LOGIN_TIMEOUT("999","用户未登录，请登录！"),
    NAMED_ERROR("899", "路径定义不符合规范，企业使用的接口路径必须以“inc”开头，如：apis/v1/incbaseinfo"),
    FORBIDDEN_DATA("997", "对不起，您没有该权限，请联系管理员！"),
    FORBIDDEN_OPERATION("998", "对不起，您没有该权限，请联系管理员！"),
    PRICE_CHANGE("600", "价格发生变化！");

    private String code;

    private String desc;

    private ResponseCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
