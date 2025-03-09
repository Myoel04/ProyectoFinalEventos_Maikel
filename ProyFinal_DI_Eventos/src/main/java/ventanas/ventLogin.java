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
    ventAdministracion va = new ventAdministracion();
    
    
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
        bEntrar = new javax.swing.JButton();
        mbAyuda2 = new javax.swing.JMenuBar();
        mAyuda2 = new javax.swing.JMenu();
        jmAyuda2 = new javax.swing.JMenuItem();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lUsuario.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        lUsuario.setText("Email:");

        lContrasena.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        lContrasena.setText("Contraseña:");

        lLogo.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 14)); // NOI18N
        lLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lLogo.setText("Inicio de Sesión");

        bEntrar.setText("Entrar");
        bEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lContrasena)
                            .addComponent(lUsuario))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(bEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lUsuario))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lContrasena)
                    .addComponent(tContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(bEntrar)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        mAyuda2.setText("Ayuda");

        jmAyuda2.setText("JavaHelp");
        jmAyuda2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAyuda2ActionPerformed(evt);
            }
        });
        mAyuda2.add(jmAyuda2);

        mbAyuda2.add(mAyuda2);

        setJMenuBar(mbAyuda2);

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

    private void bEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEntrarActionPerformed
      String email = tEmail.getText().trim();
        String contrasena = new String(tContrasena.getPassword()).trim();

        if (email.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Autenticar al usuario y obtener su ID y rol
        Usuario usuario = ud.autenticarUsuarioConId(email, contrasena);
        if (usuario != null) {
            String rol = usuario.getRol().toLowerCase(); // Convertir a minúsculas para consistencia
            int idUsuario = usuario.getIdUsuario();
            
            switch (rol) {
                case "administrador":
                    va.setVisible(true);
                    this.dispose(); // Cierra la ventana de login
                    break;
                case "usuario":
                    ventVistaUsuario vvu = new ventVistaUsuario(idUsuario); // Usar el idUsuario dinámico
                    vvu.setVisible(true);
                    this.dispose(); // Cierra la ventana de login
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Rol no reconocido: " + rol);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Email o contraseña incorrectos.");
        }
        
    }//GEN-LAST:event_bEntrarActionPerformed

    private void jmAyuda2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAyuda2ActionPerformed
        // TODO add your handling code here:
      controlarJavaHelp.mostrarAyuda();
    }//GEN-LAST:event_jmAyuda2ActionPerformed

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JMenuItem jmAyuda;
    private javax.swing.JMenuItem jmAyuda1;
    private javax.swing.JMenuItem jmAyuda2;
    private javax.swing.JLabel lContrasena;
    private javax.swing.JLabel lLogo;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JMenu mAyuda;
    private javax.swing.JMenu mAyuda1;
    private javax.swing.JMenu mAyuda2;
    private javax.swing.JMenuBar mbAyuda;
    private javax.swing.JMenuBar mbAyuda1;
    private javax.swing.JMenuBar mbAyuda2;
    private javax.swing.JPasswordField tContrasena;
    private javax.swing.JTextField tEmail;
    // End of variables declaration//GEN-END:variables
}
