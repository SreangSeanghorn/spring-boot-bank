package me.vichea.corebaking.service;

import me.vichea.corebaking.entity.Permission;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface PermissionService {
    Permission save(Permission permission);
    Permission findById(long id);
}
