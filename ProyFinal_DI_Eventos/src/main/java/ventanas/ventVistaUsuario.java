/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import DAO.EventoDAO;
import controlador.metodos;
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

    EventoDAO edao = new EventoDAO();
    metodos metodos = new metodos();
    private int paginaActual = 1;
    private int tamanoPagina = 1; // 5 eventos por página
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
        bAnterior.setEnabled(false);
        bSiguiente.setEnabled(false);
        eventosCargados = new ArrayList<>();
        filtrarEventos();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Mis Eventos");
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
        bVaciar = new javax.swing.JButton();
        bAnterior = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pGeneral.setLayout(new java.awt.BorderLayout());

        bVaciar.setText("Vaciar");
        bVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVaciarActionPerformed(evt);
            }
        });

        bAnterior.setText("Anterior");
        bAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnteriorActionPerformed(evt);
            }
        });

        bSiguiente.setText("Siguiente");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pBotonesLayout = new javax.swing.GroupLayout(pBotones);
        pBotones.setLayout(pBotonesLayout);
        pBotonesLayout.setHorizontalGroup(
            pBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBotonesLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(bAnterior)
                .addGap(42, 42, 42)
                .addComponent(bVaciar)
                .addGap(42, 42, 42)
                .addComponent(bSiguiente)
                .addContainerGap(260, Short.MAX_VALUE))
        );
        pBotonesLayout.setVerticalGroup(
            pBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBotonesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bVaciar)
                    .addComponent(bAnterior)
                    .addComponent(bSiguiente))
                .addContainerGap(45, Short.MAX_VALUE))
        );

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
                .addContainerGap(50, Short.MAX_VALUE))
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
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pTablaLayout.setVerticalGroup(
            pTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tEventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pGeneral.add(pTabla, java.awt.BorderLayout.CENTER);

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
    private javax.swing.JButton bFiltrar;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JButton bVaciar;
    private javax.swing.JComboBox<String> cbTipoEvento;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel lTipoEvento;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pFiltro;
    private javax.swing.JPanel pGeneral;
    private javax.swing.JPanel pTabla;
    private javax.swing.JScrollPane tEventos;
    private javax.swing.JTable tEventosUsuario;
    private javax.swing.JTextField tTituloEvento;
    // End of variables declaration//GEN-END:variables
}
