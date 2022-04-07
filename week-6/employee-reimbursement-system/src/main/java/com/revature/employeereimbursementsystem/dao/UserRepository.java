package com.revature.employeereimbursementsystem.dao;

import com.revature.employeereimbursementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // You can define custom ways to retrieve data
    // Spring Data JPA will figure out how to perform this operation based on how you name the method

    public abstract User findByUsernameAndPassword(String username, String password);
    public abstract List<User> findByFirstName(String firstName);
    public abstract List<User> findByLastName(String lastName);

}
