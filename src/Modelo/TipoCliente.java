/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author eduard
 */
public abstract class TipoCliente {
        
    public String nombre;
    public  double costo;
    public  double costototal;
    

    public double getCosto() {
        return costo;
    }

    public static double costofijo=1;

   

      void setCostofijo(double costofijo) {
        TipoCliente.costofijo = costofijo;
    }

    public TipoCliente(String nombre) {
        this.nombre = nombre;
    }
    
     public TipoCliente() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public  abstract void  CalcularCosto( double duracion);

   
}
