package com.nekostoryweb.service.manage;

import java.util.Map;

/**
 * Created by yujingyang on 2017/9/18.
 */
public interface SystemService {

    Map<String, Object> getMenu(String URI);

    Integer login(String userName, String password);
}
