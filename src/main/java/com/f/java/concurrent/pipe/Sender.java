package com.f.java.concurrent.pipe;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Sender implements Runnable {
    private Random random = new Random(47);
    private PipedWriter out = new PipedWriter();

    public PipedWriter getOut() {
        return out;
    }

    @Override
    public void run() {
        while (true) {
            for (char c = 'A'; c<='z'; c++){
                try {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                } catch (IOException e) {
                    System.err.println(e + " Sender write exception");
                } catch (InterruptedException e) {
                    System.err.println(e + " Sender sleep interrupted");
                }
            }
        }
    }
}
