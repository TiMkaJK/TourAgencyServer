package edu.itstep.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class FileController
{
    private File f;
    private String path;

    public FileController(String path)
    {
        setFile(path);
    }
    public void setFile(String path)
    {
        this.path = path;
        f = new File(path);
    }

    public void writePrivateKeyToFile(PrivateKey privateKey) throws IOException
    {
        f.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(privateKey.getEncoded());
        fos.flush();
        fos.close();
    }

    public void writePublicKeyToFile(PublicKey publicKey) throws IOException
    {
        f.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(publicKey.getEncoded());
        fos.flush();
        fos.close();
    }

    public PublicKey readPublicKeyFromFile() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
    {
        PublicKey publicKey = null;
        FileInputStream fis = new FileInputStream(f);
        byte[] bytesOfPublicKey = new byte[(int) f.length()];
        fis.read(bytesOfPublicKey);
        publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bytesOfPublicKey));
        fis.close();
        return publicKey;
    }

    public PrivateKey readPrivateKeyFromFile() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
    {
        PrivateKey privateKey = null;
        FileInputStream fis = new FileInputStream(f);
        byte[] bytesOfPrivateKey = new byte[(int) f.length()];
        fis.read(bytesOfPrivateKey);
        privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bytesOfPrivateKey));
        fis.close();
        return privateKey;
    }

    public void writeMessage(byte[] message) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(message);
        fos.flush();
        fos.close();
    }

    public byte[] readMessage() throws IOException
    {
        FileInputStream fis = new FileInputStream(f);
        byte[] encryptedBytes = new byte[(int)f.length()];
        fis.read(encryptedBytes);
        return encryptedBytes;
    }
}
