package Persistence;

import Utils.ConnectionManager;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

    // class implements an interface
public class UserRepo implements DataSourceCRUD<UserModel>{

    @Override
    public Integer create(UserModel userModel) /*throws SQLException, IOException */ {

        try {
            String sql = "INSERT INTO users (username, password, firstName, lastName, email) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = ConnectionManager.getConnection()
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, userModel.getUsername());
            pstmt.setString(2, userModel.getPassword());
            pstmt.setString(3, userModel.getFirstName());
            pstmt.setString(4, userModel.getLastName());
            pstmt.setString(5, userModel.getEmail());


            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserModel read(Integer id) {

    try{
        String sql = "SELECT * FROM users WHERE user_id = ?";

        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        UserModel usermodel = new UserModel();
        if(rs.next()) {

            usermodel.setUserId(rs.getInt("user_id"));
            usermodel.setUsername(rs.getString("username"));
            usermodel.setPassword(rs.getString("password"));
            usermodel.setFirstName(rs.getString("firstName"));
            usermodel.setLastName(rs.getString("lastName"));
            usermodel.setEmail(rs.getString("email"));

            return usermodel;

        } else {
            return null;
        }

        } catch (Exception e) {
             e.printStackTrace();
        }
        return null;
    }

        public UserModel update(UserModel userModel) {

        try{
            String sql = "UPDATE users SET username = ?, password = ?," +
                    "firstName = ?, lastName = ?, email =? WHERE user_id = ?";

            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setString(1, userModel.getUsername());
            pstmt.setString(2, userModel.getPassword());
            pstmt.setString(3, userModel.getFirstName());
            pstmt.setString(4, userModel.getLastName());
            pstmt.setString(5, userModel.getEmail());
            pstmt.setInt(6, userModel.getUserId());

            pstmt.executeUpdate();

            String verify = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement vstmt = ConnectionManager.getConnection().prepareStatement(verify);
            pstmt.setInt(1, userModel.getUserId());
            ResultSet rs = vstmt.executeQuery();

            if(rs.next()) {
                UserModel verifiedUserModel = new UserModel();

                verifiedUserModel.setUserId(rs.getInt("user_id"));
                verifiedUserModel.setUsername(rs.getString("username"));
                verifiedUserModel.setPassword(rs.getString("password"));
                verifiedUserModel.setFirstName(rs.getString("firstName"));
                verifiedUserModel.setLastName(rs.getString("lastName"));
                verifiedUserModel.setEmail(rs.getString("email"));

                return verifiedUserModel;
            }

            } catch (Exception e) {
                    e.printStackTrace();
            }

            return null;

        }

    @Override
    public void delete(Integer id) {

    try{
        String sql = "DELETE FROM users WHERE user_id = ?";

        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();

         } catch (Exception e) {
                 e.printStackTrace();
         }

    }
        /*
                Verification of the user information
        **/
    public UserModel authenticate(String username, String password) {

    try{
        String sql = "SELECT * FROM users WHERE username = ?";

        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();

        if(rs.next() && rs.getString("password").equals(password)) {
            return new UserModel(rs.getInt("user_id"), rs.getString("username"),
                    rs.getString("password"), rs.getString("firstName"),
                    rs.getString("lastName"), rs.getString("email"));
        }

        } catch (Exception e) {
                e.printStackTrace();
        }
            return null;
    }
}
