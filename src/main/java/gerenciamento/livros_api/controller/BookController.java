package gerenciamento.livros_api.controller;

import gerenciamento.livros_api.domain.Book;
import gerenciamento.livros_api.dto.book.CreateBookRequest;
import gerenciamento.livros_api.dto.book.CreateBookResponse;
import gerenciamento.livros_api.repository.BookRepository;
import gerenciamento.livros_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public void registerBook(@RequestBody CreateBookRequest request) {
        bookService.registerBook(request);

    }

    @GetMapping
    public List<CreateBookResponse> list() {
        return bookService.listAllBooks();
    }

}

