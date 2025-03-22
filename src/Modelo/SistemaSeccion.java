/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author eduard
 */
public class SistemaSeccion {
    
     ArrayList<Trabajador> trabajadores = new ArrayList();
      private ArrayList<Trabajador> conectados = new ArrayList();
     
     public void agregarTrabajador(Trabajador t){
        trabajadores.add(t);
    }
          
    public Trabajador login(String cedula,String pwd) {
          Trabajador tlog = new Trabajador(cedula,pwd);
          if(!conectados.contains(tlog)){
              for(Trabajador t : trabajadores){       
                if(t.equals(tlog)){
                     conectados.add(t);
                    return t;//login sucefull
                } 
             }
          }
        
        return null;//login incorrect
    }
    
    
     public ArrayList<Trabajador> getConectados() {
        return conectados;
    }
     
       public void logout(Trabajador s){
        conectados.remove(s);
    }
}
