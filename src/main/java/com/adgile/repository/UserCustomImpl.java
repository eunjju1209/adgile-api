package com.adgile.repository;

import com.adgile.domain.User;
import com.adgile.domain.conditional.UserConditional;
import com.adgile.domain.enums.CurrencyEnum;
import com.adgile.domain.enums.UserTypeEnum;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.adgile.domain.QUser.user;
import static org.springframework.util.StringUtils.hasText;

@RequiredArgsConstructor
public class UserCustomImpl implements UserCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<User> findUser(UserConditional where) {
        return Optional.ofNullable(
                queryFactory.selectFrom(user)
                        .where(
                                eqId(where.getId()),
                                eqDomestic(where.getIsDomestic()),
                                eqType(where.getType()),
                                eqUserId(where.getUserId()),
                                eqName(where.getName()),
                                eqManager(where.getManager()),
                                eqEmail(where.getEmail()),
                                eqCurrencyType(where.getCurrencyType()),
                                eqInvoiceEmail(where.getInvoiceEmail()),
                                user.deletedAt.isNull()
                        )
                        .fetchOne()
        );
    }

    @Override
    public List<User> findUsers(UserConditional where) {
        return queryFactory.selectFrom(user)
                .where(
                        eqId(where.getId()),
                        eqDomestic(where.getIsDomestic()),
                        eqType(where.getType()),
                        eqUserId(where.getUserId()),
                        eqName(where.getName()),
                        eqManager(where.getManager()),
                        eqEmail(where.getEmail()),
                        eqCurrencyType(where.getCurrencyType()),
                        eqInvoiceEmail(where.getInvoiceEmail()),
                        user.deletedAt.isNull()
                )
                .fetch();
    }

    private BooleanExpression eqId(Long id) {
        return id != null ? user.id.eq(id) : null;
    }

    private BooleanExpression eqDomestic(Boolean domestic) {
        return domestic != null ? user.isDomestic.eq(domestic) : null;
    }

    private BooleanExpression eqType(UserTypeEnum type) {
        return type != null ? user.type.eq(type) : null;
    }

    private BooleanExpression eqUserId(String userId) {
        return hasText(userId) ? user.userId.eq(userId) : null;
    }

    private BooleanExpression eqName(String name) {
        return hasText(name) ? user.name.eq(name) : null;
    }

    private BooleanExpression eqManager(String manager) {
        return hasText(manager) ? user.manager.eq(manager) : null;
    }

    private BooleanExpression eqEmail(String email) {
        return hasText(email) ? user.email.eq(email) : null;
    }

    private BooleanExpression eqCurrencyType(CurrencyEnum currencyType) {
        return currencyType != null ? user.currencyType.eq(currencyType) : null;
    }

    private BooleanExpression eqInvoiceEmail(String invoiceEmail) {
        return hasText(invoiceEmail) ? user.invoiceEmail.eq(invoiceEmail) : null;
    }

}
