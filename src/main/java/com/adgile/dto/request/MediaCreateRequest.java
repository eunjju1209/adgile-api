package com.adgile.dto.request;

import com.adgile.domain.Media;
import com.adgile.domain.enums.MediaStatusEnum;
import com.adgile.repository.MediaRepository;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MediaCreateRequest {

    // 계정ID
    private Long userId;

    // 매체 명
    private String name;

    private MediaStatusEnum status;

    // 관리자
    private String manager;

    // 이메일
    private String email;

    // click url
    private String clickUrl;

    // install postback
    private String installPostback;

    // event postback
    private String eventPostback;

    @Builder
    public MediaCreateRequest(Long userId, String name, String manager, String email, String clickUrl, String installPostback, String eventPostback) {
        this.userId = userId;
        this.name = name;
        this.manager = manager;
        this.email = email;
        this.clickUrl = clickUrl;
        this.installPostback = installPostback;
        this.eventPostback = eventPostback;
    }

    public Media toEntity() {
        return Media.builder()
                .userId(userId)
                .name(name)
                .manager(manager)
                .email(email)
                .clickUrl(clickUrl)
                .installPostback(installPostback)
                .eventPostback(eventPostback)
                .build();
    }
}
