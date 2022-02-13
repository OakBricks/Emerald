package org.oakbricks.launcher;

import io.qt.gui.QFont;
import io.qt.widgets.QApplication;
import io.qt.widgets.QMessageBox;
import io.qt.widgets.QPushButton;
import io.qt.widgets.QWidget;

public class Main {
    public static void main(String[] args) {
        QApplication.initialize(args);

        MainWindow mainWindow = new MainWindow();
        mainWindow.show();

        QApplication.exec();
    }
}
