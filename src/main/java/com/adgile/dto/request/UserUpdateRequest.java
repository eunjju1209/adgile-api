package com.adgile.dto.request;

import com.adgile.domain.enums.CurrencyEnum;
import com.adgile.domain.enums.UserTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserUpdateRequest {
    private Boolean isDomestic;

    private UserTypeEnum type;

    // unique 한 값
    private String userId;

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
}
