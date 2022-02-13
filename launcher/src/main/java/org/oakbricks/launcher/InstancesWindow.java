package org.oakbricks.launcher;

import io.qt.core.QRect;
import io.qt.core.Qt;
import io.qt.widgets.*;

import javax.swing.*;

public class InstancesWindow extends QWidget {
    public InstancesWindow() {
//        setBaseSize(400, 400);
        setMinimumSize(400, 400);
//        setLayout(new QVBoxLayout());
        QGridLayout layout = new QGridLayout(this);
        QLayout cancelAndCreateButtonLayout = new QHBoxLayout();

        QTabWidget tabWidget = new QTabWidget();
//        tabWidget.setGeometry(10, 10, 350, 300);
        tabWidget.addTab(new VanillaNewInstanceWidget(), "Vanilla");

        QPushButton createInstanceButton = new QPushButton("Create");
//        createInstanceButton.setGeometry(310, 310, 50, 25);

        QPushButton cancelButton = new QPushButton("Cancel");

        layout.addWidget(tabWidget, 0, 0);
//        layout.addWidget(createInstanceButton, 1, 0);
//        layout.addWidget(cancelButton, 1, 1);
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
