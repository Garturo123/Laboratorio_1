
package semana_2;
import java.util.Scanner;
/**
 *
 * @author gaat1
 */
public class AguilarGuillermoFechas {
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    int dia, mes, year, dia2, mes2, year2, pleca, pleca2, yearDif, mesDif, diaDif, dias = 0;
    String fecha, fecha2;
    System.out.print("Ingrese la fecha (Dia/mes/año): ");
    fecha = scanner.next().toLowerCase();
    pleca = fecha.indexOf("/");
    pleca2 = fecha.indexOf("/", pleca + 1);
    dia = Integer.parseInt(fecha.substring(0, pleca)); 
    mes = Integer.parseInt(fecha.substring(pleca+ 1,pleca2));       
    year = Integer.parseInt(fecha.substring(pleca2 + 1)); 
   
    System.out.print("Ingrese la segunda fecha (Dia/mes/año): ");
    fecha2 = scanner.next().toLowerCase();
    pleca = fecha2.indexOf("/");
    pleca2 = fecha2.indexOf("/", pleca + 1);
    dia2 = Integer.parseInt(fecha2.substring(0, pleca)); 
    mes2 = Integer.parseInt(fecha2.substring(pleca+ 1,pleca2));       
    year2 = Integer.parseInt(fecha2.substring(pleca2 + 1));
    
    if (((1 <= dia && dia <= 30) && (1 <= mes && mes <= 12) && (year >= 0)) && ((1 <= dia2 && dia2 <= 30) && (1 <= mes2 && mes2 <= 12)) &&(year2 >= 0))
     {
        yearDif = Math.abs(year - year2);
        mesDif = Math.abs(mes - mes2);
        diaDif = Math.abs(dia - dia2);

        dias += (yearDif*360);
        dias += (mesDif*30);
        dias += diaDif;

        System.out.println("Diferencias en dias entre las dos fechas: " + dias);
    }
     else{
     System.out.println("Fecha incorecta");
     }
    }
}
