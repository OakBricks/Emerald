package org.oakbricks.launcher;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainWindow extends JFrame {
    JToolBar toolBar;
    GridBagLayout gridBagLayout;

    public MainWindow() throws IOException {
        gridBagLayout = new GridBagLayout();

        setMinimumSize(new Dimension(400, 400));
        setLayout(gridBagLayout);

        toolBar = new JToolBar();

        JButton instanceButton = new JButton("Add Profiles");
        toolBar.add(instanceButton);

        JButton settingsButton = new JButton("Settings");
        toolBar.add(settingsButton);

        JList profilesListView = new JList();


        setTitle("OakLauncher");
    }
}
