/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FORMULARIOS;


import CLASES.TextPrompt;
import com.mysql.jdbc.Connection;
import conexion.conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fujitsu
 */
public class USUARIOS extends javax.swing.JFrame {
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
    private int ID;
    private String buscar;
   
       
       //Fondo fondo1=new Fondo();
    /**
     * Creates new form ADMINISTRACION
     */
    public USUARIOS() {
       // this.setContentPane(fondo1);
        initComponents();
        cn.getConnection();
        mostrardatos();
        // escritorio= new EscritorioPersonalizado();
        //this.setContentPane(escritorio);
        this.txtBuscador.requestFocus();
        this.setLocationRelativeTo(null);
      //  this.Imagen(this.fondo, "src/IMAGENES/fondomenu.jpg");
        TextPrompt nie = new TextPrompt("123456789", txtNie );
        TextPrompt busqueda = new TextPrompt("Ingrese el nombre", txtBuscador);
        TextPrompt nombre = new TextPrompt("Ingrese nombre completo", txtNombre);
        TextPrompt responsable = new TextPrompt("Ingrese nombre completo", txtResponsable);
        TextPrompt dui = new TextPrompt("12345678-9", txtDui);
        this.btnEliminar.setEnabled(false);
        this.btnActualizar.setEnabled(false);
        this.ms1.setVisible(false);
        this.ms2.setVisible(false); 
        this.error1.setVisible(false);
        this.error2.setVisible(false);
        this.error3.setVisible(false);
    }
    public void ingresar(){
      java.sql.Connection con1 = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String nie = txtBuscador.getText();
        int nieN=Integer.valueOf(nie);
        String nombre = txtNombre.getText().trim().toUpperCase();
         String responsable = txtResponsable.getText().trim().toUpperCase();
         String dui=txtDui.getText();
         int duiN=Integer.valueOf(dui);
         String grado=cbGrado.getSelectedItem().toString();
         String year=cbA.getSelectedItem().toString();
         
        if (nie.equals("") || nombre.equals("") || responsable.equals("") || dui.equals("")  ) {
            JOptionPane.showMessageDialog(this, "Uno o mas campos estan vacios. Favor de llenarlos.");
        } else {
            try {
                con1 = cn.getConnection();
                pst = con1.prepareStatement(" INSERT INTO alumnos (NIE, NOMBRE_ALUMNO, GRADO,NOMBRE_RESPONSABLE,DUI,AÑO)" + " values (?, ?, ?,?,?,?)");
                 pst.setInt(1, nieN);
                 pst.setString(2, nombre);
                 pst.setString(3, grado);
                 pst.setString(4, responsable);
                 pst.setInt(5,duiN);
                 pst.setString(6,year);
                                  
               pst.execute();
             JOptionPane.showMessageDialog(this, "Registro Agregado con Exito");
              this.txtDui.setText(null);
             this.txtNombre.setText(null); 
              this.txtResponsable.setText(null);
               this.txtBuscador.setText(null);
               this.cbGrado.setSelectedIndex(0);
               this.cbA.setSelectedIndex(0);
             this.txtBuscador.requestFocus();
              mostrardatos();
              
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
                pst = con1.prepareStatement(" Delete FROM alumnos where ID_ALUMNO="
                    +Integer.toString(this.ID));
                      
               pst.execute();
             JOptionPane.showMessageDialog(this, "Registro Eliminado con Exito");
              this.txtDui.setText(null);
             this.txtNombre.setText(null); 
              this.txtResponsable.setText(null);
               this.txtBuscador.setText(null);
               this.cbGrado.setSelectedIndex(0);
               this.cbA.setSelectedIndex(0);
             this.txtBuscador.requestFocus();
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
        String nie = txtBuscador.getText();
        int nieN=Integer.valueOf(nie);
        String nombre = txtNombre.getText().trim().toUpperCase();
         String responsable = txtResponsable.getText().trim().toUpperCase();
         String dui=txtDui.getText();
         int duiN=Integer.valueOf(dui);
         String grado=cbGrado.getSelectedItem().toString();
         String year=cbA.getSelectedItem().toString();
         
        if (nie.equals("") || nombre.equals("") || responsable.equals("") || dui.equals("")  ) {
            JOptionPane.showMessageDialog(this, "Uno o mas campos estan vacios. Favor de llenarlos.");
        } else {
            try {
                con1 = cn.getConnection();
                pst = con1.prepareStatement("UPDATE alumnos SET NIE=?, NOMBRE_ALUMNO=?, GRADO=?,NOMBRE_RESPONSABLE=?,DUI=?,AÑO=? WHERE ID_ALUMNO="+Integer.toString(this.ID));
                 pst.setInt(1, nieN);
                 pst.setString(2, nombre);
                 pst.setString(3, grado);
                 pst.setString(4, responsable);
                 pst.setInt(5,duiN);
                 pst.setString(6,year);
                                  
               pst.execute();
             JOptionPane.showMessageDialog(this, "Registro Actualizado con Exito");
              this.txtDui.setText(null);
             this.txtNombre.setText(null); 
              this.txtResponsable.setText(null);
               this.txtBuscador.setText(null);
               this.cbGrado.setSelectedIndex(0);
               this.cbA.setSelectedIndex(0);
             this.txtBuscador.requestFocus();
              mostrardatos();
              
            } catch (SQLException e) {
                System.err.print(e.toString());
                JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador.");
            }
        }
    }
    
    //    public ResultSet consultar( conexion cone2){
//         ResultSet rs=null; 
//    String sql="Select * from alumnos ORDER BY ID_ALUMNO";
//        try {
//            cone=cone2.getConnection();
//             st=cone.createStatement();
//          rs=st.executeQuery(sql);
//        } catch (Exception e) {
//             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador."+e);
//        }
//        return rs;
//    }

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscador = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        cbGrado = new javax.swing.JComboBox<>();
        cbA = new javax.swing.JComboBox<>();
        txtResponsable = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        ms2 = new javax.swing.JLabel();
        ms1 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        error1 = new javax.swing.JLabel();
        txtDui = new javax.swing.JTextField();
        txtNie = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
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

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE  ALUMNOS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 320, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 70));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 105, 150));
        jLabel2.setText("NIE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 40, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 105, 150));
        jLabel3.setText("NOMBRE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 70, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 105, 150));
        jLabel4.setText("GRADO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 60, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 105, 150));
        jLabel5.setText("RESPONSANBLE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 120, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 105, 150));
        jLabel6.setText("AÑO ELECTIVO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 110, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 105, 150));
        jLabel7.setText("BUSCADOR");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 90, -1));

        txtBuscador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscadorMouseClicked(evt);
            }
        });
        txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 230, 30));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 400, 30));

        cbGrado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KINDER 4", "KINDER 5", "KINDER 6", "PRIMERO", "SEGUNDO ", "TERCERO", "CUARTO", "QUINTO", "SEXTO", "SEPTIMO", "OCTAVO", "NOVENO", "PRIMER AÑO ", "SEGUNDO AÑO" }));
        jPanel1.add(cbGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 150, 30));

        cbA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035" }));
        jPanel1.add(cbA, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 80, 30));

        txtResponsable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 400, 30));

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
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 120, 40));

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
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 130, 40));

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
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 130, 40));

        ms2.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        ms2.setForeground(new java.awt.Color(255, 51, 51));
        ms2.setText("Este campo debe revisarse ");
        jPanel1.add(ms2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, -1));

        ms1.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        ms1.setForeground(new java.awt.Color(255, 51, 51));
        ms1.setText("Este campo debe revisarse ");
        jPanel1.add(ms1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        error2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        error2.setForeground(new java.awt.Color(255, 51, 51));
        error2.setText("ERROR");
        jPanel1.add(error2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, 30));

        error3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        error3.setForeground(new java.awt.Color(255, 51, 51));
        error3.setText("ERROR");
        jPanel1.add(error3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, 30));

        error1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 51, 51));
        error1.setText("ERROR");
        jPanel1.add(error1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, 30));

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
        jPanel1.add(txtDui, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 160, 30));

        txtNie.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNieMouseClicked(evt);
            }
        });
        txtNie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNieKeyReleased(evt);
            }
        });
        jPanel1.add(txtNie, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 130, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 105, 150));
        jLabel8.setText("DUI");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 40, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 870, 310));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 870, 200));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/fondomenu.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, -20, 1350, 650));

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

    private void menuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuariosActionPerformed
        // TODO add your handling code here:
       
        USUARIOS vermenudona= new USUARIOS();
        vermenudona.setVisible(true);
        dispose();
    
        
    }//GEN-LAST:event_menuUsuariosActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        // TODO add your handling code here:
         btnIngresar.setBackground(new Color(154,7,13));
                 btnIngresar.setForeground(Color.white);
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        
              if (txtBuscador.getText().equals("") || txtNombre.getText().equals("") || txtResponsable.getText().equals("") || txtDui.getText().equals("")  ) {
            JOptionPane.showMessageDialog(this, "Uno o mas campos estan vacios. Favor de llenarlos.");
            txtBuscador.requestFocus();
        }else{
        ingresar();
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
        // TODO add your handling code here:
          this.ms1.setVisible(true);
         this.ms2.setVisible(true);  
         this.btnEliminar.setEnabled(true);
           this.btnActualizar.setEnabled(true);
           this.btnIngresar.setEnabled(false);
        int iRow= this.tablaAlumnos.getSelectedRow();
        
        this.currReg= Integer.parseInt(this.tablaAlumnos.getValueAt(iRow, 0).toString());
        this.ID=Integer.valueOf(this.tablaAlumnos.getValueAt(iRow,0).toString());
        this.txtBuscador.setText(this.tablaAlumnos.getValueAt(iRow, 1).toString());
        this.txtNombre.setText(this.tablaAlumnos.getValueAt(iRow, 2).toString());
        this.txtResponsable.setText(this.tablaAlumnos.getValueAt(iRow, 4).toString());
        this.txtDui.setText(this.tablaAlumnos.getValueAt(iRow, 5).toString());
        
    }//GEN-LAST:event_tablaAlumnosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        habilitar();
        Eliminar();
          this.ms1.setVisible(false);
         this.ms2.setVisible(false);  
        
         this.btnEliminar.setEnabled(false);
           this.btnActualizar.setEnabled(false);
           this.btnIngresar.setEnabled(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        habilitar();
        actualizar();
          this.ms1.setVisible(false);
         this.ms2.setVisible(false);  
          this.btnEliminar.setEnabled(false);
           this.btnActualizar.setEnabled(false);
           this.btnIngresar.setEnabled(true);
           
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void MenuDonacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDonacionesActionPerformed
        // TODO add your handling code here:
         INGRESOS vermenudona= new INGRESOS();
          vermenudona.setVisible(true);
         dispose();
    }//GEN-LAST:event_MenuDonacionesActionPerformed

    private void MenuEgresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuEgresosMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_MenuEgresosMouseClicked

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

    private void txtDuiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDuiMouseClicked
        // TODO add your handling code here:
        this.error1.setVisible(false);
        this.txtDui.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_txtDuiMouseClicked

    private void txtDuiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuiKeyReleased
        // TODO add your handling code here:
        try {
            String Dui = txtDui.getText();
            int duiN=Integer.valueOf(Dui);
            this.error1.setVisible(false);
            this.txtDui.setBackground(new Color(255,255,255));
        } catch (Exception e) {
            this.error1.setVisible(true);
            this.txtDui.setBackground(new Color(154,7,13));

        }
    }//GEN-LAST:event_txtDuiKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
          try {
            String nom=txtNombre.getText();
            int nome=Integer.valueOf(nom);
            this.error3.setVisible(true);
            this.txtNombre.setBackground(new Color(154,7,13));

        } catch (Exception e) {
            this.error3.setVisible(false);
            this.txtNombre.setBackground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        // TODO add your handling code here:
         this.error3.setVisible(false);
        this.txtNombre.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_txtNombreMouseClicked

    private void txtBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorKeyReleased
        DefaultTableModel tcliente= new DefaultTableModel();
        tcliente.addColumn("ID");
        tcliente.addColumn("NIE");
        tcliente.addColumn("ALUMNO");
        tcliente.addColumn("GRADO");
        tcliente.addColumn("RESPONSABLE");
        tcliente.addColumn("DUI");
        tcliente.addColumn("AÑO");
        tablaAlumnos.setModel(tcliente);
        String []datos =new String[7];
        java.sql.Connection con2 = null;
        PreparedStatement pst = null;
        String dato = "";
        dato = this.txtBuscador.getText().toUpperCase();
   
        try {
           con2 = cn.getConnection();
             
           pst=con2.prepareStatement("Select * from alumnos where NOMBRE_ALUMNO like'%"+(dato)+"%'");
           rs = pst.executeQuery();
           while (rs.next()) {
             
               datos[0]=rs.getString(1);
               datos[1]=rs.getString(2);
               datos[2]=rs.getString(3);
               datos[3]=rs.getString(4);
               datos[4]=rs.getString(5);
               datos[5]=rs.getString(6);
               datos[6]=rs.getString(7);
                tcliente.addRow(datos);
            }
            this.tablaAlumnos.setModel(tcliente);
            
             // JOptionPane.showMessageDialog(this, "NIE"+datos[0]+"\n"+datos[1]+"\n"+datos[2]+"\n"+datos[3]+"\n"+datos[4]+"\n"+datos[5]);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
        }
             
    }//GEN-LAST:event_txtBuscadorKeyReleased

    private void txtBuscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscadorMouseClicked
        
    }//GEN-LAST:event_txtBuscadorMouseClicked

    private void txtNieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNieMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.error2.setVisible(true);
        this.txtBuscador.setBackground(new Color(154,7,13));
    }//GEN-LAST:event_txtNieMouseClicked

    private void txtNieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNieKeyReleased
        try {
            String nie = txtBuscador.getText();
            int nieN=Integer.valueOf(nie);
            this.error2.setVisible(false);
            this.txtBuscador.setBackground(new Color(255,255,255));
        } catch (Exception e) {
            this.error2.setVisible(true);
            this.txtBuscador.setBackground(new Color(154,7,13));

        }
    }//GEN-LAST:event_txtNieKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
          CUENTAEGRESOS vermenudona= new CUENTAEGRESOS();
        vermenudona.setVisible(true);
        dispose();
                  
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(USUARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(USUARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(USUARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(USUARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new USUARIOS().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuDonaciones;
    private javax.swing.JMenu MenuEgresos;
    private javax.swing.JMenu MenuInformes;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox<String> cbA;
    private javax.swing.JComboBox<String> cbGrado;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenuItem menuUsuarios;
    private javax.swing.JLabel ms1;
    private javax.swing.JLabel ms2;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTextField txtBuscador;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtNie;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtResponsable;
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
//    private void consultaTodos(ResultSet pRes)
//    {
//        try
//        {
//          model.setRowCount(0);
//          Object Datos[]= new Object[3];
//          
//          while (pRes.next())
//          {
//              for (int i=1;i<7;i++) Datos[i]=pRes.getObject(i+1).toString().trim();
//              model.addRow(Datos);
//          }
//          this.tablaAlumnos.setModel(model);
//          
//        }
//        catch(Exception e) {}
//        
//    }
    public void mostrardatos(){
     DefaultTableModel tcliente= new DefaultTableModel();
     tcliente.addColumn("ID");
     tcliente.addColumn("NIE");
     tcliente.addColumn("ALUMNO");
     tcliente.addColumn("GRADO");
     tcliente.addColumn("RESPONSABLE");
     tcliente.addColumn("DUI");
     tcliente.addColumn("AÑO");
     tablaAlumnos.setModel(tcliente);
    String []datos =new String[7];
     java.sql.Connection con2 = null;
      PreparedStatement pst = null;
   
        try {
            
             
           con2 = cn.getConnection();
           pst=con2.prepareStatement("Select * from alumnos ORDER BY ID_ALUMNO");
           rs = pst.executeQuery();
            while (rs.next()) {
             
               datos[0]=rs.getString(1);
               datos[1]=rs.getString(2);
               datos[2]=rs.getString(3);
               datos[3]=rs.getString(4);
               datos[4]=rs.getString(5);
               datos[5]=rs.getString(6);
               datos[6]=rs.getString(7);
                tcliente.addRow(datos);
            }
            this.tablaAlumnos.setModel(tcliente);
            
             // JOptionPane.showMessageDialog(this, "NIE"+datos[0]+"\n"+datos[1]+"\n"+datos[2]+"\n"+datos[3]+"\n"+datos[4]+"\n"+datos[5]);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
        }
    }
    public void BUSCADOR(String dato,String buscador){
        
     DefaultTableModel tcliente= new DefaultTableModel();
     tcliente.addColumn("ID");
     tcliente.addColumn("NIE");
     tcliente.addColumn("ALUMNO");
     tcliente.addColumn("GRADO");
     tcliente.addColumn("RESPONSABLE");
     tcliente.addColumn("DUI");
     tcliente.addColumn("AÑO");
     tablaAlumnos.setModel(tcliente);
    String []datos =new String[7];
     java.sql.Connection con2 = null;
      PreparedStatement pst = null;
   
        try {
            
             
           con2 = cn.getConnection();
            if (buscador.equals("NIE")){
                pst=con2.prepareStatement("Select * from alumnos  where NIE="+(dato));
           rs = pst.executeQuery();
             
              }else if (buscador.equals("NOMBRE")){
        pst=con2.prepareStatement("Select * from alumnos ORDER  where NOMBRE_ALUMNO='"+(dato)+"'");
           rs = pst.executeQuery();
             
              }else if (buscador.equals("GRADO")){
            pst=con2.prepareStatement("Select * from alumnos where GRADO='"+(dato)+"'");
           rs = pst.executeQuery();
             
              }else if (buscador.equals("AÑO")){
              pst=con2.prepareStatement("Select * from alumnos where AÑO="+(dato));
           rs = pst.executeQuery();
             
              }else {
              JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+dato);
              }
        
            while (rs.next()) {
             
               datos[0]=rs.getString(1);
               datos[1]=rs.getString(2);
               datos[2]=rs.getString(3);
               datos[3]=rs.getString(4);
               datos[4]=rs.getString(5);
               datos[5]=rs.getString(6);
               datos[6]=rs.getString(7);
                tcliente.addRow(datos);
            }
            this.tablaAlumnos.setModel(tcliente);
            
             // JOptionPane.showMessageDialog(this, "NIE"+datos[0]+"\n"+datos[1]+"\n"+datos[2]+"\n"+datos[3]+"\n"+datos[4]+"\n"+datos[5]);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
        }
    }
    public void habilitar(){
     txtNombre.setEnabled(true);
              txtBuscador.setEnabled(true);
               txtResponsable.setEnabled(true);
              cbA.setEnabled(true);
              cbGrado.setEnabled(true);
              txtDui.setEnabled(true);
    }
     
// 
//   class Fondo extends JLabel{
//   private Image imagenF;
//   
//   @Override
//   public void paint(Graphics g){
//   imagenF=new ImageIcon(getClass().getResource("src/IMAGENES/fondomenu.jpg")).getImage();
//   g.drawImage(imagenF, 0, 0, getWidth(), getHeight(), this);
//       setOpaque(false);
//       super.paint(g);
//   }
//   }




}
