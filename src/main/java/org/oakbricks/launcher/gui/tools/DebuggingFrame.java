package org.oakbricks.launcher.gui.tools;

import org.apache.commons.io.FileUtils;
import org.oakbricks.launcher.Main;
import org.oakbricks.launcher.scripting.LauncherBaseJavascriptMethods;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DebuggingFrame extends JFrame implements ActionListener {
    JButton exitButton;
    JTextField loggerTestTextField;
    JComboBox<String> loggerLevelComboBox;
    JButton loggerTestButton;
    JComboBox<String> scriptingComboBox;
    JTextArea scriptingTextField;
    JButton scriptingButton;
    JButton getAllAccountInfoButton;
    JButton loadClassButton;
    JTextField loadClassField;

    public DebuggingFrame() {
        String[] loggerLevels = {"Info", "Debug", "Trace", "Warn", "Error"};
        String[] actionTypes = {"Javascript", "Execute", "Lua", "None"};
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        exitButton.setBounds(25, 400, 125, 25);

        loggerLevelComboBox = new JComboBox<>(loggerLevels);
        loggerLevelComboBox.addActionListener(this);
        loggerLevelComboBox.setBounds(150, 25, 125, 25);

        loggerTestButton = new JButton("Log text");
        loggerTestButton.addActionListener(this);
        loggerTestButton.setBounds(25, 50, 250, 25);

        loggerTestTextField = new JTextField("This is a test for Logging!");
        loggerTestTextField.setBounds(25, 25, 125, 25);

        scriptingComboBox = new JComboBox<>(actionTypes);
        scriptingComboBox.addActionListener(this);
        //scriptingComboBox.setBounds(150, 75, 125, 25);
        scriptingComboBox.setBounds(150, 175, 125, 25);

        scriptingButton = new JButton("Test Script");
        scriptingButton.addActionListener(this);
        scriptingButton.setBounds(25, 175, 125, 25);

        scriptingTextField = new JTextArea();
        scriptingTextField.setBounds(25, 75, 250, 100);

        getAllAccountInfoButton = new JButton("Get the info of every account");
        getAllAccountInfoButton.addActionListener(this);
        getAllAccountInfoButton.setBounds(25, 200, 250, 25);

        loadClassButton = new JButton("Load Class");
        loadClassButton.addActionListener(this);
        loadClassButton.setBounds(25, 225, 100, 25);

        loadClassField = new JTextField();
        loadClassField.setBounds(125, 225, 150, 25);

        add(exitButton);
        add(loggerLevelComboBox);
        add(loggerTestButton);
        add(loggerTestTextField);
        add(scriptingComboBox);
        add(scriptingButton);
        add(scriptingTextField);
        add(getAllAccountInfoButton);
        add(loadClassButton);
        add(loadClassField);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(400, 500);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String testingString = loggerTestTextField.getText();
        String scriptString = scriptingTextField.getText();
        
        if (e.getSource() == exitButton) {
            dispose();
        } else if (e.getSource() == loggerTestButton) {
            switch (loggerLevelComboBox.getSelectedIndex()) {
                case 0:
                    Main.LOGGER.info(testingString);
                    break;
                case 1:
                    Main.LOGGER.debug(testingString);
                    break;
                case 2: 
                    Main.LOGGER.trace(testingString);
                    break;
                case 3:
                    Main.LOGGER.warn(testingString);
                    break;
                case 4:
                    Main.LOGGER.error(testingString);
                    break;
            }
        } else if (e.getSource() == scriptingButton) {
            switch (scriptingComboBox.getSelectedIndex()) {
                case 0:
                    try {
                        new LauncherBaseJavascriptMethods().runJSCode(scriptString);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 1:
                    try {
                        Runtime.getRuntime().exec(scriptString);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 2:
                    Main.LOGGER.debug("Not yet implemented");
            }
        } else if (e.getSource() == getAllAccountInfoButton) {
            File accountsDir = new File("accounts/");
            File[] accountFiles = accountsDir.listFiles();

            for (File accountFile: accountFiles) {
                String fileContents = null;
                try {
                    fileContents = FileUtils.readFileToString(accountFile, StandardCharsets.UTF_8);
                } catch (IOException ex) {
                    fileContents = "placeholder";
                    ex.printStackTrace();
                }
                Main.LOGGER.info(fileContents);
            }
        } else if (e.getSource() == loadClassButton) {
            Class<?> loadedClass = null;
            try {
                loadedClass = Class.forName(loadClassField.getText());
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            try {
                Object ob = loadedClass.newInstance();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
    }
}
