package com.nekostoryweb.dao.dto;

import lombok.Data;

/**
 * Created by yujingyang on 2017/9/19.
 */
@Data
public class BreadCrumbDto {
    String name;
    String url;
    BreadCrumbDto child;
}
