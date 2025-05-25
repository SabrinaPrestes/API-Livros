package gerenciamento.livros_api.domain;

import gerenciamento.livros_api.dto.book.CreateBookRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books",
        uniqueConstraints = @UniqueConstraint(name = "UK_BOOK_ISBN", columnNames = "isbn"))


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

    @Column(nullable = false, length = 13)
    private String isbn;

    public Book(CreateBookRequest request) {
        this.title = request.title();
        this.author = request.author();
        this.publicationYear = request.publicationYear();
        this.isbn = request.isbn();
    }

    public Book(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
