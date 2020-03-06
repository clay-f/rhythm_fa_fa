package com.f.java.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadFile {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        try (FileChannel fileChannel = FileChannel.open(Paths.get(ClassLoader.getSystemResource("io/readme.txt").toURI()), StandardOpenOption.READ)) {
            System.out.println("size: " + fileChannel.size());
            fileChannel.read(byteBuffer);
            byteBuffer.flip();
            int count = byteBuffer.remaining();
            byte[] bytes = new byte[count];
            byteBuffer.get(bytes);
            System.out.println(new String(bytes));
        } catch (URISyntaxException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
