package org.oakbricks.emeraldpackman;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws IOException {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Welcome to the Emerald Profile manager, press SPACE to create a new pack or enter to import an already existing one");
        String input = inputReader.nextLine();
        if (input.equals(" ")) {
            System.out.println("Please wait...");
        } else if (input.equals("\n")) {
            System.out.println("Please enter a valid file path");
        }
    }

}
