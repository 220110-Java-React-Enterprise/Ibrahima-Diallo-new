package Views;

import Persistence.AccountModel;
import Persistence.AccountRepo;
import Utils.ContextStore;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

        // class
public class AccountListView extends View {

        // No arg constructor
    public AccountListView() {
        viewName = "accountViewList";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {

        System.out.println("Welcome! " + ContextStore.getCurrentUser().getFirstName() + " " +
                ContextStore.getCurrentUser().getLastName());
        System.out.println("===========================================");

        AccountRepo accountRepo = new AccountRepo();
        AccountModel accountModel = null;

        try {
            accountModel = accountRepo.read(ContextStore.getCurrentUser().getUserId());

            } catch (Exception e) {
                    e.printStackTrace();
            }

        Double balance = accountModel.getBalance();

        // number format
        NumberFormat amountFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

        System.out.println(amountFormat.format(balance));

        System.out.println("What do you want?\n\n " + "1) for withdraw\n " +
                        "2) for Deposit and" + "\n 3) for Quit" );

        //
        String input = viewManager.getScanner().nextLine();

        switch(input) {
            case "1":
                withdraw();
                break;
            case "2":
                deposit();
                break;
            case "3":
                viewManager.quit();
                System.out.println("Main menu");
                break;
            default:
                System.out.println("\nPlease try again...\n\n\n");
                break;
        }
    }

        /*
                The Deposit method() that will not accept negative value for operation
        **/

    private void deposit(){

        System.out.println("Please input your deposit! ");

        try{

            double amount = Double.parseDouble(viewManager.getScanner().nextLine());

            AccountRepo accountRepo = new AccountRepo();
            AccountModel accountModel = accountRepo.read(ContextStore.getCurrentUser().getUserId());

            accountModel.depositAmount(amount);
            accountRepo.update(accountModel);

            }catch (NumberFormatException nfe){

            System.out.println(nfe.getMessage());

            } catch (Exception e) {
                    e.printStackTrace();
            }

    }
         /*
                The withdrawal method
         * **/
    private void withdraw(){

        System.out.println("How much do you want to withdraw? ");

        try{

            double amount = Double.parseDouble(viewManager.getScanner().nextLine());


            AccountRepo accountRepo = new AccountRepo();
            AccountModel accountModel = accountRepo.read(ContextStore.getCurrentUser().getUserId());

            accountModel.withdrawAmount(amount);
            accountRepo.update(accountModel);

            }catch (NumberFormatException nfe){

            System.out.println(nfe.getMessage());

            } catch (Exception e) {
                    e.printStackTrace();
            }

    }
}