/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.LLamada;
import java.util.ArrayList;

/**
 *
 * @author 59892
 */
public interface VistaMonitoreo {

    public void mostrarLlamadas(ArrayList<LLamada> llamadasAtendidas);
    public void mostrarLlamadasTodos(ArrayList<LLamada> llamadasAtendidas);
    public void dameElValor();

    public void salir();
    
}
