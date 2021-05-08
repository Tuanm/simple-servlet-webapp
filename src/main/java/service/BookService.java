package service;

import model.Book;

import java.util.List;

public interface BookService {
    boolean add(Book book);
    void remove(int id);
    void update(Book book);
    Book findById(int id);
    List<Book> findAll();
}
