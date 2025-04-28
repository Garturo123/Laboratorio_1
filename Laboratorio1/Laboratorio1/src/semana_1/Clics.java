/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana_1;

/**
 *
 * @author gaat1
 */
public class Clics {
         public static void main(String[] args) {
            Double clic_1 = 0.25 * 100;
            Double clic_2 = .30 * 60;
            Double clic_3 = .60 * 20;
            Double resultado = clic_1 + clic_2 + clic_3;
            Double promedio = resultado / 180;
            Double Iva = resultado * 0.16;
            Double total = resultado + Iva;
            String mensaje = String.format("Costo promedio por clic (CPC prom.): %.2f, Costo total + Iva: %.2f ", promedio, total);
            System.out.println(mensaje);
         }
}
