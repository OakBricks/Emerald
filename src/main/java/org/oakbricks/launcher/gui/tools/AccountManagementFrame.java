package org.oakbricks.launcher.gui.tools;

import org.oakbricks.launcher.gui.LoginFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountManagementFrame extends JFrame implements Runnable, ActionListener {
    JButton addMojAccountButton;

    @Override
    public void run() {
        addMojAccountButton = new JButton("Login");
        addMojAccountButton.addActionListener(this);
        addMojAccountButton.setBounds(25, 25, 100, 25);

        add(addMojAccountButton);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(400, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addMojAccountButton) {
            new LoginFrame();
        }
    }
}
