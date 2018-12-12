package PS_3_Zadanie3_Dekorator;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class DekoratorSzyfrowanie2 extends Dekorator{
    private static String fraza = "Moja fraza";
    public DekoratorSzyfrowanie2(IMailbox obj)
    {
        super(obj);
    }
        @Override
     public  void push(String s)
        {
            
        try {
            super.push(encrypt(fraza, s));
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(DekoratorSzyfrowanie2.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        @Override
     public  void pop()
        {
           super.pop();
        }
        @Override
       public String getMail()
        {
        try {
            String mail = super.getMail();
            return decrypt(fraza, mail);
     
                    } catch (GeneralSecurityException ex) {
            Logger.getLogger(DekoratorSzyfrowanie2.class.getName()).log(Level.SEVERE, null, ex);
        }
           return "Błąd";
     
        }
private static SecretKeySpec getKeySpec(String passphrase) throws NoSuchAlgorithmException {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    return new SecretKeySpec(digest.digest(passphrase.getBytes(UTF_8)), "AES");
}

private static Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
    return Cipher.getInstance("AES/CBC/PKCS5PADDING");
}

public static String encrypt(String passphrase, String value) throws GeneralSecurityException {
    byte[] initVector = new byte[16];
    SecureRandom.getInstanceStrong().nextBytes(initVector);
    Cipher cipher = getCipher();
    cipher.init(Cipher.ENCRYPT_MODE, getKeySpec(passphrase), new IvParameterSpec(initVector));
    byte[] encrypted = cipher.doFinal(value.getBytes());
    return DatatypeConverter.printBase64Binary(initVector) +
            DatatypeConverter.printBase64Binary(encrypted);
}

public static String decrypt(String passphrase, String encrypted) throws GeneralSecurityException {
    byte[] initVector = DatatypeConverter.parseBase64Binary(encrypted.substring(0, 24));
    Cipher cipher = getCipher();
    cipher.init(Cipher.DECRYPT_MODE, getKeySpec(passphrase), new IvParameterSpec(initVector));
    byte[] original = cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted.substring(24)));
    return new String(original);
}
}
