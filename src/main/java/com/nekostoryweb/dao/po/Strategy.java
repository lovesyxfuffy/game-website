package com.nekostoryweb.dao.po;

import lombok.Data;

import java.util.Date;

@Data
public class Strategy {
    private Integer id;

    private String title;

    private String writer;

    private Integer type;

    private Byte isUpToDate;

    private String imgUrl;

    private Integer orderKey;

    private String addTime;

    private String updateTime;

    private String content;

}