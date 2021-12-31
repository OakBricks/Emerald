package org.oakbricks.launcher.gui.tools;

import org.oakbricks.launcher.core.other.DebugMessages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstanceManager extends JFrame implements ActionListener {
    private final JButton exit;

    public InstanceManager() {
        exit = new JButton("Exit");
        exit.setBounds(0, 0, 125, 25);
        exit.addActionListener(this);

        DefaultListModel<String> versionListModel = new DefaultListModel<>();
        versionListModel.addElement("VERSION_1");
        versionListModel.addElement("VERSION_2");
        versionListModel.addElement("VERSION_3");
        JList<String> versionList = new JList<>(versionListModel);
        versionList.setBounds(100,100, 75,75);

        add(versionList);
        add(exit);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(800, 600);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            dispose();
            DebugMessages.disposed(InstanceManager.class, 0);
        }
    }
}
