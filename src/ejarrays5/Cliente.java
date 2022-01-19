/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejarrays5;

import Fecha.Fecha;

/**
 *
 * @author josu3
 */
public class Cliente {
   private String cif;
   private String nombre;
   private Fecha fechaFra;
   private int diasVen;
   private Float importe;

    public Cliente() {
    }

    public Cliente(String cif, String nombre, Fecha fechaFra, int diasVen, Float importe) {
        this.cif = cif;
        this.nombre = nombre;
        this.fechaFra = fechaFra;
        this.diasVen = diasVen;
        this.importe = importe;
    }

    public String getCif() {
        return cif;
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaFra() {
        return fechaFra;
    }

    public int getDiasVen() {
        return diasVen;
    }

    public Float getImporte() {
        return importe;
    }
    
    public void grabar(String cif, String nombre, Fecha fechaFra, int diasVen, Float importe) {
        this.cif = cif;
        this.nombre = nombre;
        this.fechaFra = fechaFra;
        this.diasVen = diasVen;
        this.importe = importe;
   
    
    
    } 
}
