package com.atguigu.cloud.entities;

import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 表名：t_account
*/
@Table(name = "t_account")
@ToString
public class Account implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    private String username;

    private Integer money;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return money
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * @param money
     */
    public void setMoney(Integer money) {
        this.money = money;
    }
}