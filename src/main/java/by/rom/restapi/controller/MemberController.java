package by.rom.restapi.controller;

import by.rom.restapi.dto.MemberDTO;
import by.rom.restapi.service.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController extends AbstractController<MemberDTO, MemberService>{

    public MemberController(MemberService service) {
        super(service);
    }
}
