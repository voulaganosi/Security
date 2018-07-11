import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.*;
import javax.crypto.*;
import java.util.*;
import javax.xml.bind.DatatypeConverter;
import java.io.*;

public class RSA{
    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Dwse keimeno gia kruptografisi");
        String keimeno = br.readLine();  //eisagwgh keimenou apo to pliktrologio gia kruptografisi
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");	
        KeyPair keys = gen.generateKeyPair(); //dhmiourgia  kleidiwn
        Cipher rsaCipher = Cipher.getInstance("RSA"); // kryptografisi keimenou
        rsaCipher.init(Cipher.ENCRYPT_MODE, keys.getPrivate()); 
        byte[] plaintext = keimeno.getBytes();
        byte[] ciphered_text = rsaCipher.doFinal(plaintext);//metatroph tou keimenou se bytes kai metatropi me to kleidi
        System.out.println("Keimeno se 16diki morfi: " + DatatypeConverter.printHexBinary(ciphered_text));
        rsaCipher.init(Cipher.DECRYPT_MODE,keys.getPublic());// apokryptografisi
        byte[] decoded_text = rsaCipher.doFinal(ciphered_text);
        System.out.println("Arxiko keimeno: " + new String(decoded_text));
    }
}