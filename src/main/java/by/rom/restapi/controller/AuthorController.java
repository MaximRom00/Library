package by.rom.restapi.controller;

import by.rom.restapi.dto.AuthorDTO;
import by.rom.restapi.service.AuthorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
public class AuthorController extends AbstractController<AuthorDTO, AuthorService>{

    public AuthorController(AuthorService service) {
        super(service);
    }
}
