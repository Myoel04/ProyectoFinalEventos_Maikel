/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import controlador.GestorBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import modelo.Usuario;

/**
 *
 * @author yosoy
 */
public class UsuarioDAO {
    
    //metodo de agregar nuevo usuario
    public void insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombreUsuario, emailUsuario, contrasena, rol) VALUES (?, ?, ?, ?)";
        try (Connection conn = GestorBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getEmailUsuario());
            pstmt.setString(3, usuario.getContrasena());
            pstmt.setString(4, usuario.getRol());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar el usuario: " + e.getMessage());
        }
    }

    //metodo para obtener un usuario
    public Usuario obtenerUsuario(int id) {
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        Usuario usuario = null;
        try (Connection conn = GestorBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("nombreUsuario"),
                    rs.getString("emailUsuario"),
                    rs.getString("contrasena"),
                    rs.getString("rol")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el usuario: " + e.getMessage());
        }
        return usuario;
    }

  public void actualizarUsuario(Usuario usuario) {
    String sql = "UPDATE usuario SET nombreUsuario = ?, emailUsuario = ?, rol = ? WHERE idUsuario = ?";
    if (usuario.getContrasena() != null && !usuario.getContrasena().isEmpty()) {
        sql = "UPDATE usuario SET nombreUsuario = ?, emailUsuario = ?, contrasena = ?, rol = ? WHERE idUsuario = ?";
    }

    try (Connection conn = GestorBD.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, usuario.getNombreUsuario());
        pstmt.setString(2, usuario.getEmailUsuario());
        int paramIndex = 3;
        if (usuario.getContrasena() != null && !usuario.getContrasena().isEmpty()) {
            pstmt.setString(3, usuario.getContrasena()); // Actualizar contraseña
            pstmt.setString(4, usuario.getRol());
            pstmt.setInt(5, usuario.getIdUsuario());
        } else {
            pstmt.setString(3, usuario.getRol());
            pstmt.setInt(4, usuario.getIdUsuario());
        }
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al actualizar el usuario: " + e.getMessage());
    }
}
//metodo para eliminar usuario
    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE idUsuario = ?";
        try (Connection conn = GestorBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }
    
    // Método para validar inicio de sesión por email y devolver el objeto Usuario completo
    public Usuario autenticarUsuarioConId(String email, String contrasena) {
        String sql = "SELECT idUsuario, nombreUsuario, emailUsuario, contrasena, rol FROM usuario WHERE emailUsuario = ? AND contrasena = ?";
        try (Connection conn = GestorBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, contrasena);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("nombreUsuario"),
                    rs.getString("emailUsuario"),
                    rs.getString("contrasena"),
                    rs.getString("rol")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al autenticar el usuario: " + e.getMessage());
        }
        return null;
    }
    
  // Método para validar inicio de sesión por email
public String validarUsuarioPorEmail(String email, String contrasena) {
    try (Connection conn = GestorBD.conectar();
         PreparedStatement pstmt = conn.prepareStatement("SELECT rol FROM usuario WHERE emailUsuario = ? AND contrasena = ?")) {
        
        pstmt.setString(1, email);
        pstmt.setString(2, contrasena); // En una aplicación real, deberías hashear esta contraseña
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            return rs.getString("rol");
        }
    } catch (SQLException e) {
        System.out.println("Error al validar el usuario por email: " + e.getMessage());
    }
    return null;
}

    
    //metodo para registrar un nuevo usuario
 public boolean registrarUsuario(String usuario, String correo, String contraseña, String rol) {
    try (Connection conn = GestorBD.conectar();
         PreparedStatement pstmt = conn.prepareStatement("INSERT INTO usuario (nombreUsuario, emailUsuario, contrasena, rol) VALUES (?, ?, ?, ?)")) {
        pstmt.setString(1, usuario);
        pstmt.setString(2, correo);
        pstmt.setString(3, contraseña);
        pstmt.setString(4, rol);
        int resultado = pstmt.executeUpdate();
        return resultado > 0;
    } catch (SQLException e) {
        System.out.println("Error al registrar el usuario: " + e.getMessage());
        return false;
    }
}

 //datos de tabla usuario
public List<Usuario> obtenerUsuariosParaTabla(JTable tUsuarios) {
    List<Usuario> usuarios = new ArrayList<>();
    String sql = "SELECT idUsuario, nombreUsuario, emailUsuario, rol FROM usuario";
    try (Connection conn = GestorBD.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
        while (rs.next()) {
            Usuario usuario = new Usuario(
                rs.getInt("idUsuario"),
                rs.getString("nombreUsuario"),
                rs.getString("emailUsuario"),
                null, // No necesitas la contraseña para esta vista
                rs.getString("rol")
            );
            usuarios.add(usuario);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener los usuarios para la tabla: " + e.getMessage());
    }
    return usuarios;
}


   // Método corregido para buscar usuarios con filtros
    public List<Usuario> buscarUsuarios(String nombre, String rol) throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT idUsuario, nombreUsuario, emailUsuario, rol FROM usuario WHERE 1=1");

        if (nombre != null && !nombre.isEmpty()) {
            query.append(" AND nombreUsuario LIKE ?");
        }
        if (rol != null && !rol.isEmpty() && !rol.equals("Todos")) {
            query.append(" AND rol = ?");
        }

        try (Connection conn = GestorBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            int paramIndex = 1;
            if (nombre != null && !nombre.isEmpty()) {
                stmt.setString(paramIndex++, "%" + nombre + "%");
            }
            if (rol != null && !rol.isEmpty() && !rol.equals("Todos")) {
                stmt.setString(paramIndex++, rol);
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setEmailUsuario(rs.getString("emailUsuario"));
                usuario.setRol(rs.getString("rol"));
                usuarios.add(usuario);
            }
            return usuarios;
        }
    }

    // Método para buscar usuarios con paginación
    public List<Usuario> buscarUsuariosPaginados(String nombre, String rol, int pagina, int tamanoPagina) throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT idUsuario, nombreUsuario, emailUsuario, rol FROM usuario WHERE 1=1");

        if (nombre != null && !nombre.isEmpty()) {
            query.append(" AND nombreUsuario LIKE ?");
        }
        if (rol != null && !rol.isEmpty() && !rol.equals("Todos")) {
            query.append(" AND rol = ?");
        }
        query.append(" LIMIT ? OFFSET ?");

        try (Connection conn = GestorBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            int paramIndex = 1;
            if (nombre != null && !nombre.isEmpty()) {
                stmt.setString(paramIndex++, "%" + nombre + "%");
            }
            if (rol != null && !rol.isEmpty() && !rol.equals("Todos")) {
                stmt.setString(paramIndex++, rol);
            }
            stmt.setInt(paramIndex++, tamanoPagina);
            stmt.setInt(paramIndex++, (pagina - 1) * tamanoPagina);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setEmailUsuario(rs.getString("emailUsuario"));
                usuario.setRol(rs.getString("rol"));
                usuarios.add(usuario);
            }
            return usuarios;
        }
    }

    // Método para contar el total de usuarios con los filtros aplicados
    public int contarUsuarios(String nombre, String rol) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM usuario WHERE 1=1");

        if (nombre != null && !nombre.isEmpty()) {
            query.append(" AND nombreUsuario LIKE ?");
        }
        if (rol != null && !rol.isEmpty() && !rol.equals("Todos")) {
            query.append(" AND rol = ?");
        }

        try (Connection conn = GestorBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            int paramIndex = 1;
            if (nombre != null && !nombre.isEmpty()) {
                stmt.setString(paramIndex++, "%" + nombre + "%");
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
    
}
