package com.f.design.decorator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 适配器模式: 对主要的类进行装饰完成最终的构造
 */
public class TestDecorator {
    public static void main(String[] args) {
        new ComponentA(new ComponentB(new ComponentC())).operator();

        System.out.println("----------------");
        var a = new ComponentA();
        var b = new ComponentB();
        a.setComponent(b);
        a.operator();

        TestDecorator testDecorator = new TestDecorator();
        testDecorator.ioReadWriteFile();
    }

    /**
     * 装饰模式，初始化对 读/写 文件的构造
     */
    public void ioReadWriteFile() {
        try (var reader = new BufferedReader(new FileReader(ClassLoader.getSystemResource("io/readme").getFile()));
             var writer = new PrintWriter(new BufferedWriter(new FileWriter("/tmp/foo")))) {
            reader.lines().forEach(line -> writer.println(line));
            writer.flush();
            Files.delete(Path.of("/tmp/foo"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
