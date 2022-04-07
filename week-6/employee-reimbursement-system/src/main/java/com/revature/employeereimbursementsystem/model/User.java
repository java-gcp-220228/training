package com.revature.employeereimbursementsystem.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="ers_user")
@NoArgsConstructor @Getter @Setter @ToString
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ers_user_id")
    private int id;

    @Column(name="ers_user_username", unique=true)
    private String username;

    @Column(name="ers_user_password")
    private String password;

    @Column(name="ers_user_firstname")
    private String firstName;

    @Column(name="ers_user_lastname")
    private String lastName;

    @Column(name="ers_user_email", unique=true)
    private String email;

    @ManyToOne
    @JoinColumn(name="ers_user_role_id") // Column name for the foreign key
    private UserRole role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, email, role);
    }
}
