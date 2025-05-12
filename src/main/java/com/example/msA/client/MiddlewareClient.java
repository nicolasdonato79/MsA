package com.example.msA.client;

import com.example.msA.dto.UserDetailDTO;
import com.example.msA.entity.UserDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// FeignClient a Middleware
@FeignClient(name = "middleware", url = "http://localhost:8081")
public interface MiddlewareClient {
    @PostMapping("/sync-to-legacy")
    void syncToLegacy(@RequestBody UserDetailDTO userDetail);
}