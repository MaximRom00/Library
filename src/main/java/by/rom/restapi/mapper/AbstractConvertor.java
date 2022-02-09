package by.rom.restapi.mapper;

import by.rom.restapi.dto.BaseDTO;
import by.rom.restapi.entity.BaseEntity;
import org.modelmapper.ModelMapper;
/**
 * Base class for all mappers
 * @param <ENTITY> Entity class.
 * @param <DTO> DTO class.
 */
public abstract class AbstractConvertor<DTO extends BaseDTO, ENTITY extends BaseEntity>{

    private final ModelMapper modelMapper;
    private final Class<DTO> dtoClass;
    private final Class<ENTITY> entityClass;

    public AbstractConvertor(ModelMapper modelMapper, Class<ENTITY> entityClass, Class<DTO> dtoClass) {
        this.modelMapper = modelMapper;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    public DTO toDto(ENTITY entity){
        return modelMapper.map(entity, dtoClass);
    }

    public ENTITY toEntity(DTO dto){
        return modelMapper.map(dto, entityClass);
    }

}
