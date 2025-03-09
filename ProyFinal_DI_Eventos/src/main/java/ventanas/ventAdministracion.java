/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import DAO.eventousuarioDAO;
import controlador.controlarJavaHelp;
import controlador.metodos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.eventoUsuario;

/**
 *
 * @author yosoy
 */
public class ventAdministracion extends javax.swing.JFrame {

    private eventousuarioDAO euDao = new eventousuarioDAO();
    private int paginaActual = 1;
    private int tamanoPagina = 5;
    private int totalPaginas;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private List<eventoUsuario> eventosUsuariosCargados = new ArrayList<>();

    /**
     * Creates new form ventAdministracion
     */
    public ventAdministracion() {
        initComponents();
        controlarJavaHelp.inicializarAyuda();
        bAnterior.setEnabled(false);
        bSiguiente.setEnabled(false);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        cargarEventosUsuarios();
    }

    public void cargarEventosUsuarios() {
        try {
            String titulo = tTitulo.getText().trim();
            String tipoEvento = (cbTipoEvento.getSelectedItem() != null) ? cbTipoEvento.getSelectedItem().toString() : "Todos";
            String fechaStr = null;
            Date fecha = jDateChooser1.getDate();
            if (fecha != null) {
                fechaStr = sdf.format(fecha);
            }
            String nombreUsuario = tNombreUsuario.getText().trim();
            String rol = (cbRol.getSelectedItem() != null) ? cbRol.getSelectedItem().toString() : "Todos";

            totalPaginas = (int) Math.ceil((double) euDao.contarEventosUsuarios(titulo, tipoEvento, fechaStr, nombreUsuario, rol) / tamanoPagina);
            bAnterior.setEnabled(paginaActual > 1);
            bSiguiente.setEnabled(paginaActual < totalPaginas);

            // Asignar los resultados a la lista de instancia
            eventosUsuariosCargados = euDao.buscarEventosUsuariosPaginados(titulo, tipoEvento, fechaStr, nombreUsuario, rol, paginaActual, tamanoPagina);

            DefaultTableModel tableModel = (DefaultTableModel) tGeneral.getModel();
            tableModel.setRowCount(0);
            for (eventoUsuario eu : eventosUsuariosCargados) {
                String fechaFormateada = (eu.getFecha() != null) ? sdf.format(eu.getFecha()) : "";
                tableModel.addRow(new Object[]{
                    eu.getTituloEvento(),
                    eu.getTipoEvento(),
                    fechaFormateada,
                    eu.getNombreUsuario(),
                    eu.getEmail(),
                    eu.getRolEnEvento()
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar eventos y usuarios: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        pGenerarAdm = new javax.swing.JPanel();
        pFiltros = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        tTitulo = new javax.swing.JTextField();
        lTipoEvento = new javax.swing.JLabel();
        cbTipoEvento = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lFecha = new javax.swing.JLabel();
        lRol = new javax.swing.JLabel();
        cbRol = new javax.swing.JComboBox<>();
        lNombreUsuario = new javax.swing.JLabel();
        tNombreUsuario = new javax.swing.JTextField();
        bFiltrar = new javax.swing.JButton();
        pTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tGeneral = new javax.swing.JTable();
        pBotones = new javax.swing.JPanel();
        bVaciar = new javax.swing.JButton();
        bSiguiente = new javax.swing.JButton();
        bAnterior = new javax.swing.JButton();
        bEliminarAsociacion = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmEvento = new javax.swing.JMenu();
        jmCrearEvento = new javax.swing.JMenuItem();
        jmCrearUsuario = new javax.swing.JMenuItem();
        jmAsociar = new javax.swing.JMenuItem();
        menuInformes = new javax.swing.JMenuItem();
        mVer = new javax.swing.JMenu();
        jmiVerUsuarios = new javax.swing.JMenuItem();
        jmiEventos = new javax.swing.JMenuItem();
        jmAyuda = new javax.swing.JMenu();
        jmiAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lTitulo.setText("Titulo:");

        tTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tTituloActionPerformed(evt);
            }
        });

        lTipoEvento.setText("Tipo de Evento:");

        cbTipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Deportivo", "Cultural", "Cumpleaños", "Boda", "Musical", "Bautizo", "Comunion" }));
        cbTipoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoEventoActionPerformed(evt);
            }
        });

        lFecha.setText("Fecha:");

        lRol.setText("ROL:");

        cbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "administrador", "usuario" }));
        cbRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRolActionPerformed(evt);
            }
        });

        lNombreUsuario.setText("Nombre usuario:");

        tNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNombreUsuarioActionPerformed(evt);
            }
        });

        bFiltrar.setText("Filtrar");
        bFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pFiltrosLayout = new javax.swing.GroupLayout(pFiltros);
        pFiltros.setLayout(pFiltrosLayout);
        pFiltrosLayout.setHorizontalGroup(
            pFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFiltrosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFiltrosLayout.createSequentialGroup()
                        .addComponent(lRol, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tNombreUsuario)
                        .addGap(46, 46, 46))
                    .addGroup(pFiltrosLayout.createSequentialGroup()
                        .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(pFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        pFiltrosLayout.setVerticalGroup(
            pFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFiltrosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lTitulo)
                        .addComponent(tTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lTipoEvento)
                        .addComponent(cbTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lFecha)))
                .addGap(18, 18, 18)
                .addGroup(pFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lRol)
                    .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNombreUsuario)
                    .addComponent(tNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bFiltrar))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Titulo Evento", "Tipo Evento", "Fecha", "Nombre Usuario", "Email", "Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tGeneral);

        javax.swing.GroupLayout pTablaLayout = new javax.swing.GroupLayout(pTabla);
        pTabla.setLayout(pTablaLayout);
        pTablaLayout.setHorizontalGroup(
            pTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
        );
        pTablaLayout.setVerticalGroup(
            pTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        bVaciar.setText("Vaciar Filtros");
        bVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVaciarActionPerformed(evt);
            }
        });

        bSiguiente.setText("Siguiente");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

        bAnterior.setText("Anterior");
        bAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnteriorActionPerformed(evt);
            }
        });

        bEliminarAsociacion.setText("Eliminar Asociacion");
        bEliminarAsociacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarAsociacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pBotonesLayout = new javax.swing.GroupLayout(pBotones);
        pBotones.setLayout(pBotonesLayout);
        pBotonesLayout.setHorizontalGroup(
            pBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBotonesLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(bAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bVaciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bEliminarAsociacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pBotonesLayout.setVerticalGroup(
            pBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBotonesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bVaciar)
                    .addComponent(bSiguiente)
                    .addComponent(bAnterior)
                    .addComponent(bEliminarAsociacion))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pGenerarAdmLayout = new javax.swing.GroupLayout(pGenerarAdm);
        pGenerarAdm.setLayout(pGenerarAdmLayout);
        pGenerarAdmLayout.setHorizontalGroup(
            pGenerarAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGenerarAdmLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pGenerarAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pGenerarAdmLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pTabla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pFiltros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pGenerarAdmLayout.setVerticalGroup(
            pGenerarAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGenerarAdmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jmEvento.setText("Crear");

        jmCrearEvento.setText("CrearEvento");
        jmCrearEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearEventoActionPerformed(evt);
            }
        });
        jmEvento.add(jmCrearEvento);

        jmCrearUsuario.setText("Crear Usuario");
        jmCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearUsuarioActionPerformed(evt);
            }
        });
        jmEvento.add(jmCrearUsuario);

        jmAsociar.setText("Asociar");
        jmAsociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAsociarActionPerformed(evt);
            }
        });
        jmEvento.add(jmAsociar);

        menuInformes.setText("Informes");
        menuInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInformesActionPerformed(evt);
            }
        });
        jmEvento.add(menuInformes);

        jMenuBar1.add(jmEvento);

        mVer.setText("Ver");

        jmiVerUsuarios.setText("Usuarios");
        jmiVerUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVerUsuariosActionPerformed(evt);
            }
        });
        mVer.add(jmiVerUsuarios);

        jmiEventos.setText("Eventos");
        jmiEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEventosActionPerformed(evt);
            }
        });
        mVer.add(jmiEventos);

        jMenuBar1.add(mVer);

        jmAyuda.setText("Ayuda");

        jmiAyuda.setText("Help");
        jmiAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAyudaActionPerformed(evt);
            }
        });
        jmAyuda.add(jmiAyuda);

        jMenuBar1.add(jmAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGenerarAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGenerarAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmCrearEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearEventoActionPerformed
        ventCrearEvento vce = new ventCrearEvento();
        vce.setVisible(true);


    }//GEN-LAST:event_jmCrearEventoActionPerformed

    private void jmCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearUsuarioActionPerformed
        // TODO add your handling code here:

        ventCrearUsuario vcu = new ventCrearUsuario();
        vcu.setVisible(true);

    }//GEN-LAST:event_jmCrearUsuarioActionPerformed

    private void bAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnteriorActionPerformed
        // TODO add your handling code here:
        if (paginaActual > 1) {
            paginaActual--;
            cargarEventosUsuarios();
        }
    }//GEN-LAST:event_bAnteriorActionPerformed

    private void bVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVaciarActionPerformed
        // TODO add your handling code here:
        tTitulo.setText("");
        cbTipoEvento.setSelectedIndex(0);
        jDateChooser1.setDate(null);
        tNombreUsuario.setText("");
        cbRol.setSelectedIndex(0);
        paginaActual = 1;
        cargarEventosUsuarios();
    }//GEN-LAST:event_bVaciarActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        // TODO add your handling code here:
        if (paginaActual < totalPaginas) {
            paginaActual++;
            cargarEventosUsuarios();
        }
    }//GEN-LAST:event_bSiguienteActionPerformed

    private void bFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFiltrarActionPerformed
        // TODO add your handling code here:
        paginaActual = 1;
        cargarEventosUsuarios();
    }//GEN-LAST:event_bFiltrarActionPerformed

    private void cbRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRolActionPerformed

    private void cbTipoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoEventoActionPerformed

    private void tTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tTituloActionPerformed

    private void tNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNombreUsuarioActionPerformed

    private void jmAsociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAsociarActionPerformed
        // TODO add your handling code here:

        ventAsociar va  = new ventAsociar(this);
        va.setVisible(true);

    }//GEN-LAST:event_jmAsociarActionPerformed

    private void jmiVerUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVerUsuariosActionPerformed
        // TODO add your handling code here:
        ventUsuarios vu = new ventUsuarios();
        vu.setVisible(true);
    }//GEN-LAST:event_jmiVerUsuariosActionPerformed

    private void jmiEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEventosActionPerformed
        // TODO add your handling code here:
        ventEventos ve = new ventEventos();
        ve.setVisible(true);

    }//GEN-LAST:event_jmiEventosActionPerformed

    private void bEliminarAsociacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarAsociacionActionPerformed
        // TODO add your handling code here:

        int filaSeleccionada = tGeneral.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar la asociación.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Obtener el objeto eventoUsuario correspondiente a la fila seleccionada
            eventoUsuario eu = eventosUsuariosCargados.get(filaSeleccionada);
            int idUsuario = eu.getIdUsuario();
            int idEvento = eu.getIdEvento();

            // Eliminar la asociación
            euDao.eliminarAsociacion(idUsuario, idEvento);

            // Remover la fila de la tabla
            DefaultTableModel tableModel = (DefaultTableModel) tGeneral.getModel();
            tableModel.removeRow(filaSeleccionada);
            eventosUsuariosCargados.remove(filaSeleccionada);

            JOptionPane.showMessageDialog(this, "Asociación eliminada correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar la asociación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bEliminarAsociacionActionPerformed

    private void menuInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInformesActionPerformed
        // TODO add your handling code here:
        
        
        ventInformes vi = new ventInformes();
        vi.setVisible(true);
        
    }//GEN-LAST:event_menuInformesActionPerformed

    private void jmiAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAyudaActionPerformed
        // TODO add your handling code here:
        jmiAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           controlarJavaHelp.mostrarAyuda();
            
            }
        });
        
    }//GEN-LAST:event_jmiAyudaActionPerformed

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
            java.util.logging.Logger.getLogger(ventAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventAdministracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnterior;
    private javax.swing.JButton bEliminarAsociacion;
    private javax.swing.JButton bFiltrar;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JButton bVaciar;
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JComboBox<String> cbTipoEvento;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmAsociar;
    private javax.swing.JMenu jmAyuda;
    private javax.swing.JMenuItem jmCrearEvento;
    private javax.swing.JMenuItem jmCrearUsuario;
    private javax.swing.JMenu jmEvento;
    private javax.swing.JMenuItem jmiAyuda;
    private javax.swing.JMenuItem jmiEventos;
    private javax.swing.JMenuItem jmiVerUsuarios;
    private javax.swing.JLabel lFecha;
    private javax.swing.JLabel lNombreUsuario;
    private javax.swing.JLabel lRol;
    private javax.swing.JLabel lTipoEvento;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JMenu mVer;
    private javax.swing.JMenuItem menuInformes;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pFiltros;
    private javax.swing.JPanel pGenerarAdm;
    private javax.swing.JPanel pTabla;
    private javax.swing.JTable tGeneral;
    private javax.swing.JTextField tNombreUsuario;
    private javax.swing.JTextField tTitulo;
    // End of variables declaration//GEN-END:variables
}
