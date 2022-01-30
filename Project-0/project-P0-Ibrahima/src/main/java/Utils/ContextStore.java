package Utils;

import Persistence.UserModel;

        // class that store user data
public class ContextStore {

    private static UserModel currentUser;

    public static void setCurrentUser(UserModel user) {
        currentUser = user;
    }

    public static UserModel getCurrentUser() {
        return currentUser;
    }



}