package com.revature.employeereimbursementsystem.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserJwtDto {

    private int userId;
    private String firstName;
    private String lastName;
    private String userRole;
    private String username;
    private String email;

    // Why not password?
    // JWTs shouldn't contain sensitive
//    private String password;
}
