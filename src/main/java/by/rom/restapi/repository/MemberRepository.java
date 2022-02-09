package by.rom.restapi.repository;


import by.rom.restapi.entity.Member;

public interface MemberRepository extends BaseRepository<Member>{

    Member findMemberByTelephoneNumber(String telephone);
}
