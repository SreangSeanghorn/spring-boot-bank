package me.vichea.corebaking.controller;

import lombok.RequiredArgsConstructor;
import me.vichea.corebaking.dto.RoleRequest;
import me.vichea.corebaking.entity.Role;
import me.vichea.corebaking.service.RoleService;
import me.vichea.corebaking.service.impl.RoleServiceImpl;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("api/v1/role")
@RestController
public class RoleController {
    private final RoleServiceImpl roleService;
    @GetMapping()
    public Role findRoleById(@RequestParam long id){
        return roleService.findById(id);
    }
}
