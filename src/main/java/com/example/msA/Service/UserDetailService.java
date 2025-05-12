package com.example.msA.Service;

import com.example.msA.client.MiddlewareClient;
import com.example.msA.entity.UserDetail;
import com.example.msA.repo.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {
    @Autowired
    private UserDetailRepository repo;
    @Autowired private MiddlewareClient middleware;

    public UserDetail create(UserDetail userDetail) {
        UserDetail saved = repo.save(userDetail);
        middleware.syncToLegacy(saved);
        return saved;
    }

    public UserDetail updateFromLegacy(UserDetail userDetail) {
        return repo.save(userDetail);
    }
}