/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import static java.lang.Integer.parseInt;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author eduard
 */
public class Sector  {

   
    public String nombre;
    public int tiempopromedio;
    public int cantPuesto;
    public int numero;
    ArrayList<Trabajador> trabajadores = new ArrayList();
    ArrayList<Trabajador> trabajadoresDisponibles = new ArrayList();
    ArrayList<Trabajador> trabajadoresOcupados = new ArrayList();
    ArrayList<PuestoTrabajo> puestos = new ArrayList();
    ArrayList<LLamada> llamadasAtendidas = new ArrayList<>();
    ArrayList<LLamada> llamadasEnEspera = new ArrayList<>();

    public Sector() {

    }

    public void setTiempopromedio(int tiempopromedio) {
        int suma=0;
        for(PuestoTrabajo p:puestos){
            suma+=p.calcularPromedioSegundos();
        }
        this.tiempopromedio=(suma/puestos.size());
    }
    
    
    public Sector(String nombre, int cantPuesto, int numero) {
        this.nombre = nombre;
        this.cantPuesto = cantPuesto;
        this.numero = numero;
    }

    public int getTiempopromedio() {
        return tiempopromedio;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public ArrayList<Trabajador> getTrabajadoresDisponibles() {
        return trabajadoresDisponibles;
    }

    public ArrayList<Trabajador> getTrabajadoresOcupados() {
        return trabajadoresOcupados;
    }

    public ArrayList<PuestoTrabajo> getPuestos() {
        return puestos;
    }

    public ArrayList<LLamada> getLlamadasAtendidas() {
        return llamadasAtendidas;
    }

    public ArrayList<LLamada> getLlamadasEnEspera() {
        return llamadasEnEspera;
    }

    
    public String getNombre() {
        return nombre;
    }
    
    public void Nohaypuesto() throws TelefonicaException {
        if(puestos.isEmpty()){
            throw new TelefonicaException("No Hay Puestos Disponibles");
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantPuesto() {
        return cantPuesto;
    }

    public void setCantPuesto(int cantPuesto) {
        this.cantPuesto = cantPuesto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean aregarTrabajador(Trabajador t) {
        if( !trabajadores.contains(t)){
            trabajadores.add(t);
            return true;
        }
        return false;
    }
    
    public boolean asignarPuesto(Trabajador t){
        for(PuestoTrabajo p:puestos){
            t.mipuesto =p;
            puestos.remove(p);
            trabajadoresDisponibles.add(t);
                return true;
        }
        return false;
    }


    
     public void quitarPuesto(Trabajador t){
         if(t.mipuesto!= null)
            puestos.add(t.mipuesto);
            t.mipuesto=null;
            trabajadoresDisponibles.remove(t);
    }
    
    
    public boolean EstanOcupados(){
        if(trabajadoresDisponibles.size() <1 && trabajadoresOcupados.size() >1){
            return true;
        }return false;
    }
    
     public boolean existeTrabajadordisponible(){
        if(trabajadoresDisponibles.size() >0){
         return true;
     }
       return false;
    }

      //
     ///quitar return de string y poner return llamada 
    public LLamada derivarllamada(LLamada l)  {
        Date data = new Date();
        l.fechaHoraIicio=data;
        if(trabajadoresDisponibles.size() > 0){
            for(Trabajador t: trabajadoresDisponibles){
                    this.generarnumllamada(l);
                    t.mipuesto.llamadaActual=l;
                    l.puesto=t.mipuesto.getNumero();
                    l.trabajador=t;
                    this.llamadasAtendidas.add(l);
                    this.llamadasEnEspera.remove(l);
                    this.trabajadoresDisponibles.remove(t);
                    this.trabajadoresOcupados.add(t);
                    l.estadostr="En Curso";
                   return l;
            }
        }else if(this.trabajadoresOcupados.size() > 0 && trabajadoresDisponibles.size() == 0){
              this.llamadasEnEspera.add(l);
              l.trabajador=null;
             return l;
        }
        return null;
    }

    public boolean crearPuesto(String nombre, int numero) {
        PuestoTrabajo pt = new PuestoTrabajo(numero, nombre);
        if(puestos.size()<=cantPuesto){
            puestos.add(pt);
            return true;
        }
        return false;
    }

    public Trabajador buscarTrabajador(String cedula) {
        for(Trabajador t: trabajadores){
            if(t.cedula==cedula){
                return t;
            }
        }return null;
    }

    public void finllamada(Trabajador t) {
        t.mipuesto.finalizarLLamadaTrabajador();
    }

   
    
    
    void generarnumllamada(LLamada l){
        l.numLlamda = this.llamadasAtendidas.size()+1;
    }


    public void hayTrabajadores() throws TelefonicaException{
        if(this.trabajadoresOcupados.size() ==0 && this.trabajadoresDisponibles.size()==0){
            throw  new TelefonicaException("Sector no disponible");
        }
    }

    void liberarPuesto(Trabajador t) {
        this.trabajadoresDisponibles.add(t);
        this.trabajadoresOcupados.remove(t);
    }

    
}
