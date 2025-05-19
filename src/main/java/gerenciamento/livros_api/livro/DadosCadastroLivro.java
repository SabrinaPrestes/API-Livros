package gerenciamento.livros_api.livro;

public record DadosCadastroLivro(
        String titulo,
        String autor,
        Integer anoPublicacao,
        String isbn
) {}
