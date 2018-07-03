package pl.bjur.shooter.competition;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.*;
import pl.bjur.shooter.commons.BaseController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/competition")
public class CompetitionController implements BaseController<CompetitionDto> {

    private final MapperFacade mapper;
    private final CompetitionService service;

    @Override
    @GetMapping("/{id}")
    public CompetitionDto getOne(@PathVariable Long id) {
        return mapper.map(service.getById(id), CompetitionDto.class);
    }

    @Override
    @PostMapping
    public CompetitionDto create(@RequestBody @Valid CompetitionDto dto) {
        return mapper.map(service.add(mapper.map(dto, Competition.class)), CompetitionDto.class);
    }

    @Override
    @PutMapping
    public CompetitionDto update(@RequestBody @Valid CompetitionDto dto) {
        return mapper.map(service.update(mapper.map(dto, Competition.class)), CompetitionDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
