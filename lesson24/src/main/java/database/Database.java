package database;

import domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Database {
    private static List<Book> books = new ArrayList<>();

    public void create(Book book){
        book.setId(UUID.randomUUID());
        books.add(book);
    }

    public static List<Book> getByAuthor(String author) {
        if (author == null || author.isBlank()){
            return books;
        }

        return books.stream()
                .filter(book -> author.equals(book.getAuthor()))
                .toList();
    }
}
