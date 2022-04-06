package com.revature.drivers;

import com.revature.models.Reimbursement;
import com.revature.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.revature.models.*;

import javax.persistence.Query;
import java.util.List;

public class MainDriver {
    public static void main(String[] args) {
//        populateSampleData();
//        test();
//        getDataFromDatabase();
        populateSampleData2();
    }

    public static void populateSampleData2() {
        SessionFactory sf = SessionFactorySingleton.getSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        // Reminder of Object states:
        // 1. Transient (regular object that has been created in Java)
        // 2. Persistent (an object being tracked by an OPEN session)
        // 3. Detached (an object that was once persistent, but has either been evicted or the session was closed)

        User user1 = session.get(User.class, 1); // persistent
        // Changes made to persistent objects will then be persisted to the database whenever
        // 1. the session is "flushed"
        // or
        // 2. the transaction is committed
        user1.setFirstName("Trevor");
        tx.commit(); // tx.commit() will persist changes for objects whose states are already persistent

        tx = session.beginTransaction();

        Reimbursement r1 = new Reimbursement(); // Transient
        r1.setDescription("Business travel");
        r1.setAuthor(user1);
        r1.setAmount(100);

        Reimbursement r2 = new Reimbursement(); // Transient
        r2.setDescription("Team building dinner");
        r2.setAuthor(user1);
        r2.setAmount(200);

        session.persist(r1);
        session.persist(r2);
        // At this point, r1 and r2 are no longer transient, they are now persistent

        tx.commit(); // tx.commit() will persist changes for objects whose states are already persistent
        session.close();
    }

    public static void getDataFromDatabase() {
        SessionFactory sf = SessionFactorySingleton.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Get reimbursements that belong to user
//        User u = session.get(User.class, 1);
//        System.out.println(u.getReimbursements());
        // The above would work if we have had a one-to-many mapping in the User class
        // However, we wanted to avoid the headaches with bidirectional mappings and infinite recursion
        // So we only have a Many to one mapping on the Reimbursement class

        // HQL comes to save the day
        // HQL is an object based query language
        // You don't query tables using HQL, you instead query classes and properties of those classes
        Query query = session.createQuery(
                "SELECT r FROM Reimbursement r JOIN r.author as u WHERE u.id = :id"
        );
        query.setParameter("id", 1);
        List<Reimbursement> reimbursements = query.getResultList();
        System.out.println(reimbursements);

        // Retrieve a Reimbursement object
        Reimbursement r = session.get(Reimbursement.class, 2); // id 2
        System.out.println(r);
        System.out.println(r.getAuthor());

        // HQL
        Reimbursement reimb = (Reimbursement) session
                .createQuery("FROM Reimbursement r WHERE r.id = :id")
                .setParameter("id", 2)
                .getSingleResult();
        System.out.println(reimb);

        tx.commit();
        session.close();
    }

    public static void test() {
        SessionFactory sf = SessionFactorySingleton.getSessionFactory();
    }

    public static void populateSampleData(){
        //1. get an instance of our sessionfactory
        SessionFactory sf = SessionFactorySingleton.getSessionFactory();

        //2. open a session
        Session session = sf.openSession(); //this will allows us to interact with our db

        //3. open transaction
        Transaction tx = session.beginTransaction();

        /**
         * Object states:
         * 1. Transient = plain old Java objs that have never been tracked by a session obj
         * 2. Persistent = an obj is now being tracked by the session obj and going to be synchronized with the db
         * 3. Detached = an obj that was persisted but is no longer usable within the session
         **/

        //4. make new data
        User user1 = new User("Bach", "Tran", "btran", "password"); //transient

        Reimbursement reimb1 = new Reimbursement(1000.34, user1, "gas money to annual conference");
        Reimbursement reimb2 = new Reimbursement(1000000000.02, user1, "for new Batmobile");

        //persistent
        session.persist(user1);
        session.persist(reimb1);
        session.persist(reimb2);

        tx.commit();

        session.close(); //user1/user2/reimb1/reimb2 are now detached
    }
}
