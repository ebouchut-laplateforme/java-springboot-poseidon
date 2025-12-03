package com.nnk.springboot.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Only consider the id attribute/field
@ToString
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "user_name")
    @NotBlank(message = "User name is mandatory")
    private String userName;

    @Column(name = "password")
    @NotBlank(message = "Password is mandatory")
    @ToString.Exclude // Do not expose the password in toString()
    private String password;

    @Column(name = "full_name")
    @NotBlank(message = "Full name is mandatory")
    private String fullName;

    @Column(name = "role")
    @NotBlank(message = "Role is mandatory")
    private String role;
}
