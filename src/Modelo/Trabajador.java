/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author eduard
 */
public class Trabajador extends Usuario{
    public String password;
    public Sector misector;
    public int numSector;
    public PuestoTrabajo mipuesto;
    
    ArrayList<LLamada> llamadas = new ArrayList();

    public Trabajador(){}

    

    public Sector getMisector() {
        return misector;
    }

    public PuestoTrabajo getMipuesto() {
        return mipuesto;
    }
    

    public Trabajador(String cedula,String pass, String nombre,int numSec) {
        super(cedula,nombre);
        this.password = pass;
        numSector=numSec;
        this.misector=null;
    }

    public Trabajador(String cedula, String pwd) {
        super(cedula,"");
        this.password=pwd;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    } 

    public void setMisector(Sector misector) {
        this.misector = misector;
    }
    
     @Override
    public boolean equals(Object o){
        Trabajador otro = (Trabajador)o;//casteo
        return (this.getCedula().equals(otro.getCedula())) && (this.getPassword().equals(otro.getPassword()));
    }

    @Override
    public boolean validar() {
            return (this.cedula.length() > 7 && this.nombre.length() > 3 && this.password.length() > 3);
    }

    
}
