package com.adgile.dto.request;

import com.adgile.domain.enums.MediaStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediaUpdateRequest {

    // 계정ID
    private Long userId;

    private MediaStatusEnum status;

    // 매체 명
    private String name;

    // 관리자
    private String manager;

    // 이메일
    private String email;

    // click url
    private String clickUrl;

    // install postback
    private String installPostback  ;

    // event postback
    private String eventPostback;
}
