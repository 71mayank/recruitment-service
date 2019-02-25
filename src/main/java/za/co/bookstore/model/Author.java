package za.co.bookstore.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "ForeignKeyAssoAuthortEntity")
@Table(name = "AUTHOR")
@AllArgsConstructor
@Builder
public class Author {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;

    @Column(name = "AUTHOR_NAME")
    private String authorName;

    @ManyToOne
    private Book book;
}
