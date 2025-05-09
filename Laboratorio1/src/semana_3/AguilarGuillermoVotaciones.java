package semana_3;
import java.util.Scanner;
/**
 * @author gaat1
 */
public class AguilarGuillermoVotaciones {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Escriba el numero de votantes: ");
        int votantes = scan.nextInt();
        double porcent = 100/votantes, indice=0;
        double Azul = 0, Rojo = 0, Negro = 0, Amarillo = 0;
        String Ganador = "";
        for (int i = 0; votantes >= i; i++){
            System.out.print("Votara por el partido: AZUL, ROJO, NEGRO o AMARILLO: ");
            String voto = scan.next().toUpperCase();
            switch (voto){
                case "AZUL":
                    Azul += porcent;
                case "ROJO":
                    Rojo += porcent;
                case "NEGRO":
                    Negro += porcent;
                case "AMARILLO":
                    Amarillo += porcent;
            }  
        } 
        if (Azul>=60){
            Ganador= "Azul";
            indice = Azul;
        }else if (Rojo >= 60){
            Ganador= "Rojo";
            indice = Rojo;
        }else if (Negro >= 60){
            indice = Negro;
            Ganador= "Negro";
        }else if (Amarillo >= 60){
            Ganador= "Amarillo";
            indice = Amarillo;
        }
        if(!Ganador.equals("")){
            System.out.print("El partido "+Ganador+" gano con una aprobacion del: "+ indice + "%");
        }else{
            System.out.print("Votacion Fallida");
        }
    }
}
