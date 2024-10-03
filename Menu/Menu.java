/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import com.mycompany.main.hospital.Hospital;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.mycompany.main.consulta.Consulta;
import com.mycompany.main.consultorio.Consultorio;

import com.mycompany.main.hospital.Hospital;
import com.mycompany.main.medicos.Medico;
import com.mycompany.pacientes.Paciente;

/**
 *
 * @author ameti
 */
public class Menu {

    private Scanner read = new Scanner(System.in);
    private Hospital hospi = new Hospital();
    private final String Usuario_Paciente = "Juan123";
    private final String Contrasena_Paciente = "12345*";
    private final String Usuario_Medico = "Ale123";
    private final String Contrasena_Medico = "54321*";
    private final String Usuario_Admin = "Rob234";
    private final String Contrasena_Admin = "2468*";

    public void login() {
        int intentosUsuario = 0;
        int intentosMaximos = 5;

        while (intentosUsuario < intentosMaximos) {
            System.out.println("\n Inicia sesion para continuar");

            System.out.println("Ingresa tu usuario: ");
            String usuario = read.nextLine();

            System.out.println("Ingresa tu contraseña: ");
            String contrasena = read.nextLine();

            if (usuario.equals(this.Usuario_Paciente)) {
                if (contrasena.equals(this.Contrasena_Paciente)) {
                    System.out.println("Inicio de Sesión exitoso");
                    this.mostrarMenuPaciente();
                    intentosUsuario = 0;
                } else if (usuario.equals(this.Usuario_Medico)) {
                    if (contrasena.equals(this.Contrasena_Medico)) {
                        this.mostrarMenuMedico();
                        intentosUsuario = 0;
                    } else if (usuario.equals(this.Usuario_Admin)) {
                        if (contrasena.equals(this.Contrasena_Admin)) {
                            this.mostrarMenu();
                        }
                    }
                } else {
                    this.MostrarErrorInicioSesion(intentosUsuario);
                }

            }

        }
    }

    private int MostrarErrorInicioSesion(int intentosUsuario) {
        System.out.println("Usuario o contrasena invalidos. Intente de nuevo");
        return intentosUsuario + 1;
    }

    private void mostrarMenuPaciente() {
        int opcion = 0;
        while (opcion != 2) {
            System.out.println("\n SISTEMA HOSPITAL");
            System.out.println("1. Ver sus consultas");
            System.out.println("2. Consultar paciente");
            System.out.println("3. Salir");

            System.out.println("Ingrese una opcion: ");
            opcion = read.nextInt();
            read.nextLine();
        }
    }

    private void mostrarMenuMedico() {
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\n SISTEMA HOSPITAL");
            System.out.println("1. Ver mis consultas");
            System.out.println("2. Ver mis pacientes");
            System.out.println("3. Consultar paciente");
            System.out.println("4. Salir");

            System.out.println("Ingrese una opcion: ");
            opcion = read.nextInt();
            read.nextLine();
        }
    }

    private void mostrarMenu() {

        System.out.println(
                "\n MENU \n");
        System.out.println(
                "1. Registrar Paciente");
        System.out.println(
                "2. Registrar Medico");
        System.out.println(
                "3. Registrar Consultorio");
        System.out.println(
                "4. Registrar Consulta");
        System.out.println(
                "5. Mostrar Pacientes");
        System.out.println(
                "6. Mostrar Medicos");
        System.out.println(
                "7. Mostrar Consultorios ");
        System.out.println(
                "8. Mostrar Consultas");
        System.out.println(
                "9. Mostrar Paciente por ID");
        System.out.println(
                "10. Mostrar Medico por ID");
        System.out.println(
                "11. Mostrar Consultorio por ID");
        System.out.println(
                "Ingresa una de las opciones: ");
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

                String numeroTelefono = null;

                while (numeroTelefono == null) {
                    System.out.println("Ingrese el numero telefonico del paciente: ");
                    String numeroTelefonoPaciente = read.nextLine();

                    if (!hospi.validarNumeroTelefonicoPaciente(numeroTelefonoPaciente)) {
                        System.out.println("El numero telefonico esta ocupado. Ingrese otro numero:");
                    } else {
                        numeroTelefono = numeroTelefonoPaciente;
                        System.out.println("Número telefónico ingresado correctamente");
                    }
                }

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

                read.nextLine();

                LocalDate fechaNacimientoMedico = LocalDate.of(anoDoc, mesDoc, diaDoc);

                String numeroTelefonoII = null;
                while (numeroTelefonoII == null) {
                    System.out.println("Ingrese el numero de telefono del Medico: ");
                    String numeroTelefonoMedico = read.nextLine();

                    if (!hospi.validarNumeroTelefonicoMedico(numeroTelefonoMedico)) {
                        System.out.println("El numero telefonico esta ocupado. Ingrese otro numero:");
                    } else {
                        numeroTelefonoII = numeroTelefonoMedico;
                        System.out.println("Número telefónico ingresado correctamente");
                    }
                }

                String RFC = null;
                while (RFC == null) {
                    System.out.println("Ingrese el RFC del Medico: ");
                    String RFCMedico = read.nextLine();

                    if (!hospi.validarRFCMedicoOcupado(RFCMedico)) {
                        System.out.println("El RFC esta ocupado. Ingrese otro:");
                    } else {
                        RFC = RFCMedico;
                        Medico medico = new Medico(idMedico, nombreMedico, apellidoMedico, fechaNacimientoMedico, numeroTelefonoII, RFC);

                        hospi.registrarMedico(medico);
                        System.out.println("Medico registrado correctamente");
                    }
                }

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

                String idConsulta = hospi.generarIDConsulta();

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

                if (!hospi.validarFechaConsulta(fechaConsulta)) {
                    System.out.println("No puede ingresar fechas anteriores");
                    return;
                }

                Paciente pacienteConsulta = null;
                while (pacienteConsulta == null) {
                    System.out.println("Ingresa el ID del paciente: ");
                    String idPacienteII = read.nextLine();

                    pacienteConsulta = hospi.obtenerPacientePorId(idPacienteII);
                    if (pacienteConsulta == null) {
                        System.out.println("Paciente no encontrado. Ingrese un ID existente: ");
                    }
                }

                Medico medicoConsulta = null;
                while (medicoConsulta == null) {
                    System.out.println("Ingresa el ID del medico: ");
                    String idMedicoII = read.nextLine();
                    medicoConsulta = hospi.obtenerMedicoPorId(idMedicoII);
                    if (medicoConsulta == null) {
                        System.out.println("Medico no encontrado. Ingrese un ID existente: ");
                    }
                }

                Consultorio consultorioConsulta = null;
                while (consultorioConsulta == null) {
                    System.out.println("Ingresa el ID del consultorio: ");
                    String idConsultorioII = read.nextLine();
                    consultorioConsulta = hospi.obtenerConsultorioPorId(idConsultorioII);
                    if (consultorioConsulta == null) {
                        System.out.println("Paciente no encontrado. Ingrese un ID existente: ");
                    }
                }

                Consulta consulta = new Consulta(idConsulta, fechaConsulta, pacienteConsulta, medicoConsulta, consultorioConsulta);
                hospi.registrarConsulta(consulta);

                System.out.println(hospi.listaConsultas.get(0));

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
                hospi.mostrarConsultas();
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
                String idConsultorio = read.nextLine();
                hospi.mostrarConsultorioPorId(idConsultorio);
                break;
        }
    }
}
