import java.security.*;

import javax.crypto.*;

import java.io.*;

import java.util.*;

import javax.xml.bind.DatatypeConverter;




public class CryptoAlg {

    public static void main(String args[]) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Dwse keimeno gia kruptografisi");

        String keimeno = br.readLine();

        System.out.println("Dialexe algorithmo cryptografisis");

        System.out.println("1<--3DES");

        System.out.println("2<--AES");

        String a = br.readLine();

        if(a.equals("1")){

            KeyGenerator keygen = KeyGenerator.getInstance("DESede");

            SecretKey tdesKey = keygen.generateKey();

            Cipher tdesCipher = Cipher.getInstance("DESede");

            tdesCipher.init(Cipher.ENCRYPT_MODE, tdesKey);

            byte[] plaintext = keimeno.getBytes();

            byte[] ciphered_text = tdesCipher.doFinal(plaintext);

            System.out.println("encoded text in hexadecimal format is: " + DatatypeConverter.printHexBinary(ciphered_text));

            Cipher Dec_tdesCipher = Cipher.getInstance("DESede");

            Dec_tdesCipher.init(Cipher.DECRYPT_MODE,tdesKey);

            byte[] decoded_text = Dec_tdesCipher.doFinal(ciphered_text);

            System.out.println("decoded text is: " + new String(decoded_text));

        }

        else{

            KeyGenerator keygen = KeyGenerator.getInstance("AES");

            SecretKey aeskey = keygen.generateKey();

            Cipher aesCipher = Cipher.getInstance("AES");

            aesCipher.init(Cipher.ENCRYPT_MODE, aeskey);

            byte[] plaintext = keimeno.getBytes();

            byte[] ciphered_text = aesCipher.doFinal(plaintext);

            System.out.println("encoded text in hexadecimal format is: " + DatatypeConverter.printHexBinary(ciphered_text));

            Cipher Dec_AES_Cipher = Cipher.getInstance("AES");

            Dec_AES_Cipher.init(Cipher.DECRYPT_MODE,aeskey);

            byte[] decoded_text = Dec_AES_Cipher.doFinal(ciphered_text);

            System.out.println("decoded text is: " + new String(decoded_text));

        }

    }

}
