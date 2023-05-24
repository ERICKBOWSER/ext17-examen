/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer3;

import java.io.File;
import java.io.FileNotFoundException;
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
    public static List<Trabajadores> leer(String nombre){
        // Fichero a leer con datos de ejemplo
        String idFichero = nombre;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        
        List<Trabajadores> lista = new ArrayList();

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "ISO_8859_1")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            int contador = 0;
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                
                
//                tokens = linea.split("\"*,\"");
//                
//                for (int i = 0; i < tokens.length; i++) {
//                    tokens[i] = tokens[i].replaceAll("\"", "");
//                }
                
                tokens = linea.split(",");
                
                for (int i = 0; i < tokens.length; i++) {
                    tokens[i] = tokens[i].replaceAll("\"", "");
                }
                
                
                
                Trabajadores trabajador = new Trabajadores();
                
                if(contador > 1){
                    trabajador.setApellidos(tokens[0]);
                    trabajador.setNombre(tokens[1]);
                    trabajador.setDni(tokens[2]);
                    trabajador.setTipoPersonal(tokens[3]);
                    trabajador.setPuestoTrabajo(tokens[4]);
                    if(tokens[5].equalsIgnoreCase("si")){
                        trabajador.setHorarioPerso(true);
                    }else{
                        trabajador.setHorarioPerso(false);
                    }
                    
                    if(tokens[6].equals("")){
                        trabajador.setFechaAlta(null);
                    }else{
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato para la fecha
                        LocalDate fecha1 = LocalDate.parse(tokens[6], formato);

                        trabajador.setFechaAlta(fecha1);
                    }
                    
                    //trabajador.setFechaAlta(LocalDate.parse(tokens[5]));
                    if(tokens[7].equals("")){
                        trabajador.setFechaBaja(null);
                    }else{
                        
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato para la fecha
                        LocalDate fecha2 = LocalDate.parse(tokens[7], formato);

                        trabajador.setFechaBaja(fecha2);
                    }
                    
                    //trabajador.setFechaBaja(LocalDate.parse(tokens[6]));
                    
//                    DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("H:m"); // Formato para la fecha
//
//                    
//                    trabajador.setHorasIniciales(LocalTime.parse(tokens[8], formato3));
//                                        
//                    trabajador.setTotalHoras(LocalTime.parse(tokens[9], formato3));

                    trabajador.setHorasIniciales(tokens[8]);
                    trabajador.setTotalHoras(tokens[9]);
                    
                    if(tokens[10].equalsIgnoreCase("S")){
                        trabajador.setActivo(true);
                    }else{
                        trabajador.setActivo(false);
                    }

                    lista.add(trabajador);
                }else{
                    contador++;
                }

                contador++;
                
//                for (String string : tokens) {
//                        System.out.print(string + "\t");
//                }
//                System.out.println();
            }
            
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
