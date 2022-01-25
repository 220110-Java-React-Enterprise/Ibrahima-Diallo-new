package Views;

import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

public abstract class View {

        // Declare variable as protected
    protected String viewName = "";
    protected ViewManager viewManager;


    public String getViewName() {

        return viewName;
    }

    public abstract void renderView() throws SQLException, IOException;
}
