package org.oakbricks.launcher.gui;

import org.oakbricks.launcher.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstLaunchFrame extends JFrame implements ActionListener {
    JButton loginButton;
    JButton skipButton;
    JButton cancelButton;

    public FirstLaunchFrame() {

        loginButton = new JButton("Login to a Minecraft account");
        loginButton.setBounds(25, 25, 150, 25);
        loginButton.addActionListener(this);

        skipButton = new JButton("Skip and go to launcher with default config");
        skipButton.setBounds(500, 400, 250, 25);
        skipButton.addActionListener(this);

        cancelButton = new JButton("Cancel");


        add(loginButton);
        add(skipButton);
        add(cancelButton);

        setLayout(null);
        setResizable(false);
        setSize(600, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            new LoginFrame();
        } else if (e.getSource() == skipButton) {
            dispose();
            new MainFrame();
        }
    }
}
