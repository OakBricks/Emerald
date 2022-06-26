package org.oakbricks.emerald;

import io.qt.widgets.QMainWindow;
import io.qt.widgets.QPushButton;
import io.qt.widgets.QToolBar;

import java.io.IOException;

public class MainWindow extends QMainWindow {
    public MainWindow() throws IOException {
        setFixedSize(400, 400);

        QToolBar toolBar = new QToolBar();
        toolBar.setMovable(false);
        addToolBar(toolBar);

        QPushButton instanceButton = new QPushButton("Add Profiles");
        instanceButton.clicked.connect(new InstancesWindow(), "show()");
        toolBar.addWidget(instanceButton);

        QPushButton settingsButton = new QPushButton("Settings");
        settingsButton.clicked.connect(new SettingsWindow(), "show()");
        toolBar.addWidget(settingsButton);

        setWindowTitle("OakLauncher");
    }
}
