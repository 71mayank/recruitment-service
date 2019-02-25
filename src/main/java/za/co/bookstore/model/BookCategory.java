package za.co.bookstore.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "BOOK_CATEGORY")
@AllArgsConstructor
@Builder
public class BookCategory {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookCategoryId;

    @Column(name = "BOOK_CATEGORY", nullable = false)
    private String bookCategory;

}
