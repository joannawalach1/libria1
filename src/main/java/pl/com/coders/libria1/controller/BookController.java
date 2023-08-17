package pl.com.coders.libria1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.com.coders.libria1.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public BookView get(Long id) {
        return bookService.get(id);
    }

    @PostMapping
    public BookView create(@RequestBody BookCreateRequest bookCreateRequest) {
        return bookService.create(bookCreateRequest);
    }
}
