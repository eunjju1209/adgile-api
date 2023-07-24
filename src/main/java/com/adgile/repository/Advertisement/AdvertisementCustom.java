package com.adgile.repository.Advertisement;

import com.adgile.domain.Advertisement;
import com.adgile.domain.conditional.AdvertisementConditional;
import com.querydsl.core.Tuple;

import java.util.List;
import java.util.Optional;

public interface AdvertisementCustom {

	Optional<Advertisement> findAdvertisement(AdvertisementConditional where);

	Optional<Tuple> findAdvertisementOfBudget(AdvertisementConditional where);

	List<Tuple> findAdvertisementsOfBudget(AdvertisementConditional where);

	Long findCountOfBudget(AdvertisementConditional where);
}
