package com.application.framecujdbc.gui;

import com.application.framecujdbc.dao.AngajatDaoIntf;
import com.application.framecujdbc.dao.impl.AngajatDaoImpl;
import com.application.framecujdbc.db.MyDataSource;
import com.application.framecujdbc.domain.Angajat;
import com.application.framecujdbc.gui.controlers.ApasaListenerExtern;
import com.application.framecujdbc.gui.models.AngajatiTableModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author iurasun
 */
class MyFrame extends JFrame {

    JButton jButtonApasa = new JButton(" Apasa aici! ");
    JButton jButtonExit = new JButton(" Exit ");


    JButton jButtonConnect = new JButton("Connect! ");
    JButton jButtonDisconnect = new JButton("Disconnect");
    JButton jButtonShowList = new JButton(" Show employee list! ");


    JMenuItem jMenuItemApasa = new JMenuItem(" Push the button! ");
    JMenuItem jMenuItemExit = new JMenuItem(" Exit ");

    JMenuItem jMenuItemOptions = new JMenuItem(" Options ");
    JMenuItem jMenuItemAbout = new JMenuItem(" About ");


    JTextField jTextFieldNume = new JTextField(20);
    JTextField jTextFieldPrenume = new JTextField(20);
    JTextArea jTextArea = new JTextArea(10, 20);


    JTabbedPane jTabbedPane = new JTabbedPane();
    JPanel jPanelArea = new JPanel();
    JPanel jPanel = new JPanel();

    JMenu jMenuFile = new JMenu("File");
    JMenu jMenuEdit = new JMenu("Edit");
    JMenu jMenuHelp = new JMenu("Help");


    JMenuBar jMenuBar = new JMenuBar();

    JToolBar jToolBar = new JToolBar();

    JLabel jLabelRezultat = new JLabel("Aici va fi mesajiul final!");


    JTable jTableAngajati;

    //panels
    AngajatiPanel angajatiPanel;
    DepartamentePanel departamentePanel;

    //date
    AngajatDaoIntf angajatiDao;
    List<Angajat> listaAngajati;

    //modele
    AngajatiTableModel angajatiTableModel;

    public MyFrame() {

        initCompnents();
        initModels();
        addListeners();


    }

    private void initModels() {
        angajatiTableModel = new AngajatiTableModel();
        jTableAngajati.setModel(angajatiTableModel);


    }

    private void initCompnents() {
        /////// menu ////////////////
        jMenuFile.add(jMenuItemApasa);
        jMenuFile.add(jMenuItemExit);

        jMenuEdit.add(jMenuItemOptions);

        jMenuHelp.add(jMenuItemAbout);


        jMenuBar.add(jMenuFile);
        jMenuBar.add(jMenuEdit);
        jMenuBar.add(jMenuHelp);


        setJMenuBar(jMenuBar);


        /////////tool bar////////////
        jToolBar.add(jButtonApasa);
        jToolBar.add(jButtonExit);

        jToolBar.addSeparator(new Dimension(80, 0)); // x, y

        jToolBar.add(jButtonConnect);
        jToolBar.add(jButtonDisconnect);

        jToolBar.add(jButtonShowList);

        jToolBar.setFloatable(false);
        this.add(jToolBar, BorderLayout.NORTH);


        /////// panou central ///////
        jPanel.add(new JLabel(" Numele "));
        jPanel.add(jTextFieldNume);

        jPanel.add(new JLabel("    "));

        jPanel.add(new JLabel(" Preumele "));
        jPanel.add(jTextFieldPrenume);

        jPanel.add(jLabelRezultat);

        //this.add(jPanel, BorderLayout.CENTER);// implicit cand e pus pe frame


        angajatiPanel = new AngajatiPanel();


        jTableAngajati = new JTable();

        jPanelArea.setLayout(new BorderLayout());


        jPanelArea.add(new JScrollPane(jTextArea), BorderLayout.SOUTH);
        jPanelArea.add(angajatiPanel, BorderLayout.WEST);
        jPanelArea.add(new JScrollPane(jTableAngajati), BorderLayout.CENTER);


        departamentePanel = new DepartamentePanel();
        jTabbedPane.add("Departamente", departamentePanel);
        jTabbedPane.add("Angajati", jPanelArea);


        this.add(jTabbedPane, BorderLayout.CENTER);// implicit cand e pus pe frame

        setTitle("Demo application for training");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    private void addListeners() {

        ApasaListenerExtern aL = new ApasaListenerExtern(jTextFieldNume, jTextFieldPrenume, jLabelRezultat);

        jButtonApasa.addActionListener(aL);
        jMenuItemApasa.addActionListener(aL);


        jButtonExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });


        jMenuItemExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(rootPane, "Salut! ne pare rau ca iesi asa repede... ");
                System.exit(0);
            }
        });


        jMenuItemAbout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                JOptionPane.showMessageDialog(rootPane, "2015 - " + currentYear + " Frame with Singleton");
            }
        });


        jButtonConnect.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MyDataSource dataSource = MyDataSource.getInstance();
                    conn = dataSource.getConnection();
                    if (conn != null) {
                        ArataText.showMesaj(rootPane, "Database connection established", "Success", true);

                        angajatiPanel.setButoaneAcesibile(true);
                        departamentePanel.setButoaneAcesibile(true);

                        if (angajatiDao == null) {
                            angajatiDao = new AngajatDaoImpl(conn);
                        }
                        angajatiPanel.setAngajatiDao(angajatiDao);

                        if (angajatiTableModel == null) {
                            angajatiTableModel = new AngajatiTableModel();
                        }
                        angajatiPanel.setAngajatiTableModel(angajatiTableModel);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                    ArataText.showMesaj(rootPane, ex.getMessage(), "Error", false);
                }
            }
        });

        jButtonDisconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MyDataSource dataSource = MyDataSource.getInstance();
                    Connection conn = dataSource.getConnection();
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                        ArataText.showMesaj(rootPane, "database connection has been disconnected", "Success", true);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                    ArataText.showMesaj(rootPane, ex.getMessage() + "\nMaybe connection has not been established correctly", "Error", false);
                }
            }
        });


        jButtonShowList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    angajatiDao = new AngajatDaoImpl(conn);
                    listaAngajati = angajatiDao.findAll();
                    arataLista(listaAngajati);
                } catch (Exception ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                    ArataText.showMesaj(rootPane, ex.getMessage(), "Error", false);
                }
            }
        });


        jMenuItemOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    new MyOptionsDialog(MyFrame.this).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        jTabbedPane.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (jTabbedPane.getSelectedIndex() == 1) {
                    angajatiPanel.clearForm();
                }
            }
        });

    }//add listeners

    private void arataLista(List<Angajat> listaAngajati) {
        jTextArea.setText("");

        for (int i = 0; i < listaAngajati.size(); i++) {
            Angajat angajat = listaAngajati.get(i);
            jTextArea.append(angajat.toString());
            jTextArea.append("\n");

        }

        jTabbedPane.setSelectedIndex(1);
        ////


        //aratam in tabela
        angajatiTableModel.refreshData(listaAngajati);


    }

    //clasa interna   - inner
    class ApasaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String nume = jTextFieldNume.getText();
            String prenume = jTextFieldPrenume.getText();

            String mesaj = "Salut " + nume + " " + prenume + "!";
            jLabelRezultat.setText(mesaj);

        }

    }//end class

    Connection conn;
}


