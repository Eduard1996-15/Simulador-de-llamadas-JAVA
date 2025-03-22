/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author eduard
 */
public class SistemaSector {
    
    ArrayList<Sector> sectores = new ArrayList();
    ArrayList<PuestoTrabajo> puestos = new ArrayList();
    
    
    public void agregarSector(Sector s){
        sectores.add(s);
    } 

    public ArrayList<Sector> getSectores() {
        return sectores;
    }

     
     public void agregarPuesto(PuestoTrabajo p){
         puestos.add(p);
         for(Sector s: sectores){
             s.crearPuesto(p.nombre,p.numero);
         }
    }
    

    Trabajador agregarTrabajador(Trabajador t, int numSector) {
         Trabajador tr = t;
        for(Sector s:sectores){
           if(s.numero==numSector){
               tr.misector=s;
               s.aregarTrabajador(tr);
               return t;
           }
        }
        return t;
    }
    
    boolean asignarPuesto(Trabajador t){
        return t.misector.asignarPuesto(t);
    }
    
    void quitarPuesto(Trabajador t){
         t.misector.quitarPuesto(t);
    }

   public void noHayPuesto(Sector s) throws TelefonicaException{
       s.Nohaypuesto();
   }

   public  void finalizarllamada(Trabajador t) {
       if(t.misector!=null)
        t.misector.finllamada(t);
    }

    

    public Sector buscarSector(int num) throws TelefonicaException {
        for(Sector s:sectores){
            if(s.numero == num){
                s.hayTrabajadores();
                return s;
            }
        }
        throw  new TelefonicaException("Sector no válido");
    }
    
   public LLamada derivarllamada(Sector s,LLamada l) {
      return  s.derivarllamada(l);
   }

    

   
//si trabaja con atributos que vienen hacerlo en controlador
  

    void liberarPuesto(Trabajador t) {
        t.misector.liberarPuesto(t);
    }

    public Sector buscarSectorString(String nom) {
       for(Sector s:sectores){
            if(s.nombre == nom){
                return s;
            }
        }
        return null;
    }

    
    
   
}
