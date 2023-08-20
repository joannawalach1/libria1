package pl.com.coders.libria1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.com.coders.libria1.controller.BookCreateRequest;
import pl.com.coders.libria1.controller.BookView;
import pl.com.coders.libria1.domain.Book;
import pl.com.coders.libria1.domain.Category;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    @Mapping(target = "id", ignore = true)

    Book toEntity(BookView bookView);

    @Mapping(target = "id", ignore = true)
    Book toEntity(BookCreateRequest bookCreateRequest);


    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    BookView toView(Book book);

    default Category map(Long category) {
        if (category == null) {
            return null;
        }

        Category categoryObject = new Category();
        categoryObject.setId(category);
        return categoryObject;
    }
}
