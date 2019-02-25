package za.co.bookstore.dao;

import za.co.bookstore.model.Book;

import java.util.List;

public interface BookDAO {

    Book saveBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Long bookId);

    void deleteBook(Long bookId);

}
