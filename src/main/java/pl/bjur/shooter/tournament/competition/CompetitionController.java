package pl.bjur.shooter.tournament.competition;

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
@RequestMapping("/api/competition")
public class CompetitionController implements BaseController<CompetitionDto> {

    private final MapperFacade mapper;
    private final CompetitionService service;

    @GetMapping
    public List<CompetitionDto> getAll() {
        return service.getAll().stream().map(a -> mapper.map(a, CompetitionDto.class)).collect(Collectors.toList());
    }

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
    @PutMapping("/{id}")
    public CompetitionDto update(@PathVariable Long id, @RequestBody @Valid CompetitionDto dto) {
        validateEntityId(id, dto);
        return mapper.map(service.update(mapper.map(dto, Competition.class)), CompetitionDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
