package gerenciamento.livros_api.dto;

public record CreateBookRequest(
        String title,
        String author,
        Integer publicationYear,
        String isbn

) {}
