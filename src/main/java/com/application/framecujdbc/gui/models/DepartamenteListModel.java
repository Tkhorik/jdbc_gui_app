/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.framecujdbc.gui.models;

import com.application.framecujdbc.dao.DepartamentDaoIntf;
import com.application.framecujdbc.dao.impl.DepartamentDaoImpl;
import com.application.framecujdbc.domain.Departament;

import javax.swing.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iurasun
 */
public class DepartamenteListModel  extends DefaultListModel{

    private List<Departament> departamente;
    private DepartamentDaoIntf departamenteDao;



    public DepartamenteListModel() {

        departamenteDao =  new DepartamentDaoImpl();
        try {
            departamente= departamenteDao.findAll();
            
            for (Departament dep : departamente) {
                super.addElement(dep);
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartamentComboBoxModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
}