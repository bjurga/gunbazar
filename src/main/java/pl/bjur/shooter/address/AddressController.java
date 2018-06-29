package pl.bjur.shooter.address;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.*;
import pl.bjur.shooter.commons.BaseController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/address")
public class AddressController implements BaseController<AddressDto> {

    private final MapperFacade mapper;
    private final AddressService service;

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
    @PutMapping
    public AddressDto update(@RequestBody @Valid AddressDto dto) {
        return mapper.map(service.update(mapper.map(dto, Address.class)), AddressDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
