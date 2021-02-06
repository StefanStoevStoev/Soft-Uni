package Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> autor;

    public Book(String title,int year, String...autors){
        this.title = title;
        this.year = year;
        this.setAutor(autors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAutor() {
        return autor;
    }

    public void setAutor(String... autor) {
        this.autor = Arrays.asList(autor);
    }
}
