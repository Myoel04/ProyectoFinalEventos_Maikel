/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yosoy
 */
public class metodos {
    //cargar datos tabla eventos
    public void cargarEventosEnTabla(JTable table) {
    String query = "SELECT idEvento, tituloEvento, descripcion, tipoEvento, ubicacion, fecha FROM eventos";
    try (Connection conn = GestorBD.conectar();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"idEvento", "Nombre", "Descripción", "Tipo Evento", "Ubicación", "Fecha"}, 0);

        while (rs.next()) {
            int idEvento = rs.getInt("idEvento");
            String tituloEvento = rs.getString("tituloEvento");
            String descripcion = rs.getString("descripcion");
            String tipoEvento = rs.getString("tipoEvento");
            String ubicacion = rs.getString("ubicacion");
            String fecha = rs.getString("fecha"); // Mantener como String por ahora
            tableModel.addRow(new Object[]{idEvento, tituloEvento, descripcion, tipoEvento, ubicacion, fecha});
        }
        table.setModel(tableModel);
    } catch (SQLException e) {
        System.out.println("Error al cargar los datos: " + e.getMessage());
    }
}
    
    
    //CARGAR DATOS EN TABLA DE USUARIO
    // Método para cargar datos de usuarios en la tabla
public void cargarUsuariosEnTabla(JTable table) {
    String query = "SELECT idUsuario, nombreUsuario, emailUsuario, rol FROM usuario";
    try (Connection conn = GestorBD.conectar();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Id", "Nombre", "Email", "Rol"}, 0);

        while (rs.next()) {
            int idUsuario = rs.getInt("idUsuario");
            String nombreUsuario = rs.getString("nombreUsuario");
            String emailUsuario = rs.getString("emailUsuario");
            String rol = rs.getString("rol");
            tableModel.addRow(new Object[]{idUsuario, nombreUsuario, emailUsuario, rol});
        }
        table.setModel(tableModel);
    } catch (SQLException e) {
        System.out.println("Error al cargar los datos en la tabla: " + e.getMessage());
    }
}

    
  // Método para cargar eventos filtrados por fecha
public void cargarEventosPorFecha(JTable table, Date fechaFiltro) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String fechaComoTexto = dateFormat.format(fechaFiltro);
    String query = "SELECT idEvento, tituloEvento, descripcion, tipoEvento, ubicacion, fecha FROM eventos WHERE DATE(fecha) = ?";
    
    try (Connection conn = GestorBD.conectar();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, fechaComoTexto);
        ResultSet rs = pstmt.executeQuery();

        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"idEvento", "Nombre", "Descripción", "Tipo Evento", "Ubicación", "Fecha"}, 0);

        while (rs.next()) {
            int idEvento = rs.getInt("idEvento");
            String tituloEvento = rs.getString("tituloEvento");
            String descripcion = rs.getString("descripcion");
            String tipoEvento = rs.getString("tipoEvento");
            String ubicacion = rs.getString("ubicacion");
            String fecha = rs.getString("fecha");
            tableModel.addRow(new Object[]{idEvento, tituloEvento, descripcion, tipoEvento, ubicacion, fecha});
        }
        table.setModel(tableModel);
    } catch (SQLException e) {
        System.out.println("Error al cargar los datos: " + e.getMessage());
    }
}

public void cargarEventosUsuariosEnTabla(JTable table) {
        String query = "SELECT E.tituloEvento, E.tipoEvento, E.fecha, U.nombreUsuario, U.emailUsuario, EU.rolEnEvento " +
                       "FROM eventos E " +
                       "JOIN evento_usuario EU ON E.idEvento = EU.idEvento " +
                       "JOIN usuario U ON EU.idUsuario = U.idUsuario " +
                       "ORDER BY E.idEvento, U.nombreUsuario";

        try (Connection conn = GestorBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            DefaultTableModel tableModel = new DefaultTableModel(
                new Object[]{"Título del Evento", "Tipo de Evento", "Fecha del Evento", "Nombre del Usuario", "Email del Usuario", "Rol del Usuario"}, 0
            );

            while (rs.next()) {
                String fechaStr = rs.getString("fecha");
                String fechaFormateada = (fechaStr != null && !fechaStr.isEmpty()) ? fechaStr : "";
                tableModel.addRow(new Object[]{
                    rs.getString("tituloEvento"),
                    rs.getString("tipoEvento"),
                    fechaFormateada,
                    rs.getString("nombreUsuario"),
                    rs.getString("emailUsuario"),
                    rs.getString("rolEnEvento")
                });
            }
            table.setModel(tableModel);
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos en la tabla: " + e.getMessage());
        }
    }



//metodo de comprobacion que el email ya esta registrado
// Método para verificar si el email ya está registrado
public boolean existeEmail(String email) {
    String sql = "SELECT 1 FROM usuario WHERE emailUsuario = ?";
    try (Connection conn = GestorBD.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();
        return rs.next(); // Devuelve true si hay al menos un resultado
    } catch (SQLException e) {
        System.out.println("Error al verificar el email: " + e.getMessage());
        return false;
    }
}



}
