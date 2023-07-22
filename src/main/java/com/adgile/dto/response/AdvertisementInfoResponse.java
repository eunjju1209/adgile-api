package com.adgile.dto.response;

import com.adgile.domain.enums.AdvertisementTypeEnum;
import com.adgile.domain.enums.OsEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class AdvertisementInfoResponse {

	private Long id;

	private Long accountId;

	private String name;
	private OsEnum os;
	private AdvertisementTypeEnum type;

	private ZonedDateTime startDate;

	private ZonedDateTime endDate;
	private String downloadUrl;

	// budget 정보

	// 총 예산
	private Integer total;

	private Integer daily;

	// 집행단가
	private Integer unitPrice;

	// 집행단가($)
	private Float unitPriceByDollar;

	// 실집행단가
	private Integer actualUnitPrice;

	// 실집행단가($)
	private Float actualUnitPriceByDollar;

	// 일 데일리 캡
	private Integer dailyCap;

	// 총 데일리캡
	private Integer totalDailyCap;

	private Boolean isLimitOfTotal;

	private Boolean isLimitOfDaily;

	private Boolean isLimitByDailyCap;

	private Boolean isLimitByTotalDailyCap;
}
