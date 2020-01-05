package com.owen.iframe.common.util;

import com.owen.iframe.common.url.ClasspathURLStreamHandlerFactory;
import com.owen.iframe.common.url.URLHanlderRegister;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.net.URL;

@Slf4j
public class ClasspathURLStreamHandlerTest {

    @Before
    public void init(){
        URLHanlderRegister.register(new ClasspathURLStreamHandlerFactory());
    }

    @Test
    public void test() throws Exception {
        URL url = new URL("classpath:log4j2.xml");
        InputStream is = url.openConnection().getInputStream();
        String content = IOStreamUtils.readText(is,  true);
        log.info(content);
    }

}
