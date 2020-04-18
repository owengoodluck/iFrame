package com.owen.iframe.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 文件读写工具类。
 *
 */
@Slf4j
public class FileUtils {
    public static final String CHARSET = "UTF-8";

    public static String readTextFromFile(String fileName) {
        return readTextFromFile(fileName, CHARSET);
    }

    public static String readTextFromFile(String fileName, String charset) {


        String content = null;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
            content = IOStreamUtils.readText(inputStream, charset, true);
        } catch (IOException e) {
            log.error("IOError" + e.getMessage() + "\n");

        }

        return content;
    }

    /**
     * @deprecated 将文本内容写入到文本文件中
     *
     * @param path
     *            文件的路径
     * @param content
     *            文本内容
     */
    public static void writeTextToFile22(String path, String content) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            IOStreamUtils.writeText(outputStream, content, true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 将文本内容写入到文本文件中
     *
     * @param path
     *            文件的路径
     * @param content
     *            文本内容
     */
    public static void writeTextToFile(String path, String content) {
        File file = new File(path);

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            // 如果没有调用flush(),也没有关闭输出流，不会将字符串写入文件中
            writer.close();// 关闭流

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        byte[] bytes = new byte[(int) length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "
                    + file.getName());
        }
        is.close();
        return bytes;
    }

    public static void deleteTmpFile(File file) {
        if (file != null) {
            file.delete();
            System.out.println("删除临时pdf文件:" + file.getAbsolutePath());
        }
    }

    public static String getRandomFileName() {
        Date date = new Date();
        String timestamp = date.getTime() + "";
        return timestamp;
    }

    /**
     * 对流进行压缩
     */
    public static byte[] compressBytes(ByteArrayOutputStream outStream)
            throws IOException {
        byte[] input = outStream.toByteArray();
        int cachesize = 1024;
        Deflater compresser = new Deflater();
        compresser.reset();
        compresser.setInput(input);
        compresser.finish();
        byte output[] = new byte[0];
        ByteArrayOutputStream o = new ByteArrayOutputStream(input.length);
        try {
            byte[] buf = new byte[cachesize];
            int got;
            while (!compresser.finished()) {
                got = compresser.deflate(buf);
                o.write(buf, 0, got);
            }
            output = o.toByteArray();
        } finally {
            try {
                o.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return output;
    }

    public static File saveAS(byte[] bytes, String savePath) throws IOException {
        File file = new File(savePath);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.close();
        return file;
    }

    public static byte[] getContent(String filePath) throws IOException {
        FileInputStream in = new FileInputStream(filePath);
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        byte[] temp = new byte[1024];
        int size = 0;
        while ((size = in.read(temp)) != -1) {
            out.write(temp, 0, size);
        }
        in.close();
        byte[] bytes = out.toByteArray();
        return bytes;
    }

    public static boolean isLegalImage(String extention) {
        return ".jpg".equals(extention) || ".gif".equals(extention)
                || ".png".equals(extention);
    }

    /**
     * 压缩文件
     *
     * @param files
     *            需要压缩的文件，文件路径为绝对路径
     * @param zipFilePath
     *            目标压缩文件的绝对路径
     */
    public static void zipFile(List<String> files, String zipFilePath) {
        // 声明压缩流对象
        ZipOutputStream zipOut = null;
        try {
            zipOut = new ZipOutputStream(new FileOutputStream(new File(
                    zipFilePath)));
            for (String file : files) {
                File file2 = new File(file);
                // 设置ZipEntry对象
                zipOut.putNextEntry(new ZipEntry(file2.getName()));
                // zipOut.setComment("www.fansunion.cn");
                zipOut.write(FileUtils.getBytesFromFile(file2));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zipOut != null) {
                try {
                    zipOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}