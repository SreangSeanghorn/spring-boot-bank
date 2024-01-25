package me.vichea.corebaking.repository;

import me.vichea.corebaking.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByCode(String code);
    Permission findPermissionByPermissionId(Long id);
}
