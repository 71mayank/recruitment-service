package za.co.bookstore.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "BOOK_TITLE")
@AllArgsConstructor
@Builder
public class BookTitle {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookTitleId;

    @Column(name = "BOOK_TITLE", nullable = false)
    private String bookTitle;

    @Column(name = "BOOK_TITLE_LANG", nullable = false)
    private String bookTitleLang;

}
