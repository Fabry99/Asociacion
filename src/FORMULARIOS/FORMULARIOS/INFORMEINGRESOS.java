/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FORMULARIOS;


import CLASES.TextPrompt;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;

import com.mysql.jdbc.Connection;
import conexion.conexion;
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Image;
import com.itextpdf.text.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Line;


/**
 *
 * @author Fujitsu
 */
public class INFORMEINGRESOS extends javax.swing.JFrame {
 //private JDesktopPane escritorio;
 private ImageIcon imagen;
 private ImageIcon icono;
 private ImageIcon imagen2;
 private ImageIcon icono2;
 conexion cn=new conexion();
 Connection cone;
 PreparedStatement pst;
 ResultSet rs;
 private int currReg;
 private int currReg2;
 private int ID;
 private String bus;
 private int mesb;
 private String yb;
 private int ye;
   
       
       //Fondo fondo1=new Fondo();
    /**
     * Creates new form ADMINISTRACION
     */
    public INFORMEINGRESOS() {
       // this.setContentPane(fondo1);
       initComponents();
       cn.getConnection();
       mostrardatos();
     
       lblRango.setVisible(false);
       mes1.setVisible(false);
       yea1.setVisible(false);
       GENERADOR.setEnabled(true);
       TextPrompt dui = new TextPrompt("Ingrese NIT o DUI", txtDui);
       this.setLocationRelativeTo(null);
        
        this.verificarCB();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblRango = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDui = new javax.swing.JTextField();
        txtcliente = new javax.swing.JTextField();
        cbTipoCuenta = new javax.swing.JComboBox<>();
        cbFormapago = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        cbBuscador = new javax.swing.JComboBox<>();
        mes = new javax.swing.JComboBox<>();
        yea = new javax.swing.JComboBox<>();
        GENERADOR = new javax.swing.JButton();
        ms3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mes1 = new javax.swing.JComboBox<>();
        yea1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        fInicio = new com.toedter.calendar.JDateChooser();
        fFinal = new com.toedter.calendar.JDateChooser();
        btnBucar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        MenuDonaciones = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        MenuEgresos = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MenuInformes = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        menuUsuarios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 105, 150));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Yu Gothic", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("INFORMES  INGRESOS");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 380, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 70));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 105, 150));
        jLabel2.setText("DUI / NIT");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 70, 30));

        lblRango.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblRango.setForeground(new java.awt.Color(0, 105, 150));
        lblRango.setText("SELECCIONE EL RANGO DE FECHA");
        jPanel1.add(lblRango, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 240, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 105, 150));
        jLabel4.setText("TIPO ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 60, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 105, 150));
        jLabel6.setText("FORMA DE PAGO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 120, -1));

        txtDui.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDui.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDuiKeyReleased(evt);
            }
        });
        jPanel1.add(txtDui, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 160, 30));

        txtcliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });
        txtcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtclienteKeyReleased(evt);
            }
        });
        jPanel1.add(txtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 400, 30));

        cbTipoCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COLEGIATURA", "DONACIONES", "OTROS" }));
        cbTipoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(cbTipoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 150, 30));

        cbFormapago.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbFormapago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "CHEQUE", "BITCOINS", "TARJETA", "TRANSFERENCIA", "REMESA", "BANCO", "OTRO" }));
        cbFormapago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFormapagoActionPerformed(evt);
            }
        });
        jPanel1.add(cbFormapago, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 130, 30));

        jButton2.setBackground(new java.awt.Color(0, 105, 150));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("MOSTRAR TODOS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 130, 30));

        cbBuscador.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        cbBuscador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FECHA", "TODOS", "DUI", "NOMBRE", "TIPO", "FORMA DE PAGO", "RANGO FECHA", " ", " " }));
        cbBuscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbBuscadorMouseClicked(evt);
            }
        });
        cbBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBuscadorActionPerformed(evt);
            }
        });
        jPanel1.add(cbBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 130, -1));

        mes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DECIEMBRE" }));
        mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesActionPerformed(evt);
            }
        });
        jPanel1.add(mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 120, -1));

        yea.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        yea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035" }));
        yea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yeaActionPerformed(evt);
            }
        });
        jPanel1.add(yea, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 120, -1));

        GENERADOR.setBackground(new java.awt.Color(0, 105, 150));
        GENERADOR.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        GENERADOR.setForeground(new java.awt.Color(255, 255, 255));
        GENERADOR.setText("GENERAR PDF");
        GENERADOR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GENERADORMouseClicked(evt);
            }
        });
        GENERADOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GENERADORActionPerformed(evt);
            }
        });
        jPanel1.add(GENERADOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 120, 40));

        ms3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        ms3.setForeground(new java.awt.Color(255, 51, 51));
        ms3.setText("AVISO: PARA GENERAR PDF DEBE ASIGNAR MES Y AÑO");
        jPanel1.add(ms3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 290, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 105, 150));
        jLabel5.setText("CLIENTE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 70, -1));

        mes1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DECIEMBRE" }));
        mes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mes1ActionPerformed(evt);
            }
        });
        jPanel1.add(mes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 120, -1));

        yea1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        yea1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035" }));
        yea1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yea1ActionPerformed(evt);
            }
        });
        jPanel1.add(yea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, 120, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 105, 150));
        jLabel7.setText("FILTRAR POR:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 100, -1));
        jPanel1.add(fInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, -1, -1));
        jPanel1.add(fFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, -1, -1));

        btnBucar.setText("BUSCAR");
        btnBucar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBucarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBucar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 890, 260));

        jButton1.setBackground(new java.awt.Color(0, 105, 150));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/información-35.png"))); // NOI18N
        jButton1.setText("HOME");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1083, 0, 110, 50));

        tablaAlumnos.setAutoCreateRowSorter(true);
        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAlumnos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 820, 250));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/fondomenu.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, -20, 1350, 650));

        jButton3.setBackground(new java.awt.Color(0, 105, 150));
        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/información-35.png"))); // NOI18N
        jButton3.setText("HOME");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1083, 0, 110, 50));

        jMenuBar1.setBackground(new java.awt.Color(0, 105, 150));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N

        jMenu2.setText("INGRESOS");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jMenu2.add(jSeparator3);

        MenuDonaciones.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        MenuDonaciones.setText("INGRESOS");
        MenuDonaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDonacionesActionPerformed(evt);
            }
        });
        jMenu2.add(MenuDonaciones);
        jMenu2.add(jSeparator4);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("        ");
        jMenuBar1.add(jMenu4);

        MenuEgresos.setText("EGRESOS");
        MenuEgresos.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        MenuEgresos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MenuEgresosMouseDragged(evt);
            }
        });
        MenuEgresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuEgresosMouseClicked(evt);
            }
        });

        jMenuItem2.setText("REGISTRO DE EGRESOS");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuEgresos.add(jMenuItem2);

        jMenuItem1.setText("CUENTA EGRESO");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuEgresos.add(jMenuItem1);

        jMenuBar1.add(MenuEgresos);

        jMenu3.setText("        ");
        jMenuBar1.add(jMenu3);

        MenuInformes.setText("INFORMES");
        MenuInformes.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        MenuInformes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuInformesMouseClicked(evt);
            }
        });
        MenuInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuInformesActionPerformed(evt);
            }
        });
        jMenuBar1.add(MenuInformes);

        jMenu7.setText("                                                                                                                                                                                                                               ");
        jMenuBar1.add(jMenu7);

        jMenu1.setText("ADMINISTRACION ");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        menuUsuarios.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        menuUsuarios.setText("ALUMNOS");
        menuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(menuUsuarios);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //----------------------Metodos Diseño----------------------------------
    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setBackground(new Color(154,7,13));
        jButton1.setForeground(Color.white);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setBackground(new Color(0,105,153));
        jButton1.setForeground(Color.white);
    }//GEN-LAST:event_jButton1MouseExited
    //---------------------------------------------------------------------------------------
    
    //-----------------------Metodos barra de tareas--------------------------------
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ADMINISTRACION vermenu=new ADMINISTRACION();
        vermenu.setVisible(true);
        dispose();  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnosMouseClicked
        int iRow= this.tablaAlumnos.getSelectedRow();
    }//GEN-LAST:event_tablaAlumnosMouseClicked

    private void MenuDonacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDonacionesActionPerformed
        INGRESOS vermenudona= new INGRESOS();
        vermenudona.setVisible(true);
        dispose();
    }//GEN-LAST:event_MenuDonacionesActionPerformed

    private void menuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuariosActionPerformed
        USUARIOS vermenudona= new USUARIOS();
        vermenudona.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuUsuariosActionPerformed
    //-------------------------------------------------------------------------------------------
    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void MenuEgresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuEgresosMouseClicked
     
    }//GEN-LAST:event_MenuEgresosMouseClicked

    private void cbBuscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbBuscadorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBuscadorMouseClicked
    
    //-----------------------Boton mostrar todo---------------------------------
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtDui.setText(null);
        txtcliente.setText(null);

        BUSCADOR("","" , "", "", "NOFILTRO",mesb,ye);
        txtDui.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    //------------------------Generador PDF--------------------------------------
    
    private void GENERADORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GENERADORActionPerformed
        String buscador=cbBuscador.getSelectedItem().toString();
       String mesb2 = mes.getSelectedItem().toString();
        String yb2 = yea.getSelectedItem().toString();
        
        if (buscador.equals("NOMBRE")) {
           pdf(mesb2,yb2); 
        }
        else if (!buscador.equals("NOMBRE") && !buscador.equals("TODOS")
                 && !buscador.equals("DUI") && !buscador.equals("TIPO") && !buscador.equals("FORMA DE PAGO")
                 && !buscador.equals("RANGO FECHA") ) {
            
            pdfGeneral(mesb2,yb2);
        }
{
            
        }
         

         
    }//GEN-LAST:event_GENERADORActionPerformed

    //---------------------------Menu informes-----------------------------------
    
    private void MenuInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuInformesActionPerformed
        INFORMEINGRESOS vermenudona= new INFORMEINGRESOS();
        vermenudona.setVisible(true);
        dispose();
    }//GEN-LAST:event_MenuInformesActionPerformed

    private void MenuInformesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuInformesMouseClicked
        INFORMEINGRESOS vermenudona= new INFORMEINGRESOS();
        vermenudona.setVisible(true);
        dispose();
    }//GEN-LAST:event_MenuInformesMouseClicked

    //--------------------------------Busqueda por mes-----------------------------------
    
    private void mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesActionPerformed
        String buscador=cbBuscador.getSelectedItem().toString();
        if(!buscador.equals("TODOS")) buscador = "FECHA";
        else if(buscador.equals("RANGO FECHA")) buscador = "RANGO FECHA";
        else buscador = "TODOS";
        String bus2 = "", bTipo = "", bFPago = "";
        bus2 = txtcliente.getText().toUpperCase();
        bus = "";
        bus = txtDui.getText().toUpperCase();
        bTipo = cbTipoCuenta.getSelectedItem().toString().toUpperCase();
        bFPago = cbFormapago.getSelectedItem().toString().toUpperCase();
        mesb=mes.getSelectedIndex()+1;
        yb=yea.getSelectedItem().toString();
        ye=Integer.valueOf(yb);
        BUSCADOR(bus,bus2, bTipo, bFPago,buscador,mesb,ye);
    }//GEN-LAST:event_mesActionPerformed

    //------------------------------Busqueda por DUI o NIT--------------------------
    
    private void txtDuiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuiKeyReleased
        String buscador=cbBuscador.getSelectedItem().toString();
        if(!buscador.equals("TODOS")) buscador = "DUI";
        else buscador = "TODOS";
        String bus2 = "", bTipo = "", bFPago = "";
        bus2 = txtcliente.getText().toUpperCase();
        bus = "";
        bus = txtDui.getText().toUpperCase();
        bTipo = cbTipoCuenta.getSelectedItem().toString().toUpperCase();
        bFPago = cbFormapago.getSelectedItem().toString().toUpperCase();
        mesb=mes.getSelectedIndex()+1;
        yb=yea.getSelectedItem().toString();
        ye=Integer.valueOf(yb);
        BUSCADOR(bus,bus2, bTipo, bFPago,buscador,mesb,ye);
    }//GEN-LAST:event_txtDuiKeyReleased

    //---------------------------------Busqueda por cliente------------------------
    
    private void txtclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclienteKeyReleased
         String buscador=cbBuscador.getSelectedItem().toString();
        if(!buscador.equals("TODOS")) buscador = "NOMBRE";
        else buscador = "TODOS";
        String bus2 = "", bTipo = "", bFPago = "";
        bus2 = txtcliente.getText().toUpperCase();
        bus = "";
        bus = txtDui.getText().toUpperCase();
        bTipo = cbTipoCuenta.getSelectedItem().toString().toUpperCase();
        bFPago = cbFormapago.getSelectedItem().toString().toUpperCase();
        mesb=mes.getSelectedIndex()+1;
        yb=yea.getSelectedItem().toString();
        ye=Integer.valueOf(yb);
        BUSCADOR(bus,bus2, bTipo, bFPago,buscador,mesb,ye);
    }//GEN-LAST:event_txtclienteKeyReleased

    //-------------------------Busqueda por tipo de cuenta--------------------------------------
    
    private void cbTipoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoCuentaActionPerformed
        String buscador=cbBuscador.getSelectedItem().toString();
        if(!buscador.equals("TODOS")) buscador = "TIPO";
        else buscador = "TODOS";
        String bus2 = "", bTipo = "", bFPago = "";
        bus2 = txtcliente.getText().toUpperCase();
        bus = "";
        bus = txtDui.getText().toUpperCase();
        bTipo = cbTipoCuenta.getSelectedItem().toString().toUpperCase();
        bFPago = cbFormapago.getSelectedItem().toString().toUpperCase();
        mesb=mes.getSelectedIndex()+1;
        yb=yea.getSelectedItem().toString();
        ye=Integer.valueOf(yb);
        BUSCADOR(bus,bus2, bTipo, bFPago,buscador,mesb,ye);
    }//GEN-LAST:event_cbTipoCuentaActionPerformed

    private void txtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclienteActionPerformed

    }//GEN-LAST:event_txtclienteActionPerformed

    //-------------------------Filtro de busqueda-----------------------------------
    
    private void cbBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBuscadorActionPerformed
        this.verificarCB();
    }//GEN-LAST:event_cbBuscadorActionPerformed

    //---------------------------Busqueda por forma de pago----------------------------
    
    private void cbFormapagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFormapagoActionPerformed
        String buscador=cbBuscador.getSelectedItem().toString();
        if(!buscador.equals("TODOS")) buscador = "FORMA DE PAGO";
        else buscador = "TODOS";
        String bus2 = "", bTipo = "", bFPago = "";
        bus2 = txtcliente.getText().toUpperCase();
        bus = "";
        bus = txtDui.getText().toUpperCase();
        bTipo = cbTipoCuenta.getSelectedItem().toString().toUpperCase();
        bFPago = cbFormapago.getSelectedItem().toString().toUpperCase();
        mesb=mes.getSelectedIndex()+1;
        yb=yea.getSelectedItem().toString();
        ye=Integer.valueOf(yb);
        BUSCADOR(bus,bus2, bTipo, bFPago,buscador,mesb,ye);
    }//GEN-LAST:event_cbFormapagoActionPerformed

    //-----------------------------------Busqueda por año----------------------------
    
    private void yeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yeaActionPerformed
        String buscador=cbBuscador.getSelectedItem().toString();
        if(!buscador.equals("TODOS")) buscador = "FECHA";
        else buscador = "TODOS";
        String bus2 = "", bTipo = "", bFPago = "";
        bus2 = txtcliente.getText().toUpperCase();
        bus = "";
        bus = txtDui.getText().toUpperCase();
        bTipo = cbTipoCuenta.getSelectedItem().toString().toUpperCase();
        bFPago = cbFormapago.getSelectedItem().toString().toUpperCase();
        mesb=mes.getSelectedIndex()+1;
        yb=yea.getSelectedItem().toString();
        ye=Integer.valueOf(yb);
        BUSCADOR(bus,bus2, bTipo, bFPago,buscador,mesb,ye);
    }//GEN-LAST:event_yeaActionPerformed

    private void mes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mes1ActionPerformed

    private void yea1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yea1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yea1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        CUENTAEGRESOS vermenudona= new CUENTAEGRESOS();
        vermenudona.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void MenuEgresosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuEgresosMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuEgresosMouseDragged

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
           EGRESOS vermenudona= new EGRESOS();
        vermenudona.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void GENERADORMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GENERADORMouseClicked


    }//GEN-LAST:event_GENERADORMouseClicked

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnBucarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBucarActionPerformed
        try {
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            String date1=df.format(fInicio.getDate());
            String date2=df.format(fFinal.getDate());
            DateSearchShow(date1,date2);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBucarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(INFORMEINGRESOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INFORMEINGRESOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INFORMEINGRESOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INFORMEINGRESOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INFORMEINGRESOS().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GENERADOR;
    private javax.swing.JMenuItem MenuDonaciones;
    private javax.swing.JMenu MenuEgresos;
    private javax.swing.JMenu MenuInformes;
    private javax.swing.JButton btnBucar;
    private javax.swing.JComboBox<String> cbBuscador;
    private javax.swing.JComboBox<String> cbFormapago;
    private javax.swing.JComboBox<String> cbTipoCuenta;
    private com.toedter.calendar.JDateChooser fFinal;
    private com.toedter.calendar.JDateChooser fInicio;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JLabel lblRango;
    private javax.swing.JMenuItem menuUsuarios;
    private javax.swing.JComboBox<String> mes;
    private javax.swing.JComboBox<String> mes1;
    private javax.swing.JLabel ms3;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JComboBox<String> yea;
    private javax.swing.JComboBox<String> yea1;
    // End of variables declaration//GEN-END:variables

    
    //--------------------------Metodo mostrar datos----------------------------------
    public void mostrardatos(){
     DefaultTableModel tcliente= new DefaultTableModel();
     tcliente.addColumn("ID");
     tcliente.addColumn("INGRESO");
     tcliente.addColumn("CLIENTE");
     tcliente.addColumn("DUI");
     tcliente.addColumn("FORMA_PAGO");
     tcliente.addColumn("CANTIDAD $");
     tcliente.addColumn("FECHA");
     tcliente.addColumn("DESCRIPCION");
     tablaAlumnos.setModel(tcliente);
     String []datos =new String[8];
     java.sql.Connection con2 = null;
     PreparedStatement pst = null;
     DecimalFormat formato1 = new DecimalFormat("#.00"); //Formato para los double
   
     try {
           con2 = cn.getConnection();
           pst=con2.prepareStatement("Select * from ingresos ORDER BY ID_INGRESOS");
           rs = pst.executeQuery();
           while (rs.next()) {
               datos[0]=rs.getString(1);
               datos[1]=rs.getString(2);
               datos[2]=rs.getString(3);
               datos[3]=rs.getString(4);
               datos[4]=rs.getString(5);
               datos[5]= formato1.format(Double.parseDouble(rs.getString(6)));
               datos[6]=rs.getString(7);
               datos[7]=rs.getString(8);
                tcliente.addRow(datos);
            }
            this.tablaAlumnos.setModel(tcliente);
             // JOptionPane.showMessageDialog(this, "NIE"+datos[0]+"\n"+datos[1]+"\n"+datos[2]+"\n"+datos[3]+"\n"+datos[4]+"\n"+datos[5]);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
        }
    }
    
    //Mostrar datos de ingresos entre Dos Fechas
    public void DateSearchShow(String d1, String d2){
     DefaultTableModel tcliente= new DefaultTableModel();
     tcliente.addColumn("ID");
     tcliente.addColumn("INGRESO");
     tcliente.addColumn("CLIENTE");
     tcliente.addColumn("DUI");
     tcliente.addColumn("FORMA_PAGO");
     tcliente.addColumn("CANTIDAD $");
     tcliente.addColumn("FECHA");
     tcliente.addColumn("DESCRIPCION");
     tablaAlumnos.setModel(tcliente);
     String []datos =new String[8];
     java.sql.Connection con2 = null;
     PreparedStatement pst = null;
     DecimalFormat formato1 = new DecimalFormat("#.00"); //Formato para los double
   
     try {
         if (d1.equals("") || d2.equals("")) {
           con2 = cn.getConnection();
           pst=con2.prepareStatement("Select * from ingresos ORDER BY ID_INGRESOS");
           rs = pst.executeQuery();
         }else{
           con2 = cn.getConnection();
           pst=con2.prepareStatement("Select * from ingresos where FECHA between ? and ?");
           pst.setString(1, d1);
           pst.setString(2, d2);
           rs = pst.executeQuery();
         }
           while (rs.next()) {
               datos[0]=rs.getString(1);
               datos[1]=rs.getString(2);
               datos[2]=rs.getString(3);
               datos[3]=rs.getString(4);
               datos[4]=rs.getString(5);
               datos[5]= formato1.format(Double.parseDouble(rs.getString(6)));
               datos[6]=rs.getString(7);
               datos[7]=rs.getString(8);
                tcliente.addRow(datos);
            }
            this.tablaAlumnos.setModel(tcliente);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
        }
    }
    
    
    //------------------------------------Metodo para querys de busqueda-----------------------------------------------------------
    
    public void BUSCADOR(String dato, String dato2, String dTipo, String dFPago,String buscador,int mes, int y){
        
    DefaultTableModel tcliente = new DefaultTableModel();
     tcliente.addColumn("ID");
     tcliente.addColumn("INGRESO");
     tcliente.addColumn("CLIENTE");
     tcliente.addColumn("DUI");
     tcliente.addColumn("FORMA_PAGO");
     tcliente.addColumn("CANTIDAD $");
     tcliente.addColumn("FECHA");
     tcliente.addColumn("DESCRIPCION");
     tablaAlumnos.setModel(tcliente);
     String []datos =new String[8];
     java.sql.Connection con2 = null;
     PreparedStatement pst = null;
     DecimalFormat formato1 = new DecimalFormat("#.00"); //Formato para los double
     try {
         con2 = cn.getConnection();
         if (buscador.equals("DUI")){
            pst = con2.prepareStatement("Select * from ingresos  where DUI_NIT like'"+(dato)+"%'");
            rs = pst.executeQuery();
           }else if (buscador.equals("TODOS")){
                pst=con2.prepareStatement("Select * from ingresos  where DUI_NIT like'"+(dato)
                        +"%' AND CLIENTE like'%"+(dato2)+
                        "%' AND NOMBRE_CUENTA= '"+(dTipo)+
                        "' AND TIPO_CUENTA='"+(dFPago)+
                        "' AND MONTH(FECHA)="+(mes)+" && YEAR(FECHA)="+(y));
                rs = pst.executeQuery();
                
            }else if (buscador.equals("NOFILTRO")){
                pst=con2.prepareStatement("Select * from ingresos");
                rs = pst.executeQuery();
             
              }else if (buscador.equals("NOMBRE")){
                pst=con2.prepareStatement("Select * from ingresos  where CLIENTE like'%"+(dato2)+"%'");
                rs = pst.executeQuery();
             
              }else if (buscador.equals("TIPO")){
            pst=con2.prepareStatement("Select * from ingresos where NOMBRE_CUENTA='"+(dTipo)+"'");
           rs = pst.executeQuery();
             
              }else if (buscador.equals("FORMA DE PAGO")){
              pst=con2.prepareStatement("Select * from ingresos where TIPO_CUENTA='"+(dFPago)+"'");
           rs = pst.executeQuery();
             
              }else if (buscador.equals("FECHA")){
                  
              pst=con2.prepareStatement("Select * from ingresos where MONTH(FECHA)="+(mes)+"&& YEAR(FECHA)="+(y));
           rs = pst.executeQuery();
             
              }else {
              JOptionPane.showMessageDialog(this, "ERROR AL BUSCAR "+dato);
              }
        
            while (rs.next()) {
             
               datos[0]=rs.getString(1);
               datos[1]=rs.getString(2);
               datos[2]=rs.getString(3);
               datos[3]=rs.getString(4);
               datos[4]=rs.getString(5);
               datos[5]= formato1.format(Double.parseDouble(rs.getString(6)));
               datos[6]=rs.getString(7);
               datos[7]=rs.getString(8);
                tcliente.addRow(datos);
            }
            this.tablaAlumnos.setModel(tcliente);
            
             // JOptionPane.showMessageDialog(this, "NIE"+datos[0]+"\n"+datos[1]+"\n"+datos[2]+"\n"+datos[3]+"\n"+datos[4]+"\n"+datos[5]);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
        }
    }
    public void habilitar(){
     txtcliente.setEnabled(true);
     txtDui.setEnabled(true);
     //txtDescripcion.setEnabled(true);
     cbFormapago.setEnabled(true);
     cbTipoCuenta.setEnabled(true);
     // txtCantidad.setEnabled(true);
    }
        
//       
private void pdf(String mes, String year){
    try {
        
        FileOutputStream archivo;
        File file=new File(System.getProperty("user.home")+"/desktop/"+mes+"-"+year+".pdf");
        archivo=new FileOutputStream(file);
        Document doc=new Document(PageSize.A4.rotate(), 10f, 10f, 20f, 0f);
        PdfWriter.getInstance(doc,archivo); 
        doc.open();
        
        Image imagen = Image.getInstance("src/IMAGENES/IMAGENES/asociacion.png");
        imagen.scalePercent(12f);
        imagen.setAbsolutePosition(doc.leftMargin(),doc.top()- imagen.getScaledHeight()-5);
        doc.add(imagen);
        
        Font neg=new Font(FontFactory.getFont("Arial",16, Font.BOLD,BaseColor.BLACK));
        Font neg1=new Font(FontFactory.getFont("Arial",14, Font.BOLD,BaseColor.BLACK));
        Font contac=new Font(FontFactory.getFont("Arial",12, Font.BOLD,BaseColor.BLACK));
        
        Paragraph titulo=new Paragraph("ASOCIACIÓN SANTA CATALINA DE SIENA",neg);
        titulo.setAlignment(Element.ALIGN_CENTER);
        doc.add(titulo);
        
        Paragraph tituloIn=new Paragraph("INFORME DE INGRESOS",neg1);
        tituloIn.setAlignment(Element.ALIGN_CENTER);
        tituloIn.setSpacingAfter(8f);
        doc.add(tituloIn);
        
        PdfPTable contactos=new PdfPTable(2);
        PdfPCell ConCel1=new PdfPCell(new Paragraph("santacatalina.ong@gmail.com",contac));
        PdfPCell ConCel2=new PdfPCell(new Paragraph("http://asociacionsantacatalinadesiena.org/",contac));
        ConCel1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        ConCel2.setPaddingLeft(5f);
        ConCel1.setPaddingRight(5f);
        ConCel1.setBorderWidth(0);
        ConCel2.setBorderWidth(0);
        contactos.addCell(ConCel1);
        contactos.addCell(ConCel2);
        doc.add(contactos);
        
        PdfPTable tabTelef=new PdfPTable(2);
        PdfPCell ConCel3=new PdfPCell(new Paragraph("Teléfonos:",contac));
        PdfPCell ConCel4=new PdfPCell(new Paragraph("2447-2022     (503) 7702-8122"));
        ConCel3.setHorizontalAlignment(Element.ALIGN_RIGHT);
        ConCel3.setBorderWidth(0);
        ConCel4.setBorderWidth(0);
        tabTelef.addCell(ConCel3);
        tabTelef.addCell(ConCel4);
        doc.add(tabTelef);
        
        Paragraph direccion=new Paragraph("Callejón Poniente Iglesia El Carmen, #10, Santa Ana, El Salvador"); 
        direccion.setAlignment(Element.ALIGN_CENTER);
        direccion.setSpacingAfter(13f);
        doc.add(direccion);
        
        //Datos personales clientes
        for (int i = 0; i < tablaAlumnos.getRowCount(); i++) {
            String ingreso = tablaAlumnos.getValueAt(i, 1).toString();
            String cliente = tablaAlumnos.getValueAt(i, 2).toString();
            String dui = tablaAlumnos.getValueAt(i, 3).toString();
            String forma = tablaAlumnos.getValueAt(i, 4).toString();
            String cantidad = tablaAlumnos.getValueAt(i, 5).toString();
            String fech = tablaAlumnos.getValueAt(i, 6).toString();
            String descr = tablaAlumnos.getValueAt(i, 7).toString();
            
            PdfPTable tabCliente=new PdfPTable(4);
            tabCliente.setWidths(new float[]{10f,15f,10,10});
            PdfPCell ClCell1=new PdfPCell(new Paragraph("Cliente:",contac));
            PdfPCell ClCell2=new PdfPCell(new Paragraph(cliente));
            PdfPCell ClCell3=new PdfPCell(new Paragraph("DUI/NIT:",contac));
            PdfPCell ClCell4=new PdfPCell(new Paragraph(dui));
            ClCell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            ClCell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
            ClCell1.setBorderWidth(0f);
            ClCell2.setBorderWidth(0f);
            ClCell3.setBorderWidth(0f);
            ClCell4.setBorderWidth(0f);
            tabCliente.addCell(ClCell1);
            tabCliente.addCell(ClCell2);
            tabCliente.addCell(ClCell3);
            tabCliente.addCell(ClCell4);
            tabCliente.setSpacingAfter(5f);
            doc.add(tabCliente);
           
            
            PdfPTable tabDirec=new PdfPTable(4);
            tabDirec.setWidths(new float[]{10f,15f,10,10});
            PdfPCell DCell1=new PdfPCell(new Paragraph("Dirección:",contac));
            PdfPCell DCell2=new PdfPCell(new Paragraph(""));
            PdfPCell DCell3=new PdfPCell(new Paragraph("Teléfono:",contac));
            PdfPCell DCell4=new PdfPCell(new Paragraph(""));
            DCell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            DCell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
            DCell1.setBorderWidth(0f);
            DCell2.setBorderWidth(0f);
            DCell3.setBorderWidth(0f);
            DCell4.setBorderWidth(0f);
            tabDirec.addCell(DCell1);
            tabDirec.addCell(DCell2);
            tabDirec.addCell(DCell3);
            tabDirec.addCell(DCell4);
            tabDirec.setSpacingAfter(5f);
            doc.add( tabDirec);
            
            PdfPTable tabNacio = new PdfPTable(6);
            tabNacio.setWidths(new float[]{10f, 13f, 10f, 2f,8f,2f});
            PdfPCell NCell1 = new PdfPCell(new Paragraph("Nacionalidad:", contac));
            PdfPCell NCell2 = new PdfPCell(new Paragraph(""));
            PdfPCell NCell3 = new PdfPCell(new Paragraph("Persona Natural:", contac));
            PdfPCell NCell4 = new PdfPCell(new Paragraph(""));
            PdfPCell NCell5 = new PdfPCell(new Paragraph("Persona Juridica:",contac));
            PdfPCell NCell6 = new PdfPCell(new Paragraph(""));
            NCell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            NCell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
            NCell5.setHorizontalAlignment(Element.ALIGN_RIGHT);
            NCell1.setBorderWidth(0f);
            NCell2.setBorderWidth(0f);
            NCell3.setBorderWidth(0f);
            NCell5.setBorderWidth(0f);
            tabNacio.addCell(NCell1);
            tabNacio.addCell(NCell2);
            tabNacio.addCell(NCell3);
            tabNacio.addCell(NCell4);
            tabNacio.addCell(NCell5);
            tabNacio.addCell(NCell6);
            tabNacio.setSpacingAfter(5f);
            doc.add(tabNacio);
            
            PdfPTable tabCargo = new PdfPTable(2);
            tabCargo.setWidths(new float[]{10f, 35f});
            PdfPCell crCell1 = new PdfPCell(new Paragraph("Cargo Publico:", contac));
            PdfPCell crCell2 = new PdfPCell(new Paragraph(""));
            crCell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            crCell1.setBorderWidth(0f);
            crCell2.setBorderWidth(0f);
            tabCargo.addCell(crCell1);
            tabCargo.addCell(crCell2);
            tabCargo.setSpacingAfter(5f);
            doc.add(tabCargo);
            
            PdfPTable tabRango = new PdfPTable(4);
            tabRango.setWidths(new float[]{10f,17f,8f,10f});
            PdfPCell RCel1 = new PdfPCell(new Paragraph("De:", contac));
            PdfPCell RCel2 = new PdfPCell(new Paragraph(""));
            PdfPCell RCel3 = new PdfPCell(new Paragraph("Hasta:",contac));
            PdfPCell RCel4 = new PdfPCell(new Paragraph(""));
            RCel1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            RCel3.setHorizontalAlignment(Element.ALIGN_RIGHT);
            RCel1.setBorderWidth(0f);
            RCel2.setBorderWidth(0f);
            RCel3.setBorderWidth(0f);
            RCel4.setBorderWidth(0f);
            tabRango.addCell(RCel1);
            tabRango.addCell(RCel2);
            tabRango.addCell(RCel3);
            tabRango.addCell(RCel4);
            tabRango.setSpacingAfter(12f);
            doc.add(tabRango);
            
    
        }
         
         //AQUI TERMINA PRIMERA TABLA
          PdfPTable Informe=new PdfPTable(5);
         Informe.setWidthPercentage(90);
       
         float[] Columnainforme = new float[]{15f,15f,10f,10f,25f};
         Informe.setWidths(Columnainforme);
         Informe.setHorizontalAlignment(Element.ALIGN_CENTER);
         PdfPCell c1= new PdfPCell(new Paragraph("INGRESO",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLACK)));
         PdfPCell c4= new PdfPCell(new Paragraph("FORMA DE PAGO",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLACK)));
         PdfPCell c5= new PdfPCell(new Paragraph("CANTIDAD",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLACK)));
         PdfPCell c6= new PdfPCell(new Paragraph("FECHA",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLACK)));
         PdfPCell c7= new PdfPCell(new Paragraph("DESCRIPCION",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLACK)));
         PdfPCell linea = new PdfPCell(new Paragraph("\n"));
         linea.setColspan(3);
         linea.setBorder(0);
         c1.setBackgroundColor(new BaseColor(162,216,190)); 
         c4.setBackgroundColor(new BaseColor(162,216,190));
         c5.setBackgroundColor(new BaseColor(162, 216, 190));
         c6.setBackgroundColor(new BaseColor(162,216,190));
         c7.setBackgroundColor(new BaseColor(162, 216, 190));
         c1.setHorizontalAlignment(Element.ALIGN_CENTER);
         c4.setHorizontalAlignment(Element.ALIGN_CENTER);
         c5.setHorizontalAlignment(Element.ALIGN_CENTER);
         c6.setHorizontalAlignment(Element.ALIGN_CENTER);
         c7.setHorizontalAlignment(Element.ALIGN_CENTER);
         Informe.addCell(c1); Informe.addCell(c4); Informe.addCell(c5); Informe.addCell(c6); Informe.addCell(c7);
         Informe.addCell(linea).setHorizontalAlignment(Element.ALIGN_LEFT);
         Informe.setHorizontalAlignment(Element.ALIGN_CENTER);
         doc.add(Informe);
         
      //AQUI TERMINA segunda TABLA
        PdfPTable DATOS = new PdfPTable(5);
        DATOS.setWidthPercentage(90);
        DATOS.setWidths(Columnainforme);
        DATOS.setHorizontalAlignment(Element.ALIGN_CENTER);
         
         for (int i=0; i < tablaAlumnos.getRowCount(); i++){
            String ingreso=tablaAlumnos.getValueAt(i, 1).toString();
            String forma=tablaAlumnos.getValueAt(i, 4).toString();
            String cantidad=tablaAlumnos.getValueAt(i, 5).toString();
            String fech=tablaAlumnos.getValueAt(i, 6).toString();
            String descr=tablaAlumnos.getValueAt(i, 7).toString();
            
            
            PdfPCell ingresoPDF= new PdfPCell(new Paragraph(ingreso ,FontFactory.getFont("Arial",12,BaseColor.BLACK)));
            PdfPCell formaPDF = new PdfPCell(new Paragraph(forma ,FontFactory.getFont("Arial",12,BaseColor.BLACK)));
            PdfPCell cantidadPDF = new PdfPCell(new Paragraph("$"+cantidad ,FontFactory.getFont("Arial",12,BaseColor.BLACK)));
            PdfPCell fechPDF= new PdfPCell(new Paragraph(fech ,FontFactory.getFont("Arial",12,BaseColor.BLACK)));
            PdfPCell descrPDF = new PdfPCell(new Paragraph(descr ,FontFactory.getFont("Arial",12,BaseColor.BLACK)));
            cantidadPDF.setHorizontalAlignment(Element.ALIGN_RIGHT);
            fechPDF.setHorizontalAlignment(Element.ALIGN_CENTER);
            descrPDF.setHorizontalAlignment(Element.ALIGN_CENTER);
            DATOS.addCell(ingresoPDF);
            DATOS.addCell(formaPDF);
            DATOS.addCell(cantidadPDF);
            DATOS.addCell(fechPDF);
            DATOS.addCell(descrPDF);
            }
         doc.add(DATOS);
      
         doc.close();
         archivo.close();
          JOptionPane.showMessageDialog(this, "PDF GENERADO CON EXITO");
    } catch (Exception e) {
         JOptionPane.showMessageDialog(this, e);
    }
}




private void pdfGeneral(String mes, String year){
    try {
        
        FileOutputStream archivo;
        File arc=new File(System.getProperty("user.home")+"/desktop/"+mes+"-"+year+".pdf");
        archivo=new FileOutputStream(arc);
        Document docu=new Document(PageSize.A4.rotate(), 10f, 10f, 20f, 0f);
        PdfWriter.getInstance(docu,archivo); 
        docu.open();
        
        Image imagen = Image.getInstance("src/IMAGENES/IMAGENES/asociacion.png");
        imagen.scalePercent(12f);
        imagen.setAbsolutePosition(docu.leftMargin(),docu.top()- imagen.getScaledHeight()-5);
        docu.add(imagen);
        
        Font neg=new Font(FontFactory.getFont("Arial",16, Font.BOLD,BaseColor.BLACK));
        Font neg1=new Font(FontFactory.getFont("Arial",14, Font.BOLD,BaseColor.BLACK));
        Font contac=new Font(FontFactory.getFont("Arial",12, Font.BOLD,BaseColor.BLACK));
        
        Paragraph titulo=new Paragraph("ASOCIACIÓN SANTA CATALINA DE SIENA",neg);
        titulo.setAlignment(Element.ALIGN_CENTER);
        docu.add(titulo);
        
        Paragraph tituloIn=new Paragraph("INFORME DE INGRESOS",neg1);
        tituloIn.setAlignment(Element.ALIGN_CENTER);
        tituloIn.setSpacingAfter(8f);
        docu.add(tituloIn);
        
        PdfPTable contactos=new PdfPTable(2);
        PdfPCell ConCel1=new PdfPCell(new Paragraph("santacatalina.ong@gmail.com",contac));
        PdfPCell ConCel2=new PdfPCell(new Paragraph("http://asociacionsantacatalinadesiena.org/",contac));
        ConCel1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        ConCel2.setPaddingLeft(5f);
        ConCel1.setPaddingRight(5f);
        ConCel1.setBorderWidth(0);
        ConCel2.setBorderWidth(0);
        contactos.addCell(ConCel1);
        contactos.addCell(ConCel2);
        docu.add(contactos);
        
        PdfPTable tabTelef=new PdfPTable(2);
        PdfPCell ConCel3=new PdfPCell(new Paragraph("Teléfonos:",contac));
        PdfPCell ConCel4=new PdfPCell(new Paragraph("2447-2022     (503) 7702-8122"));
        ConCel3.setHorizontalAlignment(Element.ALIGN_RIGHT);
        ConCel3.setBorderWidth(0);
        ConCel4.setBorderWidth(0);
        tabTelef.addCell(ConCel3);
        tabTelef.addCell(ConCel4);
        docu.add(tabTelef);
        
        Paragraph direccion=new Paragraph("Callejón Poniente Iglesia El Carmen, #10, Santa Ana, El Salvador"); 
        direccion.setAlignment(Element.ALIGN_CENTER);
        direccion.setSpacingAfter(25f);
        docu.add(direccion);
        
        //Datos personales clientes
//        for (int i = 0; i < tablaAlumnos.getRowCount(); i++) {
//            String ingreso = tablaAlumnos.getValueAt(i, 1).toString();
//            String cliente = tablaAlumnos.getValueAt(i, 2).toString();
//            String dui = tablaAlumnos.getValueAt(i, 3).toString();
//            String forma = tablaAlumnos.getValueAt(i, 4).toString();
//            String cantidad = tablaAlumnos.getValueAt(i, 5).toString();
//            String fech = tablaAlumnos.getValueAt(i, 6).toString();
//            String descr = tablaAlumnos.getValueAt(i, 7).toString();
//            
//            PdfPTable tabCliente=new PdfPTable(4);
//            tabCliente.setWidths(new float[]{10f,15f,10,10});
//            PdfPCell ClCell1=new PdfPCell(new Paragraph("Cliente:",contac));
//            PdfPCell ClCell2=new PdfPCell(new Paragraph(cliente));
//            PdfPCell ClCell3=new PdfPCell(new Paragraph("DUI/NIT:",contac));
//            PdfPCell ClCell4=new PdfPCell(new Paragraph(dui));
//            ClCell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            ClCell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            ClCell1.setBorderWidth(0f);
//            ClCell2.setBorderWidth(0f);
//            ClCell3.setBorderWidth(0f);
//            ClCell4.setBorderWidth(0f);
//            tabCliente.addCell(ClCell1);
//            tabCliente.addCell(ClCell2);
//            tabCliente.addCell(ClCell3);
//            tabCliente.addCell(ClCell4);
//            tabCliente.setSpacingAfter(5f);
//            doc.add(tabCliente);
//           
//            
//            PdfPTable tabDirec=new PdfPTable(4);
//            tabDirec.setWidths(new float[]{10f,15f,10,10});
//            PdfPCell DCell1=new PdfPCell(new Paragraph("Dirección:",contac));
//            PdfPCell DCell2=new PdfPCell(new Paragraph(""));
//            PdfPCell DCell3=new PdfPCell(new Paragraph("Teléfono:",contac));
//            PdfPCell DCell4=new PdfPCell(new Paragraph(""));
//            DCell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            DCell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            DCell1.setBorderWidth(0f);
//            DCell2.setBorderWidth(0f);
//            DCell3.setBorderWidth(0f);
//            DCell4.setBorderWidth(0f);
//            tabDirec.addCell(DCell1);
//            tabDirec.addCell(DCell2);
//            tabDirec.addCell(DCell3);
//            tabDirec.addCell(DCell4);
//            tabDirec.setSpacingAfter(5f);
//            doc.add( tabDirec);
//            
//            PdfPTable tabNacio = new PdfPTable(6);
//            tabNacio.setWidths(new float[]{10f, 13f, 10f, 2f,8f,2f});
//            PdfPCell NCell1 = new PdfPCell(new Paragraph("Nacionalidad:", contac));
//            PdfPCell NCell2 = new PdfPCell(new Paragraph(""));
//            PdfPCell NCell3 = new PdfPCell(new Paragraph("Persona Natural:", contac));
//            PdfPCell NCell4 = new PdfPCell(new Paragraph(""));
//            PdfPCell NCell5 = new PdfPCell(new Paragraph("Persona Juridica:",contac));
//            PdfPCell NCell6 = new PdfPCell(new Paragraph(""));
//            NCell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            NCell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            NCell5.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            NCell1.setBorderWidth(0f);
//            NCell2.setBorderWidth(0f);
//            NCell3.setBorderWidth(0f);
//            NCell5.setBorderWidth(0f);
//            tabNacio.addCell(NCell1);
//            tabNacio.addCell(NCell2);
//            tabNacio.addCell(NCell3);
//            tabNacio.addCell(NCell4);
//            tabNacio.addCell(NCell5);
//            tabNacio.addCell(NCell6);
//            tabNacio.setSpacingAfter(5f);
//            doc.add(tabNacio);
//            
//            PdfPTable tabCargo = new PdfPTable(2);
//            tabCargo.setWidths(new float[]{10f, 35f});
//            PdfPCell crCell1 = new PdfPCell(new Paragraph("Cargo Publico:", contac));
//            PdfPCell crCell2 = new PdfPCell(new Paragraph(""));
//            crCell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            crCell1.setBorderWidth(0f);
//            crCell2.setBorderWidth(0f);
//            tabCargo.addCell(crCell1);
//            tabCargo.addCell(crCell2);
//            tabCargo.setSpacingAfter(5f);
//            doc.add(tabCargo);
//            
//            PdfPTable tabRango = new PdfPTable(4);
//            tabRango.setWidths(new float[]{10f,17f,8f,10f});
//            PdfPCell RCel1 = new PdfPCell(new Paragraph("De:", contac));
//            PdfPCell RCel2 = new PdfPCell(new Paragraph(""));
//            PdfPCell RCel3 = new PdfPCell(new Paragraph("Hasta:",contac));
//            PdfPCell RCel4 = new PdfPCell(new Paragraph(""));
//            RCel1.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            RCel3.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            RCel1.setBorderWidth(0f);
//            RCel2.setBorderWidth(0f);
//            RCel3.setBorderWidth(0f);
//            RCel4.setBorderWidth(0f);
//            tabRango.addCell(RCel1);
//            tabRango.addCell(RCel2);
//            tabRango.addCell(RCel3);
//            tabRango.addCell(RCel4);
//            tabRango.setSpacingAfter(12f);
//            doc.add(tabRango);
//            
    
//      }
         
         //AQUI TERMINA PRIMERA TABLA
         PdfPTable Informe=new PdfPTable(7);
         Informe.setWidthPercentage(90);
       
         float[] Columnainformes = new float[]{15f,20f,10f,15f,10f,10f,15f};
         Informe.setWidths(Columnainformes);
         Informe.setHorizontalAlignment(Element.ALIGN_CENTER);
         PdfPCell c1= new PdfPCell(new Paragraph("INGRESO",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLACK)));
         PdfPCell c2= new PdfPCell(new Paragraph("CLIENTE",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLACK)));
         PdfPCell c3= new PdfPCell(new Paragraph("DUI/NIT",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLACK)));
         PdfPCell c4= new PdfPCell(new Paragraph("FORMA DE PAGO",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLACK)));
         PdfPCell c5= new PdfPCell(new Paragraph("CANTIDAD",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLACK)));
         PdfPCell c6= new PdfPCell(new Paragraph("FECHA",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLACK)));
         PdfPCell c7= new PdfPCell(new Paragraph("DESCRIPCION",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLACK)));
         PdfPCell linea = new PdfPCell(new Paragraph("\n"));
         linea.setColspan(3);
         linea.setBorder(0);
         c1.setBackgroundColor(new BaseColor(162,216,190)); 
         c2.setBackgroundColor(new BaseColor(162,216,190)); 
         c3.setBackgroundColor(new BaseColor(162,216,190)); 
         c4.setBackgroundColor(new BaseColor(162,216,190));
         c5.setBackgroundColor(new BaseColor(162, 216, 190));
         c6.setBackgroundColor(new BaseColor(162,216,190));
         c7.setBackgroundColor(new BaseColor(162, 216, 190));
         c1.setHorizontalAlignment(Element.ALIGN_CENTER);
         c4.setHorizontalAlignment(Element.ALIGN_CENTER);
         c5.setHorizontalAlignment(Element.ALIGN_CENTER);
         c6.setHorizontalAlignment(Element.ALIGN_CENTER);
         c7.setHorizontalAlignment(Element.ALIGN_CENTER);
         Informe.addCell(c1);Informe.addCell(c2);Informe.addCell(c3); Informe.addCell(c4); Informe.addCell(c5); Informe.addCell(c6); Informe.addCell(c7);
         Informe.addCell(linea).setHorizontalAlignment(Element.ALIGN_LEFT);
         Informe.setHorizontalAlignment(Element.ALIGN_CENTER);
         docu.add(Informe);
//         
//      //AQUI TERMINA segunda TABLA
        PdfPTable DATOS = new PdfPTable(7);
        DATOS.setWidthPercentage(90);
        DATOS.setWidths(Columnainformes);
        DATOS.setHorizontalAlignment(Element.ALIGN_CENTER);
         
         for (int i=0; i < tablaAlumnos.getRowCount(); i++){
            String ingreso=tablaAlumnos.getValueAt(i, 1).toString();
            String cliente=tablaAlumnos.getValueAt(i, 2).toString();
            String dui=tablaAlumnos.getValueAt(i, 3).toString();
            String forma=tablaAlumnos.getValueAt(i, 4).toString();
            String cantidad=tablaAlumnos.getValueAt(i, 5).toString();
            String fech=tablaAlumnos.getValueAt(i, 6).toString();
            String descr=tablaAlumnos.getValueAt(i, 7).toString();
            
            
            PdfPCell ingresoPDF= new PdfPCell(new Paragraph(ingreso ,FontFactory.getFont("Arial",10,BaseColor.BLACK)));
            PdfPCell clientePDF= new PdfPCell(new Paragraph(cliente ,FontFactory.getFont("Arial",10,BaseColor.BLACK)));
            PdfPCell duiPDF= new PdfPCell(new Paragraph(dui ,FontFactory.getFont("Arial",10,BaseColor.BLACK)));
            PdfPCell formaPDF = new PdfPCell(new Paragraph(forma ,FontFactory.getFont("Arial",10,BaseColor.BLACK)));
            PdfPCell cantidadPDF = new PdfPCell(new Paragraph("$"+cantidad ,FontFactory.getFont("Arial",10,BaseColor.BLACK)));
            PdfPCell fechPDF= new PdfPCell(new Paragraph(fech ,FontFactory.getFont("Arial",10,BaseColor.BLACK)));
            PdfPCell descrPDF = new PdfPCell(new Paragraph(descr ,FontFactory.getFont("Arial",10,BaseColor.BLACK)));
            cantidadPDF.setHorizontalAlignment(Element.ALIGN_RIGHT);
            fechPDF.setHorizontalAlignment(Element.ALIGN_CENTER);
            descrPDF.setHorizontalAlignment(Element.ALIGN_CENTER);
            DATOS.addCell(ingresoPDF);
            DATOS.addCell(clientePDF);
            DATOS.addCell(duiPDF);
            DATOS.addCell(formaPDF);
            DATOS.addCell(cantidadPDF);
            DATOS.addCell(fechPDF);
            DATOS.addCell(descrPDF);
            }
         docu.add(DATOS);
      
         docu.close();
         archivo.close();
          JOptionPane.showMessageDialog(this, "PDF GENERADO CON EXITO");
    } catch (Exception e) {
         JOptionPane.showMessageDialog(this, e);
    }
}




private void verificarCB()
{
    if (this.cbBuscador.getSelectedItem().equals("TODOS")){
            lblRango.setVisible(false);
            mes1.setVisible(false);
            yea1.setVisible(false);
            txtDui.setText(null);
            txtcliente.setText(null);
            
            txtDui.setEnabled(true);
            txtcliente.setEnabled(true);
            
            cbTipoCuenta.setEnabled(true);
            cbFormapago.setEnabled(true);
            
            mes.setEnabled(true);
            yea.setEnabled(true);
        }else if (this.cbBuscador.getSelectedItem().equals("DUI")){
            lblRango.setVisible(false);
            mes1.setVisible(false);
            yea1.setVisible(false);
            
            txtDui.setText(null);
            txtcliente.setText(null);
            
            txtDui.setEnabled(true);
            txtcliente.setEnabled(false);
            
            cbTipoCuenta.setEnabled(false);
            cbFormapago.setEnabled(false);
            
            mes.setEnabled(false);
            yea.setEnabled(false);
         }else if (this.cbBuscador.getSelectedItem().equals("NOMBRE")){
            lblRango.setVisible(false);
            mes1.setVisible(false);
            yea1.setVisible(false);
             
            txtDui.setText(null);
            txtcliente.setText(null);
            
            txtDui.setEnabled(false);
            txtcliente.setEnabled(true);
            
            cbTipoCuenta.setEnabled(false);
            cbFormapago.setEnabled(false);
            
            mes.setEnabled(false);
            yea.setEnabled(false);
        }else if (this.cbBuscador.getSelectedItem().equals("TIPO")){
            lblRango.setVisible(false);
            mes1.setVisible(false);
            yea1.setVisible(false);
            
            txtDui.setText(null);
            txtcliente.setText(null);
            
            txtDui.setEnabled(false);
            txtcliente.setEnabled(false);
            
            cbTipoCuenta.setEnabled(true);
            cbFormapago.setEnabled(false);
            
            mes.setEnabled(false);
            yea.setEnabled(false);
        }else if (this.cbBuscador.getSelectedItem().equals("FORMA DE PAGO")){
            lblRango.setVisible(false);
            mes1.setVisible(false);
            yea1.setVisible(false);
            
            txtDui.setText(null);
            txtcliente.setText(null);
            
            txtDui.setEnabled(false);
            txtcliente.setEnabled(false);
            
            cbTipoCuenta.setEnabled(false);
            cbFormapago.setEnabled(true);
            
            mes.setEnabled(false);
            yea.setEnabled(false);
        }else if(this.cbBuscador.getSelectedItem().equals("FECHA")){
            
            lblRango.setVisible(false);
            mes1.setVisible(false);
            yea1.setVisible(false);

            txtDui.setText(null);
            txtcliente.setText(null);
            
            txtDui.setEnabled(false);
            txtcliente.setEnabled(false);
            
            cbTipoCuenta.setEnabled(false);
            cbFormapago.setEnabled(false);
            
            mes.setEnabled(true);
            yea.setEnabled(true);
        }else if(this.cbBuscador.getSelectedItem().equals("RANGO FECHA")){
            
            lblRango.setVisible(true);
            mes1.setVisible(true);
            yea1.setVisible(true);
             
            txtDui.setText(null);
            txtcliente.setText(null);
            
            txtDui.setEnabled(false);
            txtcliente.setEnabled(false);
            
            cbTipoCuenta.setEnabled(false);
            cbFormapago.setEnabled(false);
            
            mes.setEnabled(true);
            yea.setEnabled(true);
        }
}
        
   
}
