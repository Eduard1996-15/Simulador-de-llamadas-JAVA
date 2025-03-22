/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author eduard
 */
public class ConCosto extends TipoCliente{

    public ConCosto(String nombre) {
        super("Con Costos");
    }

    @Override
    public void CalcularCosto( double duracion) {
        /*Pagan el costo fijo de la llamada si el tiempo de espera entre que se inició la
        llamada y fue atendida, es menor a 1 minuto. Si es mayor pagan la mitad del costo fijo.*/
        if(duracion >0){
          if(duracion > 59){
               costo= Math.abs(costofijo/2)*duracion;
               
            
          }else{
                costo= Math.abs(costofijo*duracion);
          
          }
        }
        costototal+=costo;
    }
    

}
