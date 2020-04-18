package com.owen.iframe.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class JsonUtils {

    public static <T> String convert2String(T object){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
           throw new RuntimeException(e);
        }
    }

    public static <T> T convert2Object(Class<T> T ,String input){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(input, T);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
