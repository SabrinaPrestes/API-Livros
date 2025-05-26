package gerenciamento.livros_api.controller;

import gerenciamento.livros_api.dto.book.CreateBookRequest;
import gerenciamento.livros_api.dto.book.CreateBookResponse;
import gerenciamento.livros_api.dto.book.UpdateBookRequest;
import gerenciamento.livros_api.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    public List<CreateBookResponse> listBook() {
        return bookService.listAllBooks();

    }
    @PutMapping("/{id}")
    public ResponseEntity<CreateBookResponse> updateBook(@PathVariable Long id, @RequestBody UpdateBookRequest request) {
        return ResponseEntity.ok(bookService.updateBook(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}

