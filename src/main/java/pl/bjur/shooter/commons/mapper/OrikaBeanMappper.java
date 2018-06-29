package pl.bjur.shooter.commons.mapper;

import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;


@Component
public class OrikaBeanMappper extends ConfigurableMapper implements ApplicationContextAware {

    public OrikaBeanMappper() {
        super(false);
    }

    public OrikaBeanMappper(MapperFactory factory, ApplicationContext applicationContext) {
        this.factory = factory;
        this.applicationContext = applicationContext;
    }

    private MapperFactory factory;
    private ApplicationContext applicationContext;


    @Override
    protected void configure(MapperFactory factory) {
        this.factory = factory;
        factory.getConverterFactory().registerConverter(new PassThroughConverter(LocalDateTime.class));
        addAllSpringBeans(applicationContext);
//        registerMappings();
    }

    @SuppressWarnings("rawtypes")
    public void addMapper(Mapper<?, ?> mapper) {
        factory.classMap(mapper.getAType(), mapper.getBType())
                .byDefault()
                .customize((Mapper) mapper)
                .register();
    }


    public void addConverter(Converter<?, ?> converter) {
        factory.getConverterFactory().registerConverter(converter);
    }

    @SuppressWarnings("rawtypes")
    private void addAllSpringBeans(final ApplicationContext applicationContext) {
        Map<String, Mapper> mappers = applicationContext.getBeansOfType(Mapper.class);
        mappers.values().forEach(this::addMapper);

        Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class);
        converters.values().forEach(this::addConverter);
        factory.getConverterFactory().setMapperFacade(factory.getMapperFacade());
    }

    // to sie przyda bo to jest przyklad jak rejestrowac i mapowac rozne obiekty ze soba (chyba :-D )
//    private ClassMap<AddressDto, Address> buildAddressDtoToAddressMapping() {
//        return factory.classMap(AddressDto.class, Address.class)
//                .byDefault().toClassMap();
//    }
//
//    private void registerMappings() {
//        factory.registerClassMap(buildAddressDtoToAddressMapping());
//    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        init();
    }

}
