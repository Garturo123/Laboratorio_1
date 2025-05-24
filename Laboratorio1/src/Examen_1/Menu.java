package Examen_1;
import java.util.Scanner;


/**
 * @author gaat1
 */
public class Menu {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        boolean salir = false;
        while (!salir){
            System.out.println("\n===MENU=== ");
            System.out.println("1. Piramide");
            System.out.println("2. Cifrar palabras");
            System.out.println("3. Papel, tijeras o piedra");
            System.out.println("4. Adivinar numeros");
            System.out.println("5. Salir");
            System.out.print("Selecione una opcion: ");

            int opcion = scan.nextInt();
            switch (opcion){
                case 1: //Piramide de numeros primos
                    System.out.print("Cantidad de la fila de la piramide: ");
                    int fila = scan.nextInt();
                    int num = 1;
                    int resultado = 0;
                    String filas = "";
                    String piramide = "";
                    for (int f = 0; fila > f; f++){
                        for (int c = -1; c < f; c++){
                            filas += num + " ";
                            resultado += num;
                            num += 2;
                        }
                        filas += "= " + resultado + "\n";
                        resultado = 0;
                        piramide += filas;
                        filas = "";
                    }
                    System.out.print(piramide);
                break;
                case 2://encriptar
                    boolean Continuar = true;
                    
                    String alfabeto = "abcdefghijklmnopqrstuvwxyz";
                    String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    
                    
                    while (Continuar){
                        System.out.println("<<<MENU>>> ");
                        System.out.println("1. Cifrar");
                        System.out.println("2. DesCifrar");
                        System.out.println("3. Salir");
                        System.out.print("Selecione una opcion: ");
                        int op = scan.nextInt();
                        switch (op){
                            case 1:
                                System.out.print("Ingresa la palabra que quieras cifrar: ");
                                String palabra = scan.next();
                                String cifrado = "";
                                for (int index = 0;index < palabra.length();index++){
                                    char letra = palabra.charAt(index);
                                    int alreves = 25;
                                    if (alfabeto.indexOf(letra) != -1){
                                        alreves -= alfabeto.indexOf(letra);

                                        cifrado += alfabeto.charAt(alreves);
                                    }else if(ALFABETO.indexOf(letra) != -1){
                                        alreves -= ALFABETO.indexOf(letra);
                                        cifrado += ALFABETO.indexOf(alreves);
                                    }else{
                                        cifrado += letra;
                                    }
                                }
                                System.out.println("Esta es palabra cifrafa: " + cifrado);
                            break;
                            case 2:    
                                System.out.print("Ingresa la palabra que quieras descifrar: ");
                                palabra = scan.next();

                                String Descifrado = "";

                                for (int index = 0;index < palabra.length();index++){
                                    char letra = palabra.charAt(index);
                                    int alreves = 25;
                                    if (alfabeto.indexOf(letra) != -1){
                                        alreves -= alfabeto.indexOf(letra);

                                        Descifrado += alfabeto.charAt(alreves);
                                    }else if(ALFABETO.indexOf(letra) != -1){
                                        alreves -= ALFABETO.indexOf(letra);
                                        Descifrado += ALFABETO.indexOf(alreves);
                                    }else{
                                        Descifrado += letra;
                                    }
                                }
                                System.out.println("Esta es palabra cifrafa: " + Descifrado);
                            break;
                            case 3:
                                Continuar = false;
                            break;
                            default:
                                System.out.println("No existe esta opcion. ");
                            break;
                        }
                    }    
                break;
                case 3: // tijera, papel o piedra
                    System.out.println("Bienvenido usuario, este es el juego del papel, piedra y tijera.");
                    boolean continuar = true;
                    while (continuar){
                        int min = 1, max = 3;
                        int range = max - min + 1;
                        int random = (int)(Math.random() * range) + min;
                        String Compu = "";
                        String continuacion = "";
                        String jugador = "";
                        switch (random){
                            case 1:
                                Compu = "papel";
                            break;
                            case 2:
                                Compu = "tijera";
                            break;
                            case 3:
                                Compu = "piedra";
                            break;
                        }
                        while (!jugador.equals("tijeras") && !jugador.equals("papel") && !jugador.equals("piedra")){
                            System.out.println("Escoja entre papel, tijeras y piedra.");
                            jugador = scan.next().toLowerCase();

                            if (Compu.equals("tijeras") && jugador.equals("papel") || Compu.equals("piedra") && jugador.equals("tijera") || Compu.equals("papel") && jugador.equals("piedra")){
                                System.out.println("Victoria de la computadora.");
                            }else if(Compu.equals(jugador)){
                                System.out.println("Empate de computadora y jugador");
                            }else if(Compu.equals("papel") && jugador.equals("tijeras") || Compu.equals("tijera") && jugador.equals("piedra") || Compu.equals("piedra") && jugador.equals("papel")){
                                System.out.println("Victoria del jugador.");
                            }else{
                                System.out.println("Vuelva a escoger");
                            }   
                        }
                            while (!continuacion.equals("si") && !continuacion.equals("no")){
                                System.out.println("Volver a jugar. si/no");
                                continuacion = scan.next().toLowerCase();
                                if (continuacion.equals("si")){
                                    continuar = true;
                                }else if (continuacion.equals("no")){
                                    continuar = false;
                                }else{
                                    System.out.println("Vuelve a intentar.");
                                }
                            }
                    }
                break;
                case 4: // Adivina Numeros
                    int intentos = 0;
                    int min = 1, max = 100;
                    int range = max - min + 1; 
                    int random = (int)(Math.random() * range) + min;
                    for (int i = 10; i >= 0; i--){
                        intentos++;
                        System.out.println("Adivine un numero entre el 1 y el 100");
                        int jugador = scan.nextInt();
                        if (random > jugador){
                            System.out.println("El numero aleatorio es mayor.");
                        }else if (random < jugador){
                            System.out.println("El numero aleatorio es menor.");
                        }else if(i == 0){
                            System.out.println("El numero aleatorio es: " + random);
                        }else{
                            System.out.println("Adivinastes el numero! ");
                            System.out.println("Numero de intentos: "+ intentos);
                            i = -1;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Apagando sistema...");
                    salir = true;
                    break;
                default:
                    System.out.println("Vuelva a intentar.");
                    break;
            }
        
        }
    }
}
