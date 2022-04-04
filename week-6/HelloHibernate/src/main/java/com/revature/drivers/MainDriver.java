package com.revature.drivers;

import com.revature.models.Reimbursement;
import com.revature.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.revature.models.*;

public class MainDriver {
    public static void main(String[] args) {
        //System.out.println("Hello World");
        populateSampleData();
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
        User user2 = new User("The", "Batman", "thebatman", "password"); //transient

        Reimbursement reimb1 = new Reimbursement(1000.34, user1, "gas money to annual conference");
        Reimbursement reimb2 = new Reimbursement(1000000000.02, user2, "for new Batmobile");

        //persistent
        session.persist(user1);
        session.persist(user2);
        session.persist(reimb1);
        session.persist(reimb2);

        tx.commit();

        session.close(); //user1/user2/reimb1/reimb2 are now detached
    }
}
