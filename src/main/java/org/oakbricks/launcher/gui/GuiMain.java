package org.oakbricks.launcher.gui;

import com.google.gson.*;
import org.oakbricks.launcher.Main;
import org.oakbricks.launcher.gui.tools.AccountManagementFrame;
import org.oakbricks.launcher.gui.tools.DebuggingFrame;
import org.oakbricks.launcher.gui.tools.InstanceManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileReader;
import java.util.Objects;

import static org.oakbricks.launcher.Main.LOGGER;

public class GuiMain extends JFrame implements ActionListener, Runnable {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    JPanel instancesPanel;
    JToolBar toolBar;
    JButton accountsButton;
    JButton instancesButton;
    JButton settingsButton;
    JButton debugButton;
    JLabel lastUsedAccountLabel;
    Icon addInstancesIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/icons/01.png")));
    Icon accountManagementIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/icons/02.png")));
    Icon debuggingIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/icons/03.png")));
    Image frameIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/icons/00.png"))).getImage();

    @Override
    public void run() {
        JsonElement configElement = null;
        try {
            configElement = JsonParser.parseReader(new FileReader(Main.configFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JsonObject configJsonObject = configElement.getAsJsonObject();
        instancesPanel = new JPanel();

        toolBar = new JToolBar();
        toolBar.setFloatable(false);

        instancesButton = new JButton("Add instance", addInstancesIcon);
        instancesButton.addActionListener(this);

        accountsButton = new JButton("Manage Accounts", accountManagementIcon);
        accountsButton.addActionListener(this);

        debugButton = new JButton("Debugging", debuggingIcon);
        debugButton.addActionListener(this);
        new JOptionPane();

        lastUsedAccountLabel = new JLabel(configJsonObject.get("lastUsedAccount").getAsString());

        toolBar.add(instancesButton);
        toolBar.add(accountsButton);
        if (Main.IS_DEBUGGING) {
            toolBar.add(debugButton);
        }
        toolBar.addSeparator(new Dimension());
        toolBar.add(lastUsedAccountLabel);
        if (Objects.equals(lastUsedAccountLabel.getText(), "Tm9uZQ\u003d\u003d")) {
            lastUsedAccountLabel.setText("No Account");
        }

        if (configJsonObject.get("windowIconPath").getAsString().equals("")) {
            setIconImage(frameIcon);
        } else {
            setIconImage(new ImageIcon(configJsonObject.get("windowIconPath").getAsString()).getImage());
        }


        add(toolBar, BorderLayout.PAGE_START);
        add(instancesPanel);

        setTitle("Launcher");
        setLocation(configJsonObject.getAsJsonArray("winPos").get(0).getAsInt(), configJsonObject.getAsJsonArray("winPos").get(1).getAsInt());
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                LOGGER.debug("test");
                System.exit(0);
            }
        });
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == instancesButton) {
            new InstanceManager();
        } else if (e.getSource() == accountsButton) {
            LOGGER.info("Development placeholder");
            new Thread(new AccountManagementFrame()).start();
        } else if (e.getSource() == debugButton && Main.IS_DEBUGGING) {
            new DebuggingFrame();
        }
    }
}
