package Utils;


import Views.View;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

        // Class that control the operation
public class ViewManager {

        private static ViewManager viewManager;
        private boolean running;
        private final Scanner scanner;
        CustomArrayList<View> viewList;
        View nextView;


        // Constructor
    private ViewManager() {
        // set up starting values and references
        running = true;
        scanner = new Scanner(System.in);
        viewList = new CustomArrayList<>();
    }

    public static ViewManager getViewManager(){
        if(viewManager == null) {
            viewManager = new ViewManager();
        }
        return viewManager;
    }

    public void navigate(String destination) {
        for(View view : viewList) {

            if(view.getViewName().equals(destination)){
                nextView = view;
            }
        }
    }

    public void registerView(View view) {
        viewList.add(view);
    }

    public void render() throws SQLException, IOException {
        nextView.renderView();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void quit() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }
}
