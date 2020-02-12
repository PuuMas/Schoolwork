package Saikeet;

import java.util.Scanner;

/**
 *
 * @author PuuMas
 */
public class Kt1 {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);
        System.out.println("Montako säiettä haluat ajaa?");

        int luku = lukija.nextInt();

        for (int i = 0; i < luku; i++) {
            Thread object = new Thread(new PrintDiamond());
            object.start();
        }
        lukija.close();
    }

}
//Säikeitten ajoa ei synkrossa.
class PrintDiamond implements Runnable {

    public void run() {

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
