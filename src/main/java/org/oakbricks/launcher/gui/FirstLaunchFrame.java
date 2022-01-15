package org.oakbricks.launcher.gui;

import org.oakbricks.launcher.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstLaunchFrame extends JFrame implements ActionListener {
    JButton nextButton;
    JButton prevButton;
    JButton cancelButton;
    JTabbedPane firstLaunchOptions;
    GridBagConstraints constraints;

    public FirstLaunchFrame() {

        nextButton = new JButton("Next");
        nextButton.setBounds(525, 450, 50, 25);

        prevButton = new JButton("Previous");

        cancelButton = new JButton("Cancel");

        firstLaunchOptions = new JTabbedPane(JTabbedPane.LEFT);

        add(nextButton);
        add(prevButton);
        add(cancelButton);
        add(firstLaunchOptions);

        setLayout(null);
        setResizable(false);
        setSize(600, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            Main.LOGGER.info("Next page");
            firstLaunchOptions.setSelectedIndex(firstLaunchOptions.getSelectedIndex() + 1);
        }
    }
}
