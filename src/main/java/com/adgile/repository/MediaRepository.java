package com.adgile.repository;

import com.adgile.domain.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long>, MediaCustom {
}
