package com.adgile.mapper;

import com.adgile.dto.response.AdvertisementInfoResponse;
import com.querydsl.core.Tuple;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

//@Mapper(
//		componentModel = "spring",
//		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
//		unmappedTargetPolicy = ReportingPolicy.ERROR
//)
public interface AdvertisementMapper {

//	AdvertisementMapper INSTANCE = Mappers.getMapper(AdvertisementMapper.class);

	@Mapping(target = "id", expression = "java(tuple.get(0, com.adgile.domain.Advertisement.class).getId())")
	@Mapping(target = "accountId", expression = "java(tuple.get(0, com.adgile.domain.Advertisement.class).getMemberId())")
	@Mapping(target = "name", expression = "java(tuple.get(0, com.adgile.domain.Advertisement.class).getName())")
	@Mapping(target = "os", expression = "java(tuple.get(0, com.adgile.domain.Advertisement.class).getOs())")
	@Mapping(target = "type", expression = "java(tuple.get(0, com.adgile.domain.Advertisement.class).getType())")
	@Mapping(target = "startDate", expression = "java(tuple.get(0, com.adgile.domain.Advertisement.class).getStartDate())")
	@Mapping(target = "endDate", expression = "java(tuple.get(0, com.adgile.domain.Advertisement.class).getEndDate())")
	@Mapping(target = "downloadUrl", expression = "java(tuple.get(0, com.adgile.domain.Advertisement.class).getDownloadUrl())")
	@Mapping(target = "total", expression = "java(tuple.get(1, com.adgile.domain.Budget.class).getTotal())")
	@Mapping(target = "daily", expression = "java(tuple.get(1, com.adgile.domain.Budget.class).getDaily())")
	@Mapping(target = "unitPrice", expression = "java(tuple.get(1, com.adgile.domain.Budget.class).getUnitPrice())")
	@Mapping(target = "unitPriceByDollar", expression = "java(tuple.get(1, com.adgile.domain.Budget.class).getUnitPriceByDollar())")
	@Mapping(target = "actualUnitPrice", expression = "java(tuple.get(1, com.adgile.domain.Budget.class).getActualUnitPrice())")
	@Mapping(target = "actualUnitPriceByDollar", expression = "java(tuple.get(1, com.adgile.domain.Budget.class).getActualUnitPriceByDollar())")
	@Mapping(target = "dailyCap", expression = "java(tuple.get(1, com.adgile.domain.Budget.class).getDailyCap())")
	@Mapping(target = "totalDailyCap", expression = "java(tuple.get(1, com.adgile.domain.Budget.class).getTotalDailyCap())")
	@Mapping(target = "isLimitOfTotal", expression = "java(tuple.get(1, com.adgile.domain.Budget.class).getIsLimit().getIsLimitOfTotal())")
	@Mapping(target = "isLimitOfDaily", expression = "java(tuple.get(1, com.adgile.domain.Budget.class).getIsLimit().getIsLimitOfDaily())")
	@Mapping(target = "isLimitByTotalDailyCap", expression = "java(tuple.get(1, com.adgile.domain.Budget.class).getIsLimit().getIsLimitByTotalDailyCap())")
	@Mapping(target = "isLimitByDailyCap", expression = "java(tuple.get(1, com.adgile.domain.Budget.class).getIsLimit().getIsLimitByDailyCap())")
	AdvertisementInfoResponse advertisementToInfo(Tuple tuple);

	List<AdvertisementInfoResponse> advertisementToList(List<Tuple> tuple);

}
