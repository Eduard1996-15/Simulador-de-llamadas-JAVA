/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import IuGrafica.Menu;


public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatosPrueba.cargar();
        new Menu().setVisible(true);
    }
    
}
