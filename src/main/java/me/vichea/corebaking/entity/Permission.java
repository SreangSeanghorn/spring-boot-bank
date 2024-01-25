package me.vichea.corebaking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;
    private String code;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "permissions")
    private Collection<Role> roles;
}
