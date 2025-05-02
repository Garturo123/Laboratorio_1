
package semana_2;
import java.util.Scanner;
/**
 *
 * @author gaat1
 */
public class AguilarGuillermoClases {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int mes, dia, aprobados, reprobados, alumnos,pleca,pleca2;
        double promedio, asistencia, precio, ingresos;
        String semanaDia, nivel = "", fecha;
        System.out.print("Ingrese la fecha (Dia Semana/dia/mes): ");
        fecha = scanner.next().toLowerCase();
        pleca = fecha.indexOf("/");
        pleca2 = fecha.indexOf("/", pleca + 1);
        semanaDia = fecha.substring(0, pleca); 
        dia = Integer.parseInt(fecha.substring(pleca+ 1,pleca2));       
        mes = Integer.parseInt(fecha.substring(pleca2 + 1));      
        
        if (mes <= 12 & mes > 0){
            if (dia < 31 & dia > 0){
                switch (semanaDia){
                        case "lunes":
                            nivel = "Inicial";
                            break;
                        case "martes":
                            nivel = "Intermedio";
                            break;
                        case "miercoles":
                            nivel = "Avanzado";
                            break;
                        case "jueves":
                            nivel = "Practica Hablada";
                            break;    
                        case "viernes":
                            nivel = "Viajeros";
                            break;
                        default: 
                            System.out.print("Error: La escuela solo opera los dias: Lunes, Martes, Miercoles, Jueves, Viernes");
                }
                
                
                if (dia == 1 && (mes == 1 || mes == 7 ) && nivel.equals("Viajeros")){
                                System.out.println("Comienzo de nuevo ciclo");
                                System.out.print("Ingrese la cantidad de alumnos para este ciclo: ");
                                alumnos = scanner.nextInt();
                                System.out.print("Ingrese el precio por alumno: $");
                                precio = scanner.nextDouble();
                                ingresos = precio * alumnos;
                                System.out.println("Ingreso total para este ciclo es: $" + ingresos);
                }
                else if ((nivel.equals("Inicial") || nivel.equals("Intermedio") || nivel.equals("Avanzado")) ){
                    System.out.print("Ingrese la cantidad de aprobados: ");
                    aprobados = scanner.nextInt();
                    System.out.print("Ingrese la cantidad de reprobados: ");
                    reprobados = scanner.nextInt();
                    promedio = ((aprobados+reprobados)/reprobados);
                    System.out.print("Promedio de aprobados: " + String.format("%.2f",promedio) );
                }else if (nivel.equals("Practica Hablada")){
                    System.out.print("Ingrese el porcentaje de los estudiantes que asistieron: %");
                    asistencia = scanner.nextDouble();
                    if (asistencia >= 50){
                        System.out.print("La mayoria asistio.");
                    }else {
                        System.out.print("La mayoria no asistio.");
                    }
                    
                }
            }else{
                System.out.print("Error: El dia tiene que ser de un valor de 1 a 31");
            }
        }else{
            System.out.print("Error: El mes tiene que ser de un valor de 1 a 12");
        }
        
    }
}
