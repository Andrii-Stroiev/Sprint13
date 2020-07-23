package com.softserve.academy.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@Entity(name = "users")
public class User {

    public enum Role {
        MENTOR, TRAINEE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    @Pattern(regexp = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}", message = "enter valid email address")
    private String email;

    @NotNull
    @Size(min = 2, max = 25, message = "First name must be at least 2 but no more 25 characters")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 25, message = "Last name must be at least 2 but no more 25 characters")
    private String lastName;

    @NotNull
    @Size(min = 2, max = 30, message = "Password must be at least 2 but no more 25 characters")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

//    @ToString.Exclude
//    @ManyToMany(mappedBy = "users")
//    private List<Marathon> marathons;

}
