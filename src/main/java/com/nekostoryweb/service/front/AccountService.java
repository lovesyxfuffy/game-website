package com.nekostoryweb.service.front;

/**
 * Created by yujingyang on 2017/9/27.
 */
public interface AccountService {
    String sendVerifyCode(String telephone);

    int insertOrderInfo(String telephone, String phoneType);
}
