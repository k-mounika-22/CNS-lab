import java.util.Scanner;

public class rsa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter two prime numbers (p and q):");
        long p = scanner.nextLong();
        long q = scanner.nextLong();

        long n = p * q;
        long phi = (p - 1) * (q - 1);

        long e = calculatePublicKey(phi);
        System.out.println("Public key (e, n): (" + e + ", " + n + ")");

        long d = calculatePrivateKey(e, phi);
        System.out.println("Private key (d, n): (" + d + ", " + n + ")");

        System.out.println("Enter message to encrypt (as a number):");
        long message = scanner.nextLong();

        long encryptedMessage = encrypt(message, e, n);
        System.out.println("Encrypted message: " + encryptedMessage);

        long decryptedMessage = decrypt(encryptedMessage, d, n);
        System.out.println("Decrypted message: " + decryptedMessage);

        scanner.close();
    }

    // Function to calculate public key (e)
    private static long calculatePublicKey(long phi) {
        long e = 2;
        while (e < phi) {
            if (gcd(e, phi) == 1)
                break;
            e++;
        }
        return e;
    }

    // Function to calculate private key (d)
    private static long calculatePrivateKey(long e, long phi) {
        long d = 2;
        while ((d * e) % phi != 1) {
            d++;
        }
        return d;
    }

    // Function to find greatest common divisor
    private static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Function to encrypt message
    private static long encrypt(long message, long e, long n) {
        return power(message, e) % n;
    }

    // Function to decrypt message
    private static long decrypt(long encryptedMessage, long d, long n) {
        return power(encryptedMessage, d) % n;
    }

    // Function to calculate power
    private static long power(long x, long y) {
        long result = 1;
        while (y > 0) {
            if (y % 2 == 1)
                result = (result * x);
            y = y >> 1;
            x = (x * x);
        }
        return result;
    }
}
