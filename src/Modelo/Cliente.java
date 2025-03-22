/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author eduard
 */
public class Cliente extends Usuario{
    
    public TipoCliente tipo;
    public Cliente(String cedula, String nombre, TipoCliente tip) {
        super(cedula, nombre);
        this.tipo=tip;

    }
     public Cliente(){
     }

     public double getcosto(){
            return  tipo.getCosto();
     }
     
      public double getcostoTotal(){
            return  tipo.costototal;
     }
    @Override
    public boolean validar() {
        return (this.cedula.length() > 7 && this.nombre.length() > 3 && tipo != null);
    }
    
     public void cambiarTipo(TipoCliente tc){
            this.tipo = tc;
    }


    
    
}
