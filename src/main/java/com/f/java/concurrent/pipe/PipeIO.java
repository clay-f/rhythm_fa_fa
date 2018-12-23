package com.f.java.concurrent.pipe;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PipeIO {
    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        var exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(1);
        exec.shutdownNow();
    }
}
