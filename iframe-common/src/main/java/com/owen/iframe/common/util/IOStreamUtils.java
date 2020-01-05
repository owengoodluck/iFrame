package com.owen.iframe.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * 输入输出流工具类。
 *
 */
@Slf4j
public class IOStreamUtils {
    public static final String default_encoding="UTF-8";

    public static String readText(InputStream inputStream, boolean close) {
       return readText(inputStream,default_encoding,close);
    }

    /**
     * 从输入流中读取文本内容。
     *
     * @param inputStream
     *            输入流
     * @param encoding
     *            输入流中内容的编码
     * @param close
     *            读取内容之后，是否关闭输入流。close为true表示关闭，false表示不关闭。
     * @return 输入流中的文本内容
     */
    public static String readText(InputStream inputStream, String encoding, boolean close) {
        String text = null;
        if (close) {
            text = readTextAndClose(inputStream, encoding);
        } else {
            text = readText(inputStream, encoding);
        }

        return text;
    }

    /**
     * 从输入流中读取文本内容，读取内容之后，不关闭输入流。
     *
     * @param inputStream
     *            输入流
     * @param encoding
     *            输入流中内容的编码
     * @return 输入流中的文本内容
     */
    public static String readText(InputStream inputStream, String encoding) {
        InputStreamReader inputStreamReader = null;
        StringBuffer sb = new StringBuffer("");
        try {
            inputStreamReader = new InputStreamReader(inputStream, encoding);

            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException  e) {
            log.error(e.getMessage(),e);
        }

        return sb.toString();
    }

    /**
     * 从输入流中读取文本内容，读取内容之后，关闭输入流。
     *
     * @param inputStream
     *            输入流
     * @param encoding
     *            输入流中内容的编码
     * @return 输入流中的文本内容
     */
    public static String readTextAndClose(InputStream inputStream, String encoding) {
        String text = null;

        text = readText(inputStream, encoding);
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return text;
    }

    /**
     * 向输出流中写文本内容。
     *
     * @param outputStream
     *            输出流
     * @param content
     *            文本内容
     * @param close
     *            读取内容之后，是否关闭输出流。close为true表示关闭，false表示不关闭。
     */
    public static void writeText(OutputStream outputStream, String content,
                                 boolean close) {
        if (close) {
            writeTextAndClose(outputStream, content);
        } else {
            writeText(outputStream, content);
        }
    }

    /**
     * 向输出流中写文本内容，不关闭输出流。
     *
     * @param outputStream
     *            输出流
     * @param content
     *            文本内容
     */
    public static void writeText(OutputStream outputStream, String content) {
        OutputStreamWriter outputStreamWriter = null;
        outputStreamWriter = new OutputStreamWriter(outputStream);
        try {
            outputStreamWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 向输出流中写文本内容，写完之后关闭输出流。
     *
     * @param outputStream
     *            输出流
     * @param content
     *            文本内容
     */
    public static void writeTextAndClose(OutputStream outputStream,  String content) {
        writeText(outputStream, content);

        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}