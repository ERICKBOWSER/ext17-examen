/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ERICK
 */
public class Main {
    public static void main(String[] args) {
        List<Trabajadores> lista = new ArrayList();
        
//        lista = Ficheros.leer("RelEmpCenAus.csv");
//        
//        for (Trabajadores trabajadores : lista) {
//            System.out.println(trabajadores);
//        }


        Ficheros.leer("RelEmpCenAus.csv");
        
    }
   
}
