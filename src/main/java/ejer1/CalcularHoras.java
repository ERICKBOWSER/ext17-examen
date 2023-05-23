/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer1;

/**
 *
 * @author ERICK
 */
public class CalcularHoras {
    
    private String dni;
    private int horas;
    private int minutos;

    public CalcularHoras() {
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(horas).append("; ");
        sb.append(minutos).append("; ");
        sb.append(dni).append("; ");
        return sb.toString();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
    
}
