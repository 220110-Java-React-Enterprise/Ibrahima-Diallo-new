package Views;

import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

        // Abstract class
public abstract class View {

        // Declare variable as protected
    protected String viewName;
    protected ViewManager viewManager;

        // concrete getViewName() method
    public String getViewName() {

        return viewName;
    }
        // Abstract renderView() method
    public abstract void renderView() throws SQLException, IOException;
}
