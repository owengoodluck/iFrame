package com.owen.iframe.poc.common.text;

import lombok.AllArgsConstructor;
import org.apache.commons.text.lookup.StringLookup;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
public class CurrentTimeStamStringLookup implements StringLookup {
    private String zone;

    @Override
    public String lookup(String key) {
        return zone+":"+ZonedDateTime.now(Clock.systemUTC()).format(DateTimeFormatter.ofPattern(key));
    }
}
