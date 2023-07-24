package com.adgile.domain.conditional;

import com.adgile.domain.enums.AdvertisementTypeEnum;
import com.adgile.domain.enums.OsEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class AdvertisementConditional {

	private Long id;

	private Long memberId;

	private String name;

	private OsEnum os;

	private AdvertisementTypeEnum type;

	private ZonedDateTime startDate;

	private ZonedDateTime endDate;

	private String downloadUrl;

	@Builder
	public AdvertisementConditional(Long id, Long memberId, String name, OsEnum os, AdvertisementTypeEnum type, ZonedDateTime startDate, ZonedDateTime endDate, String downloadUrl) {
		this.id = id;
		this.memberId = memberId;
		this.name = name;
		this.os = os;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.downloadUrl = downloadUrl;
	}
}
