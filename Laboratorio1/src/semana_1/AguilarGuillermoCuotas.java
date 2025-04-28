package semana_1;

/**
 *
 * @author gaat1
 */
import java.util.Scanner;
public class AguilarGuillermoCuotas {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    
    System.out.println("Ingrese el monto de la cuota: ");
    Double monto = scanner.nextDouble();
    
    System.out.println("Ingrese el plazo de la cuota en meses: ");
    Double meses = scanner.nextDouble();
    
    System.out.println("Ingrese el interes mesual de la cuota ejem. (0.15): ");
    Float interes = scanner.nextFloat();
            
    System.out.println("Ingrese la comision por cuota: ");
    Double comision = scanner.nextDouble();
    
    System.out.println("Ingrese el porcentaje del seguro de la cuota ejem. (0.15): ");
    Float porcentaje = scanner.nextFloat();
    
    Double InteresMensual = monto * interes;
    Double Amortiguacion = monto / meses;
    Double Seguro = monto * porcentaje;
    
    var PagoMensual = Math.round(InteresMensual + Amortiguacion + comision + Seguro);
    var TotalPagar = Math.round(PagoMensual * meses);
    System.out.println("**** PAGOS DE CUOTAS ****");
    System.out.println("Cuota de Pago Mensual: HNL " + PagoMensual);
    System.out.println("Total a Pagar: HNL " + TotalPagar);
    
            }
}
