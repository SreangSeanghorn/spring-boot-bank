package me.vichea.corebaking.service.impl;

import lombok.RequiredArgsConstructor;
import me.vichea.corebaking.entity.Permission;
import me.vichea.corebaking.repository.PermissionRepository;
import me.vichea.corebaking.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    @Override
    public Permission save(Permission permission) {
       return permissionRepository.save(permission);
    }

    @Override
    public Permission findById(long id) {
        return permissionRepository.findPermissionByPermissionId(id);
    }
}
