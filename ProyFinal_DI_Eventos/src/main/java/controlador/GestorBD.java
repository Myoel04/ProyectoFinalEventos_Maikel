package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;

public class GestorBD {
    
    public static Connection conectar() {
        String url = "jdbc:sqlite:./eventos.db"; // Ruta relativa al directorio de trabajo
        Connection conn = null;
        
        try {
            // Verifica si el archivo de la base de datos existe
            File dbFile = new File("eventos.db");
            if (!dbFile.exists()) {
                System.err.println("El archivo de base de datos 'eventos.db' no existe en: " + dbFile.getAbsolutePath());
                return null;
            }
            
            // Intenta establecer la conexión
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión a SQLite establecida correctamente en: " + dbFile.getAbsolutePath());
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        
        return conn;
    }
}