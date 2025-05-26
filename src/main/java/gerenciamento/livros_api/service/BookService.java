package gerenciamento.livros_api.service;

import gerenciamento.livros_api.domain.Book;
import gerenciamento.livros_api.dto.book.CreateBookRequest;
import gerenciamento.livros_api.dto.book.CreateBookResponse;
import gerenciamento.livros_api.dto.book.UpdateBookRequest;
import gerenciamento.livros_api.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Transactional
    public void registerBook(CreateBookRequest request) {
        Book book = new Book(request);
        bookRepository.save(book);

    }


    public List<CreateBookResponse> listAllBooks() {
        return bookRepository.findAll().stream().map(CreateBookResponse::fromEntity).toList();

    }

    @Transactional
    public CreateBookResponse updateBook(Long id, UpdateBookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));

        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setPublicationYear(request.publicationYear());
        book.setIsbn(request.isbn());

        Book updatedBook = bookRepository.save(book);

        return CreateBookResponse.fromEntity(updatedBook);
    }


}
