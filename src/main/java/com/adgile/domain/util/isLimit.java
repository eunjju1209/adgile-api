package com.adgile.domain.util;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class isLimit {

    private Boolean isLimitOfTotal;

    private Boolean isLimitOfDaily;

    private Boolean isLimitByTotalDailyCap;

    private Boolean isLimitByDailyCap;

    public isLimit(Boolean isLimitOfTotal, Boolean isLimitOfDaily, Boolean isLimitByTotalDailyCap, Boolean isLimitByDailyCap) {
        this.isLimitOfTotal = isLimitOfTotal;
        this.isLimitOfDaily = isLimitOfDaily;
        this.isLimitByTotalDailyCap = isLimitByTotalDailyCap;
        this.isLimitByDailyCap = isLimitByDailyCap;
    }

    public static isLimit of (boolean isLimitOfTotal, boolean isLimitOfDaily, boolean isLimitByTotalDailyCap, boolean isLimitByDailyCap) {
        return new isLimit(isLimitOfTotal, isLimitOfDaily, isLimitByTotalDailyCap, isLimitByDailyCap);
    }
}
