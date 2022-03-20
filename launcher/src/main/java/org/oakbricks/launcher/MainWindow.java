package org.oakbricks.launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JButton profileButton;
    BoxLayout instancesLayout;
    JList instancesList;
    Object[] instancesArray;

    public MainWindow() {
        instancesArray = Main.profilesFolder.listFiles();
        profileButton = new JButton("Add Profile");

        menuBar = new JMenuBar();
        menuBar.add(profileButton);
        add(menuBar);

        instancesList = new JList(instancesArray);

        add(instancesList);

        setJMenuBar(menuBar);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
