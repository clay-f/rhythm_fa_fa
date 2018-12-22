package com.f.java.concurrent.pipe;

import java.io.IOException;
import java.io.PipedReader;

public class Receiver implements Runnable {
    private PipedReader reader;

    public Receiver(Sender sender) throws IOException {
        this.reader = new PipedReader(sender.getOut());
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Read: " + (char) reader.read() + " ,");
            } catch (IOException e) {
                System.err.println(e + " Receiver read exception");
            }
        }
    }

}
