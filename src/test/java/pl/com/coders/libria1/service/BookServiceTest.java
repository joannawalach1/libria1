package pl.com.coders.libria1.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.com.coders.libria1.controller.BookCreateRequest;
import pl.com.coders.libria1.controller.BookUpdateRequest;
import pl.com.coders.libria1.controller.BookView;
import pl.com.coders.libria1.domain.Book;
import pl.com.coders.libria1.mapper.BookMapper;
import pl.com.coders.libria1.repository.BookRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DataJpaTest
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;


        @Before
        public void setUp() {
            MockitoAnnotations.openMocks(this);
        }

    @Test
    void getById() {
        Long id = 1L;
        Book testBook = new Book(1L, "Anne of Green Gables", "Montgomery", 10, LocalDateTime.now(), LocalDateTime.now());
        when(bookRepository.findById(id)).thenReturn(Optional.of(testBook));
        when(bookMapper.toView(testBook)).thenReturn(new BookView(1L, "Anne of Green Gables", "Montgomery", 10, LocalDateTime.now(), LocalDateTime.now()));

        BookView result = bookService.get(id);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
    }

    @Test
    void create() {
        BookCreateRequest bookCreateRequest = new BookCreateRequest("aaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaa", 2);
        Book bookToSave = new Book("aaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaa", 2);
        when(bookMapper.toEntity(bookCreateRequest)).thenReturn(bookToSave);
        when(bookRepository.save(any())).thenReturn(new Book(1L, "Anne of Green Gables", "Montgomery", 10, LocalDateTime.now(), LocalDateTime.now()));
        when(bookMapper.toView(any())).thenReturn(new BookView(1L, "Anne of Green Gables", "Montgomery", 10, LocalDateTime.now(), LocalDateTime.now()));
        BookView result = bookService.create(bookCreateRequest);
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
    }

    @Test
    void getAll() {
            List<Book> testBooks = new ArrayList<>();
            testBooks.add(new Book(1L, "Anne of Green Gables", "Montgomery", 10, LocalDateTime.now(), LocalDateTime.now()));
            testBooks.add(new Book(2L, "Anne of Green Gables1", "Montgomery1", 10, LocalDateTime.now(), LocalDateTime.now()));
            when(bookRepository.findAll()).thenReturn(testBooks);
            List<BookView> result = bookService.getAll();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void deleteById() {
        Long idToDelete = 1L;
        when(bookRepository.existsById(idToDelete)).thenReturn(true);
        assertThatCode(() -> bookService.delete(idToDelete))
                .doesNotThrowAnyException();
    }
//    @Test
//    void update() {
//            Long idToUpdate = 1L;
//        BookUpdateRequest updateRequest = new BookUpdateRequest("New Title", "New Author", 10);
//        Book existingBook = new Book(idToUpdate, "Anne of Green Gables", "Montgomery", 10, LocalDateTime.now(), LocalDateTime.now());
//
//        when(bookRepository.findById(idToUpdate)).thenReturn(Optional.of(existingBook));
//        when(bookRepository.save(any())).thenReturn(existingBook);
//
//        BookView result = bookService.update(idToUpdate, updateRequest);
//        assertThat(result.getId()).isEqualTo(idToUpdate);
//    }

    @Test
    void getByAuthor() {
            String author = "Rowling";
            Book testBook = new Book(1L, "Harry Potter", "Rowling", 10, LocalDateTime.now(), LocalDateTime.now());
            when(bookRepository.findByAuthor(author)).thenReturn(Optional.of(testBook));
            when(bookMapper.toView(testBook)).thenReturn(new BookView(1L, "Harry Potter", "Rowling", 10, LocalDateTime.now(), LocalDateTime.now()));

            BookView result = bookService.getByAuthor(author);

            assertThat(result).isNotNull();
            assertThat(result.getAuthor()).isEqualTo(author);
        }

    @Test
    void getByTitle() {
        String title = "Harry Potter";
        Book testBook = new Book(1L, "Harry Potter", "Rowling", 10, LocalDateTime.now(), LocalDateTime.now());
        when(bookRepository.findByAuthor(title)).thenReturn(Optional.of(testBook));
        when(bookMapper.toView(testBook)).thenReturn(new BookView(1L, "Harry Potter", "Rowling", 10, LocalDateTime.now(), LocalDateTime.now()));

        BookView result = bookService.getByAuthor(title);

        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo(title);
    }
}