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
import modelo.Evento;

public class EventoDAO {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void insertarEvento(Evento evento) {
    String sql = "INSERT INTO Eventos (tituloEvento, descripcion, fecha, capacidadMax, tipoEvento, ubicacion) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection conn = GestorBD.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, evento.getTituloEvento());
        pstmt.setString(2, evento.getDescripcion());
        pstmt.setString(3, evento.getFecha() != null ? sdf.format(evento.getFecha()) : null);
        pstmt.setInt(4, evento.getCapacidadMax());
        pstmt.setString(5, evento.getTipoEvento());
        pstmt.setString(6, evento.getUbicacion()); // Añadir la ubicación
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al insertar el evento: " + e.getMessage());
    }
}

    public Evento obtenerEvento(int id) {
        String sql = "SELECT * FROM Eventos WHERE idEvento = ?";
        Evento evento = null;
        try (Connection conn = GestorBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
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
                evento = new Evento(
                        rs.getInt("idEvento"),
                        rs.getString("tituloEvento"),
                        rs.getString("descripcion"),
                        rs.getString("ubicacion"),
                        fecha,
                        rs.getInt("capacidadMax"),
                        rs.getString("tipoEvento")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el evento: " + e.getMessage());
        }
        return evento;
    }

  public void actualizarEvento(Evento evento) {
    String sql = "UPDATE Eventos SET tituloEvento = ?, descripcion = ?, fecha = ?, capacidadMax = ?, tipoEvento = ?, ubicacion = ? WHERE idEvento = ?";
    try (Connection conn = GestorBD.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, evento.getTituloEvento());
        pstmt.setString(2, evento.getDescripcion());
        pstmt.setString(3, evento.getFecha() != null ? sdf.format(evento.getFecha()) : null);
        pstmt.setInt(4, evento.getCapacidadMax());
        pstmt.setString(5, evento.getTipoEvento());
        pstmt.setString(6, evento.getUbicacion()); // Añadir la ubicación
        pstmt.setInt(7, evento.getIdEvento());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al actualizar el evento: " + e.getMessage());
    }
}

    public void eliminarEvento(int id) {
        String sql = "DELETE FROM Eventos WHERE idEvento = ?";
        try (Connection conn = GestorBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el evento: " + e.getMessage());
        }
    }

    public List<Evento> buscarEventos(String titulo, String fecha, String tipoEvento) throws SQLException {
        List<Evento> eventos = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT idEvento, tituloEvento, descripcion, ubicacion, fecha, tipoEvento FROM Eventos WHERE 1=1");

        if (titulo != null && !titulo.isEmpty()) {
            query.append(" AND tituloEvento LIKE ?");
        }
        if (fecha != null && !fecha.isEmpty()) {
            query.append(" AND DATE(fecha) = ?");
        }
        if (tipoEvento != null && !tipoEvento.isEmpty() && !tipoEvento.equals("Todos")) {
            query.append(" AND tipoEvento = ?");
        }

        try (Connection conn = GestorBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            int paramIndex = 1;
            if (titulo != null && !titulo.isEmpty()) {
                stmt.setString(paramIndex++, "%" + titulo + "%");
            }
            if (fecha != null && !fecha.isEmpty()) {
                stmt.setString(paramIndex++, fecha);
            }
            if (tipoEvento != null && !tipoEvento.isEmpty() && !tipoEvento.equals("Todos")) {
                stmt.setString(paramIndex++, tipoEvento);
            }

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
                Evento evento = new Evento();
                evento.setIdEvento(rs.getInt("idEvento"));
                evento.setTituloEvento(rs.getString("tituloEvento"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setUbicacion(rs.getString("ubicacion"));
                evento.setFecha(fechaEvento);
                evento.setTipoEvento(rs.getString("tipoEvento"));
                eventos.add(evento);
            }
            return eventos;
        }
    }

    public List<Evento> buscarEventosPaginados(String titulo, String fecha, String tipoEvento, int pagina, int tamanoPagina) throws SQLException {
        List<Evento> eventos = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT idEvento, tituloEvento, descripcion, ubicacion, fecha, tipoEvento FROM Eventos WHERE 1=1");

        if (titulo != null && !titulo.isEmpty()) {
            query.append(" AND tituloEvento LIKE ?");
        }
        if (fecha != null && !fecha.isEmpty()) {
            query.append(" AND DATE(fecha) = ?");
        }
        if (tipoEvento != null && !tipoEvento.isEmpty() && !tipoEvento.equals("Todos")) {
            query.append(" AND tipoEvento = ?");
        }
        query.append(" LIMIT ? OFFSET ?");

        try (Connection conn = GestorBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            int paramIndex = 1;
            if (titulo != null && !titulo.isEmpty()) {
                stmt.setString(paramIndex++, "%" + titulo + "%");
            }
            if (fecha != null && !fecha.isEmpty()) {
                stmt.setString(paramIndex++, fecha);
            }
            if (tipoEvento != null && !tipoEvento.isEmpty() && !tipoEvento.equals("Todos")) {
                stmt.setString(paramIndex++, tipoEvento);
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
                Evento evento = new Evento();
                evento.setIdEvento(rs.getInt("idEvento"));
                evento.setTituloEvento(rs.getString("tituloEvento"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setUbicacion(rs.getString("ubicacion"));
                evento.setFecha(fechaEvento);
                evento.setTipoEvento(rs.getString("tipoEvento"));
                eventos.add(evento);
            }
            return eventos;
        }
    }

    public int contarEventos(String titulo, String fecha, String tipoEvento) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM Eventos WHERE 1=1");

        if (titulo != null && !titulo.isEmpty()) {
            query.append(" AND tituloEvento LIKE ?");
        }
        if (fecha != null && !fecha.isEmpty()) {
            query.append(" AND DATE(fecha) = ?");
        }
        if (tipoEvento != null && !tipoEvento.isEmpty() && !tipoEvento.equals("Todos")) {
            query.append(" AND tipoEvento = ?");
        }

        try (Connection conn = GestorBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            int paramIndex = 1;
            if (titulo != null && !titulo.isEmpty()) {
                stmt.setString(paramIndex++, "%" + titulo + "%");
            }
            if (fecha != null && !fecha.isEmpty()) {
                stmt.setString(paramIndex++, fecha);
            }
            if (tipoEvento != null && !tipoEvento.isEmpty() && !tipoEvento.equals("Todos")) {
                stmt.setString(paramIndex++, tipoEvento);
            }

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }
    
    public List<Evento> buscarEventosPorUsuarioPaginados(String titulo, String tipoEvento, int pagina, int tamanoPagina, int idUsuario) throws SQLException {
        List<Evento> eventos = new ArrayList<>();
        StringBuilder query = new StringBuilder(
            "SELECT e.idEvento, e.tituloEvento, e.descripcion, e.ubicacion, e.fecha, e.tipoEvento " +
            "FROM Eventos e " +
            "INNER JOIN evento_usuario eu ON e.idEvento = eu.idEvento " +
            "WHERE eu.idUsuario = ?"
        );

        if (titulo != null && !titulo.isEmpty()) {
            query.append(" AND e.tituloEvento LIKE ?");
        }
        if (tipoEvento != null && !tipoEvento.isEmpty() && !tipoEvento.equals("Todos")) {
            query.append(" AND e.tipoEvento = ?");
        }
        query.append(" LIMIT ? OFFSET ?");

        try (Connection conn = GestorBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            int paramIndex = 1;
            stmt.setInt(paramIndex++, idUsuario);
            if (titulo != null && !titulo.isEmpty()) {
                stmt.setString(paramIndex++, "%" + titulo + "%");
            }
            if (tipoEvento != null && !tipoEvento.isEmpty() && !tipoEvento.equals("Todos")) {
                stmt.setString(paramIndex++, tipoEvento);
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
                Evento evento = new Evento();
                evento.setIdEvento(rs.getInt("idEvento"));
                evento.setTituloEvento(rs.getString("tituloEvento"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setUbicacion(rs.getString("ubicacion"));
                evento.setFecha(fechaEvento);
                evento.setTipoEvento(rs.getString("tipoEvento"));
                eventos.add(evento);
            }
            return eventos;
        }
    }

    public int contarEventosPorUsuario(String titulo, String tipoEvento, int idUsuario) throws SQLException {
        StringBuilder query = new StringBuilder(
            "SELECT COUNT(*) " +
            "FROM Eventos e " +
            "INNER JOIN evento_usuario eu ON e.idEvento = eu.idEvento " +
            "WHERE eu.idUsuario = ?"
        );

        if (titulo != null && !titulo.isEmpty()) {
            query.append(" AND e.tituloEvento LIKE ?");
        }
        if (tipoEvento != null && !tipoEvento.isEmpty() && !tipoEvento.equals("Todos")) {
            query.append(" AND e.tipoEvento = ?");
        }

        try (Connection conn = GestorBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            int paramIndex = 1;
            stmt.setInt(paramIndex++, idUsuario);
            if (titulo != null && !titulo.isEmpty()) {
                stmt.setString(paramIndex++, "%" + titulo + "%");
            }
            if (tipoEvento != null && !tipoEvento.isEmpty() && !tipoEvento.equals("Todos")) {
                stmt.setString(paramIndex++, tipoEvento);
            }

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }
    
    public int contarAsistentesActuales(int idEvento) throws SQLException {
        String sql = "SELECT COUNT(*) FROM evento_usuario WHERE idEvento = ?";
        try (Connection conn = GestorBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idEvento);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
    
}