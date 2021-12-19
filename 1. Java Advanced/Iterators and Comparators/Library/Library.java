package Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }


    @Override
    public Iterator<Book> iterator() {
        return new LibIterator(books);
    }

    public static class LibIterator implements Iterator<Book> {
        private Book[] books;
        private int nextIndex;

        public LibIterator(Book[] books) {
            this.nextIndex = 0;
            this.books = books;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < books.length;
        }

        @Override
        public Book next() {
            Book book = books[nextIndex];
            nextIndex = nextIndex + 1;
            return book;
        }
    }
}
