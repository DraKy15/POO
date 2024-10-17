/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import com.mycompany.main.hospital.Hospital;
import java.util.Scanner;
import java.time.LocalDate;
import usuarios.medicos.Medico;
import usuarios.medicos.Paciente;
import usuarios.medicos.Rol;
import usuarios.medicos.Usuario;
import usuarios.medicos.Administrador;

public class Menu {

    private Scanner read = new Scanner(System.in);
    private Hospital hospi = new Hospital();
    
    public void login() {
        int intentosUsuario = 0;
        int intentosMaximos = 5;

        while (intentosUsuario < intentosMaximos) {
            System.out.println("\nInicia sesión para continuar");
            System.out.println("Ingresa tu usuario: ");
            String usuario = read.nextLine();

            System.out.println("Ingresa tu contraseña: ");
            String contrasena = read.nextLine();

            Usuario usuarioEnSesion = hospi.validarInicioSesion(usuario, contrasena);

            if (usuarioEnSesion != null) {
                if (usuarioEnSesion.getRol() == Rol.PACIENTE) {
                    Paciente pacienteEnSesion = (Paciente) usuarioEnSesion;
                    this.mostrarMenuPaciente(pacienteEnSesion);
                    return;
                } else if (usuarioEnSesion.getRol() == Rol.MEDICO) {
                    Medico medicoEnSesion = (Medico) usuarioEnSesion;
                    this.mostrarMenuMedico(medicoEnSesion);
                    return;
                } else if (usuarioEnSesion.getRol() == Rol.ADMIN) {
                    Administrador adminEnSesion = (Administrador) usuarioEnSesion;
                    this.mostrarMenuAdmin(adminEnSesion);
                    return;
                } else {
                    System.out.println("Rol no reconocido. Contacte al administrador.");
                }
            } else {
                intentosUsuario++;
                System.out.println("Usuario o contraseña incorrectos. Intento " + intentosUsuario + " de " + intentosMaximos);

                if (intentosUsuario >= intentosMaximos) {
                    System.out.println("Has alcanzado el número máximo de intentos. Acceso denegado.");
                } else {
                    System.out.println("Por favor, intenta nuevamente.");
                }
            }
        }
    }

    private void mostrarMenuPaciente(Paciente paciente) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\nSISTEMA HOSPITAL");
            System.out.println("1. Ver mis consultas");
            System.out.println("2. Ver mis datos personales");
            System.out.println("3. Ver mi expediente");
            System.out.println("4. Salir");

            System.out.println("Ingrese una opcion: ");
            opcion = read.nextInt();
            read.nextLine();

            switch (opcion) {
                case 1:
                    hospi.mostrarConsultas(paciente.getId());
                    break;
                case 2:
                    System.out.println(paciente.mostrarDatosPaciente());
                    break;
                case 3:
                    hospi.mostrarExpediente(paciente.getId());
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private void mostrarMenuMedico(Medico medico) {
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\nSISTEMA HOSPITAL");
            System.out.println("1. Ver mis consultas programadas");
            System.out.println("2. Ver mis datos personales");
            System.out.println("3. Consultar expediente de un paciente");
            System.out.println("4. Salir");

            System.out.println("Ingrese una opcion: ");
            opcion = read.nextInt();
            read.nextLine();

            switch (opcion) {
                case 1:
                    hospi.mostrarConsultasMedico(medico.getId());
                    break;
                case 2:
                    System.out.println(medico.mostrarDatosMedico());
                    break;
                case 3:
                    System.out.println("Ingrese el ID del paciente a consultar:");
                    String idPaciente = read.nextLine();
                    hospi.mostrarExpediente(idPaciente);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private void mostrarMenuAdmin(Administrador admin) {
        System.out.println("\nMENU ADMINISTRADOR\n");
        System.out.println("1. Registrar Paciente");
        System.out.println("2. Registrar Medico");
        System.out.println("3. Registrar Consultorio");
        System.out.println("4. Registrar Consulta");
        System.out.println("5. Mostrar Pacientes");
        System.out.println("6. Mostrar Medicos");
        System.out.println("7. Mostrar Consultorios");
        System.out.println("8. Mostrar Consultas");
        System.out.println("9. Mostrar Paciente por ID");
        System.out.println("10. Mostrar Medico por ID");
        System.out.println("11. Mostrar Consultorio por ID");
        System.out.println("12. Mostrar Consulta por ID");

        System.out.println("Ingresa una de las opciones: ");
        int opcion = read.nextInt();
        read.nextLine();

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
                read.nextLine(); // Limpiar buffer

                System.out.println("Ingrese el tipo de sangre del paciente: ");
                String tipoSangre = read.nextLine();
                System.out.println("Ingresa el sexo del paciente: ");
                char sexo = read.nextLine().charAt(0);

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
            default:
                System.out.println("Opción no válida.");
        }
    }
}

  
