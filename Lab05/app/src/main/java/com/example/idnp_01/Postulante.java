package com.example.idnp_01;

import java.io.Serializable;

public class Postulante implements Serializable {

    private String dni;
    private String apellidos;
    private String nombres;
    private String fechaNacimiento;
    private String colegioProcedencia;
    private String carrera;
    public Postulante(String dni, String apellidos, String nombres, String fechaNacimiento, String colegioProcedencia, String carrera) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.colegioProcedencia = colegioProcedencia;
        this.carrera = carrera;
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String apellidoPaterno) {
        this.dni = apellidoPaterno;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidoMaterno) {
        this.apellidos = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getColegioProcedencia() {
        return colegioProcedencia;
    }

    public void setColegioProcedencia(String colegioProcedencia) {
        this.colegioProcedencia = colegioProcedencia;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
