package com.example.msA.Service;

import com.example.msA.client.MiddlewareClient;
import com.example.msA.dto.UserDetailDTO;
import com.example.msA.entity.UserDetail;
import com.example.msA.mapper.UserDetailMapper;
import com.example.msA.repo.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        UserDetail saved = repo.save(mapper.toEntity(userDetailDto));
        userDetailDto=mapper.toDTO(saved);
        middleware.syncToLegacy(userDetailDto);
        return userDetailDto;
    }

    public UserDetailDTO updateFromLegacy(UserDetailDTO userDetailDto) {
        return mapper.toDTO(repo.save(mapper.toEntity(userDetailDto)));
    }
}