package gerenciamento.livros_api.dto.book;

import gerenciamento.livros_api.domain.Book;

public record CreateBookResponse(Long id,
                                 String title,
                                 String author,
                                 Integer publicationYear,
                                 String isbn) {

    public static CreateBookResponse fromEntity(Book book) {
        return new CreateBookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear(),
                book.getIsbn()
        );
    }

}
