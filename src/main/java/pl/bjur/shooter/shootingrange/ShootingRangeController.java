package pl.bjur.shooter.shootingrange;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.*;
import pl.bjur.shooter.address.Address;
import pl.bjur.shooter.address.AddressService;
import pl.bjur.shooter.commons.BaseController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static pl.bjur.shooter.commons.ValidationUtils.validateEntityId;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/shootingrange")
public class ShootingRangeController implements BaseController<ShootingRangeDto> {

    private final MapperFacade mapper;
    private final ShootingRangeService service;
    private final AddressService addressService;

    @GetMapping
    public List<ShootingRangeDto> getAll() {
        return service.getAll().stream().map(a -> mapper.map(a, ShootingRangeDto.class)).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/{id}")
    public ShootingRangeDto getOne(@PathVariable Long id) {
        return mapper.map(service.getById(id), ShootingRangeDto.class);
    }

    @Override
    @PostMapping
    public ShootingRangeDto create(@RequestBody @Valid ShootingRangeDto dto) {
        addressService.add(mapper.map(dto.getAddress(), Address.class));
        ShootingRange shootingRange = mapper.map(dto, ShootingRange.class);
        shootingRange.setAddress(addressService.add(mapper.map(dto.getAddress(), Address.class)));
        return mapper.map(service.add(shootingRange), ShootingRangeDto.class);
    }

    @Override
    @PutMapping("/{id}")
    public ShootingRangeDto update(@PathVariable Long id, @RequestBody @Valid ShootingRangeDto dto) {
        validateEntityId(id, dto);
        return mapper.map(service.update(mapper.map(dto, ShootingRange.class)), ShootingRangeDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

