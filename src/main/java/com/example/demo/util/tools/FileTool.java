package com.example.demo.util.tools;

import cn.hutool.core.io.IoUtil;

import java.io.*;

/**
 * @Author:王景阳
 * @DateTime:2022/6/10 8:48
 */
public class FileTool {

    public static void copyFile(String templateFilePath, String aimFilePath){
        File readerFile = new File(templateFilePath);
        if (!readerFile.exists() || !readerFile.isFile()) {
            throw new RuntimeException(String.format("源文件%s丢失！", templateFilePath));
        }
        File writerFile = new File(aimFilePath);
        FileInputStream reader;
        try {
            reader = new FileInputStream(readerFile);
            FileOutputStream writer = new FileOutputStream(writerFile);
            IoUtil.copy(reader, writer);
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
