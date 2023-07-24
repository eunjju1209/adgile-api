package com.adgile.dto.request;

import com.adgile.domain.Advertisement;
import com.adgile.domain.Budget;
import com.adgile.domain.enums.AdvertisementTypeEnum;
import com.adgile.domain.enums.OsEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class AdvertisementCreateRequest {

	private Long accountId;

	private String name;

	private OsEnum os;

	private AdvertisementTypeEnum type;

	private ZonedDateTime startDate;

	private ZonedDateTime endDate;
	private String downloadUrl;

	// 예산

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


	public Advertisement toEntity() {
		return Advertisement
				.builder()
				.memberId(accountId)
				.name(name)
				.os(os)
				.type(type)
				.startDate(startDate)
				.endDate(endDate)
				.downloadUrl(downloadUrl)
				.build();
	}

	public Budget toBudget(Long id) {
		return Budget
				.builder()
				.advertisementId(id)
				.total(total)
				.daily(daily)
				.unitPrice(unitPrice)
				.unitPriceByDollar(unitPriceByDollar)
				.actualUnitPrice(actualUnitPrice)
				.actualUnitPriceByDollar(actualUnitPriceByDollar)
				.dailyCap(dailyCap)
				.totalDailyCap(totalDailyCap)
				.isLimitOfDaily(isLimitOfDaily)
				.isLimitOfTotal(isLimitOfTotal)
				.isLimitByDailyCap(isLimitByDailyCap)
				.isLimitByTotalDailyCap(isLimitByTotalDailyCap)
				.build();
	}
}
