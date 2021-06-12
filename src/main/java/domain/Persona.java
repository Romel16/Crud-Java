/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Romel
 */
public class Persona {
    private int idPersona;
    private String nombre;
    private String apellido;
    private String emial;
    private String telefono;

    public Persona() {
    }

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(String nombre, String apellido, String emial, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.emial = emial;
        this.telefono = telefono;
    }

    public Persona(int idPersona, String nombre, String apellido, String emial, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.emial = emial;
        this.telefono = telefono;
    }
        
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", emial=" + emial + ", telefono=" + telefono + '}';
    }
    
    
}
