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
 Statement st;
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 820, 260));

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
         String mesb2 = mes.getSelectedItem().toString();
         String yb2 = yea.getSelectedItem().toString();
         pdf(mesb2,yb2);
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
    private javax.swing.JComboBox<String> cbBuscador;
    private javax.swing.JComboBox<String> cbFormapago;
    private javax.swing.JComboBox<String> cbTipoCuenta;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    
private void pdf(String mes, String year){
    try {
        FileOutputStream archivo;
        File file=new File(System.getProperty("user.home")+"/desktop/informe/informe_ingresos-"+mes+"-"+year+".pdf");
        archivo=new FileOutputStream(file);
        Image imagen = Image.getInstance("src/IMAGENES/IMAGENES/logo2.png");
        imagen.scalePercent(30f);
      
        Document doc=new Document(PageSize.A4.rotate(), 10f, 10f, 20f, 0f);
        PdfWriter.getInstance(doc,archivo); 
        doc.open();
        Paragraph fecha= new Paragraph();
        Font negrita = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK);
        fecha.add(Chunk.NEWLINE);
        Date date=new Date();
        fecha.add("FECHA: "+new SimpleDateFormat("dd-MM-yyyy").format(date));
         
        PdfPTable Encabezado=new PdfPTable(4);
         Encabezado.setWidthPercentage(100);
         Encabezado.getDefaultCell().setBorder(0);
         float[] ColumnaEncabezado = new float[]{20f,30f,70f,20F};
         Encabezado.setWidths(ColumnaEncabezado);
         Encabezado.setHorizontalAlignment(Element.ALIGN_CENTER);
        
         PdfPCell celdaEncabezado = new PdfPCell(new Paragraph("REPORTE INGRESOS",FontFactory.getFont("Arial",14,Font.BOLD,BaseColor.BLACK)));
         celdaEncabezado.setColspan(3);
         celdaEncabezado.setBorder(0);
       Encabezado.addCell(celdaEncabezado).setHorizontalAlignment(Element.ALIGN_CENTER);
       PdfPCell celdaimg = new PdfPCell(imagen);
       imagen.setAbsolutePosition(0f, 0f);
         celdaimg.setRowspan(3);
           celdaimg.setBorder(0);
        Encabezado.addCell(celdaimg).setHorizontalAlignment(Element.ALIGN_CENTER);
        
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("ASOCIACION SANTA CATALINA DE SIENA",FontFactory.getFont("Arial",14,Font.BOLD,BaseColor.BLACK)));
         celdaEncabezado2.setColspan(3);
           celdaEncabezado2.setBorder(0);
       Encabezado.addCell(celdaEncabezado2).setHorizontalAlignment(Element.ALIGN_CENTER);
             PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph(mes+"  DEL  "+year,FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK)));
         celdaEncabezado3.setColspan(3);
           celdaEncabezado3.setBorder(0);
       Encabezado.addCell(celdaEncabezado3).setHorizontalAlignment(Element.ALIGN_CENTER);
       PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("\n"));
         celdaEncabezado4.setColspan(4);
           celdaEncabezado4.setBorder(0);
       Encabezado.addCell(celdaEncabezado4).setHorizontalAlignment(Element.ALIGN_LEFT);
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("\n"));
         celdaEncabezado5.setColspan(4);
           celdaEncabezado5.setBorder(0);
       Encabezado.addCell(celdaEncabezado5).setHorizontalAlignment(Element.ALIGN_LEFT);
       doc.add(Encabezado);
         
         //AQUI TERMINA PRIMERA TABLA
          PdfPTable Informe=new PdfPTable(7);
         Informe.setWidthPercentage(90);
         Informe.getDefaultCell().setBorder(7);
       
         float[] Columnainforme = new float[]{15f,30f,10f,20f,10f,15f,20f};
         Informe.setWidths(Columnainforme);
         Informe.setHorizontalAlignment(Element.ALIGN_CENTER);
         PdfPCell c1= new PdfPCell(new Paragraph("INGRESO",FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.WHITE)));
         PdfPCell c2= new PdfPCell(new Paragraph("CLIENTE",FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.WHITE)));
         PdfPCell c3= new PdfPCell(new Paragraph("DUI",FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.WHITE)));
         PdfPCell c4= new PdfPCell(new Paragraph("FORMA_PAGO",FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.WHITE)));
         PdfPCell c5= new PdfPCell(new Paragraph("CANTIDAD",FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.WHITE)));
         PdfPCell c6= new PdfPCell(new Paragraph("FECHA",FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.WHITE)));
         PdfPCell c7= new PdfPCell(new Paragraph("DESCRIPCION",FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.WHITE)));
         PdfPCell linea = new PdfPCell(new Paragraph("\n"));
         linea.setColspan(3);
         linea.setBorder(0);
         c1.setBackgroundColor(new BaseColor(0,105,153)); 
         c2.setBackgroundColor(new BaseColor(0,105,153));
         c3.setBackgroundColor(new BaseColor(0,105,153));
         c4.setBackgroundColor(new BaseColor(0,105,153));
         c5.setBackgroundColor(new BaseColor(0,105,153));
         c6.setBackgroundColor(new BaseColor(0,105,153));
         c7.setBackgroundColor(new BaseColor(0,105,153));
         c1.setBorder(7);c2.setBorder(7);c3.setBorder(7); c4.setBorder(7); c5.setBorder(7);c6.setBorder(7);c7.setBorder(7);
         Informe.addCell(c1); Informe.addCell(c2); Informe.addCell(c3); Informe.addCell(c4); Informe.addCell(c5); Informe.addCell(c6); Informe.addCell(c7);
         Informe.addCell(linea).setHorizontalAlignment(Element.ALIGN_LEFT);
         Informe.setHorizontalAlignment(Element.ALIGN_CENTER);
         doc.add(Informe);
         
      //AQUI TERMINA segunda TABLA
        PdfPTable DATOS=new PdfPTable(7);
         DATOS.setWidthPercentage(90);
         DATOS.getDefaultCell().setBorder(2);
         DATOS.setWidths(Columnainforme);
         DATOS.setHorizontalAlignment(Element.ALIGN_CENTER);
         
         for (int i=0; i < tablaAlumnos.getRowCount(); i++){
            String ingreso=tablaAlumnos.getValueAt(i, 1).toString();
            String cliente=tablaAlumnos.getValueAt(i, 2).toString();
            String dui=tablaAlumnos.getValueAt(i, 3).toString();
            String forma=tablaAlumnos.getValueAt(i, 4).toString();
            String cantidad=tablaAlumnos.getValueAt(i, 5).toString();
            String fech=tablaAlumnos.getValueAt(i, 6).toString();
            String descr=tablaAlumnos.getValueAt(i, 7).toString();
            
            
            PdfPCell ingresoPDF= new PdfPCell(new Paragraph(ingreso ,FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.BLACK)));
            PdfPCell clientePDF= new PdfPCell(new Paragraph(cliente ,FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.BLACK)));
            PdfPCell duiPDF = new PdfPCell(new Paragraph(dui ,FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.BLACK)));
            PdfPCell formaPDF = new PdfPCell(new Paragraph(forma ,FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.BLACK)));
            PdfPCell cantidadPDF = new PdfPCell(new Paragraph(cantidad ,FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.BLACK)));
            PdfPCell fechPDF= new PdfPCell(new Paragraph(fech ,FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.BLACK)));
            PdfPCell descrPDF = new PdfPCell(new Paragraph(descr ,FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.BLACK)));
            
            ingresoPDF.setBackgroundColor(new BaseColor(162, 216, 190)); 
            clientePDF.setBackgroundColor(new BaseColor(255, 255, 255));
            duiPDF.setBackgroundColor(new BaseColor(162, 216, 190));
            formaPDF.setBackgroundColor(new BaseColor(255, 255, 255));
            cantidadPDF.setBackgroundColor(new BaseColor(162, 216, 190));
            fechPDF.setBackgroundColor(new BaseColor(255, 255, 255));
            descrPDF.setBackgroundColor(new BaseColor(162, 216, 190));
            
            DATOS.addCell(ingresoPDF);
            DATOS.addCell(clientePDF);
            DATOS.addCell(duiPDF);
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