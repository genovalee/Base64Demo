# 將PDF檔轉換成案Base64編碼
### 使用try-with-resource語句可以確保資源被正確地關閉,即使在執行過程中發生了異常。
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
---
*讀取來源PDF檔案*[c:/temp/20160128-語言技術JSF.pdf]
---
*還原目的PDF檔案*[c:/temp/test.pdf]
---
## 將圖檔轉換成base64編碼
#### 程式範例
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
