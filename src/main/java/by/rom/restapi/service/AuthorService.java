package by.rom.restapi.service;

import by.rom.restapi.dto.AuthorDTO;
import by.rom.restapi.entity.Author;
import by.rom.restapi.exception.NotFoundException;
import by.rom.restapi.mapper.AuthorConvertor;
import by.rom.restapi.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService implements BaseService<AuthorDTO>{

    private final AuthorConvertor convertor;
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorConvertor convertor, AuthorRepository authorRepository) {
        this.convertor = convertor;
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDTO getById(Long id) {
        Author author = authorRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found with id - " + id));
        return convertor.toDto(author);
    }

    @Override
    public List<AuthorDTO> getAll() {
        return authorRepository
                .findAll()
                .stream()
                .map(convertor::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDTO saveOrUpdate(AuthorDTO dto) {
        Author author = convertor.toEntity(dto);

        authorRepository.save(author);
        return convertor.toDto(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found with id - " + id));
        authorRepository.deleteById(id);
    }
}
