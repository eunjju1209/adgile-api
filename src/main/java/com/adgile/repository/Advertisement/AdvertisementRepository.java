package com.adgile.repository.Advertisement;

import com.adgile.domain.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long>, AdvertisementCustom {
}
