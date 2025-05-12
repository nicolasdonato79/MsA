package com.example.msA.controller;

import com.example.msA.Service.UserDetailService;
import com.example.msA.dto.UserDetailDTO;
import com.example.msA.entity.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users-details")
public class UserDetailController {
    @Autowired private UserDetailService service;

    @PostMapping
    public UserDetailDTO create(@RequestBody UserDetailDTO userDetailDto) {
        return service.create(userDetailDto);
    }

    // endpoint llamado desde middleware cuando cambia la base legacy
    @PostMapping("/sync-from-legacy")
    public ResponseEntity<Void> syncFromLegacy(@RequestBody UserDetailDTO userDetailDto) {
        service.updateFromLegacy(userDetailDto);
        return ResponseEntity.ok().build();
    }
}
