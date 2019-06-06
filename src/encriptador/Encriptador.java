/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptador;

import java.util.*;

/**
 *
 * @author USER
 */
public class Encriptador {

    /**
     * @param args the command line arguments
     */
    static long p, q, n, fi, s, z, a[];
    static int bits_necesarios = 0;
    static String frase;
    static char[] cadena;

    public static void main(String[] args) {
        rsa V = new rsa();      
        V.setVisible(true);  

       
        frase = V.texto.getText();
        frase = frase.replace(" ", "");
        cadena = frase.toCharArray();
        long[] Icadena = new long[cadena.length];
        System.out.println(" ingrese p ");
        p = Long.parseLong(V.numP.getText());
        System.out.println(" ingrese q ");
        q = Long.parseLong(V.numQ.getText());
        System.out.println(" ingrese n");
        n = Long.parseLong(V.numN.getText());
        fi = (p - 1) * (q - 1);
        s = n;
        z = p * q;
        cuentaBits cuenta = new cuentaBits();
        a = new long[cuenta.cuentaBits((int) n)];
        //calcula s
        do {
            s++;
        } while ((n * s) % fi != 1);
        //definiri el tamaño de a

        System.out.println("clave= " + s);
        System.out.println("z= " + z);

        for (int i = 0; i < cadena.length; i++) {

            Icadena[i] = cadena[i];

            //System.out.println("[" + i + "] =" + cadena[i] + "  ascii= " + Icadena.get(i));
            System.out.println(cadena[i] + " = " + encripta(Icadena[i], n));
            Icadena[i] = encripta(Icadena[i], n);
            //System.out.println("e  " + (Icadena.get(0)) % z);
        }
        desencripta(Icadena);
    }
//cacula los bits de n

    public static long encripta(long cade, long n) {
        long au1 = 0, au2 = 0;

        a[0] = (cade) % z;
        for (int j = 1; j < a.length; j++) {
            a[j] = (long) (Math.pow(a[j - 1], 2) % z);
        }
        for (int i = 0; i < a.length; i++) {
            if (au1 != 0 && binario.Nbinario((int) n)[i] != 0 && au2 == 0) {
                au2 = a[i];
                au1 = (au1 * au2) % z;
                au2 = 0;
            }
            if (au1 == 0 && binario.Nbinario((int) n)[i] != 0) {
                au1 = a[i];
            }
        }
        return au1;
    }

    private static void desencripta(long[] Icade) {

        String res = "";
        System.out.println("desencriptando-------");

        System.out.println("z= " + z);
        for (int i = 0; i < Icade.length; i++) {
            System.out.println("valor = " + Icade[i]);
           //res += Character.toString((char) encripta(Icade[i], s));
            System.out.println(encripta(Icade[i], s));
        }
        System.out.println("clave= " + s);
        System.out.println(res);
    }
}
