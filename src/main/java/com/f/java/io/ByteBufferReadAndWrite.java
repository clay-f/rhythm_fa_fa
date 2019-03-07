package com.f.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import static com.f.java.base.util.Print.print;

public class ByteBufferReadAndWrite {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        readAndWriteByteBuffer();
    }

    /**
     *  不管 {@link ByteBuffer} 使用 `as` 怎么变 e.g. charbuffer, intbuffer，操作的都是底层 bytebuffer
     */
    public static void chagenByteBufferPositionValue() {
        java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        // Store an array of int:
        ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016});
        // Absolute location read and write:
        System.out.println(ib.get(3));
        ib.put(3, 1811);
        // Setting a new limit before rewinding the buffer.
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }
    }

    public static void readAndWriteByteBuffer() {
        Charset charset = Charset.forName("utf-8");
        try {
            FileChannel out = new FileOutputStream("/tmp/hello").getChannel(),
                    in = new FileInputStream("/tmp/hello").getChannel();

            ByteBuffer byteBuffer = ByteBuffer.wrap("hello word 你好 こんにちは Bonjour".getBytes());
            out.write(byteBuffer);
            out.close();

            byteBuffer.clear();
            while (in.read(byteBuffer) != -1) {
                byteBuffer.flip();
                print(charset.decode(byteBuffer));
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}