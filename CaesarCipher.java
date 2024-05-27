import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text to encrypt: ");
        String plaintext = scanner.nextLine();
        System.out.print("Enter the shift value (a number between 1 and 25): ");

        int shift = scanner.nextInt();

        String ciphertext = encryptCaesar(plaintext, shift);
        System.out.println("Encrypted text: " + ciphertext);

        String decryptedText = decryptCaesar(ciphertext, shift);
        System.out.println("Decrypted text: " + decryptedText);
        scanner.close();
    }

    public static String encryptCaesar(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + shift) % 26 + base);
            }
            ciphertext.append(ch);
        }
        return ciphertext.toString();
    }

    public static String decryptCaesar(String ciphertext, int shift) {
        return encryptCaesar(ciphertext, 26 - shift);
    }
}
