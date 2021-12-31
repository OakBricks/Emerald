package org.oakbricks.launcher.core.other;

import org.oakbricks.launcher.Main;

/**
 * @author OakBricks
 * Just a bunch of DebugMessages to make making debugging messages slightly easier
 */
public class DebugMessages {
    /**
     * Debug message for when something is disposed
     * @param s String that gets put into the place holder
     */
    public static void disposed(String s) {
        if (Main.IS_DEBUGGING)
            Main.LOGGER.debug("Disposed of {}", s);
    }

    /**
     * @param c class to get name from
     * @param nameType type of name (0 gets a simple name, 1 gets a canonical name, 2 gets a name, and 3 gets a type name
     */
    public static void disposed(Class c, int nameType) {
        if (Main.IS_DEBUGGING)
            switch (nameType) {
                case 0:
                    Main.LOGGER.debug("Disposed of {}", c.getSimpleName());
                    break;
                case 1:
                    Main.LOGGER.debug("Disposed of {}", c.getCanonicalName());
                    break;
                case 2:
                    Main.LOGGER.debug("Disposed of {}", c.getName());
                    break;
                case 3:
                    Main.LOGGER.debug("Disposed of {}", c.getTypeName());
                    break;
            }
    }
}
