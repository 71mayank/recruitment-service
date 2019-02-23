
package za.co.bookstore.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.bookstore.model.Book;
import za.co.bookstore.model.BookAuthor;
import za.co.bookstore.model.BookCategory;
import za.co.bookstore.model.BookTitle;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void whenSaveBook_thenReturnBook() {
        // given
        Book book = buildBook();
        entityManager.persist(book);
        entityManager.flush();
        // when
        Optional<Book> found = bookRepository.findById(1L);
        // then
        String code = found.get().getBookYear();
        assertThat(code).isEqualTo("2010");
    }

    private Book buildBook() {
        Set authors = new HashSet<BookAuthor>();
        authors.add(BookAuthor.builder().bookAuthorId(1L).build());
        return Book.builder()
                .authors(authors)
                .bookCategory(BookCategory.builder().bookCategory("cooking").bookCategoryId(1L).build())
                .bookPrice(200.0)
                .bookYear("2010")
                .bookTitle(BookTitle.builder().bookTitle("Everyday Italian").bookTitleLang("en").bookTitleId(1L).build())
                .build();
    }
}

