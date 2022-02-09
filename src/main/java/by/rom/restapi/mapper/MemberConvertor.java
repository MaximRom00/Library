package by.rom.restapi.mapper;

import by.rom.restapi.dto.MemberDTO;
import by.rom.restapi.entity.Member;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberConvertor extends AbstractConvertor<MemberDTO, Member>{

    public MemberConvertor(ModelMapper modelMapper) {
        super(modelMapper, Member.class, MemberDTO.class);
    }
}
