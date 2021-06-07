package com.owen.iframe.poc.common.text;

import org.apache.commons.text.StringSubstitutor;
import org.apache.commons.text.lookup.StringLookup;
import org.apache.commons.text.lookup.StringLookupFactory;

import java.util.HashMap;
import java.util.Map;

public class StringSubstitutorDemo {


    public static void main(String[] args) {

        Map<String, StringLookup> stringLookupMap = new HashMap<>();
        stringLookupMap.put("CURRENT_TIMESTAMP", new CurrentTimeStamStringLookup("China"));

        Map<String, String> defaultStringMap = new HashMap<>();
        defaultStringMap.put("USER_NAME", "Owen");
        defaultStringMap.put("ENTITY_CODE", "HK");

        StringSubstitutor stringSubstitutor = new StringSubstitutor(
                StringLookupFactory.INSTANCE.interpolatorStringLookup(
                        stringLookupMap,
                        StringLookupFactory.INSTANCE.mapStringLookup(defaultStringMap),
                        false),
                "$[",
                "]",
                '\\'
        );

        String input = "User = $[USER_NAME]; entity=$[ENTITY_CODE]; timestamp = $[CURRENT_TIMESTAMP:yyyy-MM-dd]";
        String output = stringSubstitutor.replace(input);
        System.out.println(input);
        System.out.println(output);
    }
}
