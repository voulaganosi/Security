import java.security.*;
import javax.crypto.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import javax.xml.bind.DatatypeConverter;


public class MD5_SHA {
    public static void main(String args[]) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Dwse keimeno gia kruptografisi");
        String keimeno = br.readLine();  //eisagwgh keimenou apo to pliktrologio gia kruptografisi
        System.out.println("Dialexe algorithmo cryptografisis");
        System.out.println("1<--MD5");
        System.out.println("2<--SHA");
        String a = br.readLine();
        byte[] plaintext = keimeno.getBytes(); //metatropi toy keimenou se bytes
        if(a.equals("1")){
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(plaintext);
            byte[] digest = md5.digest(); //i digest exei mesa to hash apo to string pou kaname eisagwgh
            BigInteger bigInt = new BigInteger(1,digest); //kanei to digest se arithmo (1 gia thetika)
            String hashtext = bigInt.toString(16); // metatropi se 16diko
            while(hashtext.length() < 32 ){
                hashtext = "0"+hashtext;
            }
            System.out.println(hashtext);
        }
        else{
            MessageDigest sha = MessageDigest.getInstance( "SHA" );
            sha.update(plaintext);
            byte[] digest = sha.digest(); 
            BigInteger bigInt = new BigInteger(1,digest);
            String hashtext = bigInt.toString(16);
            while(hashtext.length() < 32 ){
                hashtext = "0"+hashtext;
            }
            System.out.println(hashtext);
        }
    }
    //keimeno
    //sha-->8d9592fd7b68800c59a982a45d8065d618e3edaa
}   //md5-->d41bafe966bcf505c20367193a1f12fa
