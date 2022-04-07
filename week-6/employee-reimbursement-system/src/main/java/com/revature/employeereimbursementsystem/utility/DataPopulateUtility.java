package com.revature.employeereimbursementsystem.utility;

import com.revature.employeereimbursementsystem.model.ReimbursementStatus;
import com.revature.employeereimbursementsystem.model.ReimbursementType;
import com.revature.employeereimbursementsystem.model.User;
import com.revature.employeereimbursementsystem.model.UserRole;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class DataPopulateUtility {

    @PersistenceContext // Whenever you reference the "em" variable, it will refer to the EntityManager scoped
    // to that particular transaction
    private EntityManager em;
    // EntityManager is the JPA interface that the Hibernate Session
    // type inherits from
    // EntityManager will work pretty much the same as how Session works in Hibernate

    @Transactional // Creates a transaction for this particular method while it is being executed
    public void populateInitialData() {

			/*
				Populating reimbursement types
			 */
        ReimbursementType lodging = new ReimbursementType();
        lodging.setType("lodging");
        em.persist(lodging);

        ReimbursementType travel = new ReimbursementType();
        travel.setType("travel");
        em.persist(travel);

        ReimbursementType food = new ReimbursementType();
        food.setType("food");
        em.persist(food);

        ReimbursementType other = new ReimbursementType();
        other.setType("other");
        em.persist(other);

			/*
				Reimbursement Status
			 */
        ReimbursementStatus pending = new ReimbursementStatus();
        pending.setStatus("pending");
        em.persist(pending);

        ReimbursementStatus approved = new ReimbursementStatus();
        approved.setStatus("approved");
        em.persist(approved);

        ReimbursementStatus denied = new ReimbursementStatus();
        denied.setStatus("denied");
        em.persist(denied);

			/*
				User Role
			 */
        UserRole financeManager = new UserRole();
        financeManager.setRole("finance_manager");
        em.persist(financeManager);

        UserRole employee = new UserRole();
        employee.setRole("employee");
        em.persist(employee);

        /*
            Users
         */

        User user1 = new User();
        user1.setRole(financeManager);
        user1.setEmail("bach_tran@email.com");
        user1.setFirstName("Bach");
        user1.setLastName("Tran");
        user1.setUsername("bach_tran");
        user1.setPassword("password123");
        em.persist(user1);

        User user2 = new User();
        user2.setRole(employee);
        user2.setEmail("jane_doe@email.com");
        user2.setFirstName("Jane");
        user2.setLastName("Doe");
        user2.setUsername("jane_doe");
        user2.setPassword("password");
        em.persist(user2);
    }
}
