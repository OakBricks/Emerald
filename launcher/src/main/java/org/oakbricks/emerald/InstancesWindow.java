package org.oakbricks.emerald;

import io.qt.widgets.*;
import org.oakbricks.emerald.util.settings.SettingsUtil;
import org.oakbricks.launcherapi.MinecraftMetaHelpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class InstancesWindow extends QWidget {
    public InstancesWindow() throws IOException {
//        setStyleSheet(SettingsUtil.getStyleSheetFromConfig());
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

        setWindowTitle("Create a profile");
    }

    public static class VanillaNewInstanceWidget extends QWidget {
        public static QLineEdit nameLineEdit;
        public static QListWidget versionList;

        public VanillaNewInstanceWidget() throws IOException {
            QGridLayout layout = new QGridLayout(this);
            QFormLayout formLayout = new QFormLayout();

            nameLineEdit = new QLineEdit();

            versionList = new QListWidget();
            versionList.addItems(MinecraftMetaHelpers.getVersionsAsList());

            QTableWidget versionTable = new QTableWidget();
            versionTable.setColumnCount(2);
            versionTable.setRowCount(MinecraftMetaHelpers.getVersions().length);

            formLayout.addRow("Name", nameLineEdit);

            layout.addLayout(formLayout.layout(), 0, 0);
            layout.addWidget(versionList);
        }
    }

    private class ButtonMethods {
        public void createNewInstance() {
            String instanceName = VanillaNewInstanceWidget.nameLineEdit.text();
            if (instanceName.equals("")) {
                QMessageBox.warning(null, "Blank profile name", "Profile name MUST NOT be blank!");
                return;
            } else {
                // Uhhhh how tf did i manage this?
                File instanceFolder = new File(instanceName);
                if (instanceFolder.exists()) {
                    QMessageBox.warning(null, "Profile already exists!", "Profile already exists!");
                    return;
                } else if (!instanceFolder.exists()) {
                    Path basePath = Path.of(instanceName);
                    File dotMinecraftFolder = basePath.resolve(".minecraft").toFile();
                    File instanceInfoFile = basePath.resolve("instance.json").toFile();
                    return;
                }
            }
        }
    }
}
