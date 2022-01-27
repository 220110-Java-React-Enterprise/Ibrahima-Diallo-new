package Views;

import Persistence.AccountModel;
import Persistence.AccountRepo;
import Persistence.UserModel;
import Persistence.UserRepo;
import Utils.ContextStore;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterView extends View{

    public RegisterView() {
        viewName = "register";
        viewManager = ViewManager.getViewManager();
    }
    @Override
    public void renderView() throws SQLException, IOException {
        System.out.println("Register new user\n===============");
        System.out.println("Enter new username:");
        String username =  viewManager.getScanner().nextLine();

        System.out.println("Enter new password: ");
        String password =  viewManager.getScanner().nextLine();

        UserModel newUser = new UserModel(username, password);
        UserRepo repo = new UserRepo();
                  newUser.setUserId(repo.create(newUser));

        ContextStore.setCurrentUser(newUser);

        AccountRepo accountRepo = new AccountRepo();
        AccountModel accountModel = new AccountModel(0, ContextStore.getCurrentUser().getUserId(), 0.0);
        accountRepo.create(accountModel);

        viewManager.navigate("accountList");

    }
}
