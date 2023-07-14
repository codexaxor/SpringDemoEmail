package io.getarrays.userservice.utils;

/**
 * @author Junior RT
 * @version 1.0
 * @license Get Arrays, LLC (https://getarrays.io)
 * @since 6/25/2023
 */
public class EmailUtils {

    public static String getEmailMessage(String name) {
        return "Hello " + name + ",\nYour new account has been created";
    }

}
