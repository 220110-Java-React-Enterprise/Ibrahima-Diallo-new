package Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

        // Class that check the email input and validate
public class EmailValidator {

        // taking from stack Overflow
    public static boolean validateEmailAddress(String emailAddress) {

        Pattern regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");

        Matcher regMatcher = regexPattern.matcher(emailAddress);

        if(regMatcher.matches()) {
            return true;

        } else {
            return false;
        }
    }

}
