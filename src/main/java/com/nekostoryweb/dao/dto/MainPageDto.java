package com.nekostoryweb.dao.dto;

import lombok.Data;

/**
 * Created by yujingyang on 2017/9/27.
 */
@Data
public class MainPageDto {
    Integer code;
    String name;
    String typeLink;

    MainPageDto(Integer code, String name, String typeLink) {
        this.code = code;
        this.name = name;
        this.typeLink = typeLink;
    }
}
