package com.du.utils;

import org.junit.Test;

import java.util.UUID;

//抑制警告
@SuppressWarnings("all")
public class IDUtils {

    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void TestGetId(){
        System.out.println(IDUtils.getId());
    }
}