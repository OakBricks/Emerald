package org.oakbricks.emerald.util.entropy;

import java.util.Random;

public class LauncherUniqueIDGenerator {
    public LauncherUniqueIDGenerator() {
    }

    public static String ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyz1234567890";
    public static String US_KEYBOARD = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+~`[]{}\\|;:',.<>/?";

    private String input;

    /**
     * Simple IDs are used to identify individual launchers, these and standard IDs are used as a salt for account information required to log in to minecraft
     * @return String
     */
    public String generateSimpleID() {
        Random random = new Random();
        String allowedCharacters = ALPHANUMERIC;
        StringBuilder idStringBuilder = new StringBuilder();

        for (int i = 0; i < 64; i++) {
            int randomIntThatHelpsUsWithTheRandomChar = random.nextInt(allowedCharacters.length());
            char randomCharAtLast = allowedCharacters.charAt(randomIntThatHelpsUsWithTheRandomChar);

            idStringBuilder.append(randomCharAtLast);
        }

        return idStringBuilder.toString();
    }

    /**
     * Standard IDs are used in conjunction with simple IDs as a form of salting.
     * @param maxCharacters
     * @return String
     */
    public String generateID(int maxCharacters) {
        Random random = new Random();
        String allowedCharacters = US_KEYBOARD;
        StringBuilder idStringBuilder = new StringBuilder();

        for (int i = 0; i < maxCharacters; i++) {
            int randomIntThatHelpsUsWithTheRandomChar = random.nextInt(allowedCharacters.length());
            char randomCharAtLast = allowedCharacters.charAt(randomIntThatHelpsUsWithTheRandomChar);

            idStringBuilder.append(randomCharAtLast);
        }

        return idStringBuilder.toString();
    }

    public String generateCustomID(int maxCharacters, String allowedCharacters) {
        Random random = new Random();
        StringBuilder idStringBuilder = new StringBuilder();

        for (int i = 0; i < maxCharacters; i++) {
            int randomInt = random.nextInt(allowedCharacters.length());
            char randomChar = allowedCharacters.charAt(randomInt);

            idStringBuilder.append(randomChar);
        }

        return "";
    }
}
