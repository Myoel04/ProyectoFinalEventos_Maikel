/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ventanas;

/**
 *
 * @author yosoy
 */
public class dialogoEliminarUsuario extends javax.swing.JDialog {

    private boolean confEliminar = false;

    /**
     * Creates new form dialogoEliminar
     */
    public dialogoEliminarUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
         temporizador1.setTextoNuevo("Cancelar");
        temporizador1.setTiempo(10);
    }

    public boolean isDeletionConfirmed() {
        return confEliminar;
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
        lPregunta = new javax.swing.JLabel();
        temporizador1 = new ComponentePropio.Temporizador();
        bSi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lPregunta.setText("¿Estás seguro de que quieres eliminar este usuario?");

        temporizador1.setPreferredSize(new java.awt.Dimension(76, 27));
        temporizador1.addCapturaListener(new ComponentePropio.Temporizador.CapturaListener() {
            public void capturarFinCuentaAtras(ComponentePropio.botonEvento evt) {
                temporizador1CapturarFinCuentaAtras(evt);
            }
        });
        temporizador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temporizador1ActionPerformed(evt);
            }
        });

        bSi.setText("Si");
        bSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(temporizador1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(bSi, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lPregunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(temporizador1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSi, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(37, 37, 37))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void temporizador1CapturarFinCuentaAtras(ComponentePropio.botonEvento evt) {//GEN-FIRST:event_temporizador1CapturarFinCuentaAtras
        // TODO add your handling code here:
        confEliminar = false; // Asegura que no se confirmó la eliminación
        dispose();
    }//GEN-LAST:event_temporizador1CapturarFinCuentaAtras

    private void temporizador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temporizador1ActionPerformed
        // TODO add your handling code here:
        confEliminar = false; // Asegura que no se confirmó la eliminación
        dispose();
    }//GEN-LAST:event_temporizador1ActionPerformed

    private void bSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiActionPerformed
        // TODO add your handling code here:
        confEliminar = true;
        dispose();
    }//GEN-LAST:event_bSiActionPerformed

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
            java.util.logging.Logger.getLogger(dialogoEliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dialogoEliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dialogoEliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dialogoEliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialogoEliminarUsuario dialog = new dialogoEliminarUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lPregunta;
    private ComponentePropio.Temporizador temporizador1;
    // End of variables declaration//GEN-END:variables
}
