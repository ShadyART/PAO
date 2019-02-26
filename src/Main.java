import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int a = 10, b = 5;
//        int sum = a + b;
//        System.out.println("suma numerelor " + a + " si " + b + " este " + sum);
//        System.out.println("hello say sumthin");
//        Scanner scanner = new Scanner(System.in);
//        String ceAmCititDinConsola = scanner.nextLine();
//        System.out.println("am citit: " + ceAmCititDinConsola);

        /*

        citim actiuni:
        0 - exit
        1 - suma
        2 - diferenta

         */

        Scanner scanner = new Scanner(System.in);
        int action = 0, a = 0, b = 0;
        while(true) {
            System.out.println("citim actiuni : 0 - exit, 1 - suma, 2 - diferenta");
            action = scanner.nextInt();
            if (action == 0) break;
            System.out.println("da-mi 2 intregi:");
            a = scanner.nextInt();
            b = scanner.nextInt();
            switch (action) {
                case 1: // sum
                    System.out.println("suma = " + (a + b));
                    break;
                case 2: // dif
                    System.out.println("diferenta = " + (a - b));
                    break;
            }

        }
    }
}
