package semana_3;
import java.util.Scanner;
/**
 * @author gaat1
 */
public class AguilarGuillermoNumerosPerfectos {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Escriba un numero entero que crea ser perfecto: ");
        int num = scan.nextInt();
        String perfect = " no es ";
        for (int i=0;num>i;i++){
            if (((Math.pow(2, i)-1)%2)==1){
                var perfecto = Math.pow(2, i-1) * (Math.pow(2, i)-1);
                if (num == perfecto){
                perfect= " es ";
                }
            }
        }
        System.out.println("Tu numero "+num+ perfect+"perfecto.");
    }
}
