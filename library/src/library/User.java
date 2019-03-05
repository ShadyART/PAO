package library;

import java.util.Date;

public class User {
    private final int id;
    private final String name;
    private Date startDate;

    public static int count;

    public User(String name) {
        this.id = count++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
