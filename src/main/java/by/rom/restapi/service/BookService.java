package by.rom.restapi.service;

import by.rom.restapi.dto.BookDTO;
import by.rom.restapi.entity.Book;
import by.rom.restapi.exception.NotFoundException;
import by.rom.restapi.mapper.BookConvertor;
import by.rom.restapi.repository.AuthorRepository;
import by.rom.restapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookService implements BaseService<BookDTO>{

    private final BookConvertor convertor;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public BookService(BookConvertor convertor, BookRepository bookRepository,
                       AuthorRepository authorRepository) {
        this.convertor = convertor;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public BookDTO getById(Long id) {
        Book book = bookRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found with id - " + id));
        return convertor.toDto(book);
    }

    @Override
    public List<BookDTO> getAll() {

        return bookRepository
                .findAll()
                .stream()
                .map(convertor::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO saveOrUpdate(BookDTO dto) {
        Book book = dtoToEntity(dto);

        bookRepository.save(book);

        return convertor.toDto(book);
    }


    @Override
    public void deleteById(Long id) {
        bookRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found with id - " + id));
        bookRepository.deleteById(id);
    }

    private Book dtoToEntity(BookDTO dto) {
        Book book = convertor.toEntity(dto);

//        Check author from new book. If author is present we set him to our new book.
        if (book.getAuthor() != null){
            authorRepository.findAll()
                    .stream()
                    .filter(author -> book.getAuthor().getName().equalsIgnoreCase(author.getName()))
                    .findFirst()
                    .ifPresent(book::setAuthor);
        }
        return book;
    }
}
