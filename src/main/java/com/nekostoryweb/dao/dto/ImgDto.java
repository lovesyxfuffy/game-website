package com.nekostoryweb.dao.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by yujingyang on 2017/9/22.
 */
@Data
public class ImgDto {
    private Integer id;

    private String title;

    private String author;

    private Integer type;

    private Byte isSelect;

    private Byte isVideo;

    private Integer orderKey;

    private String imgUrl;

    private String addTime;

    private String videoUrl;

}
