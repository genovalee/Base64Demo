package project1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStream;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Base64;

public class Base64Demo {
    public static void main(String[] args) {
        String filePath = "c:/temp/20160128-語言技術JSF.pdf";
        try {
            // 將PDF轉換成Base64
            byte[] encoded = Files.readAllBytes(Paths.get(new File(filePath).getAbsolutePath()));
            Base64.Encoder enc = Base64.getEncoder();
            byte[] strenc = enc.encode(encoded);
            String encode = new String(strenc, "UTF-8");
            System.out.println(encode);

            // 將Base64轉換成PDF
            Base64.Decoder dec = Base64.getDecoder();
            byte[] strdec = dec.decode(encode);
            try (OutputStream out = new FileOutputStream("c:/temp/test.pdf")) {
                out.write(strdec);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
