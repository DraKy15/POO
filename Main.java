/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.main;

import com.mycompany.main.consulta.Consulta;
import com.mycompany.main.consultorio.Consultorio;

import com.mycompany.main.hospital.Hospital;
import com.mycompany.main.medicos.Medico;
import com.mycompany.pacientes.Paciente;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        Hospital hospi = new Hospital();

        System.out.println("\n MENU \n");
        System.out.println("1. Registrar Paciente");
        System.out.println("2. Registrar Medico");
        System.out.println("3. Registrar Consultorio");
        System.out.println("4. Registrar Consulta");
        System.out.println("5. Mostrar pacientes");
        System.out.println("6. Mostrar medicos");
        System.out.println("7. Mostrar consultorios ");
        System.out.println("8. Mostrar consultas");
        System.out.println("9. Mostrar Paciente por ID");
        System.out.println("10. Mostrar Medico por ID");
        System.out.println("11. Mostrar Consultorio por ID");
        System.out.println("Ingresa una de las opciones: ");
        int opcion = read.nextInt();

        switch (opcion) {

            case 1:
                String id = hospi.generarIDPaciente();

                System.out.println("Ingresa el nombre del paciente: ");
                String nombre = read.nextLine();
                System.out.println("Ingresa el apellido del paciente: ");
                String apellido = read.nextLine();
                System.out.println("Ingresa la fecha de nacimiento del paciente: ");
                String fechaNacimiento = read.nextLine();
                System.out.println("Ingrese el tipo de sangre del paciente: ");
                String tipoSangre = read.nextLine();
                System.out.println("Ingresa el sexo del paciente: ");
                String sexoString = read.nextLine();
                char sexo = sexoString.charAt(0);
                System.out.println("Ingrese el numero telefonico del paciente: ");
                String numeroTelefono = read.nextLine();

                Paciente paciente = new Paciente(id, nombre, apellido, fechaNacimiento, numeroTelefono, tipoSangre, sexo);
                hospi.registrarPaciente(paciente);

                break;
            case 2:

                System.out.println("Ingresa el nombre del Medico: ");
                String nombreMedico = read.nextLine();
                System.out.println("Ingresa el apellido del Medico: ");
                String apellidoMedico = read.nextLine();
                String idMedico = hospi.generarIDMedico(apellidoMedico);
                System.out.println("Ingresa la fecha de nacimiento del Medico: ");
                String fechaNacimientoMedico = read.nextLine();
                System.out.println("Ingrese el numero de telefono del Medico: ");
                String telefono = read.nextLine();
                System.out.println("Ingrese el RFC del Medico: ");
                String RFC = read.nextLine();

                Medico medico = new Medico(idMedico, nombreMedico, apellidoMedico, fechaNacimientoMedico, telefono, RFC);
                hospi.registrarMedico(medico);
                System.out.println("Medico registrado correctamente");
                break;

            case 3:

                System.out.println("Ingresa el numero de piso del consultorio: ");
                int pisoConsultorio = read.nextInt();
                System.out.println("Ingrese el numero de consultorio: ");
                int numConsultorio = read.nextInt();
                String IDConsultorio = hospi.generarIDConsultorio(pisoConsultorio, numConsultorio);
                Consultorio consultorio = new Consultorio(IDConsultorio, pisoConsultorio, numConsultorio);
                hospi.registrarConsultorio(consultorio);
                System.out.println("Consultorio registrado correctamente");
                break;

            case 4:

                break;

            case 5:
                hospi.mostrarPacientes();
                break;
            case 6:
                hospi.mostrarMedicos();
                break;
            case 7:
                hospi.mostrarConsultorios();
                break;
            case 8:
                break;
            case 9:
                System.out.println("Ingrese el ID del paciente: ");
                String idPaciente = read.nextLine();
                hospi.mostrarPacientePorId(idPaciente);
                break;
            case 10:
                System.out.println("Ingrese el ID del medico: ");
                String idMedicoII = read.nextLine();
                hospi.mostrarMedicoPorId(idMedicoII);
                break;
            case 11:
                System.out.println("Ingrese el ID del consultorio: ");
                String idConsultorio = read.nextLine();
                hospi.mostrarConsultorioPorId(idConsultorio);
                break;
        }
    }

}
