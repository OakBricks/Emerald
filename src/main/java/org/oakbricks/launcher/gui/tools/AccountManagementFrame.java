package org.oakbricks.launcher.gui.tools;

import fr.litarvan.openauth.microsoft.MicrosoftAuthResult;
import fr.litarvan.openauth.microsoft.MicrosoftAuthenticationException;
import fr.litarvan.openauth.microsoft.MicrosoftAuthenticator;
import org.oakbricks.launcher.core.json.AccountsJson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.oakbricks.launcher.Main.LOGGER;

public class AccountManagementFrame extends JFrame implements Runnable, ActionListener {
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

        } else if (e.getSource() == addMSAButton) {
            int result = JOptionPane.showConfirmDialog(null, emailUserNameAuthObjects, "Log in using Microsoft", JOptionPane.OK_CANCEL_OPTION);
            if (result == 0) {
                MicrosoftAuthenticator authenticator = new MicrosoftAuthenticator();
                MicrosoftAuthResult authResult = null;
                try {
                    authResult = authenticator.loginWithCredentials(userNameTextField.getText(), passwordTextField.getText());
                } catch (MicrosoftAuthenticationException ex) {
                    ex.printStackTrace();
                }
                LOGGER.debug("Logged into Xbox using {}", authResult.getProfile().getId());
                LOGGER.info(AccountsJson.getJsonFromAccount(authResult.getProfile().getId(), passwordTextField.getText(), passwordTextField.getText(), AccountsJson.AccountType.XBOX));
            }
        }
    }
}
