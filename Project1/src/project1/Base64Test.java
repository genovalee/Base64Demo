package project1;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Paths;

import java.util.Base64;
import java.util.stream.Stream;

public class Base64Test {
    public static void main(String[] args) {
        String str = null;
        String filePath = "c:/temp/2559941.bmp";
        System.out.println(readLine(filePath));
        str = readLine(filePath);

        // Base64編碼
        byte[] encodedBytes = Base64.getEncoder().encode(str.getBytes());
        String encodedStr = new String(encodedBytes);
        System.out.println(encodedStr); // aGVsbG8gd29ybGQ=
        System.out.println("-------------------------------");

        // Base64解碼
        byte[] decodedBytes = Base64.getDecoder().decode(encodedStr.getBytes());
        String decodedStr = new String(decodedBytes);
        System.out.println(decodedStr); // hello world
    }

    private static String readLine(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
}
