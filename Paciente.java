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
import java.util.ArrayList;

public class Paciente extends Usuario {

    public String tipoSangre;
    public char sexo;
    public ArrayList<Expediente> expedientes;

    public Paciente(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String tipoSangre, char sexo, String Contrasenia) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, Contrasenia, Rol.PACIENTE);
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
    }
 
    public String getId() {
        return id;
    }
    
    @Override
    public String mostrarDatos(){
        String datosPaciente = String.format(", Tipo de Sangre: %s, Sexo: %s");
        return super.mostrarDatos()+datosPaciente;
    }

    public void registrarExpediente(Expediente expediente) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}