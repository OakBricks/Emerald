package org.oakbricks.launcher.gui;

import com.github.weisj.darklaf.LafManager;
import org.oakbricks.launcher.Main;
import org.oakbricks.launcher.gui.tools.DebuggingFrame;
import org.oakbricks.launcher.gui.tools.InstanceManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static org.oakbricks.launcher.Main.LOGGER;

public class GuiMain extends JFrame implements ActionListener, Runnable {

    JFrame frame;
    JPanel instancesPanel;
    JToolBar toolBar;
    JButton accountsButton;
    JButton instancesButton;
    JButton settingsButton;
    JButton debugButton;
    Icon addInstancesIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/icons/01.png")));
    Icon accountManagementIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/icons/02.png")));
    Icon debuggingIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/icons/03.png")));
    Image frameIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/icons/00.png"))).getImage();

    @Override
    public void run() {
        instancesPanel = new JPanel();

        toolBar = new JToolBar();
        toolBar.setFloatable(false);

        instancesButton = new JButton("Add instance", addInstancesIcon);
        instancesButton.addActionListener(this);

        accountsButton = new JButton("Manage Accounts", accountManagementIcon);
        accountsButton.addActionListener(this);

        debugButton = new JButton("Debugging", debuggingIcon);
        debugButton.addActionListener(this);

        toolBar.add(instancesButton);
        toolBar.add(accountsButton);
        if (Main.IS_DEBUGGING) {
            toolBar.add(debugButton);
        }
        setIconImage(frameIcon);

        add(toolBar, BorderLayout.PAGE_START);
        add(instancesPanel);

        setTitle("Launcher");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == instancesButton) {
            new InstanceManager();
        } else if (e.getSource() == accountsButton) {
            LOGGER.info("Development placeholder");
        } else if (e.getSource() == debugButton && Main.IS_DEBUGGING) {
            new DebuggingFrame();
        }
    }
}
