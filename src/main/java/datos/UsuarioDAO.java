/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.Persona;
import domain.Usuario;
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
public class UsuarioDAO {
     private static final String SQL_SELECT="select * from usuario";
    private static final String SQL_INSERT = "insert into usuario(usuario, password) values(?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario set usuario = ? , password = ? where idusuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE idusuario = ?";
    
    public List<Usuario> seleccionar(){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario usuario= null;
        List<Usuario> usuarios= new ArrayList<>();
        
        try {
            conn = getConnection();
            pst = conn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {                
                int idusuario = rs.getInt("idusuario");
                String Usuario = rs.getString("usuario");
                String password = rs.getString("password");
                
                usuario = new Usuario(idusuario, Usuario, password);
                usuarios.add(usuario);
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
        return usuarios;    
    }
    
    public int insertar(Usuario usuario){
        Connection conn = null;
        PreparedStatement pst = null;
        int registros = 0;
        try {
            conn = getConnection();
            pst = conn.prepareStatement(SQL_INSERT);
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getPassword());
            
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
     public int actualizar(Usuario usuario){
        Connection conn = null;
        PreparedStatement pst = null;
        int registros = 0;
        try {
            conn = getConnection();
            pst = conn.prepareStatement(SQL_UPDATE);
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getPassword());
            pst.setInt(3, usuario.getIdUsuario());
            
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
     
      public int eliminar(Usuario usuario){
        Connection conn = null;
        PreparedStatement pst = null;
        int registros = 0;
        try {
            conn = getConnection();
            pst = conn.prepareStatement(SQL_DELETE);
            pst.setInt(1, usuario.getIdUsuario());
            
            
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
