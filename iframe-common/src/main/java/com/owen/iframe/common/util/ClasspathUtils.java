package com.owen.iframe.common.util;

import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.net.URLClassLoader;

@Slf4j
public class ClasspathUtils {

    public static void printAllCurrentClasspath()  {
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            //ClassLoader cl = ClassLoader.getSystemClassLoader(); //return AppClassloader only
            URL[] urls = ((URLClassLoader)cl).getURLs();

            for(URL url: urls){
                log.info(url.getFile());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        printAllCurrentClasspath();
    }
}
