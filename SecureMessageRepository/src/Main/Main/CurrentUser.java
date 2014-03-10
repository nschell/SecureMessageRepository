package Main;

/**
 * Created by
 */

/*This simple class will get the current username successfully logged in and
 *Will save the username to curr.xml, which will be deleted at the end of the session
 * curr.xml will provide username data to all applications
 */

public class CurrentUser {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
