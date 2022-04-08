package com.revature.employeereimbursementsystem.dao;

import com.revature.employeereimbursementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // You can define custom ways to retrieve data
    // Spring Data JPA will figure out how to perform this operation based on how you name the method

    public abstract User findByUsernameAndPassword(String username, String password);

    // You can have your repository methods return a Set instead of a List
    // Set can be appropriate for querying from a database, since all records should be unique anyways
    // Set has the advantage in that there is no ordering for Sets, while ordering does exist for Lists
    // Therefore, Set may have an advantage when it comes to testing for whether certain data exists or not (and we
    // don't care about order)
    public abstract Set<User> findByFirstName(String firstName);
    public abstract List<User> findByLastName(String lastName);

}
