
                //  Ibrahima Diallo
                // Revature Training JRE
                //                     ***__ Project-P0 __***

import Utils.ConnectionManager;
import Utils.ViewManager;
import Views.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

        // This is the main Class "Main Entry point"1
public class Main {
        // main method
    public static void main(String ...args) throws SQLException, IOException {

        /*
               These methods are called here to display the welcome... to the user.
        **/

        ViewManager.getViewManager().registerView(new WelcomeView());
        ViewManager.getViewManager().registerView(new RegisterView());
        ViewManager.getViewManager().registerView(new LoginView());
        ViewManager.getViewManager().registerView(new AccountListView());


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
