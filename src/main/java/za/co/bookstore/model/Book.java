package za.co.bookstore.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "ForeignKeyAssoBookEntity")
@Table(name = "BOOK")
@Builder
@AllArgsConstructor
public class Book {
    @Id
    @Column(name = "BOOK_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private BookCategory bookCategory;

    @OneToOne(cascade = CascadeType.ALL)
    private BookTitle bookTitle;

    @Column(name = "BOOK_YEAR")
    private String bookYear;

    @Column(name = "BOOK_PRICE")
    private Double bookPrice;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="BOOK_ID")
    private Set<BookAuthor> authors;

}