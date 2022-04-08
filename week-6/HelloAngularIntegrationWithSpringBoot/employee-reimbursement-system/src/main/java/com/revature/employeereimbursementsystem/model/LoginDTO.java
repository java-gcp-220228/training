package com.revature.employeereimbursementsystem.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class LoginDTO {

    private String username;
    private String password;

}
