package pl.bjur.shooter.club;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.*;
import pl.bjur.shooter.commons.BaseController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/club")
public class ClubController implements BaseController<ClubDto> {

    private final MapperFacade mapper;
    private final ClubService service;

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
    @PutMapping
    public ClubDto update(@RequestBody @Valid ClubDto dto) {
        return mapper.map(service.update(mapper.map(dto, Club.class)), ClubDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
