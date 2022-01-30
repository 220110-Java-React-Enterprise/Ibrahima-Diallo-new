package Views;

import Utils.ViewManager;

        // Main view that user navigate through
public class WelcomeView extends View {

    public WelcomeView() {

        viewName = "welcome";
        viewManager = ViewManager.getViewManager();

    }

    @Override
    public void renderView() {

        System.out.println("Welcome to BankingApp Dear Client!\n" +
                "Do you want to register: press 1) or 2) for login?\n" +

                "==============================\n" +
                "1) Register as a New User Account\n" +
                "2) Login to an Existing Account\n" +
                "==============================\n");

        String input = viewManager.getScanner().nextLine();

        /*
                Switch case to Register or Login
        **/

        switch(input) {
            case "1":
                viewManager.navigate("register");
                break;
            case "2":
                viewManager.navigate("login");
                System.out.println("\nWelcome! Follow the instructions bellow ");
                break;
            default:
                System.out.println("\nOops, try again...\n\n\n");
                break;
        }

    }
}
