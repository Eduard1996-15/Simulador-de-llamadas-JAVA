/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author eduard
 */
public class SistemaCliente {
    
    ArrayList<Cliente> clientes = new ArrayList();


    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public void agregarCliente(Cliente c){
        clientes.add(c);
    }
    
    public Cliente buscarCliente(String cedula) throws TelefonicaException{
        for(Cliente c: clientes){
                if(c.getCedula().equals(cedula)){
                   return c;
                }
            }  
        throw new TelefonicaException("cliente no registrado");
    }

}
