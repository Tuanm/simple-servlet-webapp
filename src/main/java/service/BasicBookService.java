package service;

import model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicBookService implements BookService {
    private static Map<Integer, Book> books;

    static {
        books = new HashMap<>();
        for (int index = 1; index <= 69; index++) {
            books.put(
                    index,
                    new Book(
                            index,
                            "Sex Education chapter " + index,
                            "Prof. Do ",
                            "DM Publishing House",
                            69f)
            );
        }
        // TODO: Add more books to this map by reading from a Database
    }


    @Override
    public boolean add(Book book) {
        if (book != null && !book.isTrash()) {
            int id = book.getId();
            if (!books.containsKey(id)) {
                books.put(id, book);
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(int id) {
        books.remove(id);
    }

    @Override
    public void update(Book book) {
        if (book != null && !book.isTrash()) {
            int id = book.getId();
            if (books.containsKey(id)) {
                books.put(book.getId(), book);
            }
        }
    }

    @Override
    public Book findById(int id) {
        return books.get(id);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
}
