package com.nekostoryweb.dao.dto;

import lombok.Data;

/**
 * Created by yujingyang on 2017/9/22.
 */
@Data
public class StrategyDto {
    String title;
    String content;
    String writer;
    Integer type;
    Byte isUpToDate;
    String imgUrl;
    String orderKey;
    String addTime;
}
