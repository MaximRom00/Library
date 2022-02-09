package by.rom.restapi.mapper;

import by.rom.restapi.dto.BookDTO;
import by.rom.restapi.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookConvertor extends AbstractConvertor<BookDTO, Book>{

    public BookConvertor(ModelMapper modelMapper) {
        super(modelMapper, Book.class, BookDTO.class);
    }

}
