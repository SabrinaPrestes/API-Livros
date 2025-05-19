package gerenciamento.livros_api.controller;


import gerenciamento.livros_api.livro.DadosCadastroLivro;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PostMapping
    public void cadastrarLivro(@RequestBody DadosCadastroLivro dadosCadastroLivro) {

    }
}
