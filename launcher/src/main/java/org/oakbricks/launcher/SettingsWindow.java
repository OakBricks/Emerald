package org.oakbricks.launcher;

import io.qt.widgets.*;

public class SettingsWindow extends QWidget {
    public SettingsWindow() {
        setMinimumSize(400, 400);

        QTabWidget tabWidget = new QTabWidget();
        tabWidget.addTab(new TestingSettingClass(), "Test");

        QGridLayout grid = new QGridLayout(this);

        grid.addWidget(tabWidget);

        setWindowTitle("Settings");
    }

    private class TestingSettingClass extends QWidget {
        public TestingSettingClass() {
            QPushButton b1 = new QPushButton("Set a var");
            b1.clicked.connect(new SettingsTest(), "addToVar()");
            QGridLayout grid = new QGridLayout(this);
            grid.addWidget(b1);
        }

        class SettingsTest {
            public static int var = 0;

            public static void addToVar() {
                ++var;
                System.out.println(var);
            }
        }
    }

    private class JavaSettings extends QWidget {
        public JavaSettings() {
            QLineEdit javaPath = new QLineEdit("[DEFAULT]");
            QPushButton b1 = new QPushButton("Look for JRE/JDK");

        }
    }
}
