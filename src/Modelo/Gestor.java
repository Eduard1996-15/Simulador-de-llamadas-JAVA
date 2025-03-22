/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author eduard
 */
public class Gestor extends TipoCliente{

    public Gestor(String nombre) {
        super("Gestor");
    }
    public Gestor(){}

   
    @Override
    public void CalcularCosto(double duracion) {
        /*Pagan la mitad del costo fijo de la llamada, y al costo total de la llamada se le
        descuenta el valor de un costo fijo por cada segundo transcurrido entre que inició la
        llamada y esta fue atendida. Pero si la duración de la llamada (desde que fue atendida) es
        mayor a 3 minutos pagan el costo fijo de la llamada.*/

        costofijo = costofijo/2;
        double descuento = costofijo*(duracion);
        if(duracion > 180){//si es mayor a 3 min
            this.costo = Math.abs(duracion*costofijo);//pagacostofijo
        }else
        {
            costofijo-=descuento;//aplico el descuento al total
            this.costo=   Math.abs(costofijo*duracion);//calculo el valor
        }
        this.costototal+=costo;
    }

  
    
}
