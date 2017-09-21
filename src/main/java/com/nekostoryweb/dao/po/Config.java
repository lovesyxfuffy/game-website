package com.nekostoryweb.dao.po;

import lombok.Data;

import java.util.Date;

@Data
public class Config {
    private String configKey;

    private String configValue;

    private String configName;

    private String type;

    private Date addTime;

    private Date updateTime;

}