package me.vichea.corebaking.service;

import me.vichea.corebaking.dto.RoleRequest;
import me.vichea.corebaking.entity.Role;

public interface RoleService {
    Role findByName(String name);
    Role save(Role role);
    Role findById(long id);
}
