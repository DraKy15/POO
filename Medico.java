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
public class Medico extends Usuario {

    private String rfc;

    public Medico(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String rfc, String Contrasenia, String tipoSangreMedico, String sexoMedico) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, Contrasenia, Rol.MEDICO);
        this.rfc = rfc;
    }

    public String getRfc() {
        return rfc;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + String.format(", RFC: %s", this.rfc);
    }
}
