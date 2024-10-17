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
import java.time.LocalDate;

public class Paciente extends Usuario {

    String id;
    String nombre;
    String apellidos;
    LocalDate fechaNacimiento;
    private String telefono;
    String tipoSangre;
    char sexo;

    public Paciente(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String contrasenia, Rol rol, String tipoSangre, char sexo) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, contrasenia, rol);
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
    }

    public String mostrarDatos() {
        String datos = String.format("ID: %s, Nombre: %s, Apellidos: %s, Fecha de nacimiento: %s, Tipo de sangre: %s, Sexo: %c, Teléfono: %s",
                getId(), getNombre(), getApellidos(), getFechaNacimiento().toString(), tipoSangre, sexo, getTelefono());
        return datos;
    }
}
