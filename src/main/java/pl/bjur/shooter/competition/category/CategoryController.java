package pl.bjur.shooter.competition.category;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.*;
import pl.bjur.shooter.commons.BaseController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController implements BaseController<CategoryDto> {

    private final MapperFacade mapper;
    private final CategoryService service;

    @Override
    @GetMapping("/{id}")
    public CategoryDto getOne(@PathVariable Long id) {
        return mapper.map(service.getById(id), CategoryDto.class);
    }

    @Override
    @PostMapping
    public CategoryDto create(@RequestBody @Valid CategoryDto dto) {
        return mapper.map(service.add(mapper.map(dto, Category.class)), CategoryDto.class);
    }

    @Override
    @PutMapping
    public CategoryDto update(@RequestBody @Valid CategoryDto dto) {
        return mapper.map(service.update(mapper.map(dto, Category.class)), CategoryDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
