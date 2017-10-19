package com.nekostoryweb.contants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/27.
 */
public class StrategyType {
    private static Map<Integer,String> strategyType = new HashMap<>();

    static {

        strategyType.put(-1,"全部");
        strategyType.put(1,"新手");
        strategyType.put(2,"进阶");
        strategyType.put(4,"养成");
        strategyType.put(8,"经验");


    }

    public static Map<Integer, String> getStrategyType() {
        return strategyType;
    }

}
