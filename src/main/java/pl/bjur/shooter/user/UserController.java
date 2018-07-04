package pl.bjur.shooter.user;

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
@RequestMapping("/api/user")
public class UserController implements BaseController<UserDto> {

    private final MapperFacade mapper;
    private final UserService service;

    @GetMapping
    public List<UserDto> getAll() {
        return service.getAll().stream().map(a -> mapper.map(a, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/{id}")
    public UserDto getOne(@PathVariable Long id) {
        return mapper.map(service.getById(id), UserDto.class);
    }

    @Override
    @PostMapping
    public UserDto create(@RequestBody @Valid UserDto dto) {
        return mapper.map(service.add(mapper.map(dto, User.class)), UserDto.class);
    }

    @Override
    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody @Valid UserDto dto) {
        validateEntityId(id, dto);
        return mapper.map(service.update(mapper.map(dto, User.class)), UserDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}