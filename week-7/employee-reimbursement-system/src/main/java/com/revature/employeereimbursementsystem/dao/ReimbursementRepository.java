package com.revature.employeereimbursementsystem.dao;

import com.revature.employeereimbursementsystem.model.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement, Integer> {

    public abstract List<Reimbursement> findByAmountBetween(int lower, int upper);

    // Get all reimbursements where the author is id X
    @Query("SELECT r FROM Reimbursement r JOIN r.author a WHERE a.id = ?1") // JPQL syntax
    public List<Reimbursement> findByAuthorId(int authorId);

}
