package com.owen.iframe.common.url.jnet;


import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/**
 * This is a wrapper to make a url stream handler factory a parent aware url stream
 * handler factory.
 */
public class URLStreamHandlerFactoryWrapper extends ParentAwareURLStreamHandlerFactory {

    protected final URLStreamHandlerFactory wrapper;

    public URLStreamHandlerFactoryWrapper(URLStreamHandlerFactory f) {
        this.wrapper = f;
    }

    protected URLStreamHandler create(String protocol) {
        return this.wrapper.createURLStreamHandler(protocol);
    }


}