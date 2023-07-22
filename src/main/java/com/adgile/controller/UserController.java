package com.adgile.controller;

import com.adgile.dto.request.UserCreateRequest;
import com.adgile.dto.request.UserUpdateRequest;
import com.adgile.dto.response.UserInfoResponse;
import com.adgile.service.UserService;
import com.adgile.util.ApiResponse;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("v1/user")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "유저 목록 조회")
    @GetMapping("")
    public ApiResponse<List<UserInfoResponse>> getUsers() {
        return ApiResponse.success(userService.getUsers());
    }

    @ApiOperation(value = "특정 유저 조회")
    @GetMapping("{id}")
    public ApiResponse<UserInfoResponse> getUser(@PathVariable Long id) {
        return ApiResponse.success(userService.getUser(id));
    }

    @ApiOperation(value = "유저 중복 체크")
    @GetMapping("check/{userId}")
    public ApiResponse<Boolean> isDuplicated(@PathVariable String userId) {
        userService.isDuplicate(userId);

        return ApiResponse.success(true);
    }

    @ApiOperation(value = "유저 등록")
    @PostMapping(value = "", produces = "application/json; charset=utf8")
    public ApiResponse<String> doRegister(@RequestBody UserCreateRequest request) {
        userService.doRegister(request);
        return ApiResponse.OK;
    }

    @ApiOperation(value = "유저 수정")
    @PutMapping("{id}")
    public ApiResponse<String> doUpdate(@PathVariable Long id, @RequestBody UserUpdateRequest request) {
        userService.doModify(id, request);
        return ApiResponse.OK;
    }

    @ApiOperation(value = "유저 삭제")
    @DeleteMapping("{id}")
    public ApiResponse<String> doDelete(@PathVariable Long id) {
        userService.doDelete(id);
        return ApiResponse.OK;
    }
}
