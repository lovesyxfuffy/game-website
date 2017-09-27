package com.nekostoryweb.Contants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/27.
 */
public class ImgsType {
    private static Map<Integer,String> imgsType = new HashMap<>();

    static {
        imgsType.put(0,"精选");
        imgsType.put(1,"同人创作");
        imgsType.put(2,"cos欣赏");
        imgsType.put(4,"视频直播");
    }

    public static Map<Integer, String> getImgsType() {
        return imgsType;
    }


}
