package PS_3_Zadanie3_Dekorator;

import static java.nio.charset.StandardCharsets.UTF_8;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class test_szyfru {
  public static void main(String[] args) throws GeneralSecurityException {
    String plaintext = "Hello world";
    String passphrase = "My passphrase";
    String encrypted = encrypt(passphrase, plaintext);
    String decrypted = decrypt(passphrase, encrypted);
    System.out.println(encrypted);
    System.out.println(decrypted);
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
