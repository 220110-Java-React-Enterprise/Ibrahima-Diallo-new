package Persistence;

import Utils.ConnectionManager;
import Utils.CustomArrayList;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

        // Class implements Interface
public class AccountRepo implements DataSourceCRUD<AccountModel>{

            // CRUD: Create Read, Update, Delete

            /*    Override create() an account method
            * */
    @Override
    public Integer create(AccountModel accountModel) throws SQLException, IOException {

        String sql = "INSERT INTO accounts (balance, user_id) VALUES (?, ?)";
        PreparedStatement pstmt = ConnectionManager.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pstmt.setDouble(1, accountModel.getBalance());
        pstmt.setInt(2, accountModel.getUserId());


        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return null;
    }

        /*
                Override the read() method which get the id
        * */
    @Override
    public AccountModel read(Integer id) throws SQLException, IOException {

        String sql = "SELECT * FROM accounts WHERE account_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            AccountModel accModl = new AccountModel();
                         accModl.setAccountId(rs.getInt("account_id"));
                         accModl.setUserId(rs.getInt("user_id"));
                         accModl.setBalance(rs.getDouble("balance"));

            return accModl;
        }
        return null;
    }

        /*
                 Update the information to the database
        * */

    @Override
    public AccountModel update(AccountModel accountModel) throws SQLException, IOException {

        String sql = "UPDATE accounts SET balance =? WHERE account_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setDouble(1, accountModel.getBalance());
        pstmt.setInt(2, accountModel.getAccountId());

        pstmt.executeUpdate();

        return accountModel;
    }


    @Override
    public void delete(Integer id) throws SQLException, IOException {
        String sql = "DELETE FROM accounts WHERE account_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    public CustomArrayList<AccountModel> getAllItemsByUserId(Integer userId) throws SQLException, IOException {
        String sql = "SELECT * FROM accounts WHERE user_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
                          pstmt.setInt(1, userId);

        ResultSet rs = pstmt.executeQuery();

        List<AccountModel> accountList = new LinkedList<>();

        while(rs.next()) {
            AccountModel accModl = new AccountModel();
                         accModl.setAccountId(rs.getInt("account_id"));
                         accModl.setUserId(rs.getInt("user_id"));
                         accountList.add(accModl);
        }

        return (CustomArrayList<AccountModel>) accountList;
    }
}
