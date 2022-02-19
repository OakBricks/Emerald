package org.oakbricks.launcher;

import io.qt.widgets.*;

public class SettingsWindow extends QWidget {
    public SettingsWindow() {
        setMinimumSize(400, 400);

        QTabWidget tabWidget = new QTabWidget();
        tabWidget.addTab(new JavaSettings(), "Java");
        tabWidget.addTab(new AccountSettings(), "Accounts");

        QGridLayout grid = new QGridLayout(this);

        grid.addWidget(tabWidget);

        setWindowTitle("Settings");
    }

    private class JavaSettings extends QWidget {
        public JavaSettings() {
            QLineEdit javaPath = new QLineEdit();
            QPushButton b1 = new QPushButton("Look for JRE/JDK");

        }
    }

    private class AccountSettings extends QWidget {
        public AccountSettings() {
            QGridLayout grid = new QGridLayout();
            QListWidget accountList = new QListWidget();
            accountList.addItem("dick");
            accountList.addItem("vagina");
            QPushButton loginButton = new QPushButton("Login");
            loginButton.clicked.connect(new LoginThingy(), "show()");

            grid.addWidget(accountList);
            grid.addWidget(loginButton);

            setLayout(grid);
        }

        class LoginThingy extends QWidget{
            public LoginThingy() {
                QGridLayout grid = new QGridLayout();
                QFormLayout formLayout = new QFormLayout();
                QHBoxLayout buttonsLayout = new QHBoxLayout();

                QLineEdit usernameLine = new QLineEdit();
                QLineEdit passwordLine = new QLineEdit();
                passwordLine.inputMask();

                QPushButton cancelButton = new QPushButton("Cancel");
                cancelButton.clicked.connect(this, "dispose()");

                QPushButton loginButton = new QPushButton("Login");

                formLayout.addRow("Username/Email", usernameLine);
                formLayout.addRow("Password", passwordLine);

                buttonsLayout.addWidget(cancelButton);
                buttonsLayout.addWidget(loginButton);

                grid.addLayout(formLayout, 0, 0);
                grid.addLayout(buttonsLayout, 1, 0);

                setLayout(grid);
            }
        }
    }
}
