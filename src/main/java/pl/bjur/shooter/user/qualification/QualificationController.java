package pl.bjur.shooter.user.qualification;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.*;
import pl.bjur.shooter.commons.BaseController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/qualification")
public class QualificationController implements BaseController<QualificationDto> {

    private final MapperFacade mapper;
    private final QualificationService service;

    @Override
    @GetMapping("/{id}")
    public QualificationDto getOne(@PathVariable Long id) {
        return mapper.map(service.getById(id), QualificationDto.class);
    }

    @Override
    @PostMapping
    public QualificationDto create(@RequestBody @Valid QualificationDto dto) {
        return mapper.map(service.add(mapper.map(dto, Qualification.class)), QualificationDto.class);
    }

    @Override
    @PutMapping
    public QualificationDto update(@RequestBody @Valid QualificationDto dto) {
        return mapper.map(service.update(mapper.map(dto, Qualification.class)), QualificationDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
