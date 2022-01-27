
                //  Ibrahima Diallo
                // Revature Training
                //                     ***__ Project-P0 __***

import Utils.ConnectionManager;
import Utils.ViewManager;
import Views.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String ...args) throws SQLException, IOException {

        //Connection conn = ConnectionManager.getConnection();

        ViewManager.getViewManager().registerView(new WelcomeView());
        ViewManager.getViewManager().registerView(new RegisterView());
        ViewManager.getViewManager().registerView(new LoginView());
        ViewManager.getViewManager().registerView(new AccountListView());
        //ViewManager.getViewManager().registerView(new);



        try {
            Connection conn = ConnectionManager.getConnection();

            ViewManager.getViewManager().navigate("welcome");
            while(ViewManager.getViewManager().isRunning()) {
                ViewManager.getViewManager().render();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
