package Library;

import java.util.List;

public class Main {
    public static void main(String[] args){

        Library library = new Library(new Book("Foo",12,"asd"),
                new Book("Bar",15));

        for(Book book : library){
            System.out.println(book.getTitle());
        }
    }
}
