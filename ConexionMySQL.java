/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FOX;

import java.sql.*;

public class ConexionMySQL {
    
    
    String url = "jdbc:mysql://uzgkzvrgoomqtjrd:DYeBOGm7sfS2JqSAyXfx@bbk1jb6ydvdh4iq2jlkj-mysql.services.clever-cloud.com:3306/bbk1jb6ydvdh4iq2jlkj";
    String user = "uzgkzvrgoomqtjrd";
    String password = "DYeBOGm7sfS2JqSAyXfx";
    

    public Connection getConexion() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conn;
    }
        
       
}
