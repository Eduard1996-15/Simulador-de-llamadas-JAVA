/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Eduard
 */
public class SistemaLLamada {
   
    public ArrayList<LLamada> llamadas = new ArrayList<>();
    public ArrayList<LLamada> llamadasconteo = new ArrayList<>();
    public Sector miSector;
    public static int cantllamdas;
     public void setCantllamdas(int cantllamdas) {
        this.cantllamdas = cantllamdas;
    }
      public void sePuedellamar() throws  TelefonicaException {
        if(this.llamadasconteo.size() == this.cantllamdas ){
             throw new TelefonicaException("comuniquese mas tarde  \n maxima cantidad de llamadas en el sistema ");
        }
    }
    
    public void setMiSector(Sector miSector) {
        this.miSector = miSector;
    }
    
    public ArrayList<LLamada> getLlamadas() {
        return llamadas;
    }
    
    public void  agregarLLamada( LLamada l) {
           if(!llamadas.contains(l)) {
               llamadas.add(l);
           }
           if(!llamadasconteo.contains(l)){
               llamadasconteo.add(l);
           }
    }
     public void setcantidadLLamdasxSector(int n){
            setCantllamdas(n);
    }
    void avisarpuestodisponible() {
        Fachada.getInstancia().avisar(Fachada.eventos.disponible);
    }
     
     public void avisofinllamada(){
        Fachada.getInstancia().avisar(Fachada.eventos.cortollamada);
    }
     public void avisollamadanueva(){
          Fachada.getInstancia().avisar(Fachada.eventos.nuevallamada);
     }

    void quitardeconteo(LLamada l) {
        llamadasconteo.remove(l);
    }

    public ArrayList<LLamada>  todasLasLlamadas() {
          return   llamadas ;
    }
}
