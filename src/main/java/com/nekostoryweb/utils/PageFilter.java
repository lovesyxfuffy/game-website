package com.nekostoryweb.utils;

import com.github.pagehelper.PageInfo;
import com.nekostoryweb.dao.dto.FrontPage;


/**
 * Created by yujingyang on 2017/9/26.
 */
public class PageFilter {

    public static FrontPage filter(PageInfo pageInfo){
        FrontPage frontPage = new FrontPage();
        frontPage.setPageNo(pageInfo.getPageNum());
        frontPage.setTotal((int)pageInfo.getTotal());
        frontPage.setPageSize(pageInfo.getPageSize());
        return frontPage;
    }
}
