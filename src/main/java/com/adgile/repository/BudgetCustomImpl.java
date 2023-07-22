package com.adgile.repository;

import com.adgile.domain.Budget;
import com.adgile.domain.conditional.BudgetConditional;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.adgile.domain.QBudget.budget;

@RequiredArgsConstructor
public class BudgetCustomImpl implements BudgetCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public Optional<Budget> findBudget(BudgetConditional where) {
		return Optional.ofNullable(

				queryFactory.selectFrom(budget)
						.where(
								eqId(where.getId()),
								eqAdvertisementId(where.getAdvertisementId()),
								budget.deletedAt.isNull()
						      )
						.fetchOne()
		                          );
	}

	private BooleanExpression eqId(Long id) {
		return id != null ? budget.id.eq(id) : null;
	}

	private BooleanExpression eqAdvertisementId(Long id) {
		return id != null ? budget.advertisementId.eq(id) : null;
	}


}
