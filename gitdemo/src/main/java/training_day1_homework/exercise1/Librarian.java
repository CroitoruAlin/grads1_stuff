package training_day1_homework.exercise1;

public class Librarian {

    public void register(Library library,String title,String author,Integer isbn)
    {
        library.addBook(new Book(title,author,isbn));
    }
    public void viewHistory(Book book)
    {
        book.showHistory();
    }
}
