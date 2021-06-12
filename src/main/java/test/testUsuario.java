/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;



/**
 *
 * @author Romel
 */
public class testUsuario {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        
//        //Insertar un nuevo objeto de tipo uuario
//        Usuario usuarioNuevo = new Usuario("Rosalia", "teAmo");
//        usuarioDAO.insertar(usuarioNuevo);

//           //Modificar un objeto de usuario existente
//           Usuario usuarioModificado = new Usuario(3, "Jorge", "9876");
//           usuarioDAO.actualizar(usuarioModificado);


        //Eliminar un elemento de la base de datos
        Usuario usuarioEliminado = new Usuario(4);
        usuarioDAO.eliminar(usuarioEliminado);
        
        
        List<Usuario> usuarios = usuarioDAO.seleccionar();
        
        usuarios.forEach(usuario -> {
            System.out.println("usuario: "+ usuario);
        });
    }
}
