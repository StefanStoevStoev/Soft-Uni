package Compare;

import java.util.Arrays;

import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> autor;

    public Book(String title, int year, String... autors) {
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

    @Override
    public int compareTo(Book other) {
        int compareByTitle = this.title.compareTo(other.title);
        if (compareByTitle > 0) {
            return 1;
        } else if (compareByTitle < 0) {
            return -1;
        }
        return Integer.compare(this.year,other.year);
    }

    @Override
    public String toString(){
        return String.format("title: %s year: %d",this.title,this.year);
    }
}
