/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

/**
 *
 * @author usuario
 */
public abstract class Usuario implements Validar{
    public String cedula;
    public String nombre;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
    public Usuario(){ 
    }
    
    public Usuario(String cedula){
        this.cedula = cedula;
    }
    
    
}
