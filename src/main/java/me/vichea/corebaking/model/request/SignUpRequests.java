package me.vichea.corebaking.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.vichea.corebaking.entity.Permission;
import me.vichea.corebaking.entity.Role;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequests{
    @NotBlank
    private String username;
    @Email
    private String email;
    private String password;
    private String permission;
    private long role_id;
    private List<Long> permission_ids;
}