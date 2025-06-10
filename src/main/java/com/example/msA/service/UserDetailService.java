package com.example.msA.service;

import com.example.msA.client.MiddlewareClient;
import com.example.msA.dto.UserDetailDTO;
import com.example.msA.entity.UserDetail;
import com.example.msA.mapper.UserDetailMapper;
import com.example.msA.repo.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {
    @Autowired
    private UserDetailRepository repo;
    @Autowired
    private MiddlewareClient middleware;
    @Autowired
    private UserDetailMapper mapper;

    public UserDetailDTO create(UserDetailDTO userDetailDto) {

        repo.findByUsername(userDetailDto.getUsername())
                .ifPresent(usuario -> {
                    throw new RuntimeException("User already exists " + usuario.getUsername());
                });


        UserDetail saved = repo.save(mapper.toEntity(userDetailDto));
        userDetailDto=mapper.toDTO(saved);
        middleware.syncToLegacyCreate(userDetailDto);
        return userDetailDto;
    }

    public ResponseEntity<UserDetailDTO> update(UserDetailDTO userDetailDto) {
        UserDetail userDetail = repo.findByUsername(userDetailDto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found " + userDetailDto.getUsername()));

        mapper.updateEntityFromDTO(userDetailDto, userDetail);
        UserDetail saved = repo.save(userDetail);

        UserDetailDTO updatedDto = mapper.toDTO(saved);

        middleware.syncToLegacyUpdate(userDetailDto);

        return ResponseEntity.ok(updatedDto);
    }

    //Logico
    public  ResponseEntity<UserDetailDTO>  delete(UserDetailDTO userDetailDto) {
        UserDetail userDetail = repo.findByUsername(userDetailDto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found " + userDetailDto.getUsername()));
        userDetail.setStatus((short)0);
        UserDetail saved = repo.save(userDetail);
        UserDetailDTO updatedDto = mapper.toDTO(saved);
        middleware.syncToLegacyDelete(userDetailDto);

        return ResponseEntity.ok(updatedDto);
    }

}