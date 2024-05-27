import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class aes {

    public static void main(String[] args) {
        try {
            byte[] key = "0123456789abcdef".getBytes();

            byte[] plaintext = "Hello, AES!".getBytes();

            byte[] encrypted = encrypt(plaintext, key);
            System.out.println("Encrypted: " + bytesToHex(encrypted));

            byte[] decrypted = decrypt(encrypted, key);
            System.out.println("Decrypted: " + new String(decrypted));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(byte[] plaintext, byte[] key) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return cipher.doFinal(plaintext);
    }

    public static byte[] decrypt(byte[] ciphertext, byte[] key) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        return cipher.doFinal(ciphertext);
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
