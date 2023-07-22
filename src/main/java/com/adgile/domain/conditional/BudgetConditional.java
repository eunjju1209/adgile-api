package com.adgile.domain.conditional;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BudgetConditional {

	private Long id;

	private Long advertisementId;

	private Integer total;

	private Integer daily;

	private Integer unitPrice;

	private Float unitPriceByDollar;

	private Float actualUnitPrice;

	private Float actualUnitPriceByDollar;

	// 일 데일리 캡
	private Integer dailyCap;

	// 총 데일리캡
	private Integer totalDailyCap;

	// 제한 무제한 체크하는 부분
	private Boolean isLimitByDailyCap;
	private Boolean isLimitByTotalDailyCap;
	private Boolean isLimitOfDaily;
	private Boolean isLimitOfTotal;

	@Builder
	public BudgetConditional(Long id, Long advertisementId, Integer total, Integer daily, Integer unitPrice, Float unitPriceByDollar, Float actualUnitPrice, Float actualUnitPriceByDollar, Integer dailyCap, Integer totalDailyCap, Boolean isLimitByDailyCap, Boolean isLimitByTotalDailyCap, Boolean isLimitOfDaily, Boolean isLimitOfTotal) {
		this.id = id;
		this.advertisementId = advertisementId;
		this.total = total;
		this.daily = daily;
		this.unitPrice = unitPrice;
		this.unitPriceByDollar = unitPriceByDollar;
		this.actualUnitPrice = actualUnitPrice;
		this.actualUnitPriceByDollar = actualUnitPriceByDollar;
		this.dailyCap = dailyCap;
		this.totalDailyCap = totalDailyCap;
		this.isLimitByDailyCap = isLimitByDailyCap;
		this.isLimitByTotalDailyCap = isLimitByTotalDailyCap;
		this.isLimitOfDaily = isLimitOfDaily;
		this.isLimitOfTotal = isLimitOfTotal;
	}
}
