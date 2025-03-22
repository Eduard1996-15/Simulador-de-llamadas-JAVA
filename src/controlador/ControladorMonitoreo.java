/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Fachada;
import Modelo.Sector;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author eduard
 */
public class ControladorMonitoreo implements Observador {

    private Fachada modelo = Fachada.getInstancia();
    private VistaMonitoreo vista;

    public ControladorMonitoreo(VistaMonitoreo vista) {
        this.vista = vista;
        modelo.agregarObservador(this);
    }
    public void salir(){
        modelo.quitarObservador(this);
        vista.salir();
    }
    
    public void buscarSectorString(String nom) {
        if(nom == "todos"){
            vista.mostrarLlamadasTodos(modelo.todasLasLlamadasAtendidas());
        }
        Sector s = modelo.buscarSectorString(nom);  
        if(s!=null){
        vista.mostrarLlamadas(s.getLlamadasAtendidas());
        }
    }

    public void capturarValorActual(){
        vista.dameElValor();
    
    }
      
    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Fachada.eventos.cortollamada)){
            capturarValorActual();
        }
    }
    
}
