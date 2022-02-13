package org.oakbricks.launcher;

import io.qt.widgets.QLineEdit;
import io.qt.widgets.QTabWidget;
import io.qt.widgets.QWidget;

public class InstancesWindow extends QWidget {
    public InstancesWindow() {
        setFixedSize(400, 400);

        QTabWidget tabWidget = new QTabWidget(this);
        tabWidget.setFixedSize(300, 300);
        tabWidget.addTab(new VanillaNewInstanceWidget(), "Vanilla");

        setWindowTitle("Penis 2");
    }

    public class VanillaNewInstanceWidget extends QWidget {
        public VanillaNewInstanceWidget() {
            QLineEdit nameLineEdit = new QLineEdit("Name", this);
            nameLineEdit.setGeometry(10, 10, 100, 25);
        }
    }
}
