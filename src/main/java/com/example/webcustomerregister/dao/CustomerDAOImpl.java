package com.example.webcustomerregister.dao;

import com.example.webcustomerregister.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    //@Transactional - we moved this functionality to service level after creating service
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();

        //query + sort by last name
        Query<Customer> theQuery =
                currentSession.createQuery("from Customer order by lastName", Customer.class);

        List<Customer> customers = theQuery.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();

        //currentSession.save(theCustomer); --> because im using this method also for updating
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {

        //getting hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //retrieving from db using the key
        Customer theCustomer = currentSession.get(Customer.class, theId);

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);

        theQuery.executeUpdate();
    }


}
