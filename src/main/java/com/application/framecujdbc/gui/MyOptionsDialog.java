package com.application.framecujdbc.gui;

import com.application.framecujdbc.db.Constants;
import com.application.framecujdbc.db.DbProperties;
import com.application.framecujdbc.db.DbPropertiesUtil;
import se.datadosen.component.RiverLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


class MyOptionsDialog extends JDialog {

    private JTextField jTextFieldUrl = new JTextField();
    private JTextField jTextFieldUser = new JTextField();
    private JPasswordField jTextFieldPassword = new JPasswordField();

    private JButton jButton = new JButton("Save and Close");
    private DbProperties props = new DbProperties();

    MyOptionsDialog(JFrame parent) throws IOException {

        super(parent, true);

        DbPropertiesUtil propsService = DbPropertiesUtil.getInstance();

        props = propsService.citeste(Constants.PROPS_FILE_NAME);

        jTextFieldUrl.setText(props.getDburl());
        jTextFieldUser.setText(props.getDbusername());
        jTextFieldPassword.setText(props.getDbpassword());

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAndExit();
            }
        });

        this.setLayout(new RiverLayout());
        JLabel jLabelTitlu = new JLabel();

        jLabelTitlu.setForeground(Color.red);
        jLabelTitlu.setFont(new Font("Arial", Font.BOLD, 24));
        jLabelTitlu.setText("Form for edit DB connection credentials");


        add("center", jLabelTitlu);
        add("p left", new JLabel("UrlDB"));
        add("tab hfill", jTextFieldUrl);
//        
        add("p left", new JLabel("Username"));
        add("tab hfill", jTextFieldUser);

        add("p left", new JLabel("parola"));
        add("tab hfill", jTextFieldPassword);
//        
        add("p center", jButton);
        add("p center", new JLabel(""));
        add("p center", new JLabel(""));

        pack();
        setLocationRelativeTo(parent);
    }

    private void saveAndExit() {

        try {
            props.setDburl(jTextFieldUrl.getText());
            props.setDbusername(jTextFieldUser.getText());
            props.setDbpassword(new String(jTextFieldPassword.getPassword()));

            DbPropertiesUtil.getInstance().setTheRecordInPropertieFile(props, Constants.PROPS_FILE_NAME);
            ShowMessage.showMessage(this, "New password has been set", "Succes", true);
        } catch (IOException ex) {
            ShowMessage.showMessage(this, "An error has occurred, The record has not been set ", "Error", false);
        }
        this.dispose();
    }
}