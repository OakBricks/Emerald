package org.oakbricks.launcher;

import io.qt.gui.QPalette;
import io.qt.widgets.QMainWindow;
import io.qt.widgets.QPushButton;
import io.qt.widgets.QToolBar;
import io.qt.widgets.QWidget;
import org.oakbricks.launcher.util.SettingsUtil;

import java.io.IOException;

public class MainWindow extends QMainWindow {
    public MainWindow() throws IOException {
        setStyleSheet(SettingsUtil.getStyleSheetFromConfig());
        setFixedSize(400, 400);

        QToolBar toolBar = new QToolBar();
        toolBar.setMovable(false);
        addToolBar(toolBar);

        QPushButton instanceButton = new QPushButton("Add Profiles");
        instanceButton.clicked.connect(new ButtonMethods(), "profilesWindow()");
        toolBar.addWidget(instanceButton);

        QPushButton settingsButton = new QPushButton("Settings");
        settingsButton.clicked.connect(new ButtonMethods(), "settingsWindow()");
        toolBar.addWidget(settingsButton);

        setWindowTitle("OakLauncher");
    }
    public class ButtonMethods {
        public static void profilesWindow() throws IOException {
            InstancesWindow instancesWindow = new InstancesWindow();
            instancesWindow.show();
        }

        public static void settingsWindow() {
            SettingsWindow settingsWindow = new SettingsWindow();
            settingsWindow.show();
        }
    }
}
