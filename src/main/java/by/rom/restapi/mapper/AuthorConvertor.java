package by.rom.restapi.mapper;

import by.rom.restapi.dto.AuthorDTO;
import by.rom.restapi.entity.Author;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorConvertor extends AbstractConvertor<AuthorDTO, Author>{

    public AuthorConvertor(ModelMapper modelMapper) {
        super(modelMapper, Author.class, AuthorDTO.class);
    }
}
