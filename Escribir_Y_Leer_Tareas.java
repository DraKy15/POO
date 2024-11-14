/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_6;

import java.io.*;

/**
 *
 * @author ameti
 */
public class Escribir_Y_Leer_Tareas {

    //Escribir Tareas
    public void EscribirTareas(String texto) {
        String anadir = texto;
        try ( FileWriter fileWriter = new FileWriter("Tareas.txt", true);  BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(texto);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("Tarea agregada.");
        } catch (Exception e) {
            System.out.println("Error al sobreescribir " + e);
        }
    }

    //Lectura de Tareas
    public void LeerTareas() {
        try ( BufferedReader leer = new BufferedReader(new FileReader("Tareas.txt"))) {
            String lectura;
            System.out.println("Lista de las Tareas: ");
            while ((lectura = leer.readLine()) != null) {
                System.out.println(lectura);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo" + e);
        }
    }
}
