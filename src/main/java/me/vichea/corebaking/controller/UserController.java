package me.vichea.corebaking.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import me.vichea.corebaking.common.CommonResult;
import me.vichea.corebaking.dto.SignUpRequest;
import me.vichea.corebaking.dto.SignUpResponse;
import me.vichea.corebaking.entity.User;
import me.vichea.corebaking.repository.UserRepository;
import me.vichea.corebaking.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {

        private final UserService userService;
        private final UserRepository userRepository;
        @PreAuthorize("hasAuthority('ACCOUNT:READ') ")
        @GetMapping
        public List<User> list() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            System.out.println("auth in rest:"+authentication.getAuthorities().iterator().next().getAuthority());
            return userService.findAll();
        }
        @PostMapping("/signup")
        public CommonResult<SignUpResponse> create(@RequestBody SignUpRequest userSignUpRequest) {
            ModelMapper modelMapper = new ModelMapper();
            User user = modelMapper.map(userSignUpRequest, User.class);
            SignUpResponse signUpResponse = modelMapper.map(userService.signUp(user), SignUpResponse.class);
            if (signUpResponse != null) {
                return CommonResult.success(signUpResponse);
            } else {
                return CommonResult.failed("User already exists");
            }

        }

        @GetMapping("/{id}")
        public User get(@PathVariable("id") long id) {
            return userService.findById(id).get();
        }



}
