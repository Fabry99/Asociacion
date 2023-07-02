/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FORMULARIOS;

import com.mysql.jdbc.Connection;
import conexion.conexion;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;
import CLASES.TextPrompt;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Fujitsu
 */
public class Login extends javax.swing.JFrame {

        private ImageIcon imagen;
        private ImageIcon icono;
        conexion cn=new conexion();
        Connection cone;
        Statement st;
        ResultSet rs;

    /**
     * Creates new form Login
     */
    public Login() {
         initComponents();
         this.setLocationRelativeTo(null);
         TextPrompt usuario = new TextPrompt(" Ingresa el usuario", txtuser);
         TextPrompt contra = new TextPrompt(" Ingresa la contraseña", txtpass);
    cn.getConnection();
    }
    void consltar(){
    String sql="Select * from login";
        try {
            cone=cn.getConnection();
             st=cone.createStatement();
          rs=st.executeQuery(sql);
        } catch (Exception e) {
        }
    }
    public void ingresar(){
      java.sql.Connection con1 = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String User = txtuser.getText();
        String Pass = txtpass.getText();
        if (User.equals("") || Pass.equals("")) {
            JOptionPane.showMessageDialog(this, "Uno o mas campos estan vacios. Favor de llenarlos.");
        } else {
            try {
                con1 = cn.getConnection();
                pst = con1.prepareStatement("select usuarios, claves from login where usuarios='" + User
                        + "' and claves ='" + Pass + "'");
                rs = pst.executeQuery();
                if (rs.next()) {
                    this.dispose();
                    new ADMINISTRACION().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Credenciales incorrectas. Vuelve a intentar de nuevo.");
                    txtuser.setText(null);
                    txtpass.setText(null);
                    txtuser.requestFocus();
                }
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        logo1 = new javax.swing.JLabel();
        Button_Ver = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        IconUser = new javax.swing.JLabel();
        IconPassword = new javax.swing.JLabel();
        Button_Ocultar = new javax.swing.JLabel();
        ingresar = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();
        txtuser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ASOCIACIÓN ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SANTA CATALINA DE SIENA");

        logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/logo2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Button_Ver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Button_Ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eye_20.png"))); // NOI18N
        Button_Ver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_Ver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_VerMouseClicked(evt);
            }
        });
        getContentPane().add(Button_Ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FORMULARIOS/user.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 112, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("INGRESE CONTRASEÑA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 153));
        jLabel5.setText("INGRESE USUARIO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 133, -1));

        IconUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/user_32.png"))); // NOI18N
        getContentPane().add(IconUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 20, 20));

        IconPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/lock_32.png"))); // NOI18N
        getContentPane().add(IconPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 40, 20));

        Button_Ocultar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Button_Ocultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Hide_20.png"))); // NOI18N
        Button_Ocultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_Ocultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_OcultarMouseClicked(evt);
            }
        });
        getContentPane().add(Button_Ocultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, -1, -1));

        ingresar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        ingresar.setText("INGRESAR");
        ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ingresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ingresarMouseExited(evt);
            }
        });
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 140, 30));

        txtpass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });
        getContentPane().add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 280, 40));

        txtuser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });
        getContentPane().add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 280, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassActionPerformed

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ingresarActionPerformed

    private void ingresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarMouseClicked
        // TODO add your handling code here:
            if(MouseEvent.BUTTON1 == evt.getButton()){
            ingresar();
        }
        
    }//GEN-LAST:event_ingresarMouseClicked

    private void Button_VerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_VerMouseClicked
        if(MouseEvent.BUTTON1 == evt.getButton()){
            txtpass.setEchoChar((char)0);
            Button_Ocultar.setVisible(true);
            Button_Ver.setVisible(false);
        }
    }//GEN-LAST:event_Button_VerMouseClicked

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserActionPerformed

    private void Button_OcultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_OcultarMouseClicked
        if(MouseEvent.BUTTON1 == evt.getButton()){
            txtpass.setEchoChar('•');
            Button_Ocultar.setVisible(false);
            Button_Ver.setVisible(true);
        }
    }//GEN-LAST:event_Button_OcultarMouseClicked

    private void ingresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarMouseEntered
        // TODO add your handling code here:
          ingresar.setBackground(new Color(0,102,153));
        ingresar.setForeground(Color.white);
    }//GEN-LAST:event_ingresarMouseEntered

    private void ingresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarMouseExited
        // TODO add your handling code here:
         ingresar.setBackground(new Color(240,240,240));
        ingresar.setForeground(Color.black);
    }//GEN-LAST:event_ingresarMouseExited

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Button_Ocultar;
    private javax.swing.JLabel Button_Ver;
    private javax.swing.JLabel IconPassword;
    private javax.swing.JLabel IconUser;
    private javax.swing.JButton ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo1;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
  private void Imagen(JLabel logo1, String ruta) {
         this.imagen=new ImageIcon(ruta);
        this.icono=new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        logo1.getWidth(),
                        logo1.getHeight(),
                        Image.SCALE_DEFAULT
                )
        );
        logo1.setIcon(this.icono);
        this.repaint();
    }
 

}
