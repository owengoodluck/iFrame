package com.owen.iframe.common.url;

import com.owen.iframe.common.url.jnet.Installer;

import java.net.URLStreamHandlerFactory;

public class URLHanlderRegister {

    public static void register(URLStreamHandlerFactory factory ){
        try {
            Installer.setURLStreamHandlerFactory(factory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
