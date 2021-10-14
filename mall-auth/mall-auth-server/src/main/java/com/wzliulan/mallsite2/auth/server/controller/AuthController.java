package com.wzliulan.mallsite2.auth.server.controller;

import com.wzliulan.mallsite2.domain.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Api(description = "安全服务 -> 安全接口")
//@RequestMapping("/auth")
@RestController
public class AuthController {

    @ApiOperation("账号密码登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "登录账号", required = true),
            @ApiImplicitParam(name = "password", value = "登录密码", required = true)
    })
    @PostMapping("/login")
    public ApiResponse login(String username, String password, @RequestHeader(name = "User-Agent", required = false) String userAgent) {
        // TODO
        return ApiResponse.ok("测试端点-查找："+ UUID.randomUUID().toString());
    }

    @ApiOperation("手机验证码登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true),
            @ApiImplicitParam(name = "verifyCode", value = "短信验证码", required = true)
    })
    @PostMapping("/login-by-phone")
    public ApiResponse loginByPhone(String phone, String verifyCode, @RequestHeader(name = "User-Agent", required = false) String userAgent) {
        // TODO
        return ApiResponse.ok("测试端点："+UUID.randomUUID().toString());
    }

    @ApiOperation("微信号授权登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "wid", value = "微信全局ID", required = true),
            @ApiImplicitParam(name = "accessToken", value = "微信授权令牌", required = true)
    })
    @PostMapping("/login-by-wechat")
    public ApiResponse loginByWechat(String wid, String accessToken, @RequestHeader(name = "User-Agent", required = false) String userAgent) {
        // TODO
        return ApiResponse.ok("测试端点："+UUID.randomUUID().toString());
    }

    @ApiOperation("退出接口")
    @ApiImplicitParam(name = "token", value = "登录令牌", required = true)
    @GetMapping("/logout")
    public ApiResponse logout(String token) {
        // TODO
        return ApiResponse.ok("测试端点："+UUID.randomUUID().toString());
    }

    @ApiOperation("刷新令牌")
    @PutMapping("/refresh-token")
    public ApiResponse refreshToken(@RequestHeader("token") String token) {
        // TODO
        return ApiResponse.ok("测试端点："+UUID.randomUUID().toString());
    }

    @ApiOperation("获取接口权限列表")
    @GetMapping("/get-menus")
    public ApiResponse getMenuList(@RequestHeader("token") String token) {
        // TODO
        return ApiResponse.ok("测试端点："+UUID.randomUUID().toString());
    }

    @ApiOperation("获取用户档案")
    @GetMapping("/get-user")
    public ApiResponse getUser(@RequestHeader("token") String token) {
        // TODO
        return ApiResponse.ok("测试端点："+UUID.randomUUID().toString());
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public ApiResponse register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("phone") String phone, String token) {
        // TODO
        return ApiResponse.ok("测试端点："+UUID.randomUUID().toString());
    }
}
