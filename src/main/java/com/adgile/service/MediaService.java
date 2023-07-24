package com.adgile.service;

import com.adgile.domain.Media;
import com.adgile.domain.conditional.MediaConditional;
import com.adgile.domain.conditional.MemberConditional;
import com.adgile.dto.request.MediaCreateRequest;
import com.adgile.dto.request.MediaUpdateRequest;
import com.adgile.dto.response.MediaInfoResponse;
import com.adgile.exceptions.BusinessException;
import com.adgile.exceptions.ErrorCode;
import com.adgile.mapper.MediaMapperV2;
import com.adgile.repository.Media.MediaRepository;
import com.adgile.repository.Member.MemberRepository;
import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaService {

    private final MemberRepository userRepository;
    private final MediaRepository mediaRepository;
    private final MediaMapperV2 mediaMapper;

    public MediaInfoResponse getMedia(Long id) {

        MediaConditional where = MediaConditional.builder()
                .id(id)
                .build();

        Tuple tuple = mediaRepository.findMediaOfUser(where)
                .orElseThrow(() -> new BusinessException(ErrorCode.MEDIA_NOT_EXIST));

        return mediaMapper.mediaToInfo(tuple);
    }


    public List<MediaInfoResponse> getMedium() {

        MediaConditional where = MediaConditional.
                builder()
                .build();

        List<Tuple> mediumOfUser = mediaRepository.findMediumOfUser(where);

        return mediaMapper.mediumToInfo(mediumOfUser);
    }

    public void doRegister(MediaCreateRequest request) {

        // memberId 기준으로 찾아보기
        MemberConditional where = MemberConditional
                .builder()
                .id(request.getMemberId())
                .build();

        userRepository.findMember(where)
                        .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_EXIST));

        mediaRepository.save(request.toEntity());
    }

    @Transactional
    public void doModify(Long id, MediaUpdateRequest request) {

        MemberConditional where = MemberConditional
                .builder()
                .id(request.getMemberId())
                .build();

        userRepository.findMember(where)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_EXIST));

        MediaConditional mediaWhere = MediaConditional.builder()
                .id(id)
                .build();

        Media media = mediaRepository.findMedia(mediaWhere)
                .orElseThrow(() -> new BusinessException(ErrorCode.MEDIA_NOT_EXIST));

        media.update(request);
    }

    @Transactional
    public void doDelete(Long id) {
        MediaConditional where = MediaConditional.builder()
                .id(id)
                .build();

        Media media = mediaRepository.findMedia(where)
                .orElseThrow(() -> new BusinessException(ErrorCode.MEDIA_NOT_EXIST));

        media.updateDelete();
    }
}
