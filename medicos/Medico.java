/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.medicos;

/**
 *
 * @author ameti
 */
public class Medico {

    String id;
    String nombre;
    String apellidos;
    String fechaNacimiento;
    private String telefono;
    String RFC;

    public Medico(String id, String nombre, String apellidos, String fechaNacimiento, String telefono, String RFC) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.RFC = RFC;
    }

    public String mostrarDatosMedico() {
        String datos = String.format("id: %s, nombre: %s, apellidos: %s,fecha de nacimiento: %s, telefono: %s, RFC: %s");
        return datos;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRFC() {
        return RFC;
    }

}
