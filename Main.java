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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        System.out.println("5. Mostrar Pacientes");
        System.out.println("6. Mostrar Medicos");
        System.out.println("7. Mostrar Consultorios ");
        System.out.println("8. Mostrar Consultas");
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

                System.out.println("Ingrese el año de nacimiento del paciente: ");
                int ano = read.nextInt();
                System.out.println("Ingrese el mes de nacimiento del paciente: ");
                int mes = read.nextInt();
                System.out.println("Ingrese el dia de nacimiento del paciente: ");
                int dia = read.nextInt();

                LocalDate fechaNacimientoPaciente = LocalDate.of(ano, mes, dia);

                System.out.println("Ingrese el tipo de sangre del paciente: ");
                String tipoSangre = read.nextLine();
                System.out.println("Ingresa el sexo del paciente: ");
                String sexoString = read.nextLine();
                char sexo = sexoString.charAt(0);
                System.out.println("Ingrese el numero telefonico del paciente: ");
                String numeroTelefono = read.nextLine();

                Paciente paciente = new Paciente(id, nombre, apellido, fechaNacimientoPaciente, numeroTelefono, tipoSangre, sexo);
                hospi.registrarPaciente(paciente);

                break;
            case 2:

                System.out.println("Ingresa el nombre del Medico: ");
                String nombreMedico = read.nextLine();
                System.out.println("Ingresa el apellido del Medico: ");
                String apellidoMedico = read.nextLine();
                String idMedico = hospi.generarIDMedico(apellidoMedico);
                System.out.println("Ingrese el año de nacimiento del medico: ");
                int anoDoc = read.nextInt();
                System.out.println("Ingrese el mes de nacimiento del medico: ");
                int mesDoc = read.nextInt();
                System.out.println("Ingrese el dia de nacimiento del medico: ");
                int diaDoc = read.nextInt();

                LocalDate fechaNacimientoMedico = LocalDate.of(anoDoc, mesDoc, diaDoc);
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

                int idConsulta = 1;

                System.out.println("Ingresa el día de la consulta deseada: ");
                int diaConsulta = read.nextInt();
                read.nextLine();

                System.out.println("Ingresa el mes de la consulta deseada: ");
                int mesConsulta = read.nextInt();
                read.nextLine();

                System.out.println("Ingresa el año de la consulta deseada: ");
                int anoConsulta = read.nextInt();
                read.nextLine();

                System.out.println("Ingresa la hora de la consulta: ");
                int horaConsulta = read.nextInt();
                read.nextLine();

                System.out.println("Ingresa los minutos de la consulta: ");
                int minutosConsulta = read.nextInt();

                LocalDateTime fechaConsulta = LocalDateTime.of(anoConsulta, mesConsulta, diaConsulta, horaConsulta, minutosConsulta);

                String idPacienteII = "1234A";
                String nombrePaciente = "Juan";
                String apellidosPaciente = "Perez";
                LocalDate fechaNacimientoPacienteII = LocalDate.of(1990, 5, 20);
                String telefonoPaciente = "555-1234";
                String tipoSangreII = "O+";
                char sexoPaciente = 'M';
                Paciente pacienteII = new Paciente(idPacienteII, nombrePaciente, apellidosPaciente, fechaNacimientoPacienteII, telefonoPaciente, tipoSangreII, sexoPaciente);

                String idMedicoII = "5678B";
                String nombreMedicoII = "Carlos";
                String apellidosMedico = "Gomez";
                LocalDate fechaNacimientoMedicoII = LocalDate.of(1980, 3, 15);
                String telefonoMedico = "555-5678";
                String RFCMedico = "CG12345";
                Medico medicoII = new Medico(idMedicoII, nombreMedicoII, apellidosMedico, fechaNacimientoMedicoII, telefonoMedico, RFCMedico);

                String idConsultorio = "22333";
                int pisoConsultorioII = 2;
                int numConsultorioII = 205;
                Consultorio consultorioII = new Consultorio(idConsultorio, pisoConsultorioII, numConsultorioII);

                Consulta consulta = new Consulta(idConsulta, fechaConsulta, pacienteII, medicoII, consultorioII);

                hospi.registrarConsulta(consulta);

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
                String idMedicoIII = read.nextLine();
                hospi.mostrarMedicoPorId(idMedicoIII);
                break;
            case 11:
                System.out.println("Ingrese el ID del consultorio: ");
                String idConsultorioII = read.nextLine();
                hospi.mostrarConsultorioPorId(idConsultorioII);
                break;
        }
    }
//LocalDate fecha = LocalDate.now();
//LocalDateTime fechaHora = LocalDateTime.now();
    //LocalDate fechaCustom = LocalDate.of(2022,10,5);
    //LocalDateTime fechaHoraCustom = LocalDateTime.of(fechaCustom, hora);
    //String fechaFormateada = fechaHora.format(DateTimeFormatter.ofPattern("dd-mm-YYYY HH:mm:ss"));

}
