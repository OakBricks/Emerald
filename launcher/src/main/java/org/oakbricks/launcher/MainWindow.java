package org.oakbricks.launcher;

import io.qt.widgets.QPushButton;
import io.qt.widgets.QToolBar;
import io.qt.widgets.QWidget;

public class MainWindow extends QWidget {
    public MainWindow() {
        setFixedSize(400, 400);

        QToolBar toolBar = new QToolBar(this);

        QPushButton instanceButton = new QPushButton("Add Profiles");
        instanceButton.clicked.connect(new ButtonMethods(), "profilesWindow()");
        toolBar.addWidget(instanceButton);

        QPushButton settingsButton = new QPushButton("Settings");
        settingsButton.clicked.connect(new ButtonMethods(), "");

        setWindowTitle("Penis");
    }
    public class ButtonMethods {
        public static void profilesWindow() {
            InstancesWindow instancesWindow = new InstancesWindow();
            instancesWindow.show();
        }

        public static void settingsWindow() {

        }
    }
}
