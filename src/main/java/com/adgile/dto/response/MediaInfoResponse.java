package com.adgile.dto.response;


import com.adgile.domain.enums.MediaStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediaInfoResponse {

    private Long id;
    private Long userId;

    private MediaStatusEnum status;

    // 매체명
    private String name;
    private String code;
    private String manager;

    private String email;

    private String clickUrl;
    private String installPostback;
    private String eventPostback;

    // 구분
    private Boolean isDomestic;

    // 법인명
    private String userName;


}
