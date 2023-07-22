package com.adgile.mapper;

import com.adgile.domain.User;
import com.adgile.dto.response.UserInfoResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserMapperV2 {

	UserInfoResponse userToInfo(User user);

	List<UserInfoResponse> usersToInfo(List<User> users);
}
