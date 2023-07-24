package com.adgile.mapper;
import com.adgile.domain.Member;
import com.adgile.dto.response.MemberInfoResponse;
import org.mapstruct.Mapping;

import java.util.List;

//@Mapper(
//        injectionStrategy = InjectionStrategy.CONSTRUCTOR
//)
public interface MemberMapper {

//    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source="id", target="id")
    @Mapping(source="isDomestic", target="isDomestic")
    @Mapping(source="type", target="type")
    @Mapping(source="memberId", target="memberId")
    @Mapping(source="name", target="name")
    @Mapping(source="manager", target="manager")
    @Mapping(source="email", target="email")
    @Mapping(source="currencyType", target="currencyType")
    @Mapping(source="invoiceEmail", target="invoiceEmail")
    @Mapping(source="createdAt", target="createdAt")
    MemberInfoResponse memberToInfo(Member member);


    List<MemberInfoResponse> membersToInfo(List<Member> members);
}
