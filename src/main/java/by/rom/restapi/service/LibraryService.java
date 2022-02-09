package by.rom.restapi.service;

import by.rom.restapi.dto.LibraryDTO;
import by.rom.restapi.entity.Book;
import by.rom.restapi.entity.Library;
import by.rom.restapi.exception.NotFoundException;
import by.rom.restapi.mapper.LibraryConvertor;
import by.rom.restapi.repository.AuthorRepository;
import by.rom.restapi.repository.BookRepository;
import by.rom.restapi.repository.LibraryRepository;
import by.rom.restapi.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibraryService implements BaseService<LibraryDTO>{

    private final LibraryConvertor convertor;
    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final AuthorRepository authorRepository;

    public LibraryService(LibraryConvertor convertor, LibraryRepository libraryRepository,
                          BookRepository bookRepository, MemberRepository memberRepository, AuthorRepository authorRepository) {
        this.convertor = convertor;
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public LibraryDTO getById(Long id) {

        Library library = libraryRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found with id - " + id));

        return convertor.toDto(library);
    }

    @Override
    public List<LibraryDTO> getAll() {
        return libraryRepository
                .findAll()
                .stream()
                .map(convertor::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LibraryDTO saveOrUpdate(LibraryDTO dto) {
        Library library = dtoToEntity(dto);

        libraryRepository.save(library);

        return convertor.toDto(library);
    }

    @Override
    public void deleteById(Long id) {
        libraryRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found with id - " + id));

        libraryRepository.deleteById(id);
    }

//    Convert new library.
    private Library dtoToEntity(LibraryDTO dto) {
        Library library = convertor.toEntity(dto);

//        Check new member from library in db. If member is present we set this member to our new library.
        memberRepository
                .findAll()
                .stream()
                .filter(member -> library.getMember().equals(member))
                .findAny()
                .ifPresent(library::setMember);

//        Check book in db.
        Optional<Book> bookFromBase = bookRepository
                .findAll()
                .stream()
                .filter(book -> library.getBook().equals(book))
                .findFirst();

        if (bookFromBase.isPresent()){
            Book book = bookFromBase.get();
            book.setYear(library.getBook().getYear());
            book.setAuthor(library.getBook().getAuthor());

            library.setBook(book);
        }

//       Check author in db. If author is present in db we set this author to the book.
        if(library.getBook().getAuthor() != null){
            authorRepository.findAll()
                    .stream()
                    .filter(library.getBook().getAuthor()::equals)
                    .findFirst()
                    .ifPresent(library.getBook()::setAuthor);
        }
        return library;
    }
}
