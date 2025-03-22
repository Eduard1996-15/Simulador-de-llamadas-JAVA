/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import observador.Observable;

/**
 *
 * @author 59892
 */
public class Fachada extends Observable {
    
    private SistemaLLamada sLlamada = new SistemaLLamada();
    private SistemaSeccion sSeccion = new SistemaSeccion();
    private SistemaSector  sSector  = new SistemaSector();
    private SistemaCliente sCliente = new SistemaCliente();
    
    private static Fachada instancia = new Fachada();

    public void finalizarLLmada(Trabajador t) {
        if(t.mipuesto!=null){
       sLlamada.quitardeconteo(t.mipuesto.llamadaActual);
       sSector.finalizarllamada(t); 
       sLlamada.avisofinllamada();}
       
    }

    public void salirCliente(Trabajador t ) {
        finalizarLLmada(t);
    }

   

    public void avisaryliberarpuestodisponible(Trabajador t) {
        sSector.liberarPuesto(t);
       
    }

    public void avisarllamadaentrante() {
        sLlamada.avisollamadanueva();
    }

    public Sector buscarSectorString(String nom) {
       return  sSector.buscarSectorString(nom);  
        }
     
    public ArrayList<LLamada> todasLasLlamadasAtendidas(){
        return sLlamada.todasLasLlamadas();
    }
   


    public enum eventos{
        nuevallamada,cortollamada,disponible;
    }
    
    public static Fachada getInstancia() {
        return instancia;
    }
    
    private Fachada(){
    }
    
    public void agregarTrabajador(Trabajador t) {
        t = sSector.agregarTrabajador(t,t.numSector);
        sSeccion.agregarTrabajador(t);
        
    }
    
    public void hayPuesto(Sector s) throws TelefonicaException{
         sSector.noHayPuesto(s);
    }
    
    public void agregarPuesto(PuestoTrabajo pt){
        sSector.agregarPuesto(pt);
    } 

    public  ArrayList<LLamada> getsLlamada() {
        return sLlamada.getLlamadas();
    }

    public  ArrayList<Sector> getsSector() {
        return sSector.getSectores();
    }

    public ArrayList<Cliente> getsCliente() {
        return sCliente.getClientes();
    }
    
    public boolean asignarPuesto(Trabajador t){
        return sSector.asignarPuesto(t);
    }
    
     public void quitarPuesto(Trabajador t){
        sSector.quitarPuesto(t);
    }
    
    public Trabajador login(String cedula,String pwd) throws TelefonicaException {
        Trabajador t =  sSeccion.login(cedula,pwd);
        if(t!=null){
            this.hayPuesto(t.misector);
            this.asignarPuesto(t);
        }
        return t;
        
    }
    
    public void logout(Trabajador t) {
        sSeccion.logout(t);
    }
    
    public void agregarSector(Sector s) {
        sSector.agregarSector(s);
    }
    
    public void agregarCliente(Cliente c){
        sCliente.agregarCliente(c);
    }
   
    
   public void avisardisponible(){
        sLlamada.avisarpuestodisponible();
   }
    
    public Cliente buscarCliente(String cedula) throws TelefonicaException{
        return sCliente.buscarCliente(cedula);
    }

    public Sector buscarSector(int num) throws TelefonicaException {
       return  sSector.buscarSector(num);
    }
    
    public LLamada   derivarllamada(Sector s, LLamada l) {
       return  sSector.derivarllamada(s, l);
    }

    public void sePuedellamar(Sector s) throws  TelefonicaException {
        sLlamada.sePuedellamar();
    }

    public void setcantllamadas(int n){
        sLlamada.setcantidadLLamdasxSector(n);
    }

   
    
    public void agregarllamadasistema(LLamada l){
        sLlamada.agregarLLamada(l);
    }
    
   
    
      
}
