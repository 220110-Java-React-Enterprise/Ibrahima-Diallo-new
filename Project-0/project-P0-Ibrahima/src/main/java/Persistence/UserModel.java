package Persistence;

public class UserModel {

    // declare variables
    private Integer userId;
    private String username;
    private String password;

    // no arg constructor UserModel()
    public UserModel() {
    }
    // parameterize constructor UserModel()
    public UserModel(Integer userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
    // Another parameterize constructor UserModel()
    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
    // getters and setter for variables
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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
}
