package me.vichea.corebaking.service.impl;

import lombok.RequiredArgsConstructor;
import me.vichea.corebaking.entity.Role;
import me.vichea.corebaking.repository.RoleRepository;
import me.vichea.corebaking.service.RoleService;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role findByName(String name) {
        return null;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findByRoleId(id);
    }
}
