/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author usuario
 */
public class Exonerado extends TipoCliente{

    public Exonerado(String nombre) {
        super("Exonerado");
    }
    public Exonerado(
    ){}


    @Override
    public void CalcularCosto(double duracion) {
        costo=0;
        costototal=0;
    }

  
}
