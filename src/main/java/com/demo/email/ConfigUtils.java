package com.demo.email;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 描述：
 * 作者：zc741
 * 时间：2018/8/1 12:45.
 */
public class ConfigUtils {

    public static InputStream getInputStream(String fileName) throws FileNotFoundException {
        return ConfigUtils.class.getClassLoader().getResourceAsStream(fileName);
    }
}
