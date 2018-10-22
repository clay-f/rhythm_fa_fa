package com.f.java.stream.spliterator;

import java.util.stream.Stream;

public class SplitTest {
    public static void main(String[] args) {

    }

    public int countWords(Stream<WordCounter> stream) {
        /**
         * error  accumulate parameter error
         * stream.reduce should give three params
         * one: counter
         * two: accumulate method
         * three: combine
         */
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::combine);
        return wordCounter.getCounter();
    }
}
