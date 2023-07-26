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
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import conexion.conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fujitsu
 */
public class INGRESOS extends javax.swing.JFrame {
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
    private Double antes;
    private String can;
    
    private boolean search;
    
    /**
     * Creates new form ADMINISTRACION
     */
    public INGRESOS() {
       // this.setContentPane(fondo1);
        initComponents();
        cn.getConnection();
        mostrardatos();
        mostraralumnos();
        this.txtDui.requestFocus();
        this.setLocationRelativeTo(null);
         TextPrompt nie = new TextPrompt("123456789", txtDui);
         TextPrompt bus = new TextPrompt("Ingrese el valor a buscar", txtbus);
         TextPrompt nombre = new TextPrompt("Ingrese nombre completo", txtcliente);
         TextPrompt responsable = new TextPrompt("Ingrese descripción", txtDescripcion);
         TextPrompt dui = new TextPrompt("$0.00", txtCantidad);
         this.btnEliminar.setEnabled(false);
         this.btnActualizar.setEnabled(false);
         this.btnFinB.setEnabled(false);
         this.cbBuscador.setVisible(false);
         this.ms1.setVisible(false);
         this.ms2.setVisible(false);  
         this.mes.setVisible(false);
         this.yea.setVisible(false);
         this.cbBusca.setVisible(true);
         this.error1.setVisible(false);
         this.error2.setVisible(false);
         this.error3.setVisible(false);
         this.search = false;
    }
    
    public void ingresar(){
        java.sql.Connection con1 = null;
        java.sql.Connection con2 = null;
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        ResultSet rs = null;
        ResultSet ress=null;
        String Dui = txtDui.getText();
        int duiN=Integer.valueOf(Dui);
        String cliente = txtcliente.getText().trim().toUpperCase();
        String descripcion = txtDescripcion.getText().trim().toUpperCase();
        String cantidad=txtCantidad.getText();
        Double money=Double.valueOf(cantidad);
        String cuenta=cbTipoCuenta.getSelectedItem().toString();
        String Formapago=cbFormapago.getSelectedItem().toString();
        Date myDate = new Date();
        String fecha = new SimpleDateFormat("yyyy/MM/dd").format(myDate);
        String mesguardar = new SimpleDateFormat("MM").format(myDate);
        String ay = new SimpleDateFormat("yyyy").format(myDate);
         
        if (Dui.equals("") || cliente.equals("") || descripcion.equals("") || cantidad.equals("")  ) {
            JOptionPane.showMessageDialog(this, "Uno o mas campos estan vacios. Favor de llenarlos.");
        } else {
            
               try {
                con1 = cn.getConnection();
                pst = con1.prepareStatement(" INSERT INTO ingresos (NOMBRE_CUENTA,CLIENTE,DUI_NIT,TIPO_CUENTA,CANTIDAD,FECHA,DESCRIPCION)" + " values (?, ?, ?,?,?,?,?)");
                 pst.setString(1, cuenta); 
                  pst.setString(2, cliente);
                pst.setInt(3, duiN);
                pst.setString(4,Formapago);
                pst.setDouble(5,money);
                pst.setString(6,fecha);
                 pst.setString(7, descripcion);
                 
                 
                                  
               pst.execute();
             JOptionPane.showMessageDialog(this, "Registro Agregado con Exito");
               con2 = cn.getConnection();
                   if (Formapago.equals("EFECTIVO")){
                       pst2=con2.prepareStatement("Select sum(CANTIDAD) as cant from ingresos  where DUI_NIT="+(duiN)+"&& TIPO_CUENTA='"+(Formapago)+"' && MONTH(FECHA)="+(mesguardar));
           ress = pst2.executeQuery();
                 if (ress.next()){
               String can=ress.getString("cant");
           antes=Double.valueOf(can);
           Double total=antes;
           int rows=ress.getRow();  
              if (total>10000) {
                    JOptionPane.showMessageDialog(this, " ALERTA!!!!\nEl usuario: "+cliente+"\n"+
                                                         "DUI/NIT: "+duiN+"\n"+  
                                                                
                                                          "TIPO DE CUENTA: "+Formapago+"\n"+
                                                           "CANTIDAD: $"+money+"\n"+                             
                                                            "AH SOBREPASADO EL MAXIMO DE $10000\n SE DEBE NOTIFICAR"
                                                                   + "\n TOTAL $"+total);
                    try {
                          GenerarPdf(Dui, Formapago, mesguardar, ay,cliente,total);
                          JOptionPane.showMessageDialog(this, "SE HA CREADO UN PDF DISPONE DE 5 DIAS PARA REPORTARLO");
                     } catch (Exception e) {
                         JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
                     }
               }
              this.txtCantidad.setText(null);
             this.txtcliente.setText(null); 
              this.txtDescripcion.setText(null);
               this.txtDui.setText(null);
               this.cbTipoCuenta.setSelectedIndex(0);
               this.cbFormapago.setSelectedIndex(0);
             this.txtDui.requestFocus();
              mostrardatos();
               }else{
           JOptionPane.showMessageDialog(this, " DATO NO ENCONTRADO");
           }
                   }else{
                   pst2=con2.prepareStatement("Select sum(CANTIDAD) as cant from ingresos  where DUI_NIT="+(duiN)+"&& TIPO_CUENTA='CHEQUE' "
                           + "|| TIPO_CUENTA='BITCOINS'"
                           + "|| TIPO_CUENTA='TARJETA'"
                           + "|| TIPO_CUENTA='TRANSFERENCIA'"
                           + "|| TIPO_CUENTA='REMESA'"
                           + "|| TIPO_CUENTA='BANCO'"
                           + "&& MONTH(FECHA)="+(mesguardar));
           ress = pst2.executeQuery();
                 if (ress.next()){
               String can=ress.getString("cant");
           antes=Double.valueOf(can);
           Double total=antes;
            
              if (total>25000) {
                    JOptionPane.showMessageDialog(this, " ALERTA!!!!\nEl usuario: "+cliente+"\n"+
                                                         "DUI/NIT: "+duiN+"\n"+  
                                                                
                                                          "TIPO DE CUENTA: "+Formapago+"\n"+
                                                           "CANTIDAD: $"+money+"\n"+                             
                                                            "AH SOBREPASADO EL MAXIMO DE $25000\n SE DEBE NOTIFICAR"
                                                                   + "\n TOTAL $"+total);
                     try {
                          GenerarPdf(Dui, Formapago, mesguardar, ay,cliente,total);
                          JOptionPane.showMessageDialog(this, "SE HA CREADO UN PDF DISPONE DE 5 DIAS PARA REPORTARLO");
                     } catch (Exception e) {
                         JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
                     }
               }
             
                    
              this.txtCantidad.setText(null);
             this.txtcliente.setText(null); 
              this.txtDescripcion.setText(null);
               this.txtDui.setText(null);
               this.cbTipoCuenta.setSelectedIndex(0);
               this.cbFormapago.setSelectedIndex(0);
             this.txtDui.requestFocus();
              mostrardatos();
               }else{
           JOptionPane.showMessageDialog(this, " DATO NO ENCONTRADO");
           }
                   
                   }
            
              
            } catch (SQLException e) {
                System.err.print(e.toString());
                JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador.");
            }
            
       
            
        }
    }
    
    public void Eliminar(){
    java.sql.Connection con1 = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
                    try {
                con1 = cn.getConnection();
                pst = con1.prepareStatement(" Delete FROM ingresos where ID_INGRESOS="
                    +Integer.toString(this.ID));
                      
               pst.execute();
             JOptionPane.showMessageDialog(this, "Registro Eliminado con Exito");
              this.txtCantidad.setText(null);
             this.txtcliente.setText(null); 
              this.txtDescripcion.setText(null);
               this.txtDui.setText(null);
               this.cbTipoCuenta.setSelectedIndex(0);
               this.cbFormapago.setSelectedIndex(0);
             this.txtDui.requestFocus();
              mostrardatos();
              
            } catch (SQLException e) {
                System.err.print(e.toString());
                JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador.");
            }
        }
      public void actualizar(){
      java.sql.Connection con1 = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String Dui = txtDui.getText();
        int duiN=Integer.valueOf(Dui);
        String cliente = txtcliente.getText().trim().toUpperCase();
         String descripcion = txtDescripcion.getText().trim().toUpperCase();
         String cantidad=txtCantidad.getText();
         Double money=Double.valueOf(cantidad);
         String cuenta=cbTipoCuenta.getSelectedItem().toString();
         String Formapago=cbFormapago.getSelectedItem().toString();
           Date myDate = new Date();
             String fecha = new SimpleDateFormat("yyyy/MM/dd").format(myDate);
         
         
        if (Dui.equals("") || cliente.equals("") || descripcion.equals("") || cantidad.equals("")  ) {
            JOptionPane.showMessageDialog(this, "Uno o mas campos estan vacios. Favor de llenarlos.");
        } else {
            try {
                con1 = cn.getConnection();
                pst = con1.prepareStatement(" UPDATE ingresos SET NOMBRE_CUENTA=?, CLIENTE=?, DUI_NIT=?, TIPO_CUENTA=?, CANTIDAD=?,FECHA=?,DESCRIPCION=? WHERE ID_INGRESOS="+Integer.toString(this.ID));
                 pst.setString(1, cuenta); 
                  pst.setString(2, cliente);
                pst.setInt(3, duiN);
                pst.setString(4,Formapago);
                pst.setDouble(5,money);
                pst.setString(6,fecha);
                 pst.setString(7, descripcion);
                 
                 
                                  
               pst.execute();
             JOptionPane.showMessageDialog(this, "Registro Actualizado con Exito");
              this.txtCantidad.setText(null);
             this.txtcliente.setText(null); 
              this.txtDescripcion.setText(null);
               this.txtDui.setText(null);
               this.cbTipoCuenta.setSelectedIndex(0);
               this.cbFormapago.setSelectedIndex(0);
             this.txtDui.requestFocus();
              mostrardatos();
              
            } catch (SQLException e) {
                System.err.print(e.toString());
                JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador.");
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbTipoCuenta = new javax.swing.JComboBox<>();
        cbFormapago = new javax.swing.JComboBox<>();
        txtDescripcion = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnFinB = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBMode = new javax.swing.JButton();
        ms2 = new javax.swing.JLabel();
        ms1 = new javax.swing.JLabel();
        cbBuscador = new javax.swing.JComboBox<>();
        yea = new javax.swing.JComboBox<>();
        mes = new javax.swing.JComboBox<>();
        error1 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtcliente = new javax.swing.JTextField();
        txtDui = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaBuscador = new javax.swing.JTable();
        txtbus = new javax.swing.JTextField();
        cbBusca = new javax.swing.JComboBox<>();
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
        jLabel8.setText("INGRESOS");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 380, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 70));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 105, 150));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("DUI");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 50, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 105, 150));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("CLIENTE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 60, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 105, 150));
        jLabel4.setText("TIPO ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 60, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 105, 150));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("DESCRIPCIÓN");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 105, 150));
        jLabel6.setText("FORMA DE PAGO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 120, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 105, 150));
        jLabel7.setText("CANTIDAD");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 80, 30));

        cbTipoCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DONACIONES", "COLEGIATURA", "OTROS" }));
        jPanel1.add(cbTipoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 150, 30));

        cbFormapago.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbFormapago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "CHEQUE", "BITCOINS", "TARJETA", "TRANSFERENCIA", "REMESA", "BANCO", "OTRO" }));
        jPanel1.add(cbFormapago, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 130, 30));

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 400, 30));

        btnIngresar.setBackground(new java.awt.Color(0, 105, 150));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("INGRESAR");
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresarMouseExited(evt);
            }
        });
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 130, 40));

        btnEliminar.setBackground(new java.awt.Color(0, 105, 150));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 130, 40));

        btnFinB.setBackground(new java.awt.Color(0, 105, 150));
        btnFinB.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        btnFinB.setForeground(new java.awt.Color(255, 255, 255));
        btnFinB.setText("TERMINAR  BUSQUEDA");
        btnFinB.setToolTipText("");
        btnFinB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFinB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFinBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFinBMouseExited(evt);
            }
        });
        btnFinB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinBActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinB, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 150, 20));

        btnActualizar.setBackground(new java.awt.Color(0, 105, 150));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActualizarMouseExited(evt);
            }
        });
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 130, 40));

        btnBMode.setBackground(new java.awt.Color(0, 105, 150));
        btnBMode.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnBMode.setForeground(new java.awt.Color(255, 255, 255));
        btnBMode.setText("MODO BUSQUEDA");
        btnBMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBModeActionPerformed(evt);
            }
        });
        jPanel1.add(btnBMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 120, 40));

        ms2.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        ms2.setForeground(new java.awt.Color(255, 51, 51));
        ms2.setText("Este campo debe revisarse ");
        jPanel1.add(ms2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));

        ms1.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        ms1.setForeground(new java.awt.Color(255, 51, 51));
        ms1.setText("Este campo debe revisarse ");
        jPanel1.add(ms1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        cbBuscador.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        cbBuscador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODO", "DUI", "NOMBRE", "TIPO", "FORMA DE PAGO", "FECHA" }));
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
        jPanel1.add(cbBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 130, -1));

        yea.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        yea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035" }));
        jPanel1.add(yea, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 130, -1));

        mes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DECIEMBRE" }));
        jPanel1.add(mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 130, -1));

        error1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 51, 51));
        error1.setText("ERROR");
        jPanel1.add(error1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, -1, 30));

        error3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        error3.setForeground(new java.awt.Color(255, 51, 51));
        error3.setText("ERROR");
        jPanel1.add(error3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, 30));

        error2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        error2.setForeground(new java.awt.Color(255, 51, 51));
        error2.setText("ERROR");
        jPanel1.add(error2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, 20));

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCantidadMouseClicked(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 130, 30));

        txtcliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtclienteMouseClicked(evt);
            }
        });
        txtcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtclienteKeyReleased(evt);
            }
        });
        jPanel1.add(txtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 400, 30));

        txtDui.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDuiMouseClicked(evt);
            }
        });
        txtDui.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDuiKeyReleased(evt);
            }
        });
        jPanel1.add(txtDui, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 160, 30));

        btnCancelar.setBackground(new java.awt.Color(0, 105, 150));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 820, 310));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 820, 190));

        jPanel3.setBackground(new java.awt.Color(0, 105, 150));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BUSCADOR ALUMNOS");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 290, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 320, 70));

        TablaBuscador.setAutoCreateRowSorter(true);
        TablaBuscador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaBuscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaBuscadorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaBuscador);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, 320, 340));

        txtbus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusKeyReleased(evt);
            }
        });
        getContentPane().add(txtbus, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 140, 320, 30));

        cbBusca.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        cbBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DUI", "NOMBRE" }));
        cbBusca.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                cbBuscaComponentAdded(evt);
            }
        });
        cbBusca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBuscaItemStateChanged(evt);
            }
        });
        cbBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbBuscaMouseClicked(evt);
            }
        });
        getContentPane().add(cbBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 130, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/fondomenu.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 20, 1350, 650));

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
        MenuEgresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuEgresosMouseClicked(evt);
            }
        });
        MenuEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEgresosActionPerformed(evt);
            }
        });

        jMenuItem2.setText("REGISTRO DE EGRESOS");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuEgresos.add(jMenuItem2);

        jMenuItem1.setText("CUENTA EGRESOS");
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

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        // TODO add your handling code here:
         btnIngresar.setBackground(new Color(154,7,13));
                 btnIngresar.setForeground(Color.white);
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (txtDui.getText().equals("") || txtcliente.getText().equals("") || txtDescripcion.getText().equals("") || txtCantidad.getText().equals("")  ) {
            JOptionPane.showMessageDialog(this, "Uno o mas campos estan vacios. Favor de llenarlos.");
            txtDui.requestFocus();
        }else{  
       ingresar();
         this.btnFinB.setEnabled(false);
            this.cbBuscador.setVisible(false);
        habilitar();
        }
        
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
        // TODO add your handling code here:
          btnIngresar.setBackground(new Color(0,105,153));
        btnIngresar.setForeground(Color.white);
    }//GEN-LAST:event_btnIngresarMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        // TODO add your handling code here:
         btnEliminar.setBackground(new Color(154,7,13));
                 btnEliminar.setForeground(Color.white);
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        // TODO add your handling code here:
            btnEliminar.setBackground(new Color(0,105,153));
        btnEliminar.setForeground(Color.white);
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseEntered
        // TODO add your handling code here:
          btnActualizar.setBackground(new Color(154,7,13));
                 btnActualizar.setForeground(Color.white);
          
    }//GEN-LAST:event_btnActualizarMouseEntered

    private void btnActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseExited
        // TODO add your handling code here:
          btnActualizar.setBackground(new Color(0,105,153));
        btnActualizar.setForeground(Color.white);
       
    }//GEN-LAST:event_btnActualizarMouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
         jButton1.setBackground(new Color(154,7,13));
                 jButton1.setForeground(Color.white);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
          jButton1.setBackground(new Color(0,105,153));
        jButton1.setForeground(Color.white);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ADMINISTRACION vermenu=new ADMINISTRACION();
        vermenu.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseClicked
        // TODO add your handling code here:
          if(MouseEvent.BUTTON1 == evt.getButton()){
        
            
        }
    }//GEN-LAST:event_btnIngresarMouseClicked

    private void tablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnosMouseClicked
         this.ms1.setVisible(true);
         this.ms2.setVisible(true);  
         this.btnEliminar.setEnabled(true);
         this.btnActualizar.setEnabled(true);
         this.btnIngresar.setEnabled(false);
         this.btnFinB.setEnabled(false);
         int iRow= this.tablaAlumnos.getSelectedRow();
        
        this.currReg= Integer.parseInt(this.tablaAlumnos.getValueAt(iRow, 0).toString());
        this.ID=Integer.valueOf(this.tablaAlumnos.getValueAt(iRow,0).toString());
        this.txtDui.setText(this.tablaAlumnos.getValueAt(iRow, 3).toString());
        this.txtcliente.setText(this.tablaAlumnos.getValueAt(iRow, 2).toString());
        this.txtDescripcion.setText(this.tablaAlumnos.getValueAt(iRow, 7).toString());
        this.txtCantidad.setText(this.tablaAlumnos.getValueAt(iRow, 5).toString());
        this.cbTipoCuenta.setSelectedItem(this.tablaAlumnos.getValueAt(iRow, 1).toString());
        this.cbFormapago.setSelectedItem(this.tablaAlumnos.getValueAt(iRow, 4).toString());
        
    }//GEN-LAST:event_tablaAlumnosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.btnFinB.setEnabled(false);
        this.cbBuscador.setVisible(false);
        habilitar();
        Eliminar();
          this.ms1.setVisible(false);
         this.ms2.setVisible(false);  
        
         this.btnEliminar.setEnabled(false);
           this.btnActualizar.setEnabled(false);
           this.btnIngresar.setEnabled(true);
           this.btnFinB.setEnabled(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
          this.btnFinB.setEnabled(false);
          this.cbBusca.setVisible(false);
        habilitar();
        actualizar();
          this.ms1.setVisible(false);
         this.ms2.setVisible(false);  
          this.btnEliminar.setEnabled(false);
           this.btnActualizar.setEnabled(false);
           this.btnIngresar.setEnabled(true);
           this.btnFinB.setEnabled(false);
           
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void cbBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbBuscaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbBuscaMouseClicked

    private void cbBuscaComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_cbBuscaComponentAdded
        // TODO add your handling code here:
      
    }//GEN-LAST:event_cbBuscaComponentAdded

    private void btnBModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBModeActionPerformed
        verificarCB();
        this.search = true;
        cbBuscador.setVisible(true);
        btnFinB.setEnabled(true);
        this.btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnBModeActionPerformed

    private void cbBuscaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBuscaItemStateChanged
        // TODO add your handling code here:
        String buscador=cbBusca.getSelectedItem().toString();
          if (buscador.equals("TODO")){
             mostraralumnos();
              }
    }//GEN-LAST:event_cbBuscaItemStateChanged

    private void cbBuscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbBuscadorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBuscadorMouseClicked

    private void TablaBuscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaBuscadorMouseClicked
        // TODO add your handling code here:
           this.ms1.setVisible(true);
         this.ms2.setVisible(true);  
         this.btnEliminar.setEnabled(false);
           this.btnActualizar.setEnabled(false);
           this.btnIngresar.setEnabled(true);
           this.btnFinB.setEnabled(false);
           try {
             int iRow= this.TablaBuscador.getSelectedRow();
        
        this.currReg2= Integer.parseInt(this.TablaBuscador.getValueAt(iRow, 0).toString());
       
        this.txtDui.setText(this.TablaBuscador.getValueAt(iRow, 2).toString());
        this.txtcliente.setText(this.TablaBuscador.getValueAt(iRow, 1).toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\n "+e);
        }
       
       
    }//GEN-LAST:event_TablaBuscadorMouseClicked

    private void MenuDonacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDonacionesActionPerformed
        // TODO add your handling code here:
        INGRESOS vermenudona= new INGRESOS();
        vermenudona.setVisible(true);
        dispose();
    }//GEN-LAST:event_MenuDonacionesActionPerformed

    private void menuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuariosActionPerformed
        // TODO add your handling code here:
         USUARIOS vermenudona= new USUARIOS();
        vermenudona.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuUsuariosActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void MenuEgresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuEgresosMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_MenuEgresosMouseClicked

    private void txtCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantidadMouseClicked
        // TODO add your handling code here:
        this.error1.setVisible(false);
        this.txtCantidad.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_txtCantidadMouseClicked

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        // TODO add your handling code here:
        try {
            String cantidad=txtCantidad.getText();
            Double money=Double.valueOf(cantidad);
            this.error1.setVisible(false);
            this.txtCantidad.setBackground(new Color(255,255,255));
        } catch (Exception e) {
            this.error1.setVisible(false);
            this.txtCantidad.setBackground(new Color(250,206,208));

        }
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtclienteMouseClicked
        // TODO add your handling code here:
        this.error3.setVisible(false);
        this.txtcliente.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_txtclienteMouseClicked

    private void txtclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclienteKeyReleased
        // TODO add your handling code here:
        try {
            String nom=txtcliente.getText();
            int nome=Integer.valueOf(nom);
            this.error3.setVisible(true);
            this.txtcliente.setBackground(new Color(250,206,208));

        } catch (Exception e) {
            this.error3.setVisible(false);
            this.txtcliente.setBackground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txtclienteKeyReleased

    private void txtDuiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDuiMouseClicked
        // TODO add your handling code here:
        this.error2.setVisible(false);
        this.txtDui.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_txtDuiMouseClicked

    private void txtDuiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuiKeyReleased
        // TODO add your handling code here:
        try {
            String Dui = txtDui.getText();
            this.error2.setVisible(false);
            int duiN = Integer.valueOf(Dui);
            this.error2.setVisible(false);
        } catch (Exception e) {
            this.error2.setVisible(true);
            String Dui = txtDui.getText();
            if(Dui.equals("")) this.error2.setVisible(false);
        }
        if(search){
            String buscador=cbBuscador.getSelectedItem().toString();
            bus=txtDui.getText().toUpperCase();
            BUSCADOR(bus,buscador,mesb,ye);
        }
        

//        }else if (buscador.equals("NOMBRE")){
//            bus=txtcliente.getText().toUpperCase();
//
//        }else if (buscador.equals("TIPO")){
//            bus=cbTipoCuenta.getSelectedItem().toString().toUpperCase();
//
//        }else if (buscador.equals("FORMA DE PAGO")){
//            bus=cbFormapago.getSelectedItem().toString().toUpperCase();
//
//        }else if(buscador.equals("FECHA")){
//
//            mesb=mes.getSelectedIndex()+1;
//            yb=yea.getSelectedItem().toString();
//            ye=Integer.valueOf(yb);
//
//        }
        
    }//GEN-LAST:event_txtDuiKeyReleased

    private void MenuInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuInformesActionPerformed
        // TODO add your handling code here:
        INFORMEINGRESOS vermenudona= new INFORMEINGRESOS();
        vermenudona.setVisible(true);
        dispose();
    }//GEN-LAST:event_MenuInformesActionPerformed

    private void MenuInformesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuInformesMouseClicked
        // TODO add your handling code here:
          INFORMEINGRESOS vermenudona= new INFORMEINGRESOS();
        vermenudona.setVisible(true);
        dispose();
    }//GEN-LAST:event_MenuInformesMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        habilitar();
        limpiar();
        this.ms1.setVisible(false);
        this.ms2.setVisible(false);  
        this.error1.setVisible(false);
        this.error2.setVisible(false);
        this.error3.setVisible(false);
        this.btnActualizar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtbusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusKeyReleased
        String buscador = this.cbBusca.getSelectedItem().toString();
        String dato = this.txtbus.getText().toUpperCase();
        BUSCADOR2(dato, buscador);
    }//GEN-LAST:event_txtbusKeyReleased

    private void btnFinBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinBActionPerformed
        this.search = false;
        txtDui.setText(null);
        txtcliente.setText(null);

        cbBuscador.setVisible(false);
        mes.setVisible(false);
        yea.setVisible(false);
        btnFinB.setEnabled(false);
        btnCancelar.setEnabled(true);

        habilitar();

    }//GEN-LAST:event_btnFinBActionPerformed

    private void btnFinBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinBMouseExited
        // TODO add your handling code here:
        btnFinB.setBackground(new Color(0,105,153));
        btnFinB.setForeground(Color.white);
    }//GEN-LAST:event_btnFinBMouseExited

    private void btnFinBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinBMouseEntered
        // TODO add your handling code here:
        btnFinB.setBackground(new Color(154,7,13));
        btnFinB.setForeground(Color.white);
    }//GEN-LAST:event_btnFinBMouseEntered

    private void cbBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBuscadorActionPerformed
        verificarCB();
    }//GEN-LAST:event_cbBuscadorActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
          CUENTAEGRESOS vermenudona= new CUENTAEGRESOS();
        vermenudona.setVisible(true);
        dispose();
                 
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void MenuEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEgresosActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_MenuEgresosActionPerformed

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
            java.util.logging.Logger.getLogger(INGRESOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INGRESOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INGRESOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INGRESOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new INGRESOS().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuDonaciones;
    private javax.swing.JMenu MenuEgresos;
    private javax.swing.JMenu MenuInformes;
    private javax.swing.JTable TablaBuscador;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBMode;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFinB;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox<String> cbBusca;
    private javax.swing.JComboBox<String> cbBuscador;
    private javax.swing.JComboBox<String> cbFormapago;
    private javax.swing.JComboBox<String> cbTipoCuenta;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenuItem menuUsuarios;
    private javax.swing.JComboBox<String> mes;
    private javax.swing.JLabel ms1;
    private javax.swing.JLabel ms2;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtbus;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JComboBox<String> yea;
    // End of variables declaration//GEN-END:variables

 private void Imagen(JLabel fondo, String ruta) {
         this.imagen=new ImageIcon(ruta);
        this.icono=new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        fondo.getWidth(),
                        fondo.getHeight(),
                        Image.SCALE_DEFAULT
                )
        );
        fondo.setIcon(this.icono);
        this.repaint();
    }
  private void Imagen2(JLabel fondo, String ruta) {
         this.imagen2=new ImageIcon(ruta);
        this.icono2=new ImageIcon(
                this.imagen2.getImage().getScaledInstance(
                        fondo.getWidth(),
                        fondo.getHeight(),
                        Image.SCALE_DEFAULT
                )
        );
        fondo.setIcon(this.icono2);
        this.repaint();
    }
  public void mostraralumnos(){
  DefaultTableModel cliente= new DefaultTableModel();
     
      cliente.addColumn("ID");
     cliente.addColumn("ALUMNO");
    
     cliente.addColumn("DUI");
    
     TablaBuscador.setModel(cliente);
    String []datos =new String[3];
     java.sql.Connection con2 = null;
      PreparedStatement pst = null;
   
        try {
            
             
           con2 = cn.getConnection();
            
                pst=con2.prepareStatement("Select * from alumnos ORDER BY ID_ALUMNO");
           rs = pst.executeQuery();
             
            
                     
            while (rs.next()) {
             
               datos[0]=rs.getString(1);
               datos[1]=rs.getString(3);
                datos[2]=rs.getString(6);
             
                cliente.addRow(datos);
            }
            this.TablaBuscador.setModel(cliente);
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
        }
  }
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
               datos[5]=rs.getString(6);
               datos[6]=rs.getString(7);
               datos[7]=rs.getString(8);
                tcliente.addRow(datos);
            }
            this.tablaAlumnos.setModel(tcliente);
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
        }
    }
     public void BUSCADOR(String dato,String buscador,int mes, int y){
        
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
   
        try {
            
             
           con2 = cn.getConnection();
            if (buscador.equals("DUI")){
                pst=con2.prepareStatement("Select * from ingresos  where DUI_NIT like'"+(dato)+"%'");
                rs = pst.executeQuery();
             
              }else if (buscador.equals("NOMBRE")){
                pst=con2.prepareStatement("Select * from ingresos   where CLIENTE='"+(dato)+"'");
                rs = pst.executeQuery();
             
              }else if (buscador.equals("TIPO")){
            pst=con2.prepareStatement("Select * from ingresos where NOMBRE_CUENTA='"+(dato)+"'");
           rs = pst.executeQuery();
             
              }else if (buscador.equals("FORMA DE PAGO")){
              pst=con2.prepareStatement("Select * from ingresos where TIPO_CUENTA='"+(dato)+"'");
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
               datos[5]=rs.getString(6);
               datos[6]=rs.getString(7);
               datos[7]=rs.getString(8);
                tcliente.addRow(datos);
            }
            this.tablaAlumnos.setModel(tcliente);
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
        }
    }
    public void limpiar(){
        txtDui.setText(null);
        txtcliente.setText(null);
        txtDescripcion.setText(null);
        txtCantidad.setText(null);
    }
    public void habilitar(){
        txtcliente.setEnabled(true);
        txtDui.setEnabled(true);
        txtDescripcion.setEnabled(true);
        cbFormapago.setEnabled(true);
        cbTipoCuenta.setEnabled(true);
        txtCantidad.setEnabled(true);
        btnIngresar.setEnabled(true);
    }
    public void BUSCADOR2(String dato,String buscador){
        
     DefaultTableModel cliente= new DefaultTableModel();
     
     cliente.addColumn("ID");
     cliente.addColumn("ALUMNO");
     cliente.addColumn("DUI");
    
     TablaBuscador.setModel(cliente);
     String []datos =new String[3];
     java.sql.Connection con2 = null;
     PreparedStatement pst = null;
   
        try {
            
             
           con2 = cn.getConnection();
            if (buscador.equals("DUI")){
                pst=con2.prepareStatement("Select * from alumnos  where DUI like'"+(dato)+"%'");
           rs = pst.executeQuery();
             
              }else if (buscador.equals("NOMBRE")){
        pst=con2.prepareStatement("Select * from alumnos   where NOMBRE_ALUMNO like'%"+(dato)+"%'");
           rs = pst.executeQuery();
             
              }
        
            while (rs.next()) {
             
               datos[0]=rs.getString(1);
               datos[1]=rs.getString(3);
                datos[2]=rs.getString(6);
             
                cliente.addRow(datos);
            }
            this.TablaBuscador.setModel(cliente);
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
        }
    }
    public void GenerarPdf(String dato,String buscador,String mes, String y,String cliente,Double money){
     try {
          FileOutputStream archivo;
        File file=new File(System.getProperty("user.home")+"/desktop/informe/informe_"+cliente+"_"+mes+"_"+y+".pdf");
        archivo=new FileOutputStream(file);
      com.itextpdf.text.Image imagen = com.itextpdf.text.Image.getInstance("src/IMAGENES/IMAGENES/logo2.png");
      imagen.scalePercent(30f);
            // Paso 3: crear una conexión a la base de datos MySQL
            String url = "jdbc:mysql://localhost:3306/dbcolegio";
            String user = "root";
            String password = "";
            java.sql.Connection con = DriverManager.getConnection(url, user, password);

            // Paso 4: crear una consulta SQL
            String sql = "Select * from ingresos  where DUI_NIT="+(dato)+"&& MONTH(FECHA)="+(mes)+"&& YEAR(FECHA)="+(y)+"&& TIPO_CUENTA='"+(buscador)+"'";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Paso 5: crear un objeto de documento de iText
            Document doc=new Document(PageSize.A4, 10f, 10f, 20f, 0f);

           
            // Paso 7: agregar la tabla al objeto de página y cerrar el documento
           PdfWriter.getInstance(doc,archivo); 
         doc.open();
            
             Paragraph fecha= new Paragraph();
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
             PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph(mes+"  DEL  "+y,FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK)));
         celdaEncabezado3.setColspan(3);
           celdaEncabezado3.setBorder(0);
       Encabezado.addCell(celdaEncabezado3).setHorizontalAlignment(Element.ALIGN_CENTER);
       PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Cliente: "+cliente+"        DUI/NIT: "+dato,FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK)));
         celdaEncabezado4.setColspan(4);
           celdaEncabezado4.setBorder(0);
       Encabezado.addCell(celdaEncabezado4).setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("\n"));
         celdaEncabezado5.setColspan(4);
           celdaEncabezado5.setBorder(0);
       Encabezado.addCell(celdaEncabezado5).setHorizontalAlignment(Element.ALIGN_LEFT);
       doc.add(Encabezado);
       //aqui termian el encabezado
         PdfPTable Informe=new PdfPTable(5);
         Informe.setWidthPercentage(100);
         Informe.getDefaultCell().setBorder(7);
       
         float[] Columnainforme = new float[]{15f,20f,10f,15f,20f};
         Informe.setWidths(Columnainforme);
         Informe.setHorizontalAlignment(Element.ALIGN_CENTER);
         PdfPCell c1= new PdfPCell(new Paragraph("INGRESO",FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.WHITE)));
        
            PdfPCell c4= new PdfPCell(new Paragraph("FORMA_PAGO",FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.WHITE)));
             PdfPCell c5= new PdfPCell(new Paragraph("CANTIDAD",FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.WHITE)));
              PdfPCell c6= new PdfPCell(new Paragraph("FECHA",FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.WHITE)));
               PdfPCell c7= new PdfPCell(new Paragraph("DESCRIPCION",FontFactory.getFont("Arial",10,Font.BOLDITALIC,BaseColor.WHITE)));
                PdfPCell linea = new PdfPCell(new Paragraph("\n"));
         linea.setColspan(5);
           linea.setBorder(0);
       c1.setBackgroundColor(new BaseColor(0,105,153)); 
      
              c4.setBackgroundColor(new BaseColor(0,105,153));
               c5.setBackgroundColor(new BaseColor(0,105,153));
                c6.setBackgroundColor(new BaseColor(0,105,153));
                 c7.setBackgroundColor(new BaseColor(0,105,153));
         c1.setBorder(7); c4.setBorder(7); c5.setBorder(7);c6.setBorder(7);c7.setBorder(7);
         Informe.addCell(c1); Informe.addCell(c4); Informe.addCell(c5); Informe.addCell(c6); Informe.addCell(c7);
         Informe.addCell(linea).setHorizontalAlignment(Element.ALIGN_LEFT);
         Informe.setHorizontalAlignment(Element.ALIGN_CENTER);
         doc.add(Informe);
       //aqui termina la otra parte
             PdfPTable DATOS = new PdfPTable(5);
          DATOS.setWidthPercentage(100);
         DATOS.getDefaultCell().setBorder(2);
         float[] Columnadatos = new float[]{15f,20f,10f,15f,20f};
         DATOS.setWidths(Columnainforme);
         DATOS.setHorizontalAlignment(Element.ALIGN_CENTER);

            while (rs.next()) {
                // agregar filas a la tabla
                DATOS.addCell(rs.getString(2));
              
                  DATOS.addCell(rs.getString(5));
                   DATOS.addCell(rs.getString(6));
                    DATOS.addCell(rs.getString(7));
                     DATOS.addCell(rs.getString(8));
            }
            doc.add(DATOS);
            //aqui termina tabla
            PdfPTable Final=new PdfPTable(4);
         Final.setWidthPercentage(100);
         Final.getDefaultCell().setBorder(0);
         float[] finalpie = new float[]{20f,30f,70f,20F};
         Final.setWidths(finalpie);
         Final.setHorizontalAlignment(Element.ALIGN_CENTER);
        
         PdfPCell celdafinal = new PdfPCell(new Paragraph("TOTAL"+money,FontFactory.getFont("Arial",14,Font.BOLD,BaseColor.BLACK)));
         celdafinal.setColspan(3);
         celdafinal.setBorder(0);
       Final.addCell(celdafinal).setHorizontalAlignment(Element.ALIGN_CENTER);
         doc.add(Final);
       
       //
          
            doc.close();

            // liberar recursos
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+ex);
        }
    }
    
    private void verificarCB()
    {
        this.btnIngresar.setEnabled(false);
        this.btnActualizar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        limpiar();
        if (this.cbBuscador.getSelectedItem().equals("FECHA")) {
            this.mes.setVisible(true);
            this.yea.setVisible(true);
            
            this.txtDui.setEnabled(false);
            this.txtDescripcion.setEnabled(false);
            this.txtCantidad.setEnabled(false);
            this.txtcliente.setEnabled(false);
            this.cbFormapago.setEnabled(false);
            this.cbTipoCuenta.setEnabled(false);
        }else if (this.cbBuscador.getSelectedItem().equals("TODO")){
            this.mes.setVisible(false);
            this.yea.setVisible(false);
            
            this.txtDui.setEnabled(false);
            this.txtDescripcion.setEnabled(false);
            this.txtCantidad.setEnabled(false);
            this.txtcliente.setEnabled(false);
            this.cbFormapago.setEnabled(false);
            this.cbTipoCuenta.setEnabled(false);
             mostrardatos();
        
        }else if (this.cbBuscador.getSelectedItem().equals("DUI")){
                this.mes.setVisible(false);
                this.yea.setVisible(false);

                this.txtDui.setEnabled(true);
                this.txtDescripcion.setEnabled(false);
                this.txtCantidad.setEnabled(false);
                this.txtcliente.setEnabled(false);
                this.cbFormapago.setEnabled(false);
                this.cbTipoCuenta.setEnabled(false);
        
        }else if (this.cbBuscador.getSelectedItem().equals("NOMBRE")){
                this.mes.setVisible(false);
                this.yea.setVisible(false);

                this.txtDui.setEnabled(false);
                this.txtDescripcion.setEnabled(false);
                this.txtCantidad.setEnabled(false);
                this.txtcliente.setEnabled(true);
                this.cbFormapago.setEnabled(false);
                this.cbTipoCuenta.setEnabled(false);
        
        }else if (this.cbBuscador.getSelectedItem().equals("TIPO")){
                this.mes.setVisible(false);
                this.yea.setVisible(false);

                this.txtDui.setEnabled(false);
                this.txtDescripcion.setEnabled(false);
                this.txtCantidad.setEnabled(false);
                this.txtcliente.setEnabled(false);
                this.cbFormapago.setEnabled(false);
                this.cbTipoCuenta.setEnabled(true);
        }else if (this.cbBuscador.getSelectedItem().equals("FORMA DE PAGO")){
                this.mes.setVisible(false);
                this.yea.setVisible(false);

                this.txtDui.setEnabled(false);
                this.txtDescripcion.setEnabled(false);
                this.txtCantidad.setEnabled(false);
                this.txtcliente.setEnabled(false);
                this.cbFormapago.setEnabled(true);
                this.cbTipoCuenta.setEnabled(false);
        }
    }
}
