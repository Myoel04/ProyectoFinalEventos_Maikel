/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import DAO.EventoDAO;
import DAO.UsuarioDAO;
import DAO.eventousuarioDAO;
import controlador.controlarJavaHelp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import modelo.Evento;
import modelo.Usuario;

/**
 *
 * @author yosoy
 */
public class ventAsociar extends javax.swing.JFrame {

    private final UsuarioDAO udao = new UsuarioDAO();
    private final EventoDAO edao = new EventoDAO();
    private final eventousuarioDAO euDao = new eventousuarioDAO();
    private ventAdministracion ventAdmin;

    /**
     * Creates new form ventAsociar
     */
    public ventAsociar(ventAdministracion ventAdmin) {
        this.ventAdmin = ventAdmin; // gurdo la referencia para actualizar la tabla
        initComponents();
        controlarJavaHelp.inicializarAyuda();
        cargarUsuarios();
        cargarEventos();
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "javahelp");
        getRootPane().getActionMap().put("javahelp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlarJavaHelp.mostrarAyuda();
            }
        });
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }
//metodo para cargar los usuarios

    private void cargarUsuarios() {
        try {
            int pagina = 1;
            int tamanoPagina = 50;
            List<Usuario> usuarios = udao.buscarUsuariosPaginados(null, null, pagina, tamanoPagina);
            DefaultTableModel model = (DefaultTableModel) tUsuarios.getModel();
            model.setRowCount(0);
            for (Usuario usuario : usuarios) {
                model.addRow(new Object[]{
                    usuario.getIdUsuario(),
                    usuario.getNombreUsuario(),
                    usuario.getEmailUsuario(),
                    usuario.getRol()
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar usuarios: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//metodo para cargar los eventos

    private void cargarEventos() {
        int pagina = 1;
        int tamanoPagina = 50;
        List<Evento> eventos = edao.buscarEventosPaginados(null, null, "Todos", pagina, tamanoPagina);
        DefaultTableModel model = (DefaultTableModel) tEventos.getModel();
        model.setRowCount(0);
        for (Evento evento : eventos) {
            String fechaStr = evento.getFecha() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(evento.getFecha()) : "";
            int asistentes = edao.contarAsistentesActuales(evento.getIdEvento());
            model.addRow(new Object[]{
                evento.getIdEvento(),
                evento.getTituloEvento(),
                evento.getTipoEvento(),
                fechaStr,
                asistentes + " / " + evento.getCapacidadMax()
            });
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

        pTablasAmbas = new javax.swing.JPanel();
        pTablaUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tUsuarios = new javax.swing.JTable();
        pTablaEvento = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tEventos = new javax.swing.JTable();
        pBotones = new javax.swing.JPanel();
        bAsociar = new javax.swing.JButton();
        mbAyuda = new javax.swing.JMenuBar();
        mAyuda = new javax.swing.JMenu();
        jmAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idUsuario", "Nombre", "Email", "Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tUsuarios);

        javax.swing.GroupLayout pTablaUsuarioLayout = new javax.swing.GroupLayout(pTablaUsuario);
        pTablaUsuario.setLayout(pTablaUsuarioLayout);
        pTablaUsuarioLayout.setHorizontalGroup(
            pTablaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTablaUsuarioLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        pTablaUsuarioLayout.setVerticalGroup(
            pTablaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTablaUsuarioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        tEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idEvento", "Titulo Evento", "Tipo Evento", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tEventos);

        javax.swing.GroupLayout pTablaEventoLayout = new javax.swing.GroupLayout(pTablaEvento);
        pTablaEvento.setLayout(pTablaEventoLayout);
        pTablaEventoLayout.setHorizontalGroup(
            pTablaEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTablaEventoLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        pTablaEventoLayout.setVerticalGroup(
            pTablaEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout pBotonesLayout = new javax.swing.GroupLayout(pBotones);
        pBotones.setLayout(pBotonesLayout);
        pBotonesLayout.setHorizontalGroup(
            pBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        pBotonesLayout.setVerticalGroup(
            pBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        bAsociar.setText("Asociar");
        bAsociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAsociarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pTablasAmbasLayout = new javax.swing.GroupLayout(pTablasAmbas);
        pTablasAmbas.setLayout(pTablasAmbasLayout);
        pTablasAmbasLayout.setHorizontalGroup(
            pTablasAmbasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTablasAmbasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pTablaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTablasAmbasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bAsociar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pTablaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pTablasAmbasLayout.setVerticalGroup(
            pTablasAmbasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTablasAmbasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pTablaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTablasAmbasLayout.createSequentialGroup()
                .addGroup(pTablasAmbasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pTablasAmbasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pTablaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pTablasAmbasLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(pBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAsociar)))
                .addGap(47, 47, 47))
        );

        mAyuda.setText("Ayuda");

        jmAyuda.setText("JavaHelp");
        jmAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAyudaActionPerformed(evt);
            }
        });
        mAyuda.add(jmAyuda);

        mbAyuda.add(mAyuda);

        setJMenuBar(mbAyuda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pTablasAmbas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pTablasAmbas, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //metodo dentro para asociar una persona con el evento
    private void bAsociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAsociarActionPerformed
        // TODO add your handling code here:
        int filaUsuario = tUsuarios.getSelectedRow();
        int filaEvento = tEventos.getSelectedRow();

        if (filaUsuario == -1 || filaEvento == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un usuario y un evento para asociar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idUsuario = (int) tUsuarios.getValueAt(filaUsuario, 0);
        int idEvento = (int) tEventos.getValueAt(filaEvento, 0);

        // obtengo el evento seleccionado
        Evento evento = edao.obtenerEvento(idEvento);
        if (evento == null) {
            JOptionPane.showMessageDialog(this, "Evento no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Contar usuarios actuales
        int asistentesActuales = edao.contarAsistentesActuales(idEvento);
        if (asistentesActuales >= evento.getCapacidadMax()) {
            JOptionPane.showMessageDialog(this, "El evento ha alcanzado su capacidad máxima (" + evento.getCapacidadMax() + " personas). No se puede asociar más usuarios.", "Capacidad Máxima", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // rol por defento en usuari
        euDao.asociarUsuarioEvento(idUsuario, idEvento, "Usuario");
        JOptionPane.showMessageDialog(this, "Usuario y evento asociados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        // actualizo la tabla en ventAdministracion
        if (ventAdmin != null) {
            ventAdmin.cargarEventosUsuarios();
        }

    }//GEN-LAST:event_bAsociarActionPerformed

    private void jmAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAyudaActionPerformed
        // TODO add your handling code here:
        jmAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlarJavaHelp.mostrarAyuda();
            }
        });
    }//GEN-LAST:event_jmAyudaActionPerformed

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
            java.util.logging.Logger.getLogger(ventAsociar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventAsociar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventAsociar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventAsociar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventAsociar(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAsociar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem jmAyuda;
    private javax.swing.JMenu mAyuda;
    private javax.swing.JMenuBar mbAyuda;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pTablaEvento;
    private javax.swing.JPanel pTablaUsuario;
    private javax.swing.JPanel pTablasAmbas;
    private javax.swing.JTable tEventos;
    private javax.swing.JTable tUsuarios;
    // End of variables declaration//GEN-END:variables
}
