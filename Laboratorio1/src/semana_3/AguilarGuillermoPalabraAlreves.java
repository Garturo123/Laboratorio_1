package semana_3;
import java.util.Scanner;
/**
 * @author gaat1
 */
public class AguilarGuillermoPalabraAlreves {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Ingresar la cantidad de palabras: ");
        int cantidad = scan.nextInt(), largo, mayor = 0;
        String palabra, palidromo, frase = "";
        
        for (int i=1; cantidad >= i; i++){
            String alreves = "";
            System.out.print("Ingresar la palabra #"+i+": ");
            palabra = scan.next();
            largo = palabra.length();
            for (int k = largo-1; k >= 0; k-- ){
                char letra = palabra.charAt(k);
                alreves += letra;
            }
            System.out.println("Alreves: "+ alreves);
            if (largo >= mayor){
                if (largo > mayor){
                    frase = "";
                }
                mayor = largo;
                if (alreves.equals(palabra)){
                    palidromo = "si";
                }else{
                    palidromo = "no";
                }
                frase +=  "Esta es la palabra mas larga: "+ palabra + " y " + palidromo + " es un palidromo.\n";
            }
        }
        System.out.println(frase);
    }
}
