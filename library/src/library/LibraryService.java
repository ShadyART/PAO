package library;

import java.util.Date;

public class LibraryService {
    private User[] users = new User[50];
    private Book[] books = new Book[]{
            new Book(1, "Titlul1"),
            new Book(2, "Titlul2")
    };
    Reservation[] reservations = new Reservation[50];

    int currentIndex = 0;
    int currentUserIndex = 0;

    public Book[] listAll() {
        return books;
    }

    public int existsByTitle(String bookTitle) {
        // iteram prin lista de carti si returnam id / -1 if not found
        for(int i = 0; i < books.length; i++) {
            if(books[i].getTitle() == bookTitle) return i;
        }
        return -1;
    }


    private Date checkReturnDate (int bookId) {
        for(int i = 0; i < reservations.length; ++i) {
            if(reservations[i].getBook().getId() == bookId) {
                return reservations[i].getEndDate();
            }
        }
        return new Date();
    }


    public boolean checkAvailability(int bookId) {
        Date now = new Date();
        for(int i = 0; i < reservations.length; ++i) {
            if(reservations[i].getBook().getId() == bookId) {
                if(now.before(reservations[i].getEndDate())) return true;
                return false;
            }
        }
        return false;
    }

    public void addReservation(int userId, int bookId, Date endDate) {
        System.out.println("Userul cu id-ul: " + userId + ", vrea sa imprumute cartea cu id-ul: " + bookId);
        User user = getUserById(userId);
        Book book = getBookById(bookId);
        if(user == null || book == null) return;
        System.out.println("si cu titlul: " + book.getTitle() + " si se numeste " + user.getName());
        Date startDate = new Date();
        Reservation newReservation = new Reservation(user, book, startDate, endDate);
        reservations[currentIndex++] = newReservation;
    }

    private Book getBookById(int bookId) {
        for(Book book:books) {
            if(book.getId() == bookId) return book;
        }
        return null;
    }

    private User getUserById(int userId) {
        for(User user:users) {
            if(user.getId() == userId) return user;
        }
        return null;
    }

    public void registerUser (String userName) {
        User newUser = new User(userName);
        users[currentUserIndex++] = newUser;
    }

    public void printAllUsers () {
        for(int i = 0; i < currentUserIndex; ++i) {
            System.out.println("ID: " + users[i].getId() + ", Name: " + users[i].getName());
        }
    }
}
