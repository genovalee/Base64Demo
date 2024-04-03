package project1;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.io.UnsupportedEncodingException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Base64;

public class Base64Demo {
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        //將Pdf轉換成Base64
        String filePath = "c:/temp/output.zip";
        File pdfFile = new File(filePath);
        byte[] encoded = Files.readAllBytes(Paths.get(pdfFile.getAbsolutePath()));
        Base64.Encoder enc = Base64.getEncoder();
        byte[] strenc = enc.encode(encoded);
        String encode = new String(strenc, "UTF-8");
        System.out.println(encode);
        //將Base64轉換成Pdf
        Base64.Decoder dec = Base64.getDecoder();
        byte[] strdec = dec.decode(encode);
        OutputStream out = new FileOutputStream("c:/temp/test.zip");
        out.write(strdec);
        out.close();
    }
}
