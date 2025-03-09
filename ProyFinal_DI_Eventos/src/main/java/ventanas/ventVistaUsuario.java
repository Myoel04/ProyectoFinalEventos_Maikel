/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import DAO.EventoDAO;
import DAO.eventousuarioDAO;
import controlador.controlarJavaHelp;
import controlador.metodos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Evento;

/**
 *
 * @author yosoy
 */
public class ventVistaUsuario extends javax.swing.JFrame {

    eventousuarioDAO eudao = new eventousuarioDAO();
    EventoDAO edao = new EventoDAO();
    metodos metodos = new metodos();
    private int paginaActual = 1;
    private int tamanoPagina = 5; // 5 eventos por página
    private int totalPaginas;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private List<Evento> eventosCargados;
    private int idUsuario;

    /**
     * Creates new form ventVistaUsuario
     */
    public ventVistaUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        initComponents();
        pack();
        setResizable(false);
        controlarJavaHelp.inicializarAyuda();
        setTitle("Mis Eventos");
        bAnterior.setEnabled(false);
        bSiguiente.setEnabled(false);
        eventosCargados = new ArrayList<>();
        filtrarEventos();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //filtrar con el enter
        tTituloEvento.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    bFiltrar.doClick();
                }
            }
        });

        cbTipoEvento.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    bFiltrar.doClick();
                }
            }
        });

    }

    private void filtrarEventos() {
        try {
            String titulo = tTituloEvento.getText().trim();
            String tipoEvento = (cbTipoEvento.getSelectedItem() != null) ? cbTipoEvento.getSelectedItem().toString() : "Deportivo";

            int totalEventos = edao.contarEventosPorUsuario(titulo, tipoEvento, idUsuario);
            totalPaginas = (int) Math.ceil((double) totalEventos / tamanoPagina);

            bAnterior.setEnabled(paginaActual > 1);
            bSiguiente.setEnabled(paginaActual < totalPaginas);

            List<Evento> eventos = edao.buscarEventosPorUsuarioPaginados(titulo, tipoEvento, paginaActual, tamanoPagina, idUsuario);

            eventosCargados = new ArrayList<>(eventos);

            DefaultTableModel tableModel = (DefaultTableModel) tEventosUsuario.getModel();
            tableModel.setRowCount(0);

            for (Evento evento : eventos) {
                String fechaFormateada = (evento.getFecha() != null) ? sdf.format(evento.getFecha()) : "";
                tableModel.addRow(new Object[]{
                    evento.getIdEvento(),
                    evento.getTituloEvento(),
                    evento.getDescripcion(),
                    evento.getTipoEvento(),
                    evento.getUbicacion(),
                    fechaFormateada
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar eventos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        pGeneral = new javax.swing.JPanel();
        pBotones = new javax.swing.JPanel();
        bAnterior = new javax.swing.JButton();
        bVaciar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        bSiguiente = new javax.swing.JButton();
        pFiltro = new javax.swing.JPanel();
        lNombre = new javax.swing.JLabel();
        tTituloEvento = new javax.swing.JTextField();
        lTipoEvento = new javax.swing.JLabel();
        cbTipoEvento = new javax.swing.JComboBox<>();
        bFiltrar = new javax.swing.JButton();
        pTabla = new javax.swing.JPanel();
        tEventos = new javax.swing.JScrollPane();
        tEventosUsuario = new javax.swing.JTable();
        mbAyuda6 = new javax.swing.JMenuBar();
        mAyuda6 = new javax.swing.JMenu();
        jmAyuda6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pGeneral.setLayout(new java.awt.BorderLayout());

        bAnterior.setText("Anterior");
        bAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnteriorActionPerformed(evt);
            }
        });
        pBotones.add(bAnterior);

        bVaciar.setText("Vaciar");
        bVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVaciarActionPerformed(evt);
            }
        });
        pBotones.add(bVaciar);

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });
        pBotones.add(bEliminar);

        bSiguiente.setText("Siguiente");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });
        pBotones.add(bSiguiente);

        pGeneral.add(pBotones, java.awt.BorderLayout.PAGE_END);

        lNombre.setText("Titulo:");

        lTipoEvento.setText("Tipo Evento:");

        cbTipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Deportivo", "Cultural", "Cumpleaños", "Boda", "Musical", "Bautizo", "Comunion" }));

        bFiltrar.setText("Filtrar");
        bFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pFiltroLayout = new javax.swing.GroupLayout(pFiltro);
        pFiltro.setLayout(pFiltroLayout);
        pFiltroLayout.setHorizontalGroup(
            pFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFiltroLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tTituloEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(bFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pFiltroLayout.setVerticalGroup(
            pFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNombre)
                    .addComponent(tTituloEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTipoEvento)
                    .addComponent(cbTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pGeneral.add(pFiltro, java.awt.BorderLayout.PAGE_START);

        tEventosUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "idEvento", "Titulo", "Descripcion", "Tipo Evento", "Ubicación", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tEventos.setViewportView(tEventosUsuario);

        javax.swing.GroupLayout pTablaLayout = new javax.swing.GroupLayout(pTabla);
        pTabla.setLayout(pTablaLayout);
        pTablaLayout.setHorizontalGroup(
            pTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTablaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(tEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pTablaLayout.setVerticalGroup(
            pTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tEventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pGeneral.add(pTabla, java.awt.BorderLayout.CENTER);

        mAyuda6.setText("Ayuda");

        jmAyuda6.setText("JavaHelp");
        jmAyuda6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAyuda6ActionPerformed(evt);
            }
        });
        mAyuda6.add(jmAyuda6);

        mbAyuda6.add(mAyuda6);

        setJMenuBar(mbAyuda6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVaciarActionPerformed
        // TODO add your handling code here:

        tTituloEvento.setText("");
        cbTipoEvento.setSelectedIndex(0);
        paginaActual = 1;
        filtrarEventos();
    }//GEN-LAST:event_bVaciarActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        // TODO add your handling code here:
        if (paginaActual < totalPaginas) {
            paginaActual++;
            filtrarEventos();
        }
    }//GEN-LAST:event_bSiguienteActionPerformed

    private void bAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnteriorActionPerformed
        // TODO add your handling code here:
        if (paginaActual > 1) {
            paginaActual--;
            filtrarEventos();
        }
    }//GEN-LAST:event_bAnteriorActionPerformed

    private void bFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFiltrarActionPerformed
        // TODO add your handling code here:

        paginaActual = 1; // Reinicia a la primera página al filtrar
        filtrarEventos();
    }//GEN-LAST:event_bFiltrarActionPerformed

    private void jmAyuda6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAyuda6ActionPerformed
        // TODO add your handling code here:
        controlarJavaHelp.mostrarAyuda();
    }//GEN-LAST:event_jmAyuda6ActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        // TODO add your handling code here:

        int selectedRow = tEventosUsuario.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un evento para desapuntarse.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idEvento = (int) tEventosUsuario.getValueAt(selectedRow, 0); // idEvento está en la columna 0
        try {
            eudao.eliminarAsociacion(idUsuario, idEvento);
            JOptionPane.showMessageDialog(this, "Te has desapuntado del evento con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            filtrarEventos(); // Refresca la tabla
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al desapuntarse: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(ventVistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventVistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventVistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventVistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventVistaUsuario(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnterior;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bFiltrar;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JButton bVaciar;
    private javax.swing.JComboBox<String> cbTipoEvento;
    private javax.swing.JMenuItem jmAyuda6;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel lTipoEvento;
    private javax.swing.JMenu mAyuda6;
    private javax.swing.JMenuBar mbAyuda6;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pFiltro;
    private javax.swing.JPanel pGeneral;
    private javax.swing.JPanel pTabla;
    private javax.swing.JScrollPane tEventos;
    private javax.swing.JTable tEventosUsuario;
    private javax.swing.JTextField tTituloEvento;
    // End of variables declaration//GEN-END:variables
}
