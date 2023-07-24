package com.adgile.domain.conditional;

import com.adgile.domain.Member;
import com.adgile.domain.enums.CurrencyEnum;
import com.adgile.domain.enums.UserTypeEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberConditional {

    private Long id;

    private Boolean isDomestic;

    private Member.MemberType type;

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
    private CurrencyEnum currencyType;

    // 수신계산서 수신메일
    private String invoiceEmail;

    @Builder
    public MemberConditional(Long id, Boolean isDomestic, Member.MemberType type, String memberId, String name, String manager, String email, CurrencyEnum currencyType, String invoiceEmail) {
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
}
