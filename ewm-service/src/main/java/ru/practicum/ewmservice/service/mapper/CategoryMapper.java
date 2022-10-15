package ru.practicum.ewmservice.service.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.ewmservice.dto.CategoryDto;
import ru.practicum.ewmservice.dto.newDto.NewCategoryDto;
import ru.practicum.ewmservice.model.Category;

import java.time.LocalDateTime;

@Component
public class CategoryMapper {
    public static CategoryDto toCategoryDto(Category category) {
        return new CategoryDto(category.getId(), category.getName());
    }

    public static Category fromNewCategoryDto(NewCategoryDto dto) {
        Category cat = new Category();
        cat.setName(dto.getName());
        cat.setCreated(LocalDateTime.now());
        return cat;
    }
}
