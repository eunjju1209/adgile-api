package com.adgile.controller;

import com.adgile.dto.request.AdvertisementCreateRequest;
import com.adgile.dto.request.AdvertisementUpdateRequest;
import com.adgile.dto.response.AdvertisementInfoResponse;
import com.adgile.dto.response.AdvertisementListResponse;
import com.adgile.service.AdvertisementService;
import com.adgile.util.ApiResponse;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("v1/advertisement")
public class AdvertisementController {

	private final AdvertisementService advertisementService;

	@ApiOperation(value = "광고 생성")
	@PostMapping("")
	public ApiResponse<String> doRegister(@RequestBody @Valid AdvertisementCreateRequest request) {
		advertisementService.doRegister(request);
		return ApiResponse.OK;
	}

	@ApiOperation(value = "광고 수정")
	@PutMapping("{id}")
	public ApiResponse<String> doModify(@PathVariable Long id, @RequestBody @Valid AdvertisementUpdateRequest request) {
		advertisementService.doModify(request, id);
		return ApiResponse.OK;
	}

	@ApiOperation(value = "광고 삭제")
	@DeleteMapping("{id}")
	public ApiResponse<String> doDelete(@PathVariable Long id) {
		advertisementService.doDelete(id);
		return ApiResponse.OK;
	}

	@ApiOperation(value = "특정 광고 조회")
	@GetMapping("{id}")
	public ApiResponse<AdvertisementInfoResponse> getAdvertisement(@PathVariable Long id) {
		return ApiResponse.success(advertisementService.getAdvertisement(id));
	}

	@ApiOperation(value = "광고 목록 조회")
	@GetMapping("")
	public ApiResponse<AdvertisementListResponse> getAdvertisements() {
		return ApiResponse.success(advertisementService.getAdvertisements());
	}
}
