package pl.bjur.shooter.address;

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
@RequestMapping("/api/address")
public class AddressController implements BaseController<AddressDto> {

    private final MapperFacade mapper;
    private final AddressService service;

    @GetMapping
    public List<AddressDto> getAll() {
        return service.getAll().stream().map(a -> mapper.map(a, AddressDto.class)).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/{id}")
    public AddressDto getOne(@PathVariable Long id) {
        return mapper.map(service.getById(id), AddressDto.class);
    }

    @Override
    @PostMapping
    public AddressDto create(@RequestBody @Valid AddressDto dto) {
        return mapper.map(service.add(mapper.map(dto, Address.class)), AddressDto.class);
    }

    @Override
    @PutMapping("/{id}")
    public AddressDto update(@PathVariable Long id, @RequestBody @Valid AddressDto dto) {
        validateEntityId(id, dto);
        return mapper.map(service.update(mapper.map(dto, Address.class)), AddressDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
