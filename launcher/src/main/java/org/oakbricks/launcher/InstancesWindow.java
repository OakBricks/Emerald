package org.oakbricks.launcher;

import io.qt.widgets.*;

public class InstancesWindow extends QWidget {
    public InstancesWindow() {
        setMinimumSize(400, 400);

        QGridLayout layout = new QGridLayout(this);
        QLayout cancelAndCreateButtonLayout = new QHBoxLayout();

        QTabWidget tabWidget = new QTabWidget();
        tabWidget.addTab(new VanillaNewInstanceWidget(), "Vanilla");

        QPushButton createInstanceButton = new QPushButton("Create");

        QPushButton cancelButton = new QPushButton("Cancel");

        layout.addWidget(tabWidget, 0, 0);
        cancelAndCreateButtonLayout.addWidget(cancelButton);
        cancelAndCreateButtonLayout.addWidget(createInstanceButton);
        layout.addLayout(cancelAndCreateButtonLayout, 1, 0);

        setWindowTitle("Penis 2");
    }

    public class VanillaNewInstanceWidget extends QWidget {
        public VanillaNewInstanceWidget() {
            QLineEdit nameLineEdit = new QLineEdit("Name", this);
            nameLineEdit.setGeometry(10, 10, 100, 25);
        }
    }
}
