/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.LLamada;
import Modelo.Sector;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author eduard
 */
public interface VistaSimular {
    
   
    public void ListarSectores(ArrayList<Sector> sectores);
    void salga();
    void mensaje(String m);
    public void mostrarmensaje(double duracion, double costo, double costototalcliente);
    public void  mensajeCentral(String nombretrabajador, String nombresector, Date fechainicio);
    public void mensajeCentralEspera(double duracion , double llamadaenespera);
}
