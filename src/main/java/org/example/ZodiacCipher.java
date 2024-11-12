/**

 * Project: Lab 5
 * Purpose Details: Cipher Assignment
 * Course: IST 242
 * Author: Trevor OMalley
 * Date Developed: 10/31/2024
 * Last Date Changed: 11/10/2024
 * Rev: 2

 */

package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
1. This program uses a `HashMap` to define a mapping of letters (A-Z) to unique symbols.

2. The `encrypt` method replaces each letter in the plaintext with its corresponding symbol.

3. The `decrypt` method reverses the process by mapping symbols back to their respective letters.

4. The main method handles user input, calls the encryption and decryption methods, and displays the results.

 */


public class ZodiacCipher {

    //  Letters to symbols used by Zodiac
    private static final Map<Character, String> cipherMap = new HashMap<>();
    private static final Map<String, Character> reverseCipherMap = new HashMap<>();

    static {
        // Mapping letters to symbols
        cipherMap.put('A', "★");
        cipherMap.put('B', "☽");
        cipherMap.put('C', "✦");
        cipherMap.put('D', "☼");
        cipherMap.put('E', "✧");
        cipherMap.put('F', "✣");
        cipherMap.put('G', "♣");
        cipherMap.put('H', "♦");
        cipherMap.put('I', "♠");
        cipherMap.put('J', "♥");
        cipherMap.put('K', "✿");
        cipherMap.put('L', "❖");
        cipherMap.put('M', "✵");
        cipherMap.put('N', "✸");
        cipherMap.put('O', "☽");
        cipherMap.put('P', "✼");
        cipherMap.put('Q', "✶");
        cipherMap.put('R', "✺");
        cipherMap.put('S', "✵");
        cipherMap.put('T', "✪");
        cipherMap.put('U', "✾");
        cipherMap.put('V', "✱");
        cipherMap.put('W', "✻");
        cipherMap.put('X', "✿");
        cipherMap.put('Y', "✹");
        cipherMap.put('Z', "✺");

        // Reverse mapping for decryption
        cipherMap.forEach((key, value) -> reverseCipherMap.put(value, key));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Plain text input
        System.out.print("Enter text to be encrypted: ");
        String plaintext = scanner.nextLine().toUpperCase(); // Convert to upper case for mapping

        // Encrypt plain text
        String encryptedText = encrypt(plaintext);
        System.out.println("Encrypted text: " + encryptedText);

        // Decrypt the cipher
        String decryptedText = decrypt(encryptedText);
        System.out.println("Decrypted text: " + decryptedText);

        // Close the scanner
        scanner.close();
    }

    // Encryption Method
    public static String encrypt(String plaintext) {
        StringBuilder encryptedText = new StringBuilder();

        // Iterate over each character in the plaintext using for loop
        for (char character : plaintext.toCharArray()) {
            // If the character is in the mapping, append the corresponding symbol
            if (cipherMap.containsKey(character)) {
                encryptedText.append(cipherMap.get(character));
            } else {
                // Append non-letter characters unchanged
                encryptedText.append(character);
            }
        }

        return encryptedText.toString();
    }

    // Method for decryption
    public static String decrypt(String ciphertext) {
        StringBuilder decryptedText = new StringBuilder();
        StringBuilder symbol = new StringBuilder();

        // Iterate over each character in the cipher using for loop
        for (char character : ciphertext.toCharArray()) {
            // Check if the character is a symbol in the mapping
            symbol.append(character);
            if (reverseCipherMap.containsKey(symbol.toString())) {
                // If found, append the corresponding letter to the decrypted text
                decryptedText.append(reverseCipherMap.get(symbol.toString()));
                symbol.setLength(0); // Reset symbol builder
            }
        }

        // Handle any leftover symbols
        if (symbol.length() > 0) {
            decryptedText.append(symbol);
        }

        return decryptedText.toString();
    }
}