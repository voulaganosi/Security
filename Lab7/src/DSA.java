import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;
import java.io.*;

public class DSA {
    public static void main(String args[])throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException, NoSuchProviderException, SignatureException{
           System.out.println("Dwse keimeno gia kruptografisi");
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           String keimeno = br.readLine();  //eisagwgh keimenou apo to pliktrologio gia kruptografisi
           KeyPairGenerator keyGen =KeyPairGenerator.getInstance("DSA", "SUN");
           SecureRandom random =SecureRandom.getInstance("SHA1PRNG", "SUN");
           keyGen.initialize(1024,random);
           KeyPair keys = keyGen.generateKeyPair(); //Dimiourgia zeugos kleidiwn
           PrivateKey privateKey = keys.getPrivate();
           PublicKey publicKey = keys.getPublic();
           Signature dsa = Signature.getInstance("SHA1withDSA","SUN");
           dsa.initSign(privateKey); // dimiourgia kai initialise tou signature obgect
           dsa.update(keimeno.getBytes());
           byte[] realSig = dsa.sign(); //signature
           Signature dsa1 = Signature.getInstance("SHA1withDSA","SUN"); //Dimiourgia sun signature 
           dsa1.initVerify(publicKey); //verify tou signature object me to public key
           dsa1.update(keimeno.getBytes());
           System.out.println(dsa1.verify(realSig)); //dokimi
    }
}
