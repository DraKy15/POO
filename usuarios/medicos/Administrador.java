/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.medicos;

import java.time.LocalDate;

/**
 *
 * @author ameti
 */
public class Administrador extends Usuario {

    private double Sueldo;
    private String RFCAdmin;
    private int aniosTrabajados;

    public Administrador(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String contrasenia, Rol rol) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, contrasenia, rol);
    }

    public double getSueldo() {
        return Sueldo;
    }

    public String getRFC() {
        return RFCAdmin;
    }

    public int getAniosTrabajados() {
        return aniosTrabajados;
    }

    public String mostrarDatosM() {
        String datos = String.format("ID=%s, Nombre=%s, Año de nacimiento=%s, rfc: %s", id, nombre, fechaNacimiento, RFCAdmin);
        return datos;
    }
}
