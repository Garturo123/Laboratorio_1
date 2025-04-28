package semana_1;
/**
 * @author gaat1
 */
import java.util.Scanner;
public class AguilarGuillermoPlanillaDeEmpleo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in).useDelimiter("\n");
       System.out.println("Ingrese el nombre del empleado");
       String nombre = scanner.next();
       System.out.println("Ingresar horas trabajadas durante el mes");
       Double horas = scanner.nextDouble();
       System.out.println("Ingrese su tarifa de hora por trabajo");
       Double tarifa = scanner.nextDouble();
       Double salario = (horas / 4) * tarifa; 
       
       
       System.out.println("----- Boleta del Empleado -----");
       System.out.println("Nombre del Empleado: " + nombre);
       System.out.println("Horas de Trabajo Mensual: " + horas);
       System.out.println("Tarija por hora: Lps." + tarifa);
       System.out.println("Salario del Empleado Semanal: Lps." + salario);
        
    }
    
}
