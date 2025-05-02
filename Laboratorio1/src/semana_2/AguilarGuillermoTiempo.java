
package semana_2;
import java.util.Scanner;

/**
 *
 * @author gaat1
 */
public class AguilarGuillermoTiempo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Ingrese la cantidad de segundos: ");
        int segundos = scanner.nextInt();
        int horas = 0, minutos = 0;
        if (segundos > 0){
            if (segundos >= 3600){
                horas = segundos / 3600;
                segundos -= 3600 * horas;
            }if (segundos >= 60){
                minutos = segundos / 60;
                segundos -= 60 * minutos;
            }
            
        String Horas = (horas > 0) ? ("Horas: " + horas) : "";
        String Min = (minutos > 0) ? (" Minutos: " + minutos) : "";
        String Seg = (segundos > 0) ? (" Segundos: " + segundos) : "";
        System.out.println(Horas+Min+Seg);
        }else{
        System.out.print("No se permite este valor.");
        }
    }
}
