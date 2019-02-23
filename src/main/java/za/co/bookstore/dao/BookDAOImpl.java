package za.co.bookstore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import za.co.bookstore.model.Book;
import za.co.bookstore.repository.BookRepository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long currencyId) {
        return bookRepository.findById(currencyId).get();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long currencyId) {
        bookRepository.deleteById(currencyId);
    }


}
