package pl.bjur.shooter.shootingrange;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.*;
import pl.bjur.shooter.commons.BaseController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/shootingrange")
public class ShootingRangeController implements BaseController<ShootingRangeDto> {

    private final MapperFacade mapper;
    private final ShootingRangeService service;

    @Override
    @GetMapping("/{id}")
    public ShootingRangeDto getOne(@PathVariable Long id) {
        return mapper.map(service.getById(id), ShootingRangeDto.class);
    }

    @Override
    @PostMapping
    public ShootingRangeDto create(@RequestBody @Valid ShootingRangeDto dto) {
        return mapper.map(service.add(mapper.map(dto, ShootingRange.class)), ShootingRangeDto.class);
    }

    @Override
    @PutMapping
    public ShootingRangeDto update(@RequestBody @Valid ShootingRangeDto dto) {
        return mapper.map(service.update(mapper.map(dto, ShootingRange.class)), ShootingRangeDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

