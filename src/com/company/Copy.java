package com.company;

import java.io.*;

public class Copy {
    public static void main (String[] args) throws IOException {

        File source=new File("c:/example/book.pdf");
        System.out.println(source.canRead());
        File dest=new File("c:/example/book_copy.pdf");


        long start=System.nanoTime();
        copyFile(source, dest);
        System.out.println("Time taken = " + (System.nanoTime() - start));

    }

    private static void copyFile (File src, File dest) {
        byte[] data=new byte[1024];
        int fileLength;

        try (InputStream inputStream=new BufferedInputStream(new FileInputStream(src));
             OutputStream outputStream=new BufferedOutputStream(new FileOutputStream(dest))) {

            while ((fileLength=inputStream.read(data)) > 0) {
                outputStream.write(data, 0, fileLength);
            }

        } catch (IOException io) {
        }
    }
}
