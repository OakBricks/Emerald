package org.oakbricks.launcher;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    public SettingsWindow() {
        setMinimumSize(new Dimension(400, 400));

//        QTabWidget tabWidget = new QTabWidget();
//        tabWidget.addTab(new JavaSettings(), "Java");
//        tabWidget.addTab(new AccountSettings(), "Accounts");
//
//        QGridLayout grid = new QGridLayout(this);
//
//        grid.addWidget(tabWidget);
//
//        setWindowTitle("Settings");
    }

    private class JavaSettings extends JFrame {
        public JavaSettings() {
            JTextField javaPath = new JTextField();
            JButton b1 = new JButton("Look for JRE/JDK");

        }
    }

    private class AccountSettings extends JPanel {
        public AccountSettings() {
//            GridBagLayout grid = new GridBagLayout();
//            JList accountList = new JList<>();
//            accountList.add("dick");
//            accountList.addItem("vagina");
//            QPushButton loginButton = new QPushButton("Login");
//            loginButton.clicked.connect(new LoginThingy(), "show()");
//
//            grid.addWidget(accountList);
//            grid.addWidget(loginButton);
//
//            setLayout(grid);
        }

        class LoginThingy extends JPanel{
            public LoginThingy() {
//                QGridLayout grid = new QGridLayout();
//                QFormLayout formLayout = new QFormLayout();
//                QHBoxLayout buttonsLayout = new QHBoxLayout();
//
//                QLineEdit usernameLine = new QLineEdit();
//                QLineEdit passwordLine = new QLineEdit();
//                passwordLine.inputMask();
//
//                QPushButton cancelButton = new QPushButton("Cancel");
//                cancelButton.clicked.connect(this, "dispose()");
//
//                QPushButton loginButton = new QPushButton("Login");
//
//                formLayout.addRow("Username/Email", usernameLine);
//                formLayout.addRow("Password", passwordLine);
//
//                buttonsLayout.addWidget(cancelButton);
//                buttonsLayout.addWidget(loginButton);
//
//                grid.addLayout(formLayout, 0, 0);
//                grid.addLayout(buttonsLayout, 1, 0);
//
//                setLayout(grid);
            }
        }
    }
}
