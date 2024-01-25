package me.vichea.corebaking.controller;

import lombok.RequiredArgsConstructor;
import me.vichea.corebaking.entity.Permission;
import me.vichea.corebaking.service.impl.PermissionServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("api/v1/permission")
@RestController
public class PermissionController {
    private final PermissionServiceImpl permissionService;
    @GetMapping()
    public Permission findByID(@RequestParam long id){
        return permissionService.findById(id);
    }
}
