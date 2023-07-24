package com.adgile.domain.conditional;

import com.adgile.domain.enums.MediaStatusEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediaConditional {

    private Long id;

    private Long memberId;

    private MediaStatusEnum status;

    private String name;
    private String manager;

    private String email;
    private String clickUrl;
    private String installPostback;
    private String eventPostback;

    @Builder
    public MediaConditional(Long id, Long memberId, MediaStatusEnum status, String name, String manager, String email, String clickUrl, String installPostback, String eventPostback) {
        this.id = id;
        this.memberId = memberId;
        this.status = status;
        this.name = name;
        this.manager = manager;
        this.email = email;
        this.clickUrl = clickUrl;
        this.installPostback = installPostback;
        this.eventPostback = eventPostback;
    }
}
