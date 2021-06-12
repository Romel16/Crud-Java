/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

/**
 *
 * @author Romel
 */
public class testPersona {
    public static void main(String[] args) {
        PersonaDAO personaDAO= new PersonaDAO();
        
        
//        //Insertar un nuevo objeto de tipo Persona
//        Persona personaNueva = new Persona("Carlos", "Esparza", "car@gamil.com", "0987654");
//        personaDAO.insertar(personaNueva);
//        
//          //Modificamos un objeto de persona existente
//          Persona personaModificar = new Persona(3, "Juan Carlos", "Esparza", "jcesparza@gmail.com","6543217");
//          personaDAO.actualizar(personaModificar);

            Persona personaEliminar = new Persona(3);
            personaDAO.eliminar(personaEliminar);
          
        
        List<Persona> personas = personaDAO.seleccionar();
//        for (Persona persona : personas) {
//            System.out.println("persona: "+ persona);
//        }
//        
        personas.forEach(persona -> {
            System.out.println("persona: "+ persona);
        });
    }
}
