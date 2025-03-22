/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Cliente;
import Modelo.Fachada;
import Modelo.LLamada;
import Modelo.PuestoTrabajo;
import Modelo.Sector;
import Modelo.TelefonicaException;
import Modelo.Trabajador;
import javax.swing.JOptionPane;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author Eduard
 */
public class ControladorSimular implements Observador {
    
    
   
    public VistaSimular vs;
    public LLamada llamada = new LLamada();
    public Cliente c;
    public Sector s;
    private Fachada modelo = Fachada.getInstancia();
    
    
     public ControladorSimular(VistaSimular v){
        this.vs=v;
        modelo.agregarObservador(this);
        //cargarDatos();
       // modelo.aviso();
    }

    @Override
    public void actualizar(Object evento, Observable origen)  {
         if(evento.equals(Fachada.eventos.cortollamada)){
            llamadafinalizada();
        }if(evento.equals(Fachada.eventos.disponible)){
           Estoyatendido();
        }
    }

    private void llamadafinalizada()  {
        if(llamada.MiEstado() && !llamada.estyAtendido() ){
           vs.mostrarmensaje(llamada.getDuracionSegundos(), llamada.cliente.tipo.getCosto(),llamada.cliente.tipo.costototal);
        }
        modelo.avisardisponible();
    }

    public void buscarSector(int num)  {
          try{
           this.s= modelo.buscarSector(num);
           modelo.sePuedellamar(s);
           llamada.sector=s.getNumero();
           quierollamar();
            //llamar();
        }catch(TelefonicaException ex){
           vs.mensaje(ex.getMessage());
        }
    }



    public void buscarCliente(String cedula){
         c = new Cliente();
         try {
            c= modelo.buscarCliente(cedula);  
            llamada.setCliente(c);
         vs.ListarSectores(modelo.getsSector());  
        } catch (TelefonicaException ex) {
            vs.mensaje(ex.getMessage());
        }
        
    }

    public void cortarllamda(){
        if(llamada.estyAtendido()){
         modelo.salirCliente(llamada.trabajador);
        }
    }
    public void salir() {
        if(!llamada.MiEstado()){
         modelo.salirCliente(llamada.trabajador);
        }
        modelo.quitarObservador(this);
         vs.salga();
    }
    
    public void quierollamar() {
       llamar(s);
       
    }
    
    public void llamar(Sector s)  {
        if(s!=null){
            llamada =  s.derivarllamada(llamada);
            if(llamada.estyAtendido()){
                vs.mensajeCentral(llamada.trabajador.getNombre()  , s.getNombre(),llamada.fechaHoraIicio);
                modelo.avisarllamadaentrante();
            }
            else{
                vs.mensajeCentralEspera(s.getTiempopromedio(), s.getLlamadasEnEspera().size());
            }
              modelo.agregarllamadasistema(llamada);
        }
    }

    private void Estoyatendido() {
        if(!llamada.MiEstado() && !llamada.estyAtendido()){
            llamar(s);
        }
    }

}
