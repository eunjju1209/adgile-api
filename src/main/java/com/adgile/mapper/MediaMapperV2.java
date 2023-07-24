package com.adgile.mapper;

import com.adgile.dto.response.MediaInfoResponse;
import com.querydsl.core.Tuple;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MediaMapperV2 {

	@Mapping(target="id", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getId())")
	@Mapping(target="memberId", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getMemberId())")
	@Mapping(target="name", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getName())")
	@Mapping(target="status", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getStatus())")
	@Mapping(target="code", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getCode())")
	@Mapping(target="manager", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getManager())")
	@Mapping(target="email", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getEmail())")
	@Mapping(target="clickUrl", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getClickUrl())")
	@Mapping(target="installPostback", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getInstallPostback())")
	@Mapping(target="eventPostback", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getEventPostback())")
	@Mapping(target="isDomestic", expression = "java(tuple.get(1, com.adgile.domain.Member.class).getIsDomestic())")
	@Mapping(target="userName", expression = "java(tuple.get(1, com.adgile.domain.Member.class).getName())")
	MediaInfoResponse mediaToInfo(Tuple tuple);

	List<MediaInfoResponse> mediumToInfo(List<Tuple> tuple);

}
