package com.wzliulan.mallsite2.auth.feign;

import com.wzliulan.mallsite2.domain.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "安全服务 -> Feign远程调用接口")
@FeignClient(name = "auth-service", contextId = "auth-service-client-001")
public interface IAuthFeign {
    @PostMapping("/auth-feign/check-token")
    String checkToken(@RequestParam("token") String token, @RequestParam("username") String username);

    @GetMapping("/auth-feign/get-permissions")
    List<String> getPermissionList(@RequestParam("token") String token);

    @GetMapping("/auth-feign/get-user")
    ApiResponse getUser(@RequestParam("token") String token);

//    @ApiOperation("账号密码登录接口")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "username", value = "登录账号", required = true),
//            @ApiImplicitParam(name = "password", value = "登录密码", required = true)
//    })
//    @PostMapping("/login")
//    List<Object> login(String username, String password, @RequestHeader(name = "User-Agent", required = false) String userAgent);
//
//    @ApiOperation("手机验证码登录接口")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "phone", value = "手机号码", required = true),
//            @ApiImplicitParam(name = "verifyCode", value = "短信验证码", required = true)
//    })
//    @PostMapping("/login-by-phone")
//    ApiResponse loginByPhone(String phone, String verifyCode, @RequestHeader(name = "User-Agent", required = false) String userAgent);
//
//    @ApiOperation("微信号授权登录接口")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "wid", value = "微信全局ID", required = true),
//            @ApiImplicitParam(name = "accessToken", value = "微信授权令牌", required = true)
//    })
//    @PostMapping("/login-by-wechat")
//    ApiResponse loginByWechat(String wid, String accessToken, @RequestHeader(name = "User-Agent", required = false) String userAgent);
//
//    @ApiOperation("退出接口")
//    @ApiImplicitParam(name = "token", value = "登录令牌", required = true)
//    @GetMapping("/logout")
//    ApiResponse logout(String token);
//
//    @ApiOperation("刷新令牌")
//    @PutMapping("/refresh-token")
//    ApiResponse refreshToken(@RequestHeader("token") String token);
//
//    @ApiOperation("获取接口权限列表")
//    @GetMapping("/get-menus")
//    ApiResponse getMenuList(@RequestHeader("token") String token);
//
//    @ApiOperation("获取用户档案")
//    @GetMapping("/get-user")
//    ApiResponse getUser(@RequestHeader("token") String token);
//
//    @ApiOperation("校验令牌合法性")
//    @GetMapping("/token-is-valid")
//    ApiResponse tokenIsValid(@RequestHeader("token") String token);
//
//    @ApiOperation("用户注册")
//    @PostMapping("/register")
//    ApiResponse register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("phone") String phone, String token);
}
