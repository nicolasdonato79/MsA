package com.example.msA.client;

import com.example.msA.dto.UserDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

// FeignClient a Middleware
@FeignClient(name = "MSMIDDLEWARE")
public interface MiddlewareClient {

    @PostMapping("/msmiddleware/users-details/sync-to-legacy")
    void syncToLegacyCreate(@RequestBody UserDetailDTO userDetail);

    @PutMapping("/msmiddleware/users-details/sync-to-legacy")
    void syncToLegacyUpdate(@RequestBody UserDetailDTO userDetail);

    @DeleteMapping("/msmiddleware/users-details/sync-to-legacy")
    void syncToLegacyDelete(@RequestBody UserDetailDTO userDetail);

}


//@Component
//public class MiddlewareClient {
//    private final RestTemplate rest = new RestTemplate();
//
//    public void syncToLegacy(UserDetailDTO userDetailDTO) {
//        rest.postForEntity("http://localhost:8081/msmiddleware/users-details/sync-to-legacy", userDetailDTO, Void.class);
//    }
//}