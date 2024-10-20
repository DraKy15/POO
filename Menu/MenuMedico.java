/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import com.mycompany.main.hospital.Hospital;
import java.util.Scanner;
import usuarios.medicos.Medico;


/**
 *
 * @author ameti
 */
public class MenuMedico {

    private Scanner read = new Scanner(System.in);

    public int mostrarMenu() {

        System.out.println("\n**SISTEMA HOSPITAL**");
        System.out.println("1.Ver mis consultas");//
        System.out.println("2.Ver mis pacientes");
        System.out.println("3.Consultar paciente");
        System.out.println("4.Consultar expediente de paciente");
        System.out.println("5.Completar consulta");
        System.out.println("6.Mostrar informacion personal");
        System.out.println("7.Salir");
        int opcion = read.nextInt();
        read.nextLine();
        return opcion;
    }

    public void procesarDatosMenu(int opcion, Medico medico, Hospital hospital) {
        switch (opcion) {
            case 1:
                hospital.mostrarConsultasProgramadas(medico.getId());
                break;
            case 2:
                hospital.mostrarPacientes();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                hospital.mostrarInfoMedico(medico);
                break;
            case 7:
                System.out.println("Saliendo...");
                break;
        }
    }
}
