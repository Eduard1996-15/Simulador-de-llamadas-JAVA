/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Fachada;
import Modelo.PuestoTrabajo;
import Modelo.TelefonicaException;
import Modelo.Trabajador;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author Eduard
 */
public class ControladorAtender implements Observador {
    public Trabajador t;
    public VistaAtender va;
    private Fachada modelo = Fachada.getInstancia();
   
    
    
    public ControladorAtender(VistaAtender v, Trabajador tr){
        this.va=v;
        this.t=tr; 
        modelo.agregarObservador(this);  
        disponibleparaAtenderLlamadas(t);
    }
    //
    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Fachada.eventos.nuevallamada)){
            verificarmiPuesto();
        }else if(evento.equals(Fachada.eventos.cortollamada)){
            verificarmiPuesto();
        }
    }

    private void disponibleparaAtenderLlamadas(Trabajador t) {
        va.MostrarDatosComun(t,t.mipuesto.calcularPromedioSegundos());
    }
    

    public void salir(){
        Fachada.getInstancia().logout(t);
        modelo.quitarObservador(this);
        va.salga();
    }

    public void quieroSalir() throws TelefonicaException {
        //ver si hay llamada
            t.mipuesto.hayLLamada();
    }

    public void mandasalir() {
        finalizarLLamada(t);
        modelo.quitarPuesto(t);
        this.salir();
    }

      void finalizarLLamada(Trabajador t) {
        modelo.finalizarLLmada(t);
    }
      
      void solofinalizarllamdayseguirdisponible(){
           modelo.finalizarLLmada(t);
      }

    private void verificarmiPuesto() {
        if(t.mipuesto.tengollamadaEnEsteMomento()){
            va.recibirllamada(t.mipuesto.getActual());
        }else{
            modelo.avisaryliberarpuestodisponible(t);
            disponibleparaAtenderLlamadas(t);
        }
    }

    public void salirycortarllamada() {
        solofinalizarllamdayseguirdisponible();
    }
    
}
