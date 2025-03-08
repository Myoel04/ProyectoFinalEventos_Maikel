/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author yosoy
 */
public class GestorBD {
    
    public static Connection conectar(){
        
        String url = "jdbc:sqlite:./src/basedatos/eventos.db";
        
      Connection conn = null;
        try {
            // Crea una conexión a la base de datos
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión a SQLite establecida.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conn;
    }
    
    }
    

