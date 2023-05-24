/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ERICK
 */
public class Main {
    public static void main(String[] args) {
        
        String[][] matriz = Ficheros.leer("concierto.txt");
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) { //Así obtenemos lo que ocupa cada fila
                    System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
        
        
        
        
    }
}
