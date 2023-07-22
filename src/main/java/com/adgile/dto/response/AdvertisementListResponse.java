package com.adgile.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdvertisementListResponse {

	private List<AdvertisementInfoResponse> advertisements;
	private Long totalCount;

	@Builder
	public AdvertisementListResponse(List<AdvertisementInfoResponse> advertisements, Long totalCount) {
		this.advertisements = advertisements;
		this.totalCount = totalCount;
	}

	public static AdvertisementListResponse of(List<AdvertisementInfoResponse> list, Long count) {
		return AdvertisementListResponse
				.builder()
				.advertisements(list)
				.totalCount(count)
				.build();
	}
}
