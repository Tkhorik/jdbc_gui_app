
package com.application.framecujdbc.gui;

import javax.swing.*;
import java.awt.*;



/**
 *
 * @author iurasun
 */
public class ArataText {
    static void  showMesaj(Component component, String text, String title, boolean isInformation){
    
        if (isInformation) {
            JOptionPane.showMessageDialog(component, text, title, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(component, text, title, JOptionPane.ERROR_MESSAGE);
        }
         
    }
    
    public static void main(String[] args) {
        showMesaj(null,"Test text", "Title for window", true);  // cu import static sau dina clasa data
        ArataText.showMesaj(null,"Test text for error window", "Filed test text", false);
    }
}
