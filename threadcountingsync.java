package Ohjelmointia;

import java.util.Scanner;
//Säikeitten ajoa synkrossa.
public class KT2 {
    public static void main(String[] args) {
    //Kysytään montako ajoa ajetaan. 
    Scanner lukija = new Scanner(System.in);
    System.out.println("Montako säiettä haluat ajaa?");
    
    // Jotta säikeitä voisi ajaa synkassa täytyy esitellä yhteinen olio luokalle
    // Muuten for loopissa jokainen kierros luo uuden olion luokasta ja sync ei toimi.
    final PrintDiamond print = new PrintDiamond();

    int luku = lukija.nextInt();
    //Ajetaan annettumäärä säikeitä.
    for (int i = 0; i < luku; i++) {
        Thread tulosta = new Thread(print);
        tulosta.start();
        }
    lukija.close();
    }
}


class PrintDiamond implements Runnable{

    @Override
    public synchronized void run() {
        
    try {
        
        int i, j, space = 1;
        space = 4 - 1;
        
        for (j = 1; j <= 4; j++) {
            for (i = 1; i <= space; i++) {
                System.out.print(" ");
            }
            space--;

            for (i = 1; i <= 2 * j - 1; i++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        space = 1;

        for (j = 1; j <= 4 - 1; j++) {
            for (i = 1; i <= space; i++) {
                System.out.print(" ");
            }
            space++;
            for (i = 1; i <= 2 * (4 - j) - 1; i++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    } catch (Exception e) {
        System.out.println("Vooiii että nyt meni jotain pieleen!");
    }
    }
}