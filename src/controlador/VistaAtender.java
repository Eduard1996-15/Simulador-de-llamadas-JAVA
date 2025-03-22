/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.LLamada;
import Modelo.Trabajador;

/**
 *
 * @author eduard
 */
public interface VistaAtender {
    public void MostrarDatosComun(Trabajador t,double prom);
    public void cargarDatosconClientes(LLamada l, Trabajador t);
    public void atenderLlamada(LLamada l);
    public void NoHayPuestos(Trabajador t);
    public void PreguntoSalida(String m);
    public void salga();
    public void recibirllamada(LLamada l);
    
}

