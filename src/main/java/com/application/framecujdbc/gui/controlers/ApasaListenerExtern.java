/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.framecujdbc.gui.controlers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author iurasun
 */
public class ApasaListenerExtern implements ActionListener {

    private JTextField jTextFieldNume;
    private JTextField jTextFieldPrenume;
    private JLabel jLabelRezultat;

    public ApasaListenerExtern(JTextField jTextFieldNume, JTextField jTextFieldPrenume, JLabel jLabelRezultat) {
        this.jTextFieldNume = jTextFieldNume;
        this.jTextFieldPrenume = jTextFieldPrenume;
        this.jLabelRezultat = jLabelRezultat;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String nume = jTextFieldNume.getText();
        String prenume = jTextFieldPrenume.getText();

        String mesaj = "Salut " + nume + " " + prenume + "!";
        jLabelRezultat.setText(mesaj);

    }

}//end class
