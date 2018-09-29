package training_day1_homework.exercise1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Book {
    private final static Integer NUMBER_PAGES=100;
    private String author;
    private String title;
    private Integer isbn;
    private Integer numberPages;
    private List<Date> dateBorrowed;


    public Book(String author, String title, Integer isbn, Integer numberPages) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.numberPages = numberPages;
        dateBorrowed=new ArrayList<>();

    }

    public Book(String title, String author, Integer isbn) {
        this.title=title;
        this.author=author;
        this.isbn=isbn;
        this.numberPages = NUMBER_PAGES;
    }
    public void updateHistory()
    {
        dateBorrowed.add(Calendar.getInstance().getTime());
    }
    public void showHistory()
    {
        if(dateBorrowed.isEmpty())
            System.out.println("Cartea nu a fost imprumutata niciodata");
        for(Date d:dateBorrowed)
            System.out.println(d);
    }
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public Integer getNumberPages() {
        return numberPages;
    }

    List<Date> getDateBorrowed() {
        return dateBorrowed;
    }
}
