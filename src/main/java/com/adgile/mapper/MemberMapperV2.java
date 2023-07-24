package com.adgile.mapper;

import com.adgile.domain.Member;
import com.adgile.dto.response.MemberInfoResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @Mapper 애노테이션을 사용해서 MapStruct 클래스 라는 것을 알린다.
 * 빌드하게 되면 @Mapper 인터페이스를 찾아서 XXXImpl의 형태로 구현체를 모두 만들게 된다.
 * 이때 componentModel을 spring으로 준다면, 생성되는 IMpl은 스프링의 싱글톤 빈으로 괸리된다.
 * @Component가 붙는다.
 */
@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MemberMapperV2 {

	MemberInfoResponse memberToInfo(Member member);

	List<MemberInfoResponse> membersToInfo(List<Member> members);
}
