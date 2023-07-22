package com.adgile.domain;

import com.adgile.domain.util.isLimit;
import com.adgile.dto.request.AdvertisementUpdateRequest;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Budget extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long advertisementId;

	// 총 예산
	private Integer total;

	// 일 예산
	private Integer daily;

	// 집행단가
	private Integer unitPrice;

	private Float unitPriceByDollar;

	private Integer actualUnitPrice;

	private Float actualUnitPriceByDollar;

	// 일 데일리 캡
	private Integer dailyCap;

	// 총 데일리캡
	private Integer totalDailyCap;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "isLimitByDailyCap", column = @Column(name = "is_limit_by_daily_cap")),
			@AttributeOverride(name = "isLimitByTotalDailyCap", column = @Column(name = "is_limit_by_total_daily_cap")),
			@AttributeOverride(name = "isLimitOfDaily", column = @Column(name = "is_limit_of_daily")),
			@AttributeOverride(name = "isLimitOfTotal", column = @Column(name = "is_limit_of_total")),
	})
	private com.adgile.domain.util.isLimit isLimit;

	@Builder
	public Budget(Long id, Long advertisementId, Integer total, Integer daily, Integer unitPrice, Float unitPriceByDollar, Integer actualUnitPrice, Float actualUnitPriceByDollar, Integer dailyCap,
                  Integer totalDailyCap, Boolean isLimitOfTotal, Boolean isLimitOfDaily, Boolean isLimitByTotalDailyCap, Boolean isLimitByDailyCap) {
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
		this.isLimit = com.adgile.domain.util.isLimit.of(isLimitOfTotal, isLimitOfDaily, isLimitByTotalDailyCap, isLimitByDailyCap);
	}

	public void update(AdvertisementUpdateRequest request) {
		this.total = request.getTotal();
		this.daily = request.getDaily();
		this.unitPrice = request.getUnitPrice();
		this.unitPriceByDollar = request.getUnitPriceByDollar();
		this.actualUnitPrice = request.getActualUnitPrice();
		this.actualUnitPriceByDollar = request.getActualUnitPriceByDollar();
		this.dailyCap = request.getDailyCap();
		this.totalDailyCap = request.getTotal();
		this.isLimit = com.adgile.domain.util.isLimit.of(request.getIsLimitOfTotal(), request.getIsLimitOfDaily(), request.getIsLimitByTotalDailyCap(), request.getIsLimitByDailyCap());
	}
}
