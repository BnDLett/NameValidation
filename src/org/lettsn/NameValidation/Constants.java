package org.lettsn.NameValidation;

import java.util.regex.*;

/**
 * A class to hold constant values.
 */
public class Constants {
    public static final Pattern allowedPattern = Pattern.compile("\\A(?!\\(Admin\\)|\\(Staff\\))([ -~])+\\z", Pattern.CASE_INSENSITIVE);
}
