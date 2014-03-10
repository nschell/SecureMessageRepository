package Main;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 */
/* This class will be used for storing username/passwords for authentication
 * Each user will input username/password, and that info will be saved in UserInfo.XML
 * UserInfo.XML will be referred to when a user attempts to login.
 */
@XmlRootElement
public class UsernamePassword {
    private String Username;
    private String Password;
    private Boolean Active;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean Active) {
        this.Active = Active;
    }


}
