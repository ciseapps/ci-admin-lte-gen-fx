package com.neta.spring.api.commons;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static void createIfNotExistFolder(String path) {

        File file = new File(path);
        if (!file.exists()) {
            if(file.mkdirs()){
                System.out.println("write folder success : "+file.getAbsolutePath());
            }
        } else {
            if (file.isDirectory()) {
                System.out.println("folder exist : "+file.getAbsolutePath());
            } else {
                createIfNotExistFolder(path);
            }
        }
    }

    public static void createIfNotExistFile(String path) throws IOException {

        File file = new File(path);
        if (!file.exists()) {
            if(file.createNewFile()){
                System.out.println("write file success");
            }
        } else {
            if (file.isFile()) {
                System.out.println("file exist");
            } else {
                createIfNotExistFile(path);
            }
        }
    }

}
