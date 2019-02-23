package za.co.bookstore.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "ForeignKeyAssoAuthortEntity")
@Table(name = "BOOK_AUTHOR")
@AllArgsConstructor
@Builder
public class BookAuthor {
    @Id
    @Column(name = "BOOK_AUTHOR_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookAuthorId;

    @Column(name = "BOOK_ID", nullable = true)
    private Long bookId;

    @ManyToOne
    private Book book;
}
