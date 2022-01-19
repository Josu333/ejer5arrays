/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejarrays5;

/**
 *
 * @author josu3
 */
public class Descuento {
    private int limite;
    private float descuento;

    public Descuento(int limite, float descuento) {
        this.limite = limite;
        this.descuento = descuento;
    }

    public int getLimite() {
        return limite;
    }

    public float getDescuento() {
        return descuento;
    }
    
    
}
