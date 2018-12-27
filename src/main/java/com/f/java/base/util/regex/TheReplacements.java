package com.f.java.base.util.regex;//: strings/TheReplacements.java

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.*;

import static com.f.java.base.util.Print.print;


public class TheReplacements {
    public static void main(String[] args) throws Exception {
        var s = Files.readString(Paths.get(ClassLoader.getSystemResource("regex/replacements.txt").toURI()));
        // Match the specially commented block of text above:
        Matcher mInput =
                Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL)
                        .matcher(s);
        if (mInput.find())
            s = mInput.group(1); // Captured by parentheses
        // Replace two or more spaces with a single space:
        s = s.replaceAll(" {2,}", " ");
        // Replace one or more spaces at the beginning of each
        // line with no spaces. Must enable MULTILINE mode:
        s = s.replaceAll("(?m)^ +", "");
        print(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        // Process the find information as you
        // perform the replacements.txt:
        while (m.find())
            m.appendReplacement(sbuf, m.group().toUpperCase());
        // Put in the remainder of the text:
        m.appendTail(sbuf);
        print(sbuf);
    }
}
