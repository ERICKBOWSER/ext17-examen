/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer3;

import ejer1.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author ERICK
 */
public class Trabajadores {
    private String apellidos;
    private String nombre;
    private String dni;
    private String tipoPersonal;
    private String puestoTrabajo;
    private boolean horarioPerso;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja;
    private LocalTime horasIniciales;
    private LocalTime totalHoras;
    private boolean activo;

    public Trabajadores() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTipoPersonal() {
        return tipoPersonal;
    }

    public void setTipoPersonal(String tipoPersonal) {
        this.tipoPersonal = tipoPersonal;
    }

    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public boolean isHorarioPerso() {
        return horarioPerso;
    }

    public void setHorarioPerso(boolean horarioPerso) {
        this.horarioPerso = horarioPerso;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public LocalTime getHorasIniciales() {
        return horasIniciales;
    }

    public void setHorasIniciales(LocalTime horasIniciales) {
        this.horasIniciales = horasIniciales;
    }

    public LocalTime getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(LocalTime totalHoras) {
        this.totalHoras = totalHoras;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trabajadores other = (Trabajadores) obj;
        return Objects.equals(this.dni, other.dni);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append("; ");
        sb.append(dni).append(";    ");
        sb.append(tipoPersonal).append(";   ");
        sb.append(puestoTrabajo).append(";  ");
        sb.append(horarioPerso).append(";   ");
        sb.append(fechaAlta).append(";  ");
        sb.append(fechaBaja).append(";  ");
        sb.append(horasIniciales).append("; ");
        sb.append(totalHoras).append("; ");
        sb.append(activo).append("; ");
        return sb.toString();
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    
    
    
    
}
