/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Romel
 */
public class PersonaDAO {
    private static final String SQL_SELECT="select * from persona";
    private static final String SQL_INSERT = "insert into persona(nombre, apellido, email, telefono) values(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona set nombre = ? , apellido = ?, email = ?, telefono = ? where idPersona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idPersona = ?";
    
    public List<Persona> seleccionar(){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Persona persona= null;
        List<Persona> personas= new ArrayList<>();
        
        try {
            conn = getConnection();
            pst = conn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {                
                int idPersona = rs.getInt("idPersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(rs);
                close(pst);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return personas;    
    }
    
    public int insertar(Persona persona){
        Connection conn = null;
        PreparedStatement pst = null;
        int registros = 0;
        try {
            conn = getConnection();
            pst = conn.prepareStatement(SQL_INSERT);
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido());
            pst.setString(3, persona.getEmial());
            pst.setString(4, persona.getTelefono());
            
            registros = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{            
            try {
                close(pst);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out); 
            }            
        }
        return registros;        
    }
     public int actualizar(Persona persona){
        Connection conn = null;
        PreparedStatement pst = null;
        int registros = 0;
        try {
            conn = getConnection();
            pst = conn.prepareStatement(SQL_UPDATE);
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido());
            pst.setString(3, persona.getEmial());
            pst.setString(4, persona.getTelefono());
            pst.setInt(5, persona.getIdPersona());
            
            registros = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{            
            try {
                close(pst);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out); 
            }            
        }
        return registros;        
    }
     
      public int eliminar(Persona persona){
        Connection conn = null;
        PreparedStatement pst = null;
        int registros = 0;
        try {
            conn = getConnection();
            pst = conn.prepareStatement(SQL_DELETE);
            pst.setInt(1, persona.getIdPersona());
            
            
            registros = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{            
            try {
                close(pst);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out); 
            }            
        }
        return registros;        
    }
}
