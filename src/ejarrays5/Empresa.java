/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejarrays5;

import Fecha.Fecha;
import numeros.Numeros;
import textos.Textos;

/**
 *
 * @author josu3
 */
public class Empresa {

    Cliente[] clientes;
    Descuento[] descuentos;

    public Empresa(int nClientes) {
        clientes = new Cliente[nClientes];
        descuentos = new Descuento[]{
            new Descuento(30, 0.10f),
            new Descuento(90, 0.07f),
            new Descuento(120, 0.05f),
            new Descuento(180, 0.02f),
            new Descuento(Integer.MAX_VALUE, 0f)
        };
    }

    public void pedirClientes() {
        String nombre, cif;
        int dven;//dias de vencimiento
        Fecha fecha;
        Float importe;
        for (int ncliente = 0; ncliente < clientes.length; ncliente++) {
            cif = Textos.pedirString("CIF: ");
            nombre = Textos.pedirString("Nombre: ");
            fecha = Textos.pedirFecha("Fecha: ");
            dven = Numeros.pedirNumero("Dias vencimiento, 0", ncliente);
            importe = Numeros.pedirNumeroReal("Importe factura", 1);

            clientes[ncliente] = new Cliente(cif, nombre, fecha, dven, importe);
            
             /**
              o:
             
               clientes[nclientes]= new Cliente ();
              clientes [ncliente].grabar(......);
             **/
        }
    }
    public void informe(){
        Fecha fhoy = new Fecha ();
        System.out.println("\t\t\t\tINFORME DE FACTURAS");
        System.out.println("Fecha "+fhoy.fechaCompleta());
        System.out.println("CIF\t NOMBRE\t FECHA FACTURA\t IMPORTE BRUTO \t "
                + "FECHA VENCIMIENTO \t IMPORTE NETO");
        
        for(int ncli=0; ncli >clientes.length;ncli++)
        {
            Fecha vencimiento = new Fecha(
                    clientes[ncli].getFechaFra().getDia(),
                    clientes[ncli].getFechaFra().getMes(),
                    clientes[ncli].getFechaFra().getAnno());
            vencimiento.calcularVencimiento(clientes[ncli].getDiasVen());
            System.out.println(clientes[ncli].getCif());
            System.out.println("\t"+ clientes[ncli].getNombre());
            System.out.println("\t"+ clientes[ncli].getFechaFra().fechaCompleta());
            System.out.println("\t"+clientes[ncli].getImporte());
            System.out.println("\t"+vencimiento.fechaCompleta());
        }
    }
}
