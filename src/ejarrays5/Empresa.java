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
            dven = Numeros.pedirNumero("Dias vencimiento: ", 0);
            importe = Numeros.pedirNumeroReal("Importe factura: ", 1);

            clientes[ncliente] = new Cliente(cif, nombre, fecha, dven, importe);

            /**
             * o:
             *
             * clientes[nclientes]= new Cliente (); clientes
             * [ncliente].grabar(......);
             *
             */
        }
    }

    public void informe() {
        Fecha fhoy = new Fecha();

        float descuento;
        float importeNeto;
        int pos;
        
        int annoSig=fhoy.getAnno();
        int mesSig=fhoy.getMes()+1;
        if(mesSig>11){
            annoSig++;
            mesSig=0;
        }

        System.out.println("\t\t\t\t INFORME DE FACTURAS");
        System.out.println("\t\t\t\t Fecha " + fhoy.fechaCompleta());
        System.out.println("CIF\t NOMBRE\t FECHA FACTURA\t IMPORTE BRUTO \t "
                + "FECHA VENCIMIENTO \t IMPORTE NETO");

        for (int ncli = 0; ncli < clientes.length; ncli++) {
            pos = busqueda(clientes[ncli].getDiasVen());
            if (pos == -1) {
                descuento = 0;
            } else {
                descuento = clientes[ncli].getImporte() * descuentos[pos].getDescuento();
            }
            importeNeto = clientes[ncli].getImporte() - descuento;

            Fecha vencimiento = new Fecha(
                    clientes[ncli].getFechaFra().getDia(),
                    clientes[ncli].getFechaFra().getMes(),
                    clientes[ncli].getFechaFra().getAnno());

            vencimiento.calcularVencimiento(clientes[ncli].getDiasVen());
            if (importeNeto > 10000 && vencimiento.getMes()==mesSig &&
                    vencimiento.getAnno()==annoSig) {

                System.out.print(clientes[ncli].getCif());
                System.out.print("\t" + clientes[ncli].getNombre());
                System.out.print("\t" + clientes[ncli].getFechaFra().fechaCompleta());
                System.out.print("\t" + clientes[ncli].getImporte());
                System.out.print("\t" + vencimiento.fechaCompleta());
                System.out.println("\t" + importeNeto);
            }
        }
        
    }

    /**
     * Metodo para buscar en una tabla de rangos el porcentaje adecuado de
     * descuento al cliente. VER indexOF (sirve para localizar pos de un string)
     *
     * @param valor del elemento a buscar
     * @return posicion del valor encontrado y en el caso de que no lo
     * encuentre.
     */
    public int busqueda(int valor) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < descuentos.length) {
            if (valor > descuentos[pos].getLimite()) {
                pos++;
            } else {
                encontrado = true;
            }
        }
            if (!encontrado) {
                pos = -1;
            }

        
        return pos;
    }
}
