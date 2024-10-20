/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import com.mycompany.main.hospital.Hospital;
import java.util.Scanner;
import usuarios.medicos.Paciente;

/**
 *
 * @author ameti
 */
public class MenuPaciente {

    private Scanner read = new Scanner(System.in);

    public int mostrarMenu() {
        int opcion = 0;
        System.out.println("\n**SISTEMA HOSPITAL**");
        System.out.println("1.Ver mis consultas");
        System.out.println("2.Ver informacion personal");
        System.out.println("3.Ver mi expediente ");
        System.out.println("4.Salir");

        System.out.println("Selecciona una opcion: ");
        opcion = read.nextInt();

        return opcion;

    }

    public void procesarDatosMenu(int opcion, Hospital hospital, Paciente paciente) {
        switch (opcion) {
            case 1:
                hospital.verConsultasPaciente(paciente.getId());

            case 2:
                hospital.mostrarInfoPaciente(paciente);
                break;
            case 3:
                break;
            case 4:
                break;
        }

    }

}
