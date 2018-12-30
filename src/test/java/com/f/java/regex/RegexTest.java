package com.f.java.regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class RegexTest {
    private String str = "haha hello Python is an easy to learn ";
    @Test
    void regexReplaceTest() {
       var pattern =  Pattern.compile("(\\w+)?+");
        var match = pattern.matcher(str);
        System.out.println(match.lookingAt());
        match.find();
        StringBuffer stringBuffer = new StringBuffer();
        match.appendReplacement(stringBuffer, match.group());
        System.out.println(stringBuffer);
        System.out.println(match.appendTail(stringBuffer));
    }
}
