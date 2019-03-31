package pl.bjur.shooter.club;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.*;
import pl.bjur.shooter.commons.BaseController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static pl.bjur.shooter.commons.ValidationUtils.validateEntityId;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/club")
public class ClubController implements BaseController<ClubDto> {

    private final MapperFacade mapper;
    private final ClubService service;

    @GetMapping
    public List<ClubDto> getAll() {
        return service.getAll().stream().map(a -> mapper.map(a, ClubDto.class)).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/{id}")
    public ClubDto getOne(@PathVariable Long id) {
        return mapper.map(service.getById(id), ClubDto.class);
    }

    @Override
    @PostMapping
    public ClubDto create(@RequestBody @Valid ClubDto dto) {
        return mapper.map(service.add(mapper.map(dto, Club.class)), ClubDto.class);
    }

    @Override
    @PutMapping("/{id}")
    public ClubDto update(@PathVariable Long id, @RequestBody @Valid ClubDto dto) {
        validateEntityId(id, dto);
        return mapper.map(service.update(mapper.map(dto, Club.class)), ClubDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
