package pl.com.coders.libria1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.coders.libria1.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public BookView get(Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public BookView create(@RequestBody BookCreateRequest bookCreateRequest) {
        return bookService.create(bookCreateRequest);
    }

    @GetMapping("/books")
    public List<BookView> getAllBooks() {
        return bookService.getAll();
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<BookView> updatedBook(
            @PathVariable Long id,
            @RequestBody BookUpdateRequest bookUpdateRequest) {
        BookView updatedBook = bookService.update(id, bookUpdateRequest);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> removeBook(
            @PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/book/remove")
    public ResponseEntity<Void> removeAllBooks() {
        bookService.deleteAllBooks();
        return ResponseEntity.noContent().build();
    }

}

