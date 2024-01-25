package me.vichea.corebaking.service.impl;

import lombok.RequiredArgsConstructor;
import me.vichea.corebaking.entity.Permission;
import me.vichea.corebaking.entity.Role;
import me.vichea.corebaking.entity.User;
import me.vichea.corebaking.model.reponse.JwtAuthenticationResponse;
import me.vichea.corebaking.model.request.SignUpRequests;
import me.vichea.corebaking.model.request.SigninRequest;
import me.vichea.corebaking.repository.PermissionRepository;
import me.vichea.corebaking.repository.RoleRepository;
import me.vichea.corebaking.repository.UserRepository;
import me.vichea.corebaking.service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    @Override
    public JwtAuthenticationResponse signup(SignUpRequests request) {
        ModelMapper m = new ModelMapper();
        Role role = roleRepository.findByRoleId(request.getRole_id());
        ArrayList<Permission> permissions = new ArrayList<>();
        for(Long id:request.getPermission_ids()){
            System.out.println("id is :"+id);
            Permission p = permissionRepository.findPermissionByPermissionId(id);
            System.out.println("The original permission:"+p.getPermissionId());
            permissions.add(p);
        }
        role.setPermissions(permissions);
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(role);
        var user = User.builder().username(request.getUsername()).email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();
        System.out.println("user is"+user.toString());
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        System.out.println("role is:"+user.getRoles().iterator().next().getName());
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
