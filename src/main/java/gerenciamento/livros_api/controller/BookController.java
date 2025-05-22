package gerenciamento.livros_api.controller;

import gerenciamento.livros_api.domain.Book;
import gerenciamento.livros_api.dto.CreateBookRequest;
import gerenciamento.livros_api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public void registerBook(@RequestBody CreateBookRequest request) {
        bookRepository.save(new Book(request));

    }
}
