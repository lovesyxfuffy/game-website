package com.nekostoryweb.utils;

import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/26.
 */
public class RequestBodyFilter {

    public static <T> T  filter(Map<String,? extends Object> params, Class clazz) {
        try {
            T target = (T) clazz.newInstance();
            PropertyDescriptor[] descriptors = BeanUtils.getPropertyDescriptors(clazz);
            for (PropertyDescriptor descriptor : descriptors) {
                if (descriptor.getWriteMethod() != null && descriptor.getPropertyType() != java.lang.Class.class) {
                    descriptor.getWriteMethod().invoke(target, params.get(descriptor.getName()));
                }
            }
            return target;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
