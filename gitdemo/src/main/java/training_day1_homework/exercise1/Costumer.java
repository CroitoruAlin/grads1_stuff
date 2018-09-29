package training_day1_homework.exercise1;

public class Costumer {

    public Book borrow(Library library, String title,String author)
    {
        Book b=library.getBook(title,author);
        if(b==null)
            return null;
        else {
            b.updateHistory();
            return b;
        }
    }
}
