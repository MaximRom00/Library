package by.rom.restapi.controller;

import by.rom.restapi.dto.BookDTO;
import by.rom.restapi.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookController extends AbstractController<BookDTO, BookService> {

    public BookController(BookService service) {
        super(service);
    }
}
