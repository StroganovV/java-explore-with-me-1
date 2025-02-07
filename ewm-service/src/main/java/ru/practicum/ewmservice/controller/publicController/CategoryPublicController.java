package ru.practicum.ewmservice.controller.publicController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewmservice.dto.CategoryDto;
import ru.practicum.ewmservice.service.CategoryService;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Collection;

@RestController
@RequestMapping(path = "/categories")
@AllArgsConstructor
public class CategoryPublicController {
    private CategoryService service;

    @GetMapping
    public Collection<CategoryDto> getAll(@RequestParam(defaultValue = "0") @PositiveOrZero int from,
                                          @RequestParam(defaultValue = "10") @Positive int size) {

        return service.getAll(from, size);
    }

    @GetMapping("/{catId}")
    public CategoryDto get(@PathVariable @Positive long catId) {
        return service.get(catId);
    }
}
