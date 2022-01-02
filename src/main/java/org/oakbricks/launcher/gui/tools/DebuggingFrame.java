package org.oakbricks.launcher.gui.tools;

import org.oakbricks.launcher.Main;
import org.oakbricks.launcher.scripting.LauncherBaseJavascriptMethods;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DebuggingFrame extends JFrame implements ActionListener {
    JButton exitButton;
    JTextField loggerTestTextField;
    JComboBox<String> loggerLevelComboBox;
    JButton loggerTestButton;
    JComboBox<String> scriptingComboBox;
    JTextArea scriptingTextField;
    JButton scriptingButton;

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

        add(exitButton);
        add(loggerLevelComboBox);
        add(loggerTestButton);
        add(loggerTestTextField);
        add(scriptingComboBox);
        add(scriptingButton);
        add(scriptingTextField);

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
        }
    }
}
