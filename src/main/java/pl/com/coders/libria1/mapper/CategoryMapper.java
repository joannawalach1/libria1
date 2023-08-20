package pl.com.coders.libria1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.com.coders.libria1.controller.CategoryCreateRequest;
import pl.com.coders.libria1.controller.CategoryView;
import pl.com.coders.libria1.domain.Category;

    @Mapper(componentModel = "spring")
    public interface CategoryMapper {

        CategoryMapper instance = Mappers.getMapper((CategoryMapper.class));

        CategoryView toView(Category category);

        @Mapping(target = "id", source = "categoryTitle")
        Category toEntity(CategoryView categoryView);

        @Mapping(target = "categoryTitle", source = "categoryCreateRequest.categoryTitle")
        Category toEntity(CategoryCreateRequest categoryCreateRequest);


    }

