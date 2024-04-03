package project1;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Paths;

import java.util.Base64;
import java.util.stream.Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) {
        String filePath = "c:/temp/wonderlust_mac.png";
        try {
            // 讀取檔案內容為byte陣列
            byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));

            // Base64編碼
            byte[] encodedBytes = Base64.getEncoder().encode(fileBytes);
            String encodedStr = new String(encodedBytes);
            System.out.println(encodedStr);

            System.out.println("-------------------------------");

            // Base64解碼
            byte[] decodedBytes = Base64.getDecoder().decode(encodedStr);
            System.out.println("Decoded bytes length: " + decodedBytes.length); // 檢查解碼後的byte陣列長度是否正確
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
