package by.rom.restapi.service;

import by.rom.restapi.dto.MemberDTO;
import by.rom.restapi.entity.Member;
import by.rom.restapi.exception.NotFoundException;
import by.rom.restapi.mapper.MemberConvertor;
import by.rom.restapi.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService implements BaseService<MemberDTO>{

    private final MemberConvertor convertor;
    private final MemberRepository memberRepository;

    public MemberService(MemberConvertor convertor, MemberRepository memberRepository) {
        this.convertor = convertor;
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberDTO getById(Long id) {
        Member member = memberRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found with id - " + id));
        return convertor.toDto(member);
    }

    @Override
    public List<MemberDTO> getAll() {
        return memberRepository
                .findAll()
                .stream()
                .map(convertor::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MemberDTO saveOrUpdate(MemberDTO dto) {
        Member member = convertor.toEntity(dto);
        memberRepository.save(member);
        return convertor.toDto(member);
    }

    @Override
    public void deleteById(Long id) {
        memberRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found with id - " + id));
        memberRepository.deleteById(id);
    }
}
