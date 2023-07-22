package com.adgile.service;

import com.adgile.domain.Advertisement;
import com.adgile.domain.Budget;
import com.adgile.domain.conditional.AdvertisementConditional;
import com.adgile.domain.conditional.BudgetConditional;
import com.adgile.domain.conditional.UserConditional;
import com.adgile.dto.request.AdvertisementCreateRequest;
import com.adgile.dto.request.AdvertisementUpdateRequest;
import com.adgile.dto.response.AdvertisementInfoResponse;
import com.adgile.dto.response.AdvertisementListResponse;
import com.adgile.exceptions.BusinessException;
import com.adgile.exceptions.ErrorCode;
import com.adgile.mapper.AdvertisementMapperV2;
import com.adgile.repository.AdvertisementRepository;
import com.adgile.repository.BudgetRepository;
import com.adgile.repository.UserRepository;
import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertisementService {

	private final UserRepository userRepository;
	private final AdvertisementRepository advertisementRepository;
	private final BudgetRepository budgetRepository;
	private final AdvertisementMapperV2 advertisementMapper;


	@Transactional(readOnly = true)
	public AdvertisementInfoResponse getAdvertisement(Long id) {

		Tuple tuple = advertisementRepository
				.findAdvertisementOfBudget(AdvertisementConditional
						                           .builder()
						                           .id(id)
						                           .build())
				.orElseThrow(() -> new BusinessException(ErrorCode.ADVERTISEMENT_NOT_EXIST));

		return advertisementMapper.advertisementToInfo(tuple);
	}

	@Transactional(readOnly = true)
	public AdvertisementListResponse getAdvertisements() {

		List<Tuple> tuples = advertisementRepository.findAdvertisementsOfBudget(AdvertisementConditional
				                                                                        .builder()
				                                                                        .build());

		// response + total count 해주기 확인 필요
		var advertisements = advertisementMapper.advertisementToList(tuples);

		Long count = advertisementRepository.findCountOfBudget(AdvertisementConditional
				                                                       .builder()
				                                                       .build());

		return AdvertisementListResponse.of(advertisements, count);

	}

	@Transactional
	public void doRegister(AdvertisementCreateRequest request) {
		// user ID 있는지 체크해주기
		userRepository
				.findUser(
						UserConditional
								.builder()
								.id(request.getAccountId())
								.build()
				         )
				.orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_EXIST));

		Advertisement advertisement = advertisementRepository.save(request.toEntity());
		budgetRepository.save(request.toBudget(advertisement.getId()));
	}

	@Transactional
	public void doModify(AdvertisementUpdateRequest request, Long id) {

		// userId 있는지 체크하기
		userRepository
				.findUser(UserConditional
						          .builder()
						          .id(request.getAccountId())
						          .build())
				.orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_EXIST));

		// 광고의 유무
		Advertisement advertisement = advertisementRepository
				.findAdvertisement(AdvertisementConditional
						                   .builder()
						                   .id(id)
						                   .build())
				.orElseThrow(() -> new BusinessException(ErrorCode.ADVERTISEMENT_NOT_EXIST));

		advertisement.update(request);

		Budget budget = budgetRepository
				.findBudget(BudgetConditional
						            .builder()
						            .advertisementId(advertisement.getId())
						            .build())
				.orElseThrow(() -> new BusinessException(ErrorCode.BUDGET_NOT_EXIST));

		budget.update(request);
	}

	@Transactional
	public void doDelete(Long id) {

		// 광고 찾기
		Advertisement advertisement = advertisementRepository
				.findAdvertisement(AdvertisementConditional
						                   .builder()
						                   .id(id)
						                   .build())
				.orElseThrow(() -> new BusinessException(ErrorCode.ADVERTISEMENT_NOT_EXIST));


		advertisement.updateDelete();

		Budget budget = budgetRepository
				.findBudget(BudgetConditional
						            .builder()
						            .advertisementId(advertisement.getId())
						            .build())
				.orElseThrow(() -> new BusinessException(ErrorCode.BUDGET_NOT_EXIST));

		budget.updateDelete();
	}

}
