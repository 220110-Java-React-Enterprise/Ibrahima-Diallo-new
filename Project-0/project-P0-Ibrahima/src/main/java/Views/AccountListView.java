package Views;

import Persistence.AccountModel;
import Persistence.AccountRepo;
import Utils.ContextStore;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccountListView extends View {

    public AccountListView() {
        viewName = "accountList";
        viewManager = ViewManager.getViewManager();
    }
    @Override
    public void renderView() throws SQLException, IOException {
        System.out.println("Welcome! " + ContextStore.getCurrentUser().getUsername());
        System.out.println("===========================================");

        System.out.println("What do want?\n " + "1) for withdraw\n " +
                        "2) for Deposit and" + "\n3) for Quit" );

        String input = viewManager.getScanner().nextLine();
        switch(input) {
            case "1":
                //viewManager.navigate("newItem");
                withdraw();
                break;
            case "2":
                // deposit
                break;
            case "3":
                viewManager.quit();
                System.out.println("Main menu");
                break;
            default:
                System.out.println("\nOops, try again...\n\n\n");
                break;
        }
    }
    private void withdraw(){

        System.out.println("How much do when to withdraw? ");

        try{
            double amount = Double.parseDouble(viewManager.getScanner().nextLine());
            AccountRepo accountRepo = new AccountRepo();
            AccountModel accountModel = accountRepo.read(ContextStore.getCurrentUser().getUserId());
            accountModel.setBalance(accountModel.getBalance() - amount);
            accountRepo.update(accountModel);

        }catch (NumberFormatException nfe){

            System.out.println(nfe.getMessage());
        } catch (SQLException | IOException e) {
            e.printStackTrace();

        }

    }
}