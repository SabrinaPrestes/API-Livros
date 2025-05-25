package gerenciamento.livros_api.service;

import gerenciamento.livros_api.domain.Book;
import gerenciamento.livros_api.dto.book.CreateBookRequest;
import gerenciamento.livros_api.dto.book.CreateBookResponse;
import gerenciamento.livros_api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void registerBook(CreateBookRequest request) {
        Book book = new Book(request);
        bookRepository.save(book);

    }

    public List<CreateBookResponse> listAllBooks() {
        return bookRepository.findAll().stream().map(CreateBookResponse::fromEntity).toList();

    }
}
