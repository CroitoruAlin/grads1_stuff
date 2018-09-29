package training_day1_homework.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Book book1=new Book("Author1","Title1",123,290);
        Book book2=new Book("Author2","Title2",312,300);
        Library library=new Library();
        library.addBook(book1);
        library.addBook(book2);
        Librarian librarian=new Librarian();
        librarian.register(library,"Author3","Title3",899);
        Costumer costumer=new Costumer();
        librarian.viewHistory(book1);
        costumer.borrow(library,"Title1","Author1");
        librarian.viewHistory(book1);

    }
}
