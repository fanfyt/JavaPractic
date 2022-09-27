package com.liang.test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;

public class FileTest {
    public static void main(String[] args) throws IOException {
        Properties properties = System.getProperties();
        String dir = System.getProperty("user.dir");
        File file = new File(dir+"\\测试\\test.txt");
        boolean mkdirs = file.mkdirs();
        System.out.println(dir);
        boolean newFile = file.createNewFile();

        System.out.println();
        System.out.println(file.exists());
        System.out.println(file.createNewFile());
        System.out.println(file);
        String osName = System.getProperties().getProperty("os.name").toLowerCase(Locale.ROOT);
        System.out.println(osName);
    }
}
