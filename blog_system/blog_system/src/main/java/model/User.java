package model;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-08-18
 * Time: 15:06
 */
public class User {
    private int userId;
    private String username;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
}
