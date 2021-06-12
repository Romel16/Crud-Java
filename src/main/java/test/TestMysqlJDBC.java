/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Romel
 */
public class TestMysqlJDBC {
    public static void main(String[] args) {
        var uri= "jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=CONVERT_TO_NULL";
        //String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //para web
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(uri, "root", "1234");
            Statement instruccion = conexion.createStatement();
            var sql = "select * from Persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {                
                System.out.println("ID Persona: "+ resultado.getInt("idPersona"));
                System.out.print(" nombre de Persona: "+ resultado.getString("nombre"));
                System.out.print(" apellido de Persona: "+ resultado.getString("apellido"));
                System.out.print(" email de Persona: "+ resultado.getString("email"));
                System.out.print(" telefono de Persona: "+ resultado.getString("telefono"));
                System.out.println("");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
