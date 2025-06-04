package com.example.msA.client;

import com.example.msA.config.FeignClientConfig;
import com.example.msA.dto.UserDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

// FeignClient a Middleware
@FeignClient(name = "MSMIDDLEWARE", configuration = FeignClientConfig.class)
public interface MiddlewareClient {

    @PostMapping("/msmiddleware/users-details/sync-to-legacy")
    void syncToLegacyCreate(@RequestBody UserDetailDTO userDetail);

    @PutMapping("/msmiddleware/users-details/sync-to-legacy")
    void syncToLegacyUpdate(@RequestBody UserDetailDTO userDetail);

    @DeleteMapping("/msmiddleware/users-details/sync-to-legacy")
    void syncToLegacyDelete(@RequestBody UserDetailDTO userDetail);

}