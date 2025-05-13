package com.example.msA.client;

import com.example.msA.dto.UserDetailDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

// FeignClient a Middleware
//@FeignClient(name = "middleware", url = "http://localhost:8081")
//public interface MiddlewareClient {
//    @PostMapping("/sync-to-legacy")
//    void syncToLegacy(@RequestBody UserDetailDTO userDetail);
//}


@Component
public class MiddlewareClient {
    private final RestTemplate rest = new RestTemplate();

    public void syncToLegacy(UserDetailDTO userDetailDTO) {
        rest.postForEntity("http://localhost:8081/sync-to-legacy", userDetailDTO, Void.class);
    }
}