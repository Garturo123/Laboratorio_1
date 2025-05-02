package semana_2;
import java.util.Scanner;

/**
 *
 * @author gaat1
 */
public class AguilarGuillermoPagos {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int cod, categoria,horaExtra = 0;
        double horas = 0, horasMas = 0, salario = 0;
        String nombre, apellido;
        System.out.print("Ingrese el codigo de empleado: ");
        cod = scanner.nextInt();
        System.out.print("Ingrese el nombre de empleado: ");
        nombre = scanner.next();
        System.out.print("Ingrese el apellido de empleado: ");
        apellido = scanner.next();
        System.out.print("Ingrese horas trabajadas por el empleado: ");
        horas = scanner.nextDouble();
        System.out.println("Cat. 1 - $40 , Cat. 2 - $50, Cat. 3 - $85 , Cat. 4 - $0 por hora extra");
        System.out.print("Ingrese la categoria a la que pertenece: ");
        categoria = scanner.nextInt();
        switch (categoria){
            case 1:
                horaExtra = 40;
                break;
            case 2:
                horaExtra = 50;
                break;
            case 3:
                horaExtra = 85;
                break;
            case 4:
                horaExtra = 0;
                break;
        }
        if (horas > 40){
            horasMas = horas - 40;
            salario += 40 * 35.99;
            if (horasMas > 15){
                salario += 15 * horaExtra;
            }   
        }else {
            salario = horas * 35.99;
        }
        System.out.println("Codigo: "+ cod + "   Nombre: " + nombre + "   Apellido: " + apellido);
        System.out.println("Horas trabajadas: " + horas + " Categoria: " + categoria + " Salario: " + String.format("%.2f", salario));
    }
}
