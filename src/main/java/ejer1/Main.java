/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ERICK
 */
public class Main {
    public static void main(String[] args) {
        
        List<Trabajadores> listaTrabajadores = new ArrayList();
        
        listaTrabajadores = Ficheros.leer("RelEmpCenAus.txt");
        
        System.out.println("Lista desde el main:");
        for (Trabajadores lista : listaTrabajadores) {
            System.out.println(lista);
        }
        
        List<CalcularHoras> listaHoras = new ArrayList();
        
        listaHoras = Ficheros.leerHoras("RelEmpCenAus.txt");
        System.out.println("Lista desde el main de las horas:");
        for (CalcularHoras lista : listaHoras) {
            System.out.println(lista);
        }
        
        
//        Ficheros.leerHoras("RelEmpCenAus.txt");
        
        
        
        
        
    }
    
}
