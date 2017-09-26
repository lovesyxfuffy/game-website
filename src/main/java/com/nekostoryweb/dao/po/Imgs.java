package com.nekostoryweb.dao.po;

import lombok.Data;


@Data
public class Imgs {
    private Integer id;

    private String title;

    private String author;

    private Integer type;

    private byte isSelect;

    private byte isVideo;

    private Integer orderKey;

    private String imgUrl;

    private String videoUrl;

    private String addTime;

    private String updateTime;

}