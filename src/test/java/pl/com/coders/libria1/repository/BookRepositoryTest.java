package pl.com.coders.libria1.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.com.coders.libria1.domain.Book;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testCreate(){
        Book sapkowski = bookRepository.save(new Book("Wiedźmin 1", "Sapkowski", 10));
        bookRepository.findAll();
    }


}