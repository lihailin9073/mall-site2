package com.wzliulan.mallsite2.gateway.auth.service;

import com.wzliulan.mallsite2.auth.feign.IAuthFeign;
import com.wzliulan.mallsite2.domain.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AuthService {
    @Autowired
    private IAuthFeign authFeign;

    public boolean isValid(String token) {
        String result1 = authFeign.checkToken("tk:xxx-xxx", "admin");
        List<String> permissionList = authFeign.getPermissionList("tk:xxx-xxx");
        ApiResponse apiResponse = authFeign.getUser("tk:xxx-xxx");

        log.info("token验证结果：{}，权限清单：{}，用户列表：{}", result1, permissionList, apiResponse);

        return true;
    }
}
