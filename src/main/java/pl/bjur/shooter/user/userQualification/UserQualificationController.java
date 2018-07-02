package pl.bjur.shooter.user.userQualification;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.*;
import pl.bjur.shooter.commons.BaseController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/userqualification")
public class UserQualificationController implements BaseController<UserQualificationDto> {

    private final MapperFacade mapper;
    private final UserQualificationService service;

    @Override
    @GetMapping("/{id}")
    public UserQualificationDto getOne(@PathVariable Long id) {
        return mapper.map(service.getById(id), UserQualificationDto.class);
    }

    @Override
    @PostMapping
    public UserQualificationDto create(@RequestBody @Valid UserQualificationDto dto) {
        return mapper.map(service.add(mapper.map(dto, UserQualification.class)), UserQualificationDto.class);
    }

    @Override
    @PutMapping
    public UserQualificationDto update(@RequestBody @Valid UserQualificationDto dto) {
        return mapper.map(service.update(mapper.map(dto, UserQualification.class)), UserQualificationDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
