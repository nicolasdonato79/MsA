package com.example.msA.controller;

import com.example.msA.Service.UserDetailService;
import com.example.msA.dto.UserDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// endpoint llamados desde middleware cuando cambia la base legacy
@RestController
@RequestMapping("/msa/users-details")
public class UserDetailController {
    @Autowired
    private UserDetailService service;

    @PostMapping
    public ResponseEntity<Void>  create(@RequestBody UserDetailDTO userDetailDto) {
        service.create(userDetailDto);
        return ResponseEntity.ok().build();
    }


    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UserDetailDTO userDetailDto) {
        service.update(userDetailDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody UserDetailDTO userDetailDto) {
        service.delete(userDetailDto);
        return ResponseEntity.ok().build();
    }



    @PostMapping("/sync-from-legacy")
    public ResponseEntity<Void> syncFromLegacyCreate(@RequestBody UserDetailDTO userDetailDto) {
        service.create(userDetailDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/sync-from-legacy")
    public ResponseEntity<Void> syncFromLegacyUpdate(@RequestBody UserDetailDTO userDetailDto) {
        service.update(userDetailDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/sync-from-legacy")
    public ResponseEntity<Void> syncFromLegacyDelete(@RequestBody UserDetailDTO userDetailDto) {
        service.update(userDetailDto);
        return ResponseEntity.ok().build();
    }
}
