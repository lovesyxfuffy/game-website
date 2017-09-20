package com.nekostoryweb.dao.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by yujingyang on 2017/9/18.
 */
@Data
public class MenuDto {
    Integer id;
    String menuName;
    List<MenuDto> children;
    Integer menuLevel;
    String menuIcon;
    String menuUrl;
    Integer fatherId;
    Boolean isActive;
    Boolean isOpen;



    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
