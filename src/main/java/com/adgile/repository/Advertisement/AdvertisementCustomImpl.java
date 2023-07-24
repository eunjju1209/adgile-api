package com.adgile.repository.Advertisement;

import com.adgile.domain.Advertisement;
import com.adgile.domain.conditional.AdvertisementConditional;
import com.adgile.domain.enums.AdvertisementTypeEnum;
import com.adgile.domain.enums.OsEnum;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.adgile.domain.QAdvertisement.advertisement;
import static com.adgile.domain.QBudget.budget;
import static org.springframework.util.StringUtils.hasText;

@RequiredArgsConstructor
public class AdvertisementCustomImpl implements AdvertisementCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public Optional<Advertisement> findAdvertisement(AdvertisementConditional where) {
		return Optional.ofNullable(
				queryFactory
						.selectFrom(advertisement)
						.where(
								eqId(where.getId()),
								eqMemberId(where.getMemberId()),
								eqName(where.getName()),
								eqOs(where.getOs()),
								eqType(where.getType()),
								eqDownloadUrl(where.getDownloadUrl()),
								advertisement.deletedAt.isNull()
						      )
						.fetchOne()
		                          );
	}

	@Override
	public Optional<Tuple> findAdvertisementOfBudget(AdvertisementConditional where) {
		return Optional.ofNullable(
				queryFactory.select(advertisement, budget)
						.from(advertisement)
						.leftJoin(budget).on(budget.advertisementId.eq(advertisement.id), advertisement.deletedAt.isNull())
						.where(
								eqId(where.getId()),
								eqMemberId(where.getMemberId()),
								eqName(where.getName()),
								eqOs(where.getOs()),
								eqType(where.getType()),
								eqDownloadUrl(where.getDownloadUrl()),
								advertisement.deletedAt.isNull()
						      )
						.fetchOne()
                      );
	}

	@Override
	public List<Tuple> findAdvertisementsOfBudget(AdvertisementConditional where) {
		return queryFactory
				.select(advertisement, budget)
				.from(advertisement)
				.leftJoin(budget).on(budget.advertisementId.eq(advertisement.id), advertisement.deletedAt.isNull())
				.where(
						eqId(where.getId()),
						eqMemberId(where.getMemberId()),
						eqName(where.getName()),
						eqOs(where.getOs()),
						eqType(where.getType()),
						eqDownloadUrl(where.getDownloadUrl()),
						advertisement.deletedAt.isNull()
				      )
				.fetch();


	}

	@Override
	public Long findCountOfBudget(AdvertisementConditional where) {
		Long aLong = queryFactory
				.select(advertisement.count())
				.from(advertisement)
				.leftJoin(budget)
				.on(budget.advertisementId.eq(advertisement.id), advertisement.deletedAt.isNull())
				.where(
						eqId(where.getId()),
						eqMemberId(where.getMemberId()),
						eqName(where.getName()),
						eqOs(where.getOs()),
						eqType(where.getType()),
						eqDownloadUrl(where.getDownloadUrl()),
						advertisement.deletedAt.isNull()
				      )
				.fetchOne();

		return aLong;
	}


	private BooleanExpression eqId(Long id) {
		return id != null ? advertisement.id.eq(id) : null;
	}

	private BooleanExpression eqMemberId(Long memberId) {
		return memberId != null ? advertisement.memberId.eq(memberId) : null;
	}

	private BooleanExpression eqName(String name) {
		return hasText(name) ? advertisement.name.eq(name) : null;
	}

	private BooleanExpression eqOs(OsEnum os) {
		return os != null ? advertisement.os.eq(os) : null;
	}

	private BooleanExpression eqType(AdvertisementTypeEnum type) {
		return type != null ? advertisement.type.eq(type) : null;
	}

	private BooleanExpression eqDownloadUrl(String url) {
		return hasText(url) ? advertisement.downloadUrl.eq(url) : null;
	}

}
