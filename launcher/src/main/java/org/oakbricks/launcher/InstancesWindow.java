package org.oakbricks.launcher;

import io.qt.widgets.*;
import org.oakbricks.launcherapi.MinecraftMetaHelpers;

import java.io.IOException;

public class InstancesWindow extends QWidget {
    public InstancesWindow() throws IOException {
        setMinimumSize(400, 400);

        QGridLayout layout = new QGridLayout(this);
        QLayout cancelAndCreateButtonLayout = new QHBoxLayout();

        QTabWidget tabWidget = new QTabWidget();
        tabWidget.addTab(new VanillaNewInstanceWidget(), "Vanilla");

        QPushButton createInstanceButton = new QPushButton("Create");
        createInstanceButton.clicked.connect(new ButtonMethods(), "createNewInstance()");

        QPushButton cancelButton = new QPushButton("Cancel");

        layout.addWidget(tabWidget, 0, 0);
        // Cancel and create buttons
        cancelAndCreateButtonLayout.addWidget(cancelButton);
        cancelAndCreateButtonLayout.addWidget(createInstanceButton);
        layout.addLayout(cancelAndCreateButtonLayout, 1, 0);

        setWindowTitle("Create an instance");
    }

    public class VanillaNewInstanceWidget extends QWidget {
        public static QLineEdit nameLineEdit;
        public static QListWidget versionList;

        public VanillaNewInstanceWidget() throws IOException {
            QGridLayout layout = new QGridLayout(this);
            QFormLayout formLayout = new QFormLayout();

            nameLineEdit = new QLineEdit();

            versionList = new QListWidget();
            versionList.addItems(MinecraftMetaHelpers.getVersionsAsList());

            formLayout.addRow("Name", nameLineEdit);

            layout.addLayout(formLayout.layout(), 0, 0);
            layout.addWidget(versionList);
        }

        public static void debugShit(String s) {
            System.out.println(s);
        }
    }

    private class ButtonMethods {
        public void createNewInstance() throws IOException {
            String instanceName = VanillaNewInstanceWidget.nameLineEdit.text();
//            System.out.println(VanillaNewInstanceWidget.nameLineEdit.text());
            if (instanceName.equals("")) {
               new QInputDialog();
            }
        }
    }
}
