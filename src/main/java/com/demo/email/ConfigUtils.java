package com.demo.email;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ConfigUtils {

    public static InputStream getInputStream(String fileName) throws FileNotFoundException {
        return ConfigUtils.class.getClassLoader().getResourceAsStream(fileName);
    }
}
