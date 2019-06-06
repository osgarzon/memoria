/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptador;

import static encriptador.Encriptador.bits_necesarios;

/**
 *
 * @author Estudiantes
 */

public class cuentaBits {

    public int cuentaBits(int numero) {

        while (numero > 0) {
            bits_necesarios++;
            numero = numero >> 1; // Desplazo bits (división por 2)
        }
        return bits_necesarios;
    }
    
}
