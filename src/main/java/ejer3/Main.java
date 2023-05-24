/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ERICK
 */
public class Main {
    public static void main(String[] args) {
        List<Trabajadores> lista = new ArrayList();
        
        lista = Ficheros.leer("RelEmpCenAus.csv");
        
        for (Trabajadores trabajadores : lista) {
            System.out.println(trabajadores);
        }
        
        Map<String, Integer> map = generarMap(lista);
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            
            System.out.println(key + ":" + val + "hrs");
            
        }
        
        lista.stream()
                .map(t -> t.getPuestoTrabajo()) // Filtramos por su puesto de trabajo
                .distinct() //  Hacemos que los datos tengan que ser distintos
                .forEach(System.out :: println);
                
        long numTrab = lista.stream()
                .filter(t -> t.isActivo() == true) // Filtramos solo por los datos true
                .count(); // Contamos los datos
        
        System.out.println(numTrab);
        
        lista.stream()
                .filter(t -> t.isActivo() == false)
                .distinct()
                .sorted((t1, t2) -> t1.getDni().compareToIgnoreCase(t2.getDni()))
                .map(Trabajadores::getDni)
                .forEach(System.out :: println);
        
        

        
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
   
}
