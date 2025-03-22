/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Eduard
 */
public class PuestoTrabajo {
    int numero;
    String nombre;
    ArrayList<LLamada> llamadasAtendidasPorTrabajador = new ArrayList();
    LLamada llamadaActual;
    ArrayList<LLamada> todasLasLlamadas = new ArrayList();

    public void setLlamadasAtendidasPorTrabajador(LLamada actual) {
        this.llamadasAtendidasPorTrabajador.add(actual);
    }

    public void setActual(LLamada actual) {
        this.llamadaActual = actual;
    }

    public ArrayList<LLamada> getLlamadasAtendidasPorTrabajador() {
        return llamadasAtendidasPorTrabajador;
    }

    public LLamada getActual() {
        return llamadaActual;
    }

    public ArrayList<LLamada> getTodasLasLlamadas() {
        return todasLasLlamadas;
    }
    
    
    
    public PuestoTrabajo(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    void finalizarLLamadaTrabajador() {
        if(this.llamadaActual!=null){
            Date date = new Date();//fecha de la llamada
            this.llamadaActual.fechaHoraFin = date;
            this.llamadaActual.calcularDuracionSegundos();//calculo duracion
            this.llamadaActual.cliente.tipo.CalcularCosto(llamadaActual.getDuracionSegundos());
            this.llamadaActual.estado =true;//marco su estado ya finalizado
            this.llamadaActual.estadostr="finalizada";
            this.llamadasAtendidasPorTrabajador.add(llamadaActual);//agrego a llamadas atendidas
            this.todasLasLlamadas.add(llamadaActual);//agrego a llamdas
            this.llamadaActual=null;//y la pongo en null
           // Fachada.getInstancia().avisar(Fachada.eventos.cortollamada);
        }
    }
    
    public double calcularPromedioSegundos(){
        double sum=0, prom=0;
        for(LLamada l: llamadasAtendidasPorTrabajador){
            sum+=l.getDuracionSegundos();
        }
        if(sum>0){
          prom=(sum/llamadasAtendidasPorTrabajador.size());
        }
        return prom;
    }
   

    public void hayLLamada() throws TelefonicaException {
        if(this.llamadaActual!=null){
            throw new TelefonicaException("Tiene Lamamda en curso desea salir igualmente?");
        }
    }
    
    public boolean tengollamadaEnEsteMomento(){
      return   this.llamadaActual!=null;
    }
    
    public int getCantidad(){
        if(llamadasAtendidasPorTrabajador != null && llamadasAtendidasPorTrabajador.size() > 0){
            return llamadasAtendidasPorTrabajador.size();
        }
        return 0;
    }

}
