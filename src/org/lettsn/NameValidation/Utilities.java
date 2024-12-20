package org.lettsn.NameValidation;

import java.util.regex.*;
import static org.lettsn.NameValidation.Constants.allowedPattern;

/**
 * A class that holds utility related methods.
 */
public class Utilities {
    public static Boolean checkUsername(String username) {
        Matcher matcher = allowedPattern.matcher(username);


        return matcher.find();
    }
}
