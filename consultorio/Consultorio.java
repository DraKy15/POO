/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.consultorio;

/**
 *
 * @author ameti
 */
public class Consultorio {

    String id;
    int piso;
    int numConsultorio;

    public Consultorio(String id, int piso, int numConsultorio) {
        this.id = id;
        this.piso = piso;
        this.numConsultorio = numConsultorio;
    }

    public String getId() {
        return id;
    }

    public int getPiso() {
        return piso;
    }

    public int getNumConsultorio() {
        return numConsultorio;
    }

    public String mostrarConsultorios(){
        String datosConsultorio = String.format("id: %s, piso: %d, Numero de Consultorio: %d");
        return datosConsultorio;
    }
}
