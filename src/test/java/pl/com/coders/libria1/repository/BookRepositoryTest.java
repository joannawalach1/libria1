package pl.com.coders.libria1.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.com.coders.libria1.domain.Book;
import pl.com.coders.libria1.domain.Category;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        Category category = new Category();
        category.setCategoryTitle("romance");
        Book book1 = new Book(2L, "Anne of Green Gables", "Montgomery", 10,category, LocalDateTime.now(), LocalDateTime.now());
        Book book2 = new Book(3L, "Wuthering Heights", "Bronte", 5, category, LocalDateTime.now(), LocalDateTime.now());
        Book book3 = new Book(4L, "Harry Potter", "Rowling", 20, category, LocalDateTime.now(), LocalDateTime.now());
    }

    @Test
    void testSaveBookAndFindById(Category category) {
        Book newBook = new Book(4L, "Wiedzmin", "Stepkowski", 2, category, LocalDateTime.now(), LocalDateTime.now());
        Book savedBook = bookRepository.save(newBook);
        Optional<Book> foundBook = bookRepository.findById(newBook.getId());
        assertThat(foundBook.isPresent());
    }

    @Test
    void testFindByAuthor(Category category) {
        Book newBook = new Book(4L, "Wiedzmin", "Stepkowski", 2, category, LocalDateTime.now(), LocalDateTime.now());
        Book savedBook = bookRepository.save(newBook);
        Optional<Book> foundBook = bookRepository.findByAuthor(savedBook.getAuthor());
        assertThat(foundBook.isPresent());
        assertEquals(foundBook.get().getAuthor(), savedBook.getAuthor());
    }

    @Test
    void testFindAll(Category category) {
        Book newBook = new Book(4L, "Wiedzmin", "Sapkowski", 2, category, LocalDateTime.now(), LocalDateTime.now());
        Book savedBook = bookRepository.save(newBook);
        Iterable<Book> allBooks = bookRepository.findAll();
        Long count = allBooks.spliterator().getExactSizeIfKnown();
        assertEquals(1, count);
        assertEquals("Sapkowski", savedBook.getAuthor());

    }

    @Test
    void testCount(Category category) {
        List<Book> booksToSave = Arrays.asList(
                new Book(2L, "Anne of Green Gables", "Montgomery", 10, category, LocalDateTime.now(), LocalDateTime.now()),
                new Book(3L, "Wuthering Heights", "Bronte", 5, category, LocalDateTime.now(), LocalDateTime.now()),
                new Book(4L, "Harry Potter", "Rowling", 20, category, LocalDateTime.now(), LocalDateTime.now()),
                new Book(5L, "Wiedzmin", "Sapkowski", 2, category,  LocalDateTime.now(), LocalDateTime.now())
        );

        Iterable<Book> savedBooks = bookRepository.saveAll(booksToSave);
        long countedBooks = StreamSupport.stream(savedBooks.spliterator(), false).count();

        assertThat(countedBooks).isEqualTo(4);
    }

    @Test
    void testDeleteById(Category category) {
        Book book1 = new Book(6L, "Anne of Green Gables", "Montgomery", 10, category, LocalDateTime.now(), LocalDateTime.now());
        Book book = bookRepository.save(book1);
        bookRepository.deleteById(book.getId());
        Optional<Book> removedBook = bookRepository.findById(book.getId());
        assertThat(removedBook.isEmpty());
    }

    @Test
    void testDeleteAll(Category category) {
        Book book1 = new Book(2L, "Anne of Green Gables", "Montgomery", 10, category,  LocalDateTime.now(), LocalDateTime.now());
        Book book2 = new Book(3L, "Wuthering Heights", "Bronte", 5, category, LocalDateTime.now(), LocalDateTime.now());
        Book book3 = new Book(4L, "Harry Potter", "Rowling", 20, category, LocalDateTime.now(), LocalDateTime.now());
        Book book4 = new Book(5L, "Wiedzmin", "Sapkowski", 2, category, LocalDateTime.now(), LocalDateTime.now());
        Iterable<Book> savedBook = bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4));
        bookRepository.deleteAll();
        Iterable<Book> allBooks = bookRepository.findAll();
        assertThat(allBooks).isEmpty();
        assertThat(allBooks).hasSize(0);

    }

    @Test
    void testUpdate(Category category) {
        Book book1 = new Book(6L, "Anne of Green Gables", "Montgomery", 10, category, LocalDateTime.now(), LocalDateTime.now());
        Book book = bookRepository.save(book1);
        book.setTitle("Scarlet Letter");
        book.setAuthor("Hawthorne");
        book.setAmount(30);
        Book updatedBook = bookRepository.save(book1);
        assertThat(updatedBook.getTitle()).isEqualTo("Anne of Green Gables");
        assertThat(updatedBook.getAuthor()).isEqualTo("Montgomery");
    }
}