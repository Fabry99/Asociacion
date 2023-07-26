
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
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.time.Instant;
import java.util.Date;


public class CUENTAEGRESOS extends javax.swing.JFrame {

     private ImageIcon imagen;
    private ImageIcon icono;
     private ImageIcon imagen2;
    private ImageIcon icono2;
    java.sql.Connection con2 ;
      PreparedStatement pst;
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
   
    public CUENTAEGRESOS() {
        initComponents();
        cn.getConnection();
         mostrardatos();
         mostraralumnos();
        
         this.setLocationRelativeTo(null);
         TextPrompt nombreE = new TextPrompt("Ingrese Proveedor", txtNombre);
         TextPrompt direccion = new TextPrompt("Ingrese direccion", txtDireccion);
         TextPrompt numero = new TextPrompt("77777777", txtNumero);
         this.btnEliminar.setEnabled(false);
         this.btnActualizar.setEnabled(false);
         this.btnMostrar.setEnabled(true);
         this.cbBuscador.setVisible(true);
//         this.ms1.setVisible(false);
//         this.ms2.setVisible(false);  
//         this.mes.setVisible(true);
//         this.yea.setVisible(true);
         this.txtNombre.requestFocus();
         this.btnCancelar.setVisible(false);
    }
    public void ingresar(){
      java.sql.Connection con1 = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String nombre = txtNombre.getText().trim().toUpperCase();
         String direccion = txtDireccion.getText().trim().toUpperCase();
         String numero=txtNumero.getText();
         Integer telefono=Integer.valueOf(numero);
//         String cuenta=cbTipoCuenta.getSelectedItem().toString();
//         String Formapago=cbFormapago.getSelectedItem().toString();
           Date myDate = new Date();
             String fecha = new SimpleDateFormat("yyyy/MM/dd").format(myDate);
         
         
        if ( nombre.equals("") || numero.equals("")  ) {
            JOptionPane.showMessageDialog(this, "Uno o mas campos estan vacios. Favor de llenarlos.");
        } else {
            try {
                con1 = cn.getConnection();
                pst = con1.prepareStatement(" INSERT INTO cuenta_egresos (NOMBRE_CUENTA,TELEFONO,DIRECCION)" + " values (?,?,?)");
                 pst.setString(1, nombre); 
                 pst.setInt(2,telefono);
                 pst.setString(3, direccion);
                 
                 
                                  
               pst.execute();
             JOptionPane.showMessageDialog(this, "Registro Agregado con Exito");
             this.txtNombre.setText(null);
              this.txtNumero.setText(null);
           
              this.txtDireccion.setText(null);
               
//               this.cbTipoCuenta.setSelectedIndex(0);
//               this.cbFormapago.setSelectedIndex(0);
             this.txtNumero.requestFocus();
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
                pst = con1.prepareStatement(" Delete FROM cuenta_egresos where ID_CUENTA_EGRESOS="
                    +Integer.toString(this.ID));
                      
               pst.execute();
             JOptionPane.showMessageDialog(this, "Registro Eliminado con Exito");
              this.txtNumero.setText(null);
            
              this.txtDireccion.setText(null);
             
//               this.cbTipoCuenta.setSelectedIndex(0);
//               this.cbFormapago.setSelectedIndex(0);
               this.txtNumero.requestFocus();
             
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
         String nombre = txtNombre.getText().trim().toUpperCase();
         String direccion = txtDireccion.getText().trim().toUpperCase();
         String numero=txtNumero.getText();
         Integer telefono=Integer.valueOf(numero);
//         String cuenta=cbTipoCuenta.getSelectedItem().toString();
//         String Formapago=cbFormapago.getSelectedItem().toString();
           Date myDate = new Date();
             String fecha = new SimpleDateFormat("yyyy/MM/dd").format(myDate);
         
         
        if (nombre.equals("") || telefono.equals("")  ) {
            JOptionPane.showMessageDialog(this, "Uno o mas campos estan vacios. Favor de llenarlos.");
        } else {
            try {
                con1 = cn.getConnection();
                pst = con1.prepareStatement(" UPDATE cuenta_egresos SET NOMBRE_CUENTA=?, TELEFONO=?,DIRECCION=? WHERE ID_CUENTA_EGRESOS="+Integer.toString(this.ID));
                 pst.setString(1, nombre); 
                 pst.setInt(2,telefono);
                 pst.setString(3, direccion);
                 
                                  
               pst.execute();
             JOptionPane.showMessageDialog(this, "Registro Actualizado con Exito");
              this.txtNumero.setText(null);
            // this.txtcliente.setText(null); 
              this.txtDireccion.setText(null);
              // this.txtDui.setText(null);
//               this.cbTipoCuenta.setSelectedIndex(0);
//               this.cbFormapago.setSelectedIndex(0);
             //this.txtDui.requestFocus();
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
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        cbBuscador = new javax.swing.JComboBox<>();
        btnMostrarTodo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
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
        jLabel8.setText("CUENTAS EGRESOS");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 270, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 70));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 105, 150));
        jLabel5.setText("DIRECCION");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 120, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 105, 150));
        jLabel7.setText("TELEFONO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 80, -1));

        txtDireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 530, 30));

        txtNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 150, 30));

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
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 130, 40));

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
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 130, 40));

        btnMostrar.setBackground(new java.awt.Color(0, 105, 150));
        btnMostrar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setText("BUSCAR");
        btnMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMostrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMostrarMouseExited(evt);
            }
        });
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 130, 40));

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
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 130, 40));

        cbBuscador.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        cbBuscador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "INTERNET", "AGUA", "ENERGIA ELECTRICA", "SALARIOS", "AFP", "SEGURO", "SERVICIO PROFESIONAL", "MANTENIMIENTO", "OTRO" }));
        cbBuscador.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                cbBuscadorComponentAdded(evt);
            }
        });
        cbBuscador.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBuscadorItemStateChanged(evt);
            }
        });
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
        jPanel1.add(cbBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 130, -1));

        btnMostrarTodo.setBackground(new java.awt.Color(0, 105, 150));
        btnMostrarTodo.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnMostrarTodo.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarTodo.setText("MOSTRAR TODO");
        btnMostrarTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMostrarTodoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMostrarTodoMouseExited(evt);
            }
        });
        btnMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodoActionPerformed(evt);
            }
        });
        jPanel1.add(btnMostrarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 130, 20));

        btnCancelar.setBackground(new java.awt.Color(0, 105, 150));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 130, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 105, 150));
        jLabel9.setText("NOMBRE ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 80, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 290, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 690, 260));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 690, 240));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/fondomenu.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 10, 1350, 650));

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

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        // TODO add your handling code here:
         btnIngresar.setBackground(new Color(154,7,13));
                 btnIngresar.setForeground(Color.white);
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        
              if ( txtDireccion.getText().equals("") || txtNumero.getText().equals("")  ) {
            JOptionPane.showMessageDialog(this, "Uno o mas campos estan vacios. Favor de llenarlos.");
          
        }else{
        ingresar();
         this.btnMostrar.setEnabled(true);
            this.cbBuscador.setVisible(true);
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

    private void btnMostrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseEntered
        // TODO add your handling code here:
         btnMostrar.setBackground(new Color(154,7,13));
                 btnMostrar.setForeground(Color.white);
    }//GEN-LAST:event_btnMostrarMouseEntered

    private void btnMostrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseExited
        // TODO add your handling code here:
        btnMostrar.setBackground(new Color(0,105,153));
        btnMostrar.setForeground(Color.white);
    }//GEN-LAST:event_btnMostrarMouseExited

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
         this.btnCancelar.setVisible(true);
         this.btnEliminar.setEnabled(true);
         this.btnActualizar.setEnabled(true);
         this.btnIngresar.setEnabled(false);
         this.btnMostrar.setEnabled(false);
         int iRow= this.tablaAlumnos.getSelectedRow();
        
         this.currReg= Integer.parseInt(this.tablaAlumnos.getValueAt(iRow, 0).toString());
         this.ID=Integer.valueOf(this.tablaAlumnos.getValueAt(iRow,0).toString());
         this.txtNombre.setText(this.tablaAlumnos.getValueAt(iRow, 1).toString());
        this.txtDireccion.setText(this.tablaAlumnos.getValueAt(iRow, 3).toString());
        this.txtNumero.setText(this.tablaAlumnos.getValueAt(iRow, 2).toString());
        //  this.cbFormapago.setSelectedItem(this.tablaAlumnos.getValueAt(iRow, 2).toString());
    }//GEN-LAST:event_tablaAlumnosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        
        this.btnMostrar.setEnabled(false);
        this.cbBuscador.setVisible(false);
        habilitar();
        Eliminar();
//        this.ms1.setVisible(false);
//        this.ms2.setVisible(false);  
        
        this.btnEliminar.setEnabled(false);
        this.btnActualizar.setEnabled(false);
        this.btnIngresar.setEnabled(true);
        this.btnMostrar.setEnabled(false);
        this.btnCancelar.setVisible(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
          this.btnMostrar.setEnabled(false);
         // this.cbBusca.setVisible(false);
        habilitar();
        actualizar();
//          this.ms1.setVisible(false);
//         this.ms2.setVisible(false);  
          this.btnEliminar.setEnabled(false);
           this.btnActualizar.setEnabled(false);
           this.btnIngresar.setEnabled(true);
           this.btnMostrar.setEnabled(false);
           this.btnCancelar.setVisible(false);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
         String buscador=cbBuscador.getSelectedItem().toString();
//         mesb=mes.getSelectedIndex()+1;
//         yb=yea.getSelectedItem().toString();
         ye=Integer.valueOf(yb);
         BUSCADOR(buscador,mesb,ye);
         //this.cbBusca.setVisible(false);
         habilitar();

    }//GEN-LAST:event_btnMostrarActionPerformed

    private void cbBuscadorComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_cbBuscadorComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBuscadorComponentAdded

    private void cbBuscadorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBuscadorItemStateChanged
        // TODO add your handling code here:
       String op=cbBuscador.getSelectedItem().toString();
        if (op.equals("FECHA")) {
//            this.mes.setVisible(true);
//            this.yea.setVisible(true);
        }else
          if (op.equals("TODO")){
             mostrardatos();
              }
       
    }//GEN-LAST:event_cbBuscadorItemStateChanged

    private void cbBuscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbBuscadorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBuscadorMouseClicked

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

    private void btnMostrarTodoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarTodoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarTodoMouseEntered

    private void btnMostrarTodoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarTodoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarTodoMouseExited

    private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
        mostrardatos();
    }//GEN-LAST:event_btnMostrarTodoActionPerformed

    private void cbBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBuscadorActionPerformed
        DefaultTableModel tcliente= new DefaultTableModel();
     tcliente.addColumn("ID");
     tcliente.addColumn("PROVEEDOR");
     tcliente.addColumn("TELEFONO");
     tcliente.addColumn("DIRECCION");
     tablaAlumnos.setModel(tcliente);
    String []datos =new String[4];
    String      dato = cbBuscador.getSelectedItem().toString();
        try {
              con2 = cn.getConnection();
            pst=con2.prepareStatement("Select * from cuenta_egresos where NOMBRE_CUENTA='"+(dato)+"'");
            rs = pst.executeQuery();
                     while (rs.next()) {
               datos[0]=rs.getString(1);
               datos[1]=rs.getString(2);
               datos[2]=rs.getString(3);
               datos[3]=rs.getString(4);
                tcliente.addRow(datos);
            this.tablaAlumnos.setModel(tcliente);
                     }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
        }
    }//GEN-LAST:event_cbBuscadorActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.btnMostrar.setEnabled(false);
        this.cbBuscador.setVisible(false);
        habilitar();
        this.btnEliminar.setEnabled(false);
        this.btnActualizar.setEnabled(false);
        this.btnIngresar.setEnabled(true);
        this.btnMostrar.setEnabled(false);
        this.btnCancelar.setVisible(false);
        this.txtNumero.setText(null);
        this.txtDireccion.setText(null);
        this.txtNumero.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CUENTAEGRESOS vermenudona= new CUENTAEGRESOS();
        vermenudona.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
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
            java.util.logging.Logger.getLogger(CUENTAEGRESOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CUENTAEGRESOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CUENTAEGRESOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CUENTAEGRESOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CUENTAEGRESOS().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuDonaciones;
    private javax.swing.JMenu MenuEgresos;
    private javax.swing.JMenu MenuInformes;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnMostrarTodo;
    private javax.swing.JComboBox<String> cbBuscador;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
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
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
        }
  }
    public void mostrardatos(){
     DefaultTableModel tcliente= new DefaultTableModel();
     tcliente.addColumn("ID");
     tcliente.addColumn("PROVEEDOR");
     tcliente.addColumn("TELEFONO");
     tcliente.addColumn("DIRECCION");
 
     tablaAlumnos.setModel(tcliente);
    String []datos =new String[4];
     java.sql.Connection con2 = null;
      PreparedStatement pst = null;
   
        try {
            
             
           con2 = cn.getConnection();
           pst=con2.prepareStatement("Select * from cuenta_egresos ORDER BY ID_CUENTA_EGRESOS");
           rs = pst.executeQuery();
            while (rs.next()) {
             
               datos[0]=rs.getString(1);
               datos[1]=rs.getString(2);
               datos[2]=rs.getString(3);
               datos[3]=rs.getString(4);
         
              
                tcliente.addRow(datos);
            }
            this.tablaAlumnos.setModel(tcliente);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
        }
    }
        public void BUSCADOR(String dato,int mes, int y){
            dato=cbBuscador.getSelectedItem().toString();
         DefaultTableModel tcliente= new DefaultTableModel();
         tcliente.addColumn("ID");
         tcliente.addColumn("EGRESOS");
         tcliente.addColumn("FORMA_PAGO");
         tcliente.addColumn("CANTIDAD $");
         tcliente.addColumn("FECHA");
         tcliente.addColumn("DESCRIPCION");
         tablaAlumnos.setModel(tcliente);
         String []datos =new String[6];
         java.sql.Connection con2 = null;
         PreparedStatement pst = null;

            try {
                con2 = cn.getConnection();
                if(dato.equals("TODOS")) pst=con2.prepareStatement("Select * from egresos where MONTH(FECHA)="+(mes)+"&& YEAR(FECHA)="+(y));
                else pst=con2.prepareStatement("Select * from egresos where NOMBRE_CUENTA='"+(dato)+"' AND MONTH(FECHA)="+(mes)+"&& YEAR(FECHA)="+(y));
                rs = pst.executeQuery();
                while (rs.next()) {

                   datos[0]=rs.getString(1);
                   datos[1]=rs.getString(2);
                   datos[2]=rs.getString(3);
                   datos[3]=rs.getString(4);
                   datos[4]=rs.getString(5);
                   datos[5]=rs.getString(6);

                    tcliente.addRow(datos);
                }
                this.tablaAlumnos.setModel(tcliente);
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
            }
    }
    public void habilitar(){
         txtDireccion.setEnabled(true);
         txtNumero.setEnabled(true);
    }
}
//    public void BUSCADOR2(String dato,String buscador){
//        
//     DefaultTableModel cliente= new DefaultTableModel();
//     
//      cliente.addColumn("ID");
//     cliente.addColumn("ALUMNO");
//    
//     cliente.addColumn("DUI");
//    
//    String []datos =new String[3];
//     java.sql.Connection con2 = null;
//      PreparedStatement pst = null;
//   
//        try {
//            
//             
//           con2 = cn.getConnection();
//            if (buscador.equals("NIE")){
//                pst=con2.prepareStatement("Select * from alumnos  where NIE="+(dato));
//           rs = pst.executeQuery();
//             
//              }else if (buscador.equals("NOMBRE")){
//        pst=con2.prepareStatement("Select * from alumnos   where NOMBRE_ALUMNO="+(dato));
//           rs = pst.executeQuery();
//             
//              }
//        
//            while (rs.next()) {
//             
//               datos[0]=rs.getString(1);
//               datos[1]=rs.getString(3);
//                datos[2]=rs.getString(6);
//             
//                cliente.addRow(datos);
//            }
//        } catch (Exception e) {
//             JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador. "+e);
//        }
//    }
//}
