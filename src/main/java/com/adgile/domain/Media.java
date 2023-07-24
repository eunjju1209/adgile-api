package com.adgile.domain;

import com.adgile.domain.enums.MediaStatusEnum;
import com.adgile.dto.request.MediaUpdateRequest;
import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Media extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 매체 id
    private Long memberId;

    // 상태
    @Enumerated(EnumType.STRING)
    private MediaStatusEnum status;

    private String code;

    // 매체명
    private String name;

    // 담당자
    private String manager;

    // 이메일
    private String email;

    // click Url
    private String clickUrl;

    // install postback
    private String installPostback;

    // event postback
    private String eventPostback;

    @Builder
    public Media(Long id, Long memberId, MediaStatusEnum status, String code, String name, String manager, String email, String clickUrl, String installPostback, String eventPostback) {
        this.id = id;
        this.memberId = memberId;
        this.status = status;
        this.code = code;
        this.name = name;
        this.manager = manager;
        this.email = email;
        this.clickUrl = clickUrl;
        this.installPostback = installPostback;
        this.eventPostback = eventPostback;
    }

    public void update(MediaUpdateRequest request) {
        this.memberId = request.getMemberId();
        this.status = request.getStatus();
        this.name = request.getName();
        this.manager = request.getManager();
        this.email = request.getEmail();
        this.clickUrl = request.getClickUrl();
        this.installPostback = request.getInstallPostback();
        this.eventPostback = request.getEventPostback();
    }
}
