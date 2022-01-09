package org.oakbricks.launcher.gui.tools;

import com.google.gson.Gson;
import fr.litarvan.openauth.AuthPoints;
import fr.litarvan.openauth.Authenticator;
import fr.litarvan.openauth.microsoft.MicrosoftAuthResult;
import fr.litarvan.openauth.microsoft.MicrosoftAuthenticationException;
import fr.litarvan.openauth.microsoft.MicrosoftAuthenticator;
import fr.litarvan.openauth.microsoft.model.response.MinecraftProfile;
import org.apache.commons.io.FileUtils;
import org.oakbricks.launcher.core.json.AccountsJson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.oakbricks.launcher.Main.LOGGER;

public class AccountManagementFrame extends JFrame implements Runnable, ActionListener {
    File ACCOUNT_FILE;

    JButton addMSAButton;
    JButton addMojAccountButton;
    JLabel userNameLabel;
    JTextField userNameTextField;
    JLabel passwordLabel;
    JTextField passwordTextField;
    Object[] emailUserNameAuthObjects;
    @Override
    public void run() {
        addMojAccountButton = new JButton("Add Mojang Account");
        addMojAccountButton.addActionListener(this);
        addMojAccountButton.setBounds(25, 25, 175, 25);

        addMSAButton = new JButton("Add Microsoft Account");
        addMSAButton.addActionListener(this);
        addMSAButton.setBounds(25, 50, 175, 25);

        userNameLabel = new JLabel("Email");
        userNameTextField = new JTextField();
        passwordLabel = new JLabel("Password");
        passwordTextField = new JPasswordField();
        emailUserNameAuthObjects = new Object[]{userNameLabel, userNameTextField, passwordLabel, passwordTextField};


        add(addMojAccountButton);
        add(addMSAButton);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(400, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addMojAccountButton) {
            int result = JOptionPane.showConfirmDialog(this, emailUserNameAuthObjects, "Log in using Mojang", JOptionPane.OK_CANCEL_OPTION);
            if (result == 0) {
                AuthPoints authPoints = AuthPoints.NORMAL_AUTH_POINTS;
                Authenticator authenticator = new Authenticator(Authenticator.MOJANG_AUTH_URL, authPoints);
            }
        } else if (e.getSource() == addMSAButton) {
            int result = JOptionPane.showConfirmDialog(this, emailUserNameAuthObjects, "Log in using Microsoft", JOptionPane.OK_CANCEL_OPTION);
            if (result == 0) {
                MicrosoftAuthenticator authenticator = new MicrosoftAuthenticator();
                MicrosoftAuthResult authResult = null;
                try {
                    authResult = authenticator.loginWithCredentials(userNameTextField.getText(), passwordTextField.getText());
                } catch (MicrosoftAuthenticationException ex) {
                    ex.printStackTrace();
                }
                ACCOUNT_FILE = new File("accounts", authResult.getProfile().getId());
                ACCOUNT_FILE.getParentFile().mkdir();
                try {
                    MinecraftProfile PROFILE = authResult.getProfile();
                    ACCOUNT_FILE.createNewFile();
                    FileUtils.writeStringToFile(ACCOUNT_FILE, AccountsJson.getJsonFromAccount(PROFILE.getId(), PROFILE.getName(),userNameTextField.getText(), passwordTextField.getText(), AccountsJson.AccountType.MSA), StandardCharsets.UTF_8);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
    }
}
