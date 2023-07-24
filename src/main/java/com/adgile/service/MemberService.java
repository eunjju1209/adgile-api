package com.adgile.service;

import com.adgile.domain.Member;
import com.adgile.domain.conditional.MemberConditional;
import com.adgile.dto.request.MemberCreateRequest;
import com.adgile.dto.request.MemberUpdateRequest;
import com.adgile.dto.response.MemberInfoResponse;
import com.adgile.exceptions.BusinessException;
import com.adgile.exceptions.ErrorCode;
import com.adgile.mapper.MemberMapperV2;
import com.adgile.repository.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapperV2 memberMapper;

    public MemberInfoResponse getUser(Long id) {
        MemberConditional where = MemberConditional
                .builder()
                .id(id)
                .build();

        var member = memberRepository.findMember(where)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_EXIST));

        return memberMapper.memberToInfo(member);
    }

    public List<MemberInfoResponse> getUsers() {
        MemberConditional where = MemberConditional
                .builder()
                .build();

//        List<User> users = userRepository.findUsers(where);
//        return userMapper.usersToInfo(users);

        var members = memberRepository.findMembers(where);
        return memberMapper.membersToInfo(members);
    }

    public Boolean isDuplicate(String memberId) {

        MemberConditional where = MemberConditional
                .builder()
                .memberId(memberId)
                .build();

        memberRepository.findMember(where)
                        .ifPresent(user -> {
                            throw new BusinessException(ErrorCode.USER_EXIST);
                        });

        return true;
    }

    @Transactional
    public void doRegister(MemberCreateRequest request) {

        MemberConditional where = MemberConditional
                .builder()
                .memberId(request.getMemberId())
                .build();

        memberRepository.findMember(where)
                        .ifPresent(user -> {
                            throw new BusinessException(ErrorCode.USER_EXIST);
                        });

        memberRepository.save(request.toEntity());
    }

    @Transactional
    public void doModify(Long id, MemberUpdateRequest request) {

        MemberConditional where = MemberConditional
                .builder()
                .id(id)
                .build();

        var member = memberRepository.findMember(where)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_EXIST));

        member.update(request);
    }

    @Transactional
    public void doDelete(Long id) {
        MemberConditional where = MemberConditional
                .builder()
                .id(id)
                .build();

        Member member = memberRepository.findMember(where)
                                        .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_EXIST));

        member.updateDelete();
    }

}
