package gerenciamento.livros_api.dto;

public record CreateBookRequest(
        Long id,
        String title,
        String author,
        Integer publicationYear,
        String isbn

) {}
