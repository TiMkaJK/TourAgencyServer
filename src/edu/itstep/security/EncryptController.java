package edu.itstep.security;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class EncryptController
{
    private KeyController keyController;
    private RSAController rsaController;

    public EncryptController()
    {
        this.keyController = new KeyController(2048);
        try
        {
            this.keyController.generateRandomKeys();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        this.rsaController = new RSAController(this.keyController.getPrivateKey());
    }

    public PublicKey getPublicKey()
    {
        return keyController.getPublicKey();
    }

    public String decrypt(byte[] data)
    {
        try
        {
            rsaController.decrypt(data);
        }
        catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e)
        {
            e.printStackTrace();
        }
        return rsaController.getDecryptedMessage();
    }
}
