package edu.itstep.security;

import java.security.*;

public class KeyController
{
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private int keySize;

    public KeyController(int keySize)
    {
        if(keySize==2048) this.keySize=2048;
        else this.keySize=1024;
    }
    public PublicKey getPublicKey()
    {
        return publicKey;
    }

    public PrivateKey getPrivateKey()
    {
        return privateKey;
    }
    public void setPublicKey(PublicKey publicKey)
    {
        this.publicKey = publicKey;
    }
    public void setPrivateKey(PrivateKey privateKey)
    {
        this.privateKey = privateKey;
    }
    public void generateRandomKeys() throws NoSuchAlgorithmException
    {
        KeyPairGenerator keyGen = null;
        keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(keySize);
        KeyPair pair = keyGen.generateKeyPair();
        privateKey = pair.getPrivate();
        publicKey = pair.getPublic();
    }
}
