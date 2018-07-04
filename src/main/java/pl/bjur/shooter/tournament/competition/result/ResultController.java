package pl.bjur.shooter.tournament.competition.result;

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
@RequestMapping("/api/result")
public class ResultController implements BaseController<ResultDto> {

    private final MapperFacade mapper;
    private final ResultService service;

    @GetMapping
    public List<ResultDto> getAll() {
        return service.getAll().stream().map(a -> mapper.map(a, ResultDto.class)).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/{id}")
    public ResultDto getOne(@PathVariable Long id) {
        return mapper.map(service.getById(id), ResultDto.class);
    }

    @Override
    @PostMapping
    public ResultDto create(@RequestBody @Valid ResultDto dto) {
        return mapper.map(service.add(mapper.map(dto, Result.class)), ResultDto.class);
    }

    @Override
    @PutMapping("/{id}")
    public ResultDto update(@PathVariable Long id, @RequestBody @Valid ResultDto dto) {
        validateEntityId(id, dto);
        return mapper.map(service.update(mapper.map(dto, Result.class)), ResultDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
