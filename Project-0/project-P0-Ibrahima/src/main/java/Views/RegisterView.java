package Views;

import Persistence.AccountModel;
import Persistence.AccountRepo;
import Persistence.UserModel;
import Persistence.UserRepo;
import Utils.ContextStore;
import Utils.EmailValidator;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

        // Class
public class RegisterView extends View{

        // Constructor
    public RegisterView() {

        viewName = "register";
        viewManager = ViewManager.getViewManager();

    }
        /*
                the renderView method that prompt input to user
        * **/

    @Override
    public void renderView() throws SQLException, IOException {
        System.out.println("Register new user\n===============");

        System.out.println("Enter new username:");
        String username =  viewManager.getScanner().nextLine();

        System.out.println("Enter new password: ");
        String password =  viewManager.getScanner().nextLine();

        System.out.println("Enter new firstName: ");
        String firstName =  viewManager.getScanner().nextLine();

        System.out.println("Enter new lastName: ");
        String lastName =  viewManager.getScanner().nextLine();

        String email = "";

        /*
                email verification
        * **/
        while(!EmailValidator.validateEmailAddress(email)) {

            System.out.println("Enter new email: ");
            email = viewManager.getScanner().nextLine();

            if(!EmailValidator.validateEmailAddress(email)){
                System.out.println("Sorry you've tapped a wrong email! Try again");

            }
        }


        UserModel newUser = new UserModel(username, password, firstName, lastName, email);
        UserRepo repo = new UserRepo();
        newUser.setUserId(repo.create(newUser));

        ContextStore.setCurrentUser(newUser);

        AccountRepo accountRepo = new AccountRepo();
        AccountModel accountModel = new AccountModel(0, ContextStore.getCurrentUser()
                                                                            .getUserId(), 0.0);
        accountRepo.create(accountModel);

        viewManager.navigate("accountViewList");

    }
}
