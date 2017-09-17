package com.nekostoryweb.dao.po;

import java.util.Date;

public class Reserve {
    private Integer id;

    private String telephone;

    private Date reserveTime;

    private String reserveIp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Date getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Date reserveTime) {
        this.reserveTime = reserveTime;
    }

    public String getReserveIp() {
        return reserveIp;
    }

    public void setReserveIp(String reserveIp) {
        this.reserveIp = reserveIp == null ? null : reserveIp.trim();
    }
}