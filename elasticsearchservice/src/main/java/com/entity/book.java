package com.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
@Data
public class book {
    private int id;
    private String title;
    private String language;
    private String author;
    private BigDecimal price;
    private Date publish_time;
    private String description;
    private int counter;
}
