package org.oakbricks.launcher;

import io.qt.gui.QAction;
import io.qt.widgets.QPushButton;
import io.qt.widgets.QToolBar;
import io.qt.widgets.QWidget;

public class MainWindow extends QWidget {
    public MainWindow() {
        setFixedSize(400, 400);

        QToolBar toolBar = new QToolBar(this);
        QPushButton instanceButton = new QPushButton("Instances");
        instanceButton.clicked.connect(new Other(), "penis()");
        toolBar.addWidget(instanceButton);
        setWindowTitle("Penis");
    }
    public class Other {
        public static void penis() {
            InstancesWindow instancesWindow = new InstancesWindow();
            instancesWindow.show();
        }
    }
}
