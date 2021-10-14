package com.wzliulan.mallsite2.auth.server.feign;

import com.wzliulan.mallsite2.auth.feign.IAuthFeign;
import com.wzliulan.mallsite2.domain.ApiResponse;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Api(description = "安全服务 -> Feign接口")
@RequestMapping("/auth-feign")
@RestController
public class AuthFeign implements IAuthFeign {

    @PostMapping("/check-token")
    public String checkToken(String token, String username) {
        log.info("------ checkToken()方法被调用！");
        return UUID.randomUUID().toString();
    }

    @GetMapping("/get-permissions")
    @Override
    public List<String> getPermissionList(String token) {
        List<String> permissionList = new ArrayList<>();
        permissionList.add("/auth/login");
        permissionList.add("/auth/logout");
        permissionList.add("/goods/");

        return permissionList;
    }

    @GetMapping("/get-user")
    @Override
    public ApiResponse getUser(String token) {
        List<String> userList = new ArrayList<>();
        userList.add("user1:zhangsan");
        userList.add("user2:lisi");
        userList.add("user3:wangwu");
        userList.add("user4:chenliu");

        return ApiResponse.ok(userList);
    }

    //    @Override
//    public List<Object> login(String username, String password, String userAgent) {
//        return null;
//    }
//
//    @Override
//    public ApiResponse loginByPhone(String phone, String verifyCode, String userAgent) {
//        return null;
//    }
//
//    @Override
//    public ApiResponse loginByWechat(String wid, String accessToken, String userAgent) {
//        return null;
//    }
//
//    @Override
//    public ApiResponse logout(String token) {
//        return null;
//    }
//
//    @Override
//    public ApiResponse refreshToken(String token) {
//        return null;
//    }
//
//    @Override
//    public ApiResponse getMenuList(String token) {
//        return null;
//    }
//
//    @Override
//    public ApiResponse getUser(String token) {
//        return null;
//    }
//
//    @Override
//    public ApiResponse tokenIsValid(String token) {
//        return null;
//    }
//
//    @Override
//    public ApiResponse register(String username, String password, String phone, String token) {
//        return null;
//    }
}
