package platform.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 转换类型
 */
@ApiModel(value = "JsonResult", description = "JsonResult转换类型")
public class JsonResult<T> {

    //成功返回编码
    public static final String OK = "200";
    //失败返回编码
    public static final String ERR = "-1";
    public static final JsonResult SUCESS = new JsonResult(OK, "请求结果成功!");

    //杩斿洖缁撴灉瀹氫箟,榛樿杩斿洖"-1",璇锋眰澶辫触
    @ApiModelProperty(name = "失败", value = "请求失败，返回异常信息")
    private String result = "-1";

    @ApiModelProperty(name = "结果描述", value = "结果描述")
    private String desc = "";

    @ApiModelProperty(name = "结果数据", value = "结果数据")
    private T data;


    /**
     * 澶辫触
     *
     * @param message
     * @return
     */
    public static JsonResult getFailResult(String message) {
        return new JsonResult(ERR, message);
    }

    /**
     * 鎴愬姛
     *
     * @param message
     * @return
     */
    public static JsonResult getSuccessResult(String message) {
        return new JsonResult(OK, message);
    }

    /**
     * 鎴愬姛
     *
     * @param data
     * @param message
     * @return
     */
    public static JsonResult getSuccessResult(Object data, String message) {
        return new JsonResult(OK, message, data);
    }

    public JsonResult() {
    }

    public JsonResult(String code, String message) {
        this.result = code;
        this.desc = message;
    }

    public JsonResult(String code, String message, T result) {
        this.result = code;
        this.desc = message;
        this.data = result;
    }

    public JsonResult(T result) {
        this(OK, "成功！", result);
    }


    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;

        final JsonResult ret = (JsonResult) obj;
        return result == ret.getResult();
    }

    public String getDesc() {
        return desc;
    }

    public JsonResult setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getResult() {
        return result;
    }

    public JsonResult setResult(String result) {
        this.result = result;
        return this;
    }

    public Object getData() {
        return data;
    }

    public JsonResult setData(T data) {
        this.data = data;
        return this;
    }


}
