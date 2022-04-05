package com.revature.HelloSpringBoot.repositories;

import com.revature.HelloSpringBoot.models.Candy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JPA repository has built-in methods that we can use to query our database
//find, findall, save, delete, etc.
//JPARepository vs. CrudRepository
@Repository
public interface CandyRepository extends JpaRepository<Candy, Integer> {

}
