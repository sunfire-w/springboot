package com.hotel.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Pojo Entity
 */
@Data
public class User {
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;
}

