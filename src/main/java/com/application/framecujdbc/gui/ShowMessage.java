
package com.application.framecujdbc.gui;

import javax.swing.*;
import java.awt.*;


/**
 * @author iurasun
 */
public class ShowMessage {
    static void showMessage(Component component, String text, String title, boolean isInformation) {

        if (isInformation) {
            JOptionPane.showMessageDialog(component, text, title, JOptionPane.INFORMATION_MESSAGE);
        }
        if (!isInformation) {
            JOptionPane.showMessageDialog(component, text, title, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(component, text, title, JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args) {
        showMessage(null, "Test text in alert window", "Title for window", true);  // get from static variable
        showMessage(null, "Test text in alert window", "Title for window", true);  // get from static variable
        ShowMessage.showMessage(null, "Text for information window!!!", "Title for information window!!!", false); //just for testing added? should be removed from showMessage method
    }
}