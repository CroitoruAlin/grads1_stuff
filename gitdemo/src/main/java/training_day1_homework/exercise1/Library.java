package training_day1_homework.exercise1;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    public Library() {
        books=new ArrayList<>();
    }

    public Library(List<Book> books) {
        this.books=books;
    }
    public void addBook(Book book)
    {
        books.add(book);

    }
    public Book getBook(String title,String author)
    {
        for(Book b:books)
            if(b.getAuthor().equals(author) && b.getTitle().equals(title))
                return b;

        return null;
    }

}
