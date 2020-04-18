package com.owen.iframe.common.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Log4j2Test {
    @Test
    public void testLog(){
        log.info("info");
        log.warn("warn");
        log.error("error");
    }
}
