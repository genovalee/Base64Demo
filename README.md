# 將PDF檔轉換成案Base64編碼
### 使用try-with-resource語句可以確保資源被正確地關閉,即使在執行過程中發生了異常。
<pre>
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
</pre>
---
*讀取來源PDF檔案*[c:/temp/20160128-語言技術JSF.pdf]
---
*還原目的PDF檔案*[c:/temp/test.pdf]
---
