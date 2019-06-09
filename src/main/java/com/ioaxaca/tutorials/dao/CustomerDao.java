/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioaxaca.tutorials.dao;
import com.ioaxaca.tutorials.entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Israel
 */
@Repository("customerDao")
public class CustomerDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional(readOnly = true)
    public List<Customer> findAll(){
        List resultList = entityManager.createQuery("FROM Customer").getResultList();
        return resultList;
    }
    @Transactional(readOnly = true)
    public Customer findById(Long id){
        return entityManager.find(Customer.class, id);
    }
    
    @Transactional
    public void save(Customer customer){
        entityManager.persist(customer);
    }

    @Transactional(readOnly = true)
    public Customer findByEmail(String email) {
        return entityManager.unwrap(Session.class)
                .createQuery("SELECT c FROM Customer c WHERE c.email= :email",Customer.class)
                .setParameter("email", email)
                .getSingleResult();
    }
}
