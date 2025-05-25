package gerenciamento.livros_api.domain;

import gerenciamento.livros_api.dto.CreateBookRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books",
        uniqueConstraints = @UniqueConstraint(name = "UK_BOOK_ISBN", columnNames = "isbn"))
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Book {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(name = "publication_year", nullable = false)
    private Integer publicationYear;
    private String isbn;

    public Book(CreateBookRequest request) {
        this.title = request.title();
        this.author = request.author();
        this.publicationYear = request.publicationYear();
        this.isbn = request.isbn();
    }

    public Book(){}


}
