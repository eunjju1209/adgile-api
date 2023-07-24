package com.adgile.repository.Member;

import com.adgile.domain.Member;
import com.adgile.domain.conditional.MemberConditional;
import com.adgile.domain.enums.CurrencyEnum;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.adgile.domain.QMember.member;
import static org.springframework.util.StringUtils.hasText;

@RequiredArgsConstructor
public class MemberCustomImpl implements MemberCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Member> findMember(MemberConditional where) {
        return Optional.ofNullable(
                queryFactory.selectFrom(member)
                        .where(
                                eqId(where.getId()),
                                eqDomestic(where.getIsDomestic()),
                                eqType(where.getType()),
                                eqMemberId(where.getMemberId()),
                                eqName(where.getName()),
                                eqManager(where.getManager()),
                                eqEmail(where.getEmail()),
                                eqCurrencyType(where.getCurrencyType()),
                                eqInvoiceEmail(where.getInvoiceEmail()),
                                member.deletedAt.isNull()
                        )
                        .fetchOne()
        );
    }

    @Override
    public List<Member> findMembers(MemberConditional where) {
        return queryFactory.selectFrom(member)
                .where(
                        eqId(where.getId()),
                        eqDomestic(where.getIsDomestic()),
                        eqType(where.getType()),
                        eqMemberId(where.getMemberId()),
                        eqName(where.getName()),
                        eqManager(where.getManager()),
                        eqEmail(where.getEmail()),
                        eqCurrencyType(where.getCurrencyType()),
                        eqInvoiceEmail(where.getInvoiceEmail()),
                        member.deletedAt.isNull()
                )
                .fetch();
    }

    private BooleanExpression eqId(Long id) {
        return id != null ? member.id.eq(id) : null;
    }

    private BooleanExpression eqDomestic(Boolean domestic) {
        return domestic != null ? member.isDomestic.eq(domestic) : null;
    }

    private BooleanExpression eqType(Member.MemberType type) {
        return type != null ? member.type.eq(type) : null;
    }

    private BooleanExpression eqMemberId(String memberId) {
        return hasText(memberId) ? member.memberId.eq(memberId) : null;
    }

    private BooleanExpression eqName(String name) {
        return hasText(name) ? member.name.eq(name) : null;
    }

    private BooleanExpression eqManager(String manager) {
        return hasText(manager) ? member.manager.eq(manager) : null;
    }

    private BooleanExpression eqEmail(String email) {
        return hasText(email) ? member.email.eq(email) : null;
    }

    private BooleanExpression eqCurrencyType(CurrencyEnum currencyType) {
        return currencyType != null ? member.currencyType.eq(currencyType) : null;
    }

    private BooleanExpression eqInvoiceEmail(String invoiceEmail) {
        return hasText(invoiceEmail) ? member.invoiceEmail.eq(invoiceEmail) : null;
    }

}
