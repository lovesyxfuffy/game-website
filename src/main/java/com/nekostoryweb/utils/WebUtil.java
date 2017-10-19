package com.nekostoryweb.utils;

import com.google.common.collect.Maps;
import com.nekostoryweb.contants.ResponseConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 * Created by yujingyang on 2017/9/18.
 */
public class WebUtil {

    public static final String DATA = "data";

    public static final String MESSAGE = "message";

    public static final String ErrorCode = "errorCode";

    public static final String CODE = "status";

    public static ResponseEntity<Map<String, Object>> success() {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        data.put(MESSAGE, ResponseConstants.RES_SUCCESS_MSG);
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.RES_SUCCESS);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> success(String msg) {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        data.put(MESSAGE, msg);
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.RES_SUCCESS);
        return new ResponseEntity(result, HttpStatus.OK);
    }
    public static ResponseEntity<Map<String, Object>> forbidden(String msg) {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        data.put(MESSAGE, msg);
        data.put(ErrorCode,ResponseConstants.FORBIDDEN);
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.RES_FAIL);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> result(Object object) {
        Map result = Maps.newHashMap();
        result.put(DATA, object);
        result.put(CODE, ResponseConstants.RES_SUCCESS);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> error(String msg) {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        data.put(MESSAGE, msg);
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.RES_FAIL);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> error(Object object) {
        Map result = Maps.newHashMap();
        result.put(DATA, object);
        result.put(CODE, ResponseConstants.RES_FAIL);
        return new ResponseEntity(result, HttpStatus.OK);
    }


    public static ResponseEntity<Map<String, Object>> errorWithPop(String msg, String pop) {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        data.put("tips", pop);
        data.put(MESSAGE, msg);
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.RES_FAIL);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
