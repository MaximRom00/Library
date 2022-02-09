package by.rom.restapi.mapper;

import by.rom.restapi.dto.LibraryDTO;
import by.rom.restapi.entity.Library;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LibraryConvertor extends AbstractConvertor<LibraryDTO, Library>{

    public LibraryConvertor(ModelMapper modelMapper) {
        super(modelMapper, Library.class, LibraryDTO.class);
    }
}
