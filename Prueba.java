/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FOX;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prueba {
    
    
    public static void main(String[] args) throws Exception{
        
        Scanner x = new Scanner(System.in);
        
        List<Dog> listDogs = new ArrayList<>();
        
        ConexionMySQL con = new ConexionMySQL();
        
        con.getConexion();
        
        //GET ALL DOGS
        
        listDogs = show();
        
        for (int i = 0; i < listDogs.size(); i++) {
            
            System.out.println(listDogs.get(i).toString());
        }
        
        //INSERTAR PERRO
        System.out.println("Escribe el id, nombre y raza");
        
        int res = insertar(x.next(), x.next());
        
        if(res == 1) System.out.println("Insercion hecha");
        
        
        //UPDATE DOGS
        System.out.println("Escribe el id del perro que quieras modificar y el nuevo nombre que vallas a poner");
        
        int resU = update(x.nextInt(), x.next());
        
        if(resU == 1) System.out.println("Actualizacion hecha");
        
        
        //DELETE DOG
        System.out.println("Escribe el id del perro que quieras borrar");
        
        int resD = delete(x.nextInt());
        
        if(resD == 1) System.out.println("Eliminacion echa");
 
    }
    
    public static int insertar(String nombre, String raza) throws Exception{
        
        String sql = "INSERT INTO dogs VALUES(NULL, ?, ?)";
        
        ConexionMySQL conexionMySQL = new ConexionMySQL();
        
        Connection con = conexionMySQL.getConexion();
        
        PreparedStatement pstmt = con.prepareStatement(sql);
        
        pstmt.setString(1, nombre);
        pstmt.setString(2, raza);
        
        int res = pstmt.executeUpdate();
        
        return res;
        
    }
    
    public static List<Dog> show() throws Exception{
        
        List<Dog> listDogs = new ArrayList<>();
        
        ConexionMySQL conexionMySQL = new ConexionMySQL();
                
        Connection con = conexionMySQL.getConexion();
        
        String sql = "SELECT * FROM dogs";
        
        PreparedStatement pstmt = con.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            
            Dog dog = new Dog(rs.getInt(1), rs.getString(2), rs.getString(3));
            
            listDogs.add(dog);
            
        }
        
        return listDogs;
        
    } 
    
    public static int update(int id ,String nombre) throws Exception{
        
        ConexionMySQL conexionMySQL = new ConexionMySQL();
                
        Connection con = conexionMySQL.getConexion();
        
        String sql = "UPDATE dogs SET nombre = ? WHERE id = ?";
        
        PreparedStatement pstmt = con.prepareStatement(sql);
        
        pstmt.setString(1, nombre);
        pstmt.setInt(2, id);
        
        int res = pstmt.executeUpdate();
        
        return res;
        
    } 
 
    public static int delete(int id) throws Exception{
        
        ConexionMySQL conexionMySQL = new ConexionMySQL();
                
        Connection con = conexionMySQL.getConexion();
        
        String sql = "DELETE FROM dogs WHERE id = ?";
        
        PreparedStatement pstmt = con.prepareStatement(sql);
        
        pstmt.setInt(1, id);
        
        int res = pstmt.executeUpdate();
        
        return res;
    }
}
