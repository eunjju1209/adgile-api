package com.adgile.controller;

import com.adgile.dto.request.MemberCreateRequest;
import com.adgile.dto.request.MemberUpdateRequest;
import com.adgile.dto.response.MemberInfoResponse;
import com.adgile.service.MemberService;
import com.adgile.util.ApiResponse;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("v1/member")
public class MemberController {

    private final MemberService memberService;

    @ApiOperation(value = "유저 목록 조회")
    @GetMapping("")
    public ApiResponse<List<MemberInfoResponse>> getUsers() {
        return ApiResponse.success(memberService.getUsers());
    }

    @ApiOperation(value = "특정 유저 조회")
    @GetMapping("{id}")
    public ApiResponse<MemberInfoResponse> getUser(@PathVariable Long id) {
        return ApiResponse.success(memberService.getUser(id));
    }

    @ApiOperation(value = "유저 중복 체크")
    @GetMapping("check/{memberId}")
    public ApiResponse<Boolean> isDuplicated(@PathVariable String memberId) {
        memberService.isDuplicate(memberId);

        return ApiResponse.success(true);
    }

    @ApiOperation(value = "유저 등록")
    @PostMapping(value = "", produces = "application/json; charset=utf8")
    public ApiResponse<String> doRegister(@RequestBody MemberCreateRequest request) {
        memberService.doRegister(request);
        return ApiResponse.OK;
    }

    @ApiOperation(value = "유저 수정")
    @PutMapping("{id}")
    public ApiResponse<String> doUpdate(@PathVariable Long id, @RequestBody MemberUpdateRequest request) {
        memberService.doModify(id, request);
        return ApiResponse.OK;
    }

    @ApiOperation(value = "유저 삭제")
    @DeleteMapping("{id}")
    public ApiResponse<String> doDelete(@PathVariable Long id) {
        memberService.doDelete(id);
        return ApiResponse.OK;
    }
}
