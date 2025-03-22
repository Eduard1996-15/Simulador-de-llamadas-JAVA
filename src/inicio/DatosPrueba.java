/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import Modelo.*;

/**
 *
 * @author 59892
 */
public class DatosPrueba {
    
    public static void cargar(){
        
    Fachada logica = Fachada.getInstancia();
        
//*Clientes - Información básica: cédula de identidad, nombre completo, y saldo
//*Trabajadores - Información básica: cédula de identidad, contraseña, y nombre completo.
//*Sectores - información básica: nombre, número y cantidad de puestos de trabajo.
//*Cantidad máxima de llamadas totales (tanto en curso como en espera) que soporta el
//sistema = 5.
//*Valor del costo fijo x segundo de las llamadas = $1

       
            //CLIENTES
            Exonerado e = new Exonerado();
            Gestor g= new Gestor();
            logica.agregarCliente(new Cliente("1","Pedro",g));
            logica.agregarCliente(new Cliente("2","maria",g));
            logica.agregarCliente(new Cliente("3","juan",g));
            logica.agregarCliente(new Cliente("4","tilin",g));
            logica.agregarCliente(new Cliente("5","firulai",g));
            logica.agregarCliente(new Cliente("6","gondor",g));
            logica.agregarCliente(new Cliente("7","frodo",g));
            logica.agregarCliente(new Cliente("8","poter",g));



            //SECTORES
            logica.agregarSector(new Sector("ventas",3,1));
            logica.agregarSector(new Sector("consultas",3,2));
            logica.agregarSector(new Sector("sugerencias",3,3));

            //PUESTOS

            logica.agregarPuesto(new PuestoTrabajo(1,"atencion1"));
            logica.agregarPuesto(new PuestoTrabajo(2,"atencion2"));
            logica.agregarPuesto(new PuestoTrabajo(3,"atencion3"));


            //TRABAJADORES
            logica.agregarTrabajador(new Trabajador("1","12345","Anastacia",1));
            logica.agregarTrabajador(new Trabajador("2","12345","Eduard",1));
            logica.agregarTrabajador(new Trabajador("3","12345","Ivan",1));
            logica.agregarTrabajador(new Trabajador("4","12345","diego",2));
            logica.agregarTrabajador(new Trabajador("5","12345","analia",2));
            logica.agregarTrabajador(new Trabajador("6","12345","romina",3));
            logica.agregarTrabajador(new Trabajador("7","12345","doril",3));

            logica.setcantllamadas(10);

    }
}
