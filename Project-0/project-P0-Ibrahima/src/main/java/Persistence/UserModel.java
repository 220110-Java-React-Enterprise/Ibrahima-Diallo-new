package Persistence;

    // class name User information (parameters)
public class UserModel {

    // declare variables as private
    private Integer userAccount;
    private Integer userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    // no arg constructor UserModel()
    public UserModel() {
    }

    // parameterize constructor UserModel()
    public UserModel(Integer userId, String username, String password, String firstName,
                     String lastName, String email) {

        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Another parameterize constructor UserModel()
    public UserModel(String username, String password, String firstName,
                     String lastName, String email) {

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    // getters and setter for variables

    public Integer getUserAccount() { return userAccount; }

    public void setUserAccount(Integer userAccount) { this.userAccount = userAccount; }

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

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

}
