package com.adgile.mapper;

import com.adgile.domain.User;
import com.adgile.dto.response.UserInfoResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

//@Mapper(
//        componentModel = "spring",
//        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
//        unmappedTargetPolicy = ReportingPolicy.ERROR
//)
public interface UserMapper {

//    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//    @Mapping(source="id", target="id")
//    @Mapping(source="isDomestic", target="isDomestic")
//    @Mapping(source="type", target="type")
//    @Mapping(source="userId", target="userId")
//    @Mapping(source="name", target="name")
//    @Mapping(source="manager", target="manager")
//    @Mapping(source="email", target="email")
//    @Mapping(source="currencyType", target="currencyType")
//    @Mapping(source="invoiceEmail", target="invoiceEmail")
//    @Mapping(source="createdAt", target="createdAt")
    UserInfoResponse userToInfo(User user);


    List<UserInfoResponse> usersToInfo(List<User> users);
}
