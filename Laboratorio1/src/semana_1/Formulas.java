/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana_1;
import java.util.Scanner;
/**
 *
 * @author gaat1
 */
public class Formulas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ejercicio a");
        
        System.out.print("Numerador 1: "); Double n1a = scanner.nextDouble();   
        System.out.print("Denominador 1 : "); Double d1a = scanner.nextDouble();    
        System.out.print("Numerador 2 : "); Double n2a = scanner.nextDouble();
        System.out.print("Denominador 2 : "); Double d2a = scanner.nextDouble();
        
        var resultado_a = String.format("El resultado es: %.1f", ((n1a / d1a) + (n2a/d2a)));
        System.out.println(resultado_a);
        
        System.out.println("Ejercicio b");
        
        System.out.print("Valor de x: "); Double xb = scanner.nextDouble();
        System.out.print("Valor de y: "); Double yb = scanner.nextDouble();
        System.out.print("Numerador 1: "); Double n1b = scanner.nextDouble();
        System.out.print("Denominador 1: "); Double d1b = scanner.nextDouble();
        System.out.print("Numerador 2: "); Double n2b = scanner.nextDouble();
        
        System.out.print("Denominador 2: "); Double d2b = scanner.nextDouble();
        
        var resultado_b = String.format("El resultado es: %.1f", ((n1b / (xb - d1b)) - ((n2b * xb * yb)/d2b)));
        System.out.println(resultado_b);
        
        System.out.println("Ejercicio c");
        
        System.out.print("Numerador 1: "); Double n1c = scanner.nextDouble();
        System.out.print("Denominador 1: "); Double d1c = scanner.nextDouble();
        System.out.print("Entero 1: "); Double Int1c = scanner.nextDouble();
        
        var resultado_c = String.format("El resultado es: %.1f", ((n1c/d1c) + Int1c));
        System.out.println(resultado_c);
        
        System.out.println("Ejercicio d");
        
        System.out.print("Entero 1: "); Double Int1d = scanner.nextDouble();
        System.out.print("Numerador 1: "); Double n1d = scanner.nextDouble();
        System.out.print("Denominador 1: "); Double d1d = scanner.nextDouble();
        
        var resultado_d = String.format("El resultado es: %.1f", (Int1d + (n1d/d1d)));
        System.out.println(resultado_d);
        
        System.out.println("Ejercicio e");

        System.out.print("Valor de a: "); Double ae = scanner.nextDouble();
        System.out.print("Valor de b: "); Double be = scanner.nextDouble();
        System.out.print("Valor de c: "); Double ce = scanner.nextDouble();
        System.out.print("Valor de d: "); Double de = scanner.nextDouble();
        System.out.print("Valor de e: "); Double ee = scanner.nextDouble();
        System.out.print("Valor de f: "); Double fe = scanner.nextDouble();
        System.out.print("Valor de g: "); Double ge = scanner.nextDouble();
        System.out.print("Valor de h: "); Double he = scanner.nextDouble();
        System.out.print("Valor de j: "); Double je = scanner.nextDouble();
        
        Double operacion_e =  (Math.pow(ae, 2) / (be-ce) ) +  (de - ee) / (fe - ( (ge * he) / je) );
        var resultado_e_s = String.format("El resultado es: %.1f", operacion_e); System.out.println(resultado_e_s);
        
        System.out.println("Ejercicio f");
        
        System.out.print("Valor de mf: "); Double mf= scanner.nextDouble();
        System.out.print("Valor de nf: "); Double nf= scanner.nextDouble();
        System.out.print("Valor de pf: "); Double pf= scanner.nextDouble();
        
        Double operacion_f = (mf/nf) + pf;
        var resultado_f_s = String.format("El resultado es: %.1f", operacion_f); System.out.println(resultado_f_s);
        
        System.out.println("Ejercicio g");
        System.out.print("Valor de mg: "); Double mg= scanner.nextDouble();
        System.out.print("Valor de ng: "); Double ng= scanner.nextDouble();
        System.out.print("Valor de pg: "); Double pg= scanner.nextDouble();
        System.out.print("Valor de qg: "); Double qg= scanner.nextDouble();
        
        Double operacion_g = mg + (ng/(pg-qg));
        var resultado_g_s = String.format("El resultado es: %.1f", operacion_g); System.out.println(resultado_g_s);
    
        System.out.println("Ejercicio h");
        System.out.print("Valor de ah: "); Double ah= scanner.nextDouble();
        System.out.print("Valor de bh: "); Double bh= scanner.nextDouble();
        System.out.print("Valor de ch: "); Double ch= scanner.nextDouble();
        System.out.print("Valor de dh: "); Double dh= scanner.nextDouble();
        
        Double operacion_h = Math.pow(ah,2)/Math.pow(bh,2)+Math.pow(ch,2)/Math.pow(dh,2);
        var resultado_h_s = String.format("El resultado es: %.1f", operacion_h); System.out.println(resultado_h_s);
         
        System.out.println("Ejercicio i");
        System.out.print("Valor de mi: "); Double mi= scanner.nextDouble();
        System.out.print("Valor de ni: "); Double ni= scanner.nextDouble();
        System.out.print("Valor de pi: "); Double pi= scanner.nextDouble();
        System.out.print("Valor de qi: "); Double qi= scanner.nextDouble();
        System.out.print("Valor de ri: "); Double ri= scanner.nextDouble();
        System.out.print("Valor de si: "); Double si= scanner.nextDouble();
        
        Double operacion_i = (mi+(ni/pi))/(qi-(ri/si));
        var resultado_i_s = String.format("El resultado es: %.1f", operacion_i); System.out.println(resultado_i_s);
        
        System.out.println("Ejercicio j");
        System.out.print("Valor de aj: "); Double aj= scanner.nextDouble();
        System.out.print("Valor de bj: "); Double bj= scanner.nextDouble();
        System.out.print("Valor de cj: "); Double cj= scanner.nextDouble();
        System.out.print("Valor de dj: "); Double dj= scanner.nextDouble();
        System.out.print("Valor de ej: "); Double ej= scanner.nextDouble();
        System.out.print("Valor de fj: "); Double fj= scanner.nextDouble();
        System.out.print("Valor de gj: "); Double gj= scanner.nextDouble();
        System.out.print("Valor de hj: "); Double hj= scanner.nextDouble();
        System.out.print("Numerador 1: "); Double n1j = scanner.nextDouble();
        System.out.print("Denominador 1: "); Double d1j = scanner.nextDouble();
        System.out.print("Numerador 2: "); Double n2j = scanner.nextDouble();
        
        Double operacion_j = ((n1j*aj)+bj)/(cj-((dj+n2j*ej)/(fj+(gj/(d1j*hj)))));
        var resultado_j_s = String.format("El resultado es: %.1f", operacion_j); System.out.println(resultado_j_s);

        System.out.println("Ejercicio k");
        System.out.print("Valor de ak: "); Double ak= scanner.nextDouble();
        System.out.print("Valor de bk: "); Double bk= scanner.nextDouble();
        System.out.print("Valor de xk: "); Double xk= scanner.nextDouble();
        System.out.print("Numerador 1: "); Double n1k = scanner.nextDouble();
        System.out.print("Denominador 1: "); Double d1k = scanner.nextDouble();
        System.out.print("Numerador 2: "); Double n2k = scanner.nextDouble();
        
        Double operacion_k = (Math.pow(ak, 2)+(n1k*ak*bk)+Math.pow(bk, 2))/(n2k/Math.pow(xk, 2)+d1k);
        var resultado_k_s = String.format("El resultado es: %.1f", operacion_k); System.out.println(resultado_k_s);

    }
}
