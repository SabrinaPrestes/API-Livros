package gerenciamento.livros_api.domain;

import gerenciamento.livros_api.dto.CreateBookRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books",
        uniqueConstraints = @UniqueConstraint(name = "UK_BOOK_ISBN", columnNames = "isbn"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String isbn;

    public Book(CreateBookRequest request) {
        this.title = request.title();
        this.author = request.author();
        this.publicationYear = request.publicationYear();
        this.isbn = request.isbn();
    }
}
