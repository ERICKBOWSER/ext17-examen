/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ERICK
 */
public class Main {
    public static void main(String[] args) throws IOException {
        
        List<Trabajadores> listaTrabajadores = new ArrayList();
        
        listaTrabajadores = Ficheros.leer("RelEmpCenAus.txt");
        
        System.out.println("Lista desde el main:");
        for (Trabajadores lista : listaTrabajadores) {
            System.out.println(lista);
        }
        
        Map<String, Integer> map = generarMap(listaTrabajadores);
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            
            System.out.println(key + ":" + val + "hrs");
            
        }
        
        generarJSON(map);
        
        
    }
    
    private static Map<String, Integer> generarMap(List<Trabajadores> trab){
        Map<String, Integer> totalHoras = new HashMap();
        int horasEmpleado = 0;
        
        for (Trabajadores t : trab) {
            // Guardamos las horas del trabajador
            horasEmpleado = Integer.parseInt(t.getTotalHoras().split(":")[0]);
            
            // Comprobamos si el empleado ya existe
            if(totalHoras.containsKey(t.getDni())){
                // sumamos las horas que ya tenía con la nueva
                totalHoras.put(t.getDni(), totalHoras.get(t.getDni()) + horasEmpleado);
            }else{
                totalHoras.put(t.getDni(), horasEmpleado);
            }
        }
        return totalHoras;
    }
    
    private static void generarJSON(Map<String, Integer> map) throws IOException{
         ObjectMapper mapeador = new ObjectMapper();
        
        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());
        
        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File("totalHorasPorTrabajador.json"), map);
        
    }
    
}
