package pl.bjur.shooter.tournament;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.*;
import pl.bjur.shooter.commons.BaseController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/competition")
public class TournamentController implements BaseController<TournamentDto> {

    private final MapperFacade mapper;
    private final TournamentService service;

    @Override
    @GetMapping("/{id}")
    public TournamentDto getOne(@PathVariable Long id) {
        return mapper.map(service.getById(id), TournamentDto.class);
    }

    @Override
    @PostMapping
    public TournamentDto create(@RequestBody @Valid TournamentDto dto) {
        return mapper.map(service.add(mapper.map(dto, Tournament.class)), TournamentDto.class);
    }

    @Override
    @PutMapping
    public TournamentDto update(@RequestBody @Valid TournamentDto dto) {
        return mapper.map(service.update(mapper.map(dto, Tournament.class)), TournamentDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
