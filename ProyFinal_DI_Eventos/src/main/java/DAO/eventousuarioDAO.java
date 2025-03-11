package DAO;

import controlador.GestorBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.eventoUsuario;

public class eventousuarioDAO {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // Método para insertar una nueva asociación
    public void asociarUsuarioEvento(int idUsuario, int idEvento, String rol) {
        String sql = "INSERT INTO evento_usuario (idUsuario, idEvento, rolEnEvento) VALUES (?, ?, ?)";
        try (Connection conn = GestorBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idEvento);
            pstmt.setString(3, rol);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al asociar usuario y evento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    public List<eventoUsuario> obtenerEventosUsuarios() {
        List<eventoUsuario> eventosUsuarios = new ArrayList<>();
        String sql = "SELECT E.idEvento, E.tituloEvento, E.tipoEvento, E.fecha, U.idUsuario, U.nombreUsuario, U.emailUsuario, EU.rolEnEvento " +
                     "FROM eventos E " +
                     "JOIN evento_usuario EU ON E.idEvento = EU.idEvento " +
                     "JOIN usuario U ON EU.idUsuario = U.idUsuario " +
                     "ORDER BY E.idEvento, U.nombreUsuario";

        try (Connection conn = GestorBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Date fecha = null;
                try {
                    String fechaStr = rs.getString("fecha");
                    if (fechaStr != null && !fechaStr.isEmpty()) {
                        fecha = sdf.parse(fechaStr);
                    }
                } catch (ParseException e) {
                    System.out.println("Error al parsear la fecha: " + e.getMessage());
                    fecha = null;
                }
                eventosUsuarios.add(new eventoUsuario(
                    rs.getInt("idEvento"),
                    rs.getString("tituloEvento"),
                    rs.getString("tipoEvento"),
                    fecha,
                    rs.getInt("idUsuario"),
                    rs.getString("nombreUsuario"),
                    rs.getString("emailUsuario"),
                    rs.getString("rolEnEvento")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los eventos y usuarios: " + e.getMessage());
            e.printStackTrace();
        }
        return eventosUsuarios;
    }
//metodo para buscar los eventso
    public List<eventoUsuario> buscarEventosUsuariosPaginados(String titulo, String tipoEvento, String fecha, 
                                                              String nombreUsuario, String rol, 
                                                              int pagina, int tamanoPagina)  {
        List<eventoUsuario> eventosUsuarios = new ArrayList<>();
        StringBuilder query = new StringBuilder(
            "SELECT E.idEvento, E.tituloEvento, E.tipoEvento, E.fecha, U.idUsuario, U.nombreUsuario, U.emailUsuario, EU.rolEnEvento " +
            "FROM eventos E " +
            "JOIN evento_usuario EU ON E.idEvento = EU.idEvento " +
            "JOIN usuario U ON EU.idUsuario = U.idUsuario " +
            "WHERE 1=1"
        );

        if (titulo != null && !titulo.isEmpty()) {
            query.append(" AND E.tituloEvento LIKE ?");
        }
        if (tipoEvento != null && !tipoEvento.isEmpty() && !tipoEvento.equals("Todos")) {
            query.append(" AND E.tipoEvento = ?");
        }
        if (fecha != null && !fecha.isEmpty()) {
            query.append(" AND DATE(E.fecha) = ?");
        }
        if (nombreUsuario != null && !nombreUsuario.isEmpty()) {
            query.append(" AND U.nombreUsuario LIKE ?");
        }
        if (rol != null && !rol.isEmpty() && !rol.equals("Todos")) {
            query.append(" AND EU.rolEnEvento = ?");
        }
        query.append(" ORDER BY E.idEvento, U.nombreUsuario LIMIT ? OFFSET ?");

        try (Connection conn = GestorBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            int paramIndex = 1;
            if (titulo != null && !titulo.isEmpty()) {
                stmt.setString(paramIndex++, "%" + titulo + "%");
            }
            if (tipoEvento != null && !tipoEvento.isEmpty() && !tipoEvento.equals("Todos")) {
                stmt.setString(paramIndex++, tipoEvento);
            }
            if (fecha != null && !fecha.isEmpty()) {
                stmt.setString(paramIndex++, fecha);
            }
            if (nombreUsuario != null && !nombreUsuario.isEmpty()) {
                stmt.setString(paramIndex++, "%" + nombreUsuario + "%");
            }
            if (rol != null && !rol.isEmpty() && !rol.equals("Todos")) {
                stmt.setString(paramIndex++, rol);
            }
            stmt.setInt(paramIndex++, tamanoPagina);
            stmt.setInt(paramIndex++, (pagina - 1) * tamanoPagina);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Date fechaEvento = null;
                try {
                    String fechaStr = rs.getString("fecha");
                    if (fechaStr != null && !fechaStr.isEmpty()) {
                        fechaEvento = sdf.parse(fechaStr);
                    }
                } catch (ParseException e) {
                    System.out.println("Error al parsear la fecha: " + e.getMessage());
                    fechaEvento = null;
                }
                eventosUsuarios.add(new eventoUsuario(
                    rs.getInt("idEvento"),
                    rs.getString("tituloEvento"),
                    rs.getString("tipoEvento"),
                    fechaEvento,
                    rs.getInt("idUsuario"),
                    rs.getString("nombreUsuario"),
                    rs.getString("emailUsuario"),
                    rs.getString("rolEnEvento")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return eventosUsuarios;
    }
//contar los eventos de un usuario
    public int contarEventosUsuarios(String titulo, String tipoEvento, String fecha, String nombreUsuario, String rol) throws SQLException {
        StringBuilder query = new StringBuilder(
            "SELECT COUNT(*) " +
            "FROM eventos E " +
            "JOIN evento_usuario EU ON E.idEvento = EU.idEvento " +
            "JOIN usuario U ON EU.idUsuario = U.idUsuario " +
            "WHERE 1=1"
        );

        if (titulo != null && !titulo.isEmpty()) {
            query.append(" AND E.tituloEvento LIKE ?");
        }
        if (tipoEvento != null && !tipoEvento.isEmpty() && !tipoEvento.equals("Todos")) {
            query.append(" AND E.tipoEvento = ?");
        }
        if (fecha != null && !fecha.isEmpty()) {
            query.append(" AND DATE(E.fecha) = ?");
        }
        if (nombreUsuario != null && !nombreUsuario.isEmpty()) {
            query.append(" AND U.nombreUsuario LIKE ?");
        }
        if (rol != null && !rol.isEmpty() && !rol.equals("Todos")) {
            query.append(" AND EU.rolEnEvento = ?");
        }

        try (Connection conn = GestorBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            int paramIndex = 1;
            if (titulo != null && !titulo.isEmpty()) {
                stmt.setString(paramIndex++, "%" + titulo + "%");
            }
            if (tipoEvento != null && !tipoEvento.isEmpty() && !tipoEvento.equals("Todos")) {
                stmt.setString(paramIndex++, tipoEvento);
            }
            if (fecha != null && !fecha.isEmpty()) {
                stmt.setString(paramIndex++, fecha);
            }
            if (nombreUsuario != null && !nombreUsuario.isEmpty()) {
                stmt.setString(paramIndex++, "%" + nombreUsuario + "%");
            }
            if (rol != null && !rol.isEmpty() && !rol.equals("Todos")) {
                stmt.setString(paramIndex++, rol);
            }

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }
    
    
    //  eliminar una asociación
    public void eliminarAsociacion(int idUsuario, int idEvento) throws SQLException {
        String sql = "DELETE FROM evento_usuario WHERE idUsuario = ? AND idEvento = ?";
        try (Connection conn = GestorBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idEvento);
            pstmt.executeUpdate();
        }
    }

    // obtrener asociacion
    public eventoUsuario obtenerAsociacionPorDatos(String tituloEvento, String nombreUsuario, String email) throws SQLException {
        String sql = "SELECT E.idEvento, E.tituloEvento, E.tipoEvento, E.fecha, U.idUsuario, U.nombreUsuario, U.emailUsuario, EU.rolEnEvento " +
                     "FROM eventos E " +
                     "JOIN evento_usuario EU ON E.idEvento = EU.idEvento " +
                     "JOIN usuario U ON EU.idUsuario = U.idUsuario " +
                     "WHERE E.tituloEvento = ? AND U.nombreUsuario = ? AND U.emailUsuario = ?";
        try (Connection conn = GestorBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tituloEvento);
            pstmt.setString(2, nombreUsuario);
            pstmt.setString(3, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Date fecha = null;
                try {
                    String fechaStr = rs.getString("fecha");
                    if (fechaStr != null && !fechaStr.isEmpty()) {
                        fecha = sdf.parse(fechaStr);
                    }
                } catch (ParseException e) {
                    System.out.println("Error al parsear la fecha: " + e.getMessage());
                    fecha = null;
                }
                return new eventoUsuario(
                    rs.getInt("idEvento"),
                    rs.getString("tituloEvento"),
                    rs.getString("tipoEvento"),
                    fecha,
                    rs.getInt("idUsuario"),
                    rs.getString("nombreUsuario"),
                    rs.getString("emailUsuario"),
                    rs.getString("rolEnEvento")
                );
            }
        }
        return null;
    }
    
}