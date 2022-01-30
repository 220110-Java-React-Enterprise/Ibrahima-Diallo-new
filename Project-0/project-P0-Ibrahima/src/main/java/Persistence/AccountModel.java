package Persistence;

        // Class name
public class AccountModel {

        // Declare variables
    private Integer accountId;
    private Integer userId;     // FK pointing to the PK in UserModel
    private Double balance = 0.0d;

    public AccountModel() { // no arg constructor
    }

    public AccountModel(Double firstDeposit) {
        this.balance = firstDeposit;
    }

    public AccountModel(Integer userId, Double firstDeposit) {
        this.userId = userId;
        this.balance = firstDeposit;
    }

        // parameterize constructor
    public AccountModel(Integer accountId, Integer userId, Double balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
    }
        // getter and setter for variables
    public Integer getAccountId() { return accountId; }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getBalance() { return balance; }

    public void setBalance(Double balance) {
        this.balance = balance;
    }


        // The deposit() method
     public void depositAmount(Double deposit) {

        if(deposit >= 0){
            this.balance += deposit;
        }
     }

        // The withdraw() method
     public boolean withdrawAmount(Double withdraw) {

         if (withdraw <= balance && withdraw >= 0) {
             balance -= withdraw;
             return true;
         }
          else
              return false;

    }

//            /*    Override the toString() method and return accountId, balance and userId
//             * */
//    @Override
//    public String toString() {
//        return "AccountModel{" +
//                "accountId=" + accountId +
//                ", balance=" + balance +
//                ", userId=" + userId +
//                '}';
//    }
}
