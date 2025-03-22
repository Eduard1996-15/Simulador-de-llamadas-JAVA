/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Eduard
 */
public class LLamada {
    public boolean facturada;
    public boolean estado;
    public String estadostr;
    public int numLlamda;
    public Trabajador trabajador;
    public Cliente  cliente;
    public Date fechaHoraIicio;
    public Date fechaHoraFin;
    public int puesto;//numero del puesto
    public int sector;
    public int numeroSector;//relativo al sector
    public static double duracionSegundos;

    public int getNumLlamda() {
        return numLlamda;
    }

    public void setNumLlamda(int numLlamda) {
        this.numLlamda = numLlamda;
    }

    public double getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(double duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    public LLamada(Trabajador trabajador, Cliente cliente, Date fechaHoraIicio, int numeroPuesto, int numeroSector) {
        this.trabajador = trabajador;
        this.cliente = cliente;
        this.fechaHoraIicio = fechaHoraIicio;
        this.fechaHoraFin = null;
        this.puesto = numeroPuesto;
        this.numeroSector = numeroSector;
    }

    public LLamada() {
        estado=false;
        this.cliente=new Cliente();
        this.trabajador=new Trabajador();
    }

    public int getPuesto() {
        return puesto;
    }
    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }
    public int getSector() {
        return sector;
    }
    public void setSector(int sector) {
        this.sector = sector;
    }
    public Trabajador getTrabajador() {
        return trabajador;
    }
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Date getFechaHoraIicio() {
        return fechaHoraIicio;
    }

    public void setFechaHoraIicio(Date fechaHoraIicio) {
        this.fechaHoraIicio = fechaHoraIicio;
    }
    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public int getNumeroSector() {
        return numeroSector;
    }

    public void setNumeroSector(int numeroSector) {
        this.numeroSector = numeroSector;
    }

    public double getDuracion() {
        return duracionSegundos*=(1.0/60);
    }

   
    
    public double calcularDuracionSegundos(){
            this.fechaHoraFin = new Date();
            // obtener la diferencia entre dos fechas en minutos
            long elapsedms = this.fechaHoraIicio.getTime() - this.fechaHoraFin.getTime();
            double diff = TimeUnit.SECONDS.convert(elapsedms, TimeUnit.MILLISECONDS);
            this.setDuracionSegundos(Math.abs(diff));
            return Math.abs(diff);
            
    }
    
 
    public boolean estyAtendido(){
        return this.estadostr=="En Curso";
    }
    
    public boolean MiEstado(){
        return this.estado;
    }
    
    public void facturar() {
        facturada=true;
    }

    public boolean facturada() {
        return facturada;
    }

   
    
}
