package com.f.java.io;
// Uses Zip compression to compress any
// number of files given on the command line.
// {Args: ZipCompress.java}

import java.util.zip.*;
import java.io.*;
import java.util.*;

import static com.f.java.base.util.Print.print;

public class ZipCompress {
    public static final String srcDir = "/tmp/hello.zip";

    public static void main(String[] args) throws IOException {
        ZipFile zipFile = new ZipFile(srcDir);
        zipFile.stream()
                .forEach((ZipEntry item) -> {
                    System.out.println(item.getName());
                });
    }

    /**
     * 根据目录结构压缩目录文件夹.
     * <p>
     * 若目录结构是多个文件与多个文件夹混合交叉，则按照目录结构压缩文件。
     *
     * @param sourceDir 要被压缩的文件夹路径
     * @param targetDir 压缩包文件夹路径
     */
    public void zipDir(String sourceDir, String targetDir) {
        try (var zop = new ZipOutputStream(new CheckedOutputStream(new BufferedOutputStream(new FileOutputStream(targetDir)), new CRC32()))) {
            zipArchive(zop, new File(sourceDir), "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void zipArchive(ZipOutputStream zop, File file, String parentDir) {
        if (file == null || !file.exists())
            return;

        String zipEntryName = file.getName();
        if (parentDir != null && !parentDir.isEmpty())
            zipEntryName = parentDir + "/" + file.getName();

        if (file.isDirectory()) {
            System.out.println("+" + zipEntryName);
            for (File item : file.listFiles())
                zipArchive(zop, item, zipEntryName);
        } else {
            try (var fileInputStream = new BufferedInputStream(new FileInputStream(file))) {
                System.out.println("   " + zipEntryName);
                byte[] bytes = new byte[1024];
                zop.putNextEntry(new ZipEntry(zipEntryName));
                while ((fileInputStream.read(bytes, 0, 1024)) > 0)
                    zop.write(bytes, 0, 1024);
                zop.closeEntry();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用 <strong>adler32</strong>校验和压缩一个目录下的所有文件并形成一个压缩包。
     * 并解压压缩包文件，读取文件内容。
     *
     * @param args 多个文件名字。用来被打包为一个压缩包
     * @throws IOException
     */
    public void zipSimpleDirAndunZip(String... args) throws IOException {

        try (var csum = new CheckedOutputStream(new FileOutputStream("test.zip"), new Adler32()); var zos = new ZipOutputStream(csum);
             var out = new BufferedOutputStream(zos)) {
            zos.setComment("A test of Java Zipping");
            // No corresponding getComment(), though.
            for (String arg : args) {
                print("Writing file " + arg);
                BufferedReader in =
                        new BufferedReader(new FileReader(arg));
                zos.putNextEntry(new ZipEntry(arg));
                int c;
                while ((c = in.read()) != -1)
                    out.write(c);
                in.close();
                out.flush();
            }
            out.close();
            // Checksum valid only after the file has been closed!
            print("Checksum: " + csum.getChecksum().getValue());
            // Now extract the files:
            print("Reading file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream fi = new FileInputStream("test.zip");
        CheckedInputStream csumi =
                new CheckedInputStream(fi, new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while ((ze = in2.getNextEntry()) != null) {
            print("Reading file " + ze);
            int x;
            while ((x = bis.read()) != -1)
                System.out.write(x);
        }
        if (args.length == 1)
            print("Checksum: " + csumi.getChecksum().getValue());
        bis.close();
        // Alternative way to open and read Zip files:
        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry) e.nextElement();
            print("File: " + ze2);
            // ... and extract the data as before
        }
    }
} /* (Execute to see output) *///:~
