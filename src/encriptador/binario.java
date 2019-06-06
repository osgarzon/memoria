/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptador;

import static encriptador.Encriptador.n;

/**
 *
 * @author Estudiantes
 */
public class binario {
    

    public static long[] Nbinario(int bin) {
        cuentaBits cuenta= new cuentaBits();
        int decimal, cnt, res;
        decimal = bin;
        long[] binario;
        binario = new long[cuenta.cuentaBits((int) n)];

        cnt = 0;
        res = decimal;
        do {
            binario[cnt++] = res % 2;
            res = res / 2;
        } while (res > 1);

        binario[cnt++] = res % 2;

        return binario;
    }

    public binario() {
    }

}
