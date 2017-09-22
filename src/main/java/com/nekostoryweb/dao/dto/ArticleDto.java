package com.nekostoryweb.dao.dto;

import lombok.Data;
import org.apache.xpath.operations.Bool;

/**
 * Created by yujingyang on 2017/9/21.
 */
@Data
public class ArticleDto {
    String title;
    String content;
    String writer;
    Integer type;
    Byte isUpToDate;
    String imgUrl;
    Integer orderKey;
    String addTime;

}
