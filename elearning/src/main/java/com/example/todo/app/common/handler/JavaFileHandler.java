package com.example.todo.app.common.handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaFileHandler {

    private static final Logger logger = LoggerFactory.getLogger(
            JavaFileHandler.class);

    private String filePath;

    public JavaFileHandler(String filePath) {
        super();
        this.filePath = filePath;
    }

    public void create(byte[] input) {

        try {

            File file = new File(filePath);
            if (file.exists()) {
                logger.debug("フォルダーの既に存在： " + filePath);
            } else {
                logger.debug("フォルダーの新規作成： " + filePath);
                file.mkdirs();
            }

            FileOutputStream fos = new FileOutputStream(filePath + "Main.java");
            fos.write(input);
            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
