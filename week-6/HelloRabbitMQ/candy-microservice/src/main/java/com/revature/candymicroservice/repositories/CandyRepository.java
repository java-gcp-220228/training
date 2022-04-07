package com.revature.candymicroservice.repositories;

import com.revature.candymicroservice.models.Candy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandyRepository extends JpaRepository<Candy, Integer> {

}
