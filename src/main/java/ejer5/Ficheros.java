/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer5;

import ejer3.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ERICK
 */
public class Ficheros {
    public static String[][] leer(String nombre){
        List<String> lineas;
        String[][] matriz = null;
        
        try{
            lineas = Files.readAllLines(Paths.get(nombre));
            
            // Le damos el número de filas que tiene el fichero
            matriz = new String[lineas.size()][];
            
            for (int i = 0; i < lineas.size(); i++) {
                
                // Cogemos el largo y se lo damos a las columnas de la fila
                matriz[i] = new String[lineas.get(i).length()]; 
                
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = String.valueOf(lineas.get(i).charAt(j));
                }                
                
            }
                    
                    
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return matriz;        
    }
    
    
    
//    public static String[] leer(String nombre){
//        // Fichero a leer con datos de ejemplo
//        String idFichero = nombre;
//
//        // Variables para guardar los datos que se van leyendo
//        String[] tokens;
//        String linea;
//        
//        String[] matriz = new String[6];
//
//        System.out.println("Leyendo el fichero: " + idFichero);
//
//        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
//        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
//        // las operaciones con el archivo
//        try (Scanner datosFichero = new Scanner(new File(idFichero), "ISO_8859_1")) {
//            // hasNextLine devuelve true mientras haya líneas por leer
//
//            int contador = 0;
//            
//            while (datosFichero.hasNextLine()) {
//                // Guarda la línea completa en un String
//                linea = datosFichero.nextLine();
//                // Se guarda en el array de String cada elemento de la
//                // línea en función del carácter separador de campos del fichero CSV
//                
//
//                matriz[contador] = linea;
//
//                contador++;
//                
//                    
////                char[] datos = linea.toCharArray();
////
////                matriz = datos;
//                
//                
//               
//            }
//            System.out.println("Ficheros:");
//            for (String string : matriz) {
//                System.out.println(string);
//            }
//            
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        return matriz;
//    }
    
//    public static char[][] matriz(List<String> linea){
//        int fila = 0, columna = 0;
//        char[][] matriz = new char[linea.size()][linea.];
//        
//        for (int i = 0; i < linea.size(); i++) {
//            char[] array = new char[linea.get(i).length()];
//            for (int j = 0; j < linea.get(i).length(); j++) {
//                array[j] = linea.get(i).charAt(j);
//            }
//            matriz[i] = array;
//            
//        }
//        return matriz;
//    }
//    
//    public static void mostrarMatriz(char[][] matriz){
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[i].length; j++) {
//                System.out.print(matriz[i][j] + "\t");
//            }
//        }
//        System.out.println("");
//    }
    
    
    
    
    
    
    
    
    
    
    
    
}
