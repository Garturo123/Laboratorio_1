package semana_3;
import java.util.Scanner;

/**
 * @author gaat1
 */
public class AguilarGuillermoMenu {
    public static void main(String[] args){
        String salir = "NO";
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        int PalabrasAlreves = 0, NumerosPerfectos = 0, NumerosPrimos = 0, Votaciones = 0;
        while (salir .equals("NO")){
            System.out.println("\n**** MENU ****");
            System.out.println("1. Palabras Alreves ");
            System.out.println("2. Numeros Perfectos ");
            System.out.println("3. Numeros Primos ");
            System.out.println("4. Votaciones ");
            System.out.println("5. Salir ");
            System.out.print("Ingrese un numero del 1 al 5 para elegir un programa: ");
           
            byte op = scan.nextByte();
            switch (op){
                
                case 1: //Palabras alreves
                    System.out.print("\nIngresar la cantidad de palabras: ");
                    int cantidad = scan.nextInt(), largo, mayor = 0;
                    String palabra, palidromo, frase = "";
                    PalabrasAlreves += 1;
                    for (int i=1; cantidad >= i; i++){
                        String alreves = "";
                        System.out.print("Ingresar la palabra #"+i+": ");
                        palabra = scan.next().toLowerCase();
                        largo = palabra.length();
                        for (int k = largo-1; k >= 0; k-- ){
                            char letra = palabra.charAt(k);
                            alreves += letra;
                        }
                        System.out.println("Alreves: "+ alreves+ "\n");
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
                    break;
                    
             case 2: //Numeros Perfectos
                System.out.print("\nEscriba un numero entero que crea ser perfecto: ");
                NumerosPerfectos += 1;
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
                 break;
                 
             case 3://Numeros Primos
                 NumerosPrimos += 1;
                String primo = "";
                int random = (int)(Math.random()*100);
                for (int j =2; j <= Math.sqrt(random); j++){
                    if (random % j == 0){
                        primo = " no";
                        break;
                    }
                }
                if (random < 2){
                    primo = " no";
                }
                System.out.println("\nEl numero " + random + primo + " es primo.");
                 break;
                 
             case 4://Votaciones
                 Votaciones += 1;
                System.out.print("\nEscriba el numero de votantes: ");
                int votantes = scan.nextInt();
                double porcent = 100/votantes, indice=0;
                double Azul = 0, Rojo = 0, Negro = 0, Amarillo = 0;
                String Ganador = "";
                for (int i = 1; votantes >= i; i++){
                    System.out.print("Votara por el partido: AZUL, ROJO, NEGRO o AMARILLO: ");
                    String voto = scan.next().toUpperCase();
                    switch (voto){
                        case "AZUL":
                            Azul += porcent;
                            break;
                        case "ROJO":
                            Rojo += porcent;
                            break;
                        case "NEGRO":
                            Negro += porcent;
                            break;
                        case "AMARILLO":
                            Amarillo += porcent;
                            break;
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
                    System.out.println("\nEl partido "+Ganador+" gano con una aprobacion del: "+ indice + "%");
                }else{
                    System.out.println("\nVotacion Fallida");
                }
                 break;
             case 5:
                System.out.println("\nIngreso a palabras alreves unas: "+ PalabrasAlreves);
                System.out.println("Ingresastes a Numeros Perfectos unas: " +NumerosPerfectos);
                System.out.println("Ingresastes a Numeros Primos unas: " + NumerosPrimos);
                System.out.println("Ingresastes a Votaciones unas: " + Votaciones);
                 salir = "Si";
            }
        }
    }
}
