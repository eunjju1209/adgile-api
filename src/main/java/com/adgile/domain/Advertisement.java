package com.adgile.domain;

import com.adgile.domain.enums.AdvertisementTypeEnum;
import com.adgile.domain.enums.OsEnum;
import com.adgile.dto.request.AdvertisementUpdateRequest;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@ToString
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Advertisement extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String name;

    @Enumerated(EnumType.STRING)
    private OsEnum os;

    @Enumerated(EnumType.STRING)
    private AdvertisementTypeEnum type;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

    private String downloadUrl;

    @Builder
    public Advertisement(Long id, Long userId, String name, OsEnum os, AdvertisementTypeEnum type, ZonedDateTime startDate, ZonedDateTime endDate, String downloadUrl) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.os = os;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.downloadUrl = downloadUrl;
    }

    public void update(AdvertisementUpdateRequest request) {
        this.userId = request.getAccountId();
        this.name = request.getName();
        this.os = request.getOs();
        this.type = request.getType();
        this.startDate = request.getStartDate();
        this.endDate = request.getEndDate();
        this.downloadUrl = request.getDownloadUrl();
    }
}
