package com.mycompany.caesercipher;

import java.util.Scanner;

/**
 *
 * @author moataz
 */
public class CaeserCipher {

    /**
     * Enciphers the given plain text using the Caesar cipher with the specified key.
     *
     * @param plainText The input plain text to be enciphered.
     * @param key       The key for the Caesar cipher.
     * @return A StringBuilder containing the enciphered text.
     */
    public static StringBuilder encipher(String plainText, int key) {
        int size = plainText.length();
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char c = plainText.charAt(i);
            if (c >= 'a' && c <= 'z') {
                cipherText.append((char) ((c - 'a' + key) % 26 + 'a'));// substracted 26 inside () to bring a letter back into range of 0 to 25, and after operation is done, add 'a' to use it as ascii 
            } else if (c >= 'A' && c <= 'Z') {
                cipherText.append((char) ((c - 'A' + key) % 26 + 'A'));
            } else {
                cipherText.append(c);
            }
        }
        return cipherText;
    }

    /**
     * Deciphers the given cipher text using the Caesar cipher with the specified key.
     *
     * @param cipherText The input cipher text to be deciphered.
     * @param key        The key for the Caesar cipher.
     * @return A StringBuilder containing the deciphered text.
     */
    public static StringBuilder decipher(String cipherText, int key) {
        int size = cipherText.length();

        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char p = cipherText.charAt(i);
            if (p >= 'a' && p <= 'z') {
                plainText.append((char) ((p - 'a' - key + 26) % 26 + 'a'));
            }else if (p >= 'A' && p <= 'Z') {
                plainText.append((char) ((p - 'A' - key + 26) % 26 + 'A'));
            } else {
                plainText.append(p);
            }
        }

        return plainText;
    }
    
    
    public static void main(String[] args) {
     
        Scanner input = new Scanner(System.in);

        String str;
        int key;
        
        System.out.println("Enter The Message You Want To Encrypt/Decrypt : ");
        str = input.nextLine();
        
        System.out.println("Enter Your Choice : \n1. Encrypt \n2. Decrypt");
        int choice = input.nextInt();
        
        
        System.out.println("Enter a Key : ");
        key = input.nextInt();
                
        switch(choice){
            case 1:
                System.out.println("Encrypted Message of \""+str+"\" is \""+encipher(str, key)+"\"");
                break;
            case 2:
                System.out.println("Decrypted Message of \""+str+"\" is \""+decipher(str, key)+"\"");
                break;
            default:
                System.out.println("Wrong Choice");
        }
        
      
    }

}
