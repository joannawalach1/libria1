package pl.com.coders.libria1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.coders.libria1.domain.Book;
import pl.com.coders.libria1.domain.Category;
import pl.com.coders.libria1.repository.BookRepository;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/test1")
public class TestController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("{n}")
    public void generateBook(@PathVariable int n) {

        Category category = new Category();
        category.setCategoryTitle("romance");
        for (int i = n; i > 0; i--) {
            bookRepository.save(new Book(129L+i, "q"+1,"w"+i,i, category, LocalDateTime.now(), LocalDateTime.now()));
        }
    }
}
