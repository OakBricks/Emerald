package org.oakbricks.launcher;

import org.oakbricks.launcher.util.SettingsUtil;
import org.oakbricks.launcherapi.MinecraftMetaHelpers;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class InstancesWindow extends JFrame {
    public InstancesWindow() throws IOException {
        setMinimumSize(new Dimension(400, 400));


        JTabbedPane tabWidget = new JTabbedPane();
        tabWidget.addTab("", new VanillaNewInstanceWidget());

        JButton createInstanceButton = new JButton("Create");

        JButton cancelButton = new JButton("Cancel");

        setTitle("Create a profile");
    }

    public class VanillaNewInstanceWidget extends JFrame {
        public static JTextField nameLineEdit;
        public static JList versionList;

        public VanillaNewInstanceWidget() throws IOException {

            nameLineEdit = new JTextField();

            versionList = new JList();
//            versionList.add(MinecraftMetaHelpers.getVersionsAsList());

//            JTable versionTable = new JTable();
//            versionTable.setColumnCount(2);
//            versionTable.setRowCount(MinecraftMetaHelpers.getVersions().length);

//            formLayout.addRow("Name", nameLineEdit);

//            layout.addLayout(formLayout.layout(), 0, 0);
//            layout.addWidget(versionList);
        }
    }
}
