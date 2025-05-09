package semana_3;
/**
 * @author gaat1
 */
public class AguilarGuillermoPrimos {
    public static void main(String[] args){
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
            System.out.println("El numero " + random + primo + " es primo.");
    }
}
