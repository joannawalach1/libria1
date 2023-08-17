package pl.com.coders.libria1.mapper;

import org.mapstruct.Mapper;
import pl.com.coders.libria1.controller.BookCreateRequest;
import pl.com.coders.libria1.controller.BookView;
import pl.com.coders.libria1.domain.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookView toView(Book book);
    Book toEntity(BookView view);

    Book toEntity(BookCreateRequest bookCreateRequest);
}
