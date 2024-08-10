/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encrypt;

/**
 *
 * @author ndhlt
 */
public class test {
    public static void main(String[] args) {
        String pass = "kuroneko1215";
        String hashed = SHA256.hashPassword(pass);
        System.out.println(hashed);
        String pass1 = "kuroneko1215";
        String hashed1 = SHA256.hashPassword(pass1, SHA256.getSalt(hashed));
        System.out.println(hashed1);
        System.out.println(hashed.equals(hashed1));

        System.out.println(AES.generateSecretKey());
    }
}
