package library;

import java.util.Date;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        System.out.println("Welcome to the library");

        LibraryService libraryService = new LibraryService();
        Book[] booksThatExist = libraryService.listAll();
//        libraryService.addReservation(0, 0, new Date());
        libraryService.registerUser("Gigel");
        libraryService.registerUser("Gigica");
        libraryService.registerUser("Alt_Gigel");
        int run = 1;
        Scanner scanner = new Scanner(System.in);
        while(run == 1) {
            System.out.println("Options: 1 - list all books, 2 - list all users, 0 - exit");
            int op = scanner.nextInt();
            switch(op) {
                case 1:
                    for(Book book:booksThatExist) {
                        System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle());
                    }
                    break;
                case 2:
                    libraryService.printAllUsers();
                    break;
                case 0:
                    run = 0;
                    break;
                default:
                    System.out.println("Unknown Command");
            }
        }
    }
}
