package edu.uml.nschell;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by
 */

/*This simple class will get the current username successfully logged in and
 *Will save the username to curr.xml, which will be deleted at the end of the session
 * curr.xml will provide username data to all applications
 */

@XmlRootElement

public class CurrentUser {
    private String username;

    public String getUsername() throws Exception {
        String encryptUsername = Encryption.encryptText(username);
        return encryptUsername;
    }

    public void setUsername(String username) throws Exception {
        String decryptUsername = Decryption.decryptText(username);
        this.username = username;
    }
}
