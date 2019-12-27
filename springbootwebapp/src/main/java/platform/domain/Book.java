package platform.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Book 实体类
 *
 * Created by bysocket on 27/09/2017.
 */
@Data
public class Book implements Serializable {

    /**
     * 编号
     */
    private String id;

    /**
     * 书名
     */
    private String title;
    /**
     * 语言
     */
    private String language;

    /**
     * 作者
     */
    private String author;
    /**
     * 图片路径
     */
    private String bookImageurl;

    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 简介
     */
    private String introduction;
}
