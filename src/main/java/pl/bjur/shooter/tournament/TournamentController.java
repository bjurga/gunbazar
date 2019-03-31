package pl.bjur.shooter.tournament;

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
@RequestMapping("/api/tournament")
public class TournamentController implements BaseController<TournamentDto> {

    private final MapperFacade mapper;
    private final TournamentService service;

    @GetMapping
    public List<TournamentDto> getAll() {
        return service.getAll().stream().map(a -> mapper.map(a, TournamentDto.class)).collect(Collectors.toList());
    }

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
    @PutMapping("/{id}")
    public TournamentDto update(@PathVariable Long id, @RequestBody @Valid TournamentDto dto) {
        validateEntityId(id, dto);
        return mapper.map(service.update(mapper.map(dto, Tournament.class)), TournamentDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
