package com.adgile.repository.Member;

import com.adgile.domain.Member;
import com.adgile.domain.conditional.MemberConditional;

import java.util.List;
import java.util.Optional;

public interface MemberCustom {

    Optional<Member> findMember(MemberConditional where);

    List<Member> findMembers(MemberConditional where);
}
