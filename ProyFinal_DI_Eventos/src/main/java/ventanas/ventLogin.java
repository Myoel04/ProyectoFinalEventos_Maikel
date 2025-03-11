/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import DAO.UsuarioDAO;
import controlador.controlarJavaHelp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author yosoy
 */
public class ventLogin extends javax.swing.JFrame {

    UsuarioDAO ud = new UsuarioDAO();
    ventAdministracion va  = new ventAdministracion();

    /**
     * Creates new form vistaLogin
     */
    public ventLogin() {
        initComponents();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        controlarJavaHelp.inicializarAyuda();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lUsuario = new javax.swing.JLabel();
        lContrasena = new javax.swing.JLabel();
        tEmail = new javax.swing.JTextField();
        tContrasena = new javax.swing.JPasswordField();
        lLogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bRegistrarse = new javax.swing.JButton();
        bEntrar = new javax.swing.JButton();
        chMostrar = new javax.swing.JCheckBox();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lUsuario.setText("Email:");

        lContrasena.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lContrasena.setText("Contraseña:");

        lLogo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lLogo.setText("Inicio de Sesión");

        bRegistrarse.setText("Registrarse");
        bRegistrarse.setPreferredSize(new java.awt.Dimension(102, 27));
        bRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarseActionPerformed(evt);
            }
        });
        jPanel2.add(bRegistrarse);

        bEntrar.setText("Entrar");
        bEntrar.setMaximumSize(new java.awt.Dimension(92, 27));
        bEntrar.setMinimumSize(new java.awt.Dimension(92, 27));
        bEntrar.setPreferredSize(new java.awt.Dimension(98, 27));
        bEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEntrarActionPerformed(evt);
            }
        });
        jPanel2.add(bEntrar);

        chMostrar.setText("Mostrar Contraseña");
        chMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(chMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lContrasena)
                                            .addComponent(lUsuario))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tContrasena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lUsuario))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lContrasena)
                    .addComponent(tContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(chMostrar)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//confirmo credenciales y luego entro 
    private void bEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEntrarActionPerformed
        String email = tEmail.getText().trim();
        String contrasena = new String(tContrasena.getPassword()).trim();

        if (email.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // obtener id y rol
        Usuario usuario = ud.autenticarUsuarioConId(email, contrasena);
        if (usuario != null) {
            String rol = usuario.getRol().toLowerCase();
            int idUsuario = usuario.getIdUsuario();

            switch (rol) {
                case "administrador":
                    va.setVisible(true);
                    this.dispose();
                    break;
                case "usuario":
                    ventVistaUsuario vvu = new ventVistaUsuario(idUsuario);
                    vvu.setVisible(true);
                    this.dispose();
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Rol no reconocido: " + rol);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Email o contraseña incorrectos.");
        }

    }//GEN-LAST:event_bEntrarActionPerformed

    private void bRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarseActionPerformed
        // TODO add your handling code here:

        ventRegistroUsuario vru = new ventRegistroUsuario();
        vru.setVisible(true);
    }//GEN-LAST:event_bRegistrarseActionPerformed

    private void chMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chMostrarActionPerformed
        // TODO add your handling code here:

        if (chMostrar.isSelected()) {
            tContrasena.setEchoChar((char) 0);
        } else {
            tContrasena.setEchoChar('*'); // 
        }


    }//GEN-LAST:event_chMostrarActionPerformed

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
            java.util.logging.Logger.getLogger(ventLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEntrar;
    private javax.swing.JButton bRegistrarse;
    private javax.swing.JCheckBox chMostrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lContrasena;
    private javax.swing.JLabel lLogo;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JPasswordField tContrasena;
    private javax.swing.JTextField tEmail;
    // End of variables declaration//GEN-END:variables
}
