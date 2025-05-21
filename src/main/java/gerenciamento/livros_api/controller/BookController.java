package gerenciamento.livros_api.controller;

import gerenciamento.livros_api.dto.CreateBookRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @PostMapping
    public void registerBook(@RequestBody CreateBookRequest request) {
        System.out.println(request);

    }
}
