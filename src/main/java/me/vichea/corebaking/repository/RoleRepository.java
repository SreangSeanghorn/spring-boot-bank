package me.vichea.corebaking.repository;

import me.vichea.corebaking.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByCode(String code);
    Role findByRoleId(long id);
}
