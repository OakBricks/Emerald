package org.oakbricks.launcher.gui.tools;

import org.oakbricks.launcher.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DebuggingFrame extends JFrame implements ActionListener {
    JButton exitButton;
    JTextField loggerTestTextField;
    JComboBox<String> loggerLevelComboBox;
    JButton loggerTestButton;

    public DebuggingFrame() {
        String[] loggerLevels = {"Info", "Debug", "Trace", "Warn", "Error"};
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

        add(exitButton);
        add(loggerLevelComboBox);
        add(loggerTestButton);
        add(loggerTestTextField);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(400, 500);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String testingString = loggerTestTextField.getText();
        
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
        }
    }
}
