package edu.itstep.security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RSAController
{
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private byte[] encryptedMessage;
    private String decryptedMessage;

    public RSAController()
    {
        publicKey = null;
        privateKey = null;
    }

    public RSAController(PublicKey publicKey)
    {
        this.publicKey = publicKey;
        this.privateKey = null;
    }

    public RSAController(PrivateKey privateKey)
    {
        this.privateKey = privateKey;
        this.publicKey = null;
    }

    public void setPublicKey(PublicKey publicKey)
    {
        this.publicKey = publicKey;
    }

    public void setPrivateKey(PrivateKey privateKey)
    {
        this.privateKey = privateKey;
    }

    public PublicKey getPublicKey()
    {
        return publicKey;
    }

    public PrivateKey getPrivateKey()
    {
        return privateKey;
    }

    public byte[] getEncryptedMessage()
    {
        return encryptedMessage;
    }

    public String getDecryptedMessage()
    {
        return decryptedMessage;
    }

    public void encrypt(String data) throws BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException,
                                            NoSuchAlgorithmException, InvalidKeyException
    {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey());
        this.encryptedMessage = cipher.doFinal(data.getBytes());
    }

    public void decrypt(byte[] data) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
                                            BadPaddingException, IllegalBlockSizeException
    {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        this.decryptedMessage = new String(cipher.doFinal(data));
    }

    public void decrypt(String data) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException,
                                            NoSuchAlgorithmException, NoSuchPaddingException
    {
        decrypt(Base64.getDecoder().decode(data.getBytes()));
    }
}
