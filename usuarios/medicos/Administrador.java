/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.medicos;

import java.time.LocalDate;
import usuarios.medicos.Rol;
import usuarios.medicos.Usuario;

/**
 *
 * @author ameti
 */
public class Administrador extends Usuario {

    private double sueldo;
    private String rfcAdmin;
    private int aniosTrabajados;

    // Constructor con parámetros adecuados para inicializar todos los atributos
    public Administrador(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String contrasenia, Rol rol, double sueldo, String rfcAdmin, int aniosTrabajados) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, contrasenia, rol);
        this.sueldo = sueldo;
        this.rfcAdmin = rfcAdmin;
        this.aniosTrabajados = aniosTrabajados;
    }

   
    public double getSueldo() {
        return sueldo;
    }

    public String getRFCAdmin() {
        return rfcAdmin;
    }

    public int getAniosTrabajados() {
        return aniosTrabajados;
    }

  
    public String mostrarDatosAdministrador() {
        String datos = String.format(
                "ID=%s, Nombre=%s, Apellidos=%s, Fecha de nacimiento=%s, RFC: %s, Sueldo: %.2f, Años trabajados: %d",
                super.getId(), super.getNombre(), super.getApellidos(), super.getFechaNacimiento(), rfcAdmin, sueldo, aniosTrabajados
        );
        return datos;
    }
}
