package by.rom.restapi.controller;

import by.rom.restapi.dto.LibraryDTO;
import by.rom.restapi.service.LibraryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/library")
public class LibraryController extends AbstractController<LibraryDTO, LibraryService>{

    public LibraryController(LibraryService service) {
        super(service);
    }
}
