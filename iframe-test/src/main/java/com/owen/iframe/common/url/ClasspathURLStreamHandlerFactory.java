package com.owen.iframe.common.url;

import com.owen.iframe.common.url.jnet.ParentAwareURLStreamHandlerFactory;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * sample URL "classpath:log4j2.xml";
 */
public class ClasspathURLStreamHandlerFactory extends ParentAwareURLStreamHandlerFactory {

    @Override
    protected URLStreamHandler create(String protocol) {
        if("classpath".equalsIgnoreCase(protocol)){
            return new URLStreamHandler(){
                @Override
                protected URLConnection openConnection(URL u) throws IOException {
                    return Thread.currentThread().getContextClassLoader().getResource(u.getPath()).openConnection();
                }
            };
        }
        return null;
    }

}

