/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer1;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
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
                tokens = linea.split("\\s*\\|");
                
                Trabajadores trabajador = new Trabajadores();
                
                //for(String token : tokens){
                if(contador > 8){
                    trabajador.setNombre(tokens[0]);
                    trabajador.setDni(tokens[1]);
                    trabajador.setTipoPersonal(tokens[2]);
                    trabajador.setPuestoTrabajo(tokens[3]);
                    if(tokens[4].equalsIgnoreCase("si")){
                        trabajador.setHorarioPerso(true);
                    }else{
                        trabajador.setHorarioPerso(false);
                    }
                    
                    DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato para la fecha
                    LocalDate fecha1 = LocalDate.parse(tokens[5], formato1);

                    trabajador.setFechaAlta(fecha1);
                    
                    //trabajador.setFechaAlta(LocalDate.parse(tokens[5]));
                    if(tokens[6].equalsIgnoreCase("")){
                        trabajador.setFechaBaja(null);
                    }else{
                        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato para la fecha
                        LocalDate fecha2 = LocalDate.parse(tokens[6], formato2);

                        trabajador.setFechaBaja(fecha2);
                    }
                    
                    //trabajador.setFechaBaja(LocalDate.parse(tokens[6]));
                    
                    DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("H:m"); // Formato para la fecha

                    
                    trabajador.setHorasIniciales(LocalTime.parse(tokens[7], formato3));
                    trabajador.setTotalHoras(tokens[8]);
                    if(tokens[9].equalsIgnoreCase("S")){
                        trabajador.setActivo(true);
                    }else{
                        trabajador.setActivo(false);
                    }

                    lista.add(trabajador);
                
                }else{
                    contador++;
                }
                //}
                
//                for (String string : tokens) {
//                    if(contador > 10){
//                        System.out.print(string + "\t");
//                    }else{
//                        contador++;
//                    }
//                }
                System.out.println();
            }
            
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
   
    
    
    
    
    
    
    
    
    
}
