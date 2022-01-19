/*
 Una empresa dedicada al sector informático va a realizar un programa para 
gestionar mejor los datos de las facturas de los clientes.
Los datos que tiene de cada cliente son: CIF, Nombre, Fecha Factura,
Días de Vencimiento e Importe factura.

Se pide:
• Realizar la carga de los datos de todos sus clientes.

• Obtener el informe de los clientes cuya factura cuyo vencimiento sea el mes
próximo y el Importe Neto de factura sea superior a 10000€.

El importe neto se obtiene restando al Importe Bruto el descuento. El porcentaje
de descuento se obtiene en función de los días de vencimiento de las facturas,
según la siguiente tabla:

DIAS VENCIMIENTO DESCUENTO
Entre 0 y 30 días 10%
Entre 30-90 días 7%
Entre 90 y 120 días 5%
Entre 120 y 180 días 2%
Más de 180 días 0%

El formato del informe es el siguiente:
                        INFORME DE facturas

Fecha: (fecha actual con el formato día-mes en letra-año)

CIF| NOMBRE| FECHA FACTURA| FECHA VENCIMIENTO| IMPORTE BRUTO| IMPORTE NETO

TOTAL IMPORTE NETO

Nota: el campo TOTAL IMPORTE NETO es la suma del importe neto de todas las facturas
 */
package ejarrays5;

import numeros.Numeros;
import textos.Textos;

/**
 *
 * @author josu3
 */
public class EjArrays5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Empresa miEmpresa;
        int nclientes;
        
        nclientes=Numeros.pedirNumero("Introduce el número de cliente: ", 0);
        miEmpresa= new Empresa (nclientes);
        miEmpresa.pedirClientes();
        miEmpresa.informe();
        
        
            
           
        
        
    }
    
}
