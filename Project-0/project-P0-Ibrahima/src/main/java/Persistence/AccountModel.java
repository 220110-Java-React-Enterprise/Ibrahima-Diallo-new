package Persistence;

public class AccountModel {

    private Integer accountId;
    private Double balance;
    private Integer userId; //FK pointing to the PK in UserModel

    public AccountModel() {
    }

    public AccountModel(Integer accountId,
                        Integer userId, Double balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getBalance() { return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountModel{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", userId=" + userId +
                '}';
    }
}
