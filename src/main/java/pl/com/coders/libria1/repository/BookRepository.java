package pl.com.coders.libria1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.coders.libria1.domain.Book;

@Repository
public interface BookRepository  extends CrudRepository<Book, Long> {
}
