package com.adgile.domain;

import com.adgile.domain.enums.CurrencyEnum;
import com.adgile.domain.enums.UserTypeEnum;
import com.adgile.dto.request.MemberUpdateRequest;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isDomestic;

    @Enumerated(EnumType.STRING)
    private MemberType type;

    // unique 한 값
    private String memberId;

    // 매체사 - 법인명
    // 광고주 - 광고주명
    private String name;

    // 담당자
    private String manager;

    // 이메일
    private String email;

    // NET, GROSS 이거랑 구분할 수있도록 필드명 다시 재정의
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currencyType;

    // 수신계산서 수신메일
    private String invoiceEmail;

    @Builder
    public Member(Long id, Boolean isDomestic, MemberType type, String memberId, String name, String manager, String email, CurrencyEnum currencyType, String invoiceEmail) {
        this.id = id;
        this.isDomestic = isDomestic;
        this.type = type;
        this.memberId = memberId;
        this.name = name;
        this.manager = manager;
        this.email = email;
        this.currencyType = currencyType;
        this.invoiceEmail = invoiceEmail;
    }

    public void update(MemberUpdateRequest request) {
        this.isDomestic = request.getIsDomestic();
        this.type = request.getType();
        this.memberId = request.getMemberId();
        this.name = request.getName();
        this.manager = request.getManager();
        this.email = request.getEmail();
        this.currencyType = request.getCurrencyType();
        this.invoiceEmail = request.getInvoiceEmail();
    }

    @Getter
    public enum MemberType {
        MEDIA,
        ADVERTISEMENT
    }
}
