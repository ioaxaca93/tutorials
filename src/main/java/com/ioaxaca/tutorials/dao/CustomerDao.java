/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioaxaca.tutorials.dao;
import com.ioaxaca.tutorials.entities.Customer;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Israel
 */
@Repository("customerDao")
@Primary//en caso de q haya mas de una implementacion del mismo Bean primary se usa para que el contenedor use la isntancia con esa anotacion por defecto para las injecciones
public class CustomerDao implements CrudRepository<Customer,Long >{
    
    @PersistenceContext
    private EntityManager entityManager;
    
//    @Transactional(readOnly = true)
//    public List<Customer> findAll(){
//        List resultList = entityManager.createQuery("FROM Customer").getResultList();
//        return resultList;
//    }
//    @Transactional(readOnly = true)
//    public Customer findById(Long id){
//        return entityManager.find(Customer.class, id);
//    }
//    
//    @Transactional
//    public void save(Customer customer){
//        entityManager.persist(customer);
//    }

    @Transactional(readOnly = true)
    public Customer findByEmail(String email) {
        return entityManager.unwrap(Session.class)
                .createQuery("SELECT c FROM Customer c WHERE c.email= :email",Customer.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existsById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<Long> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(Iterable<? extends Customer> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Customer> S save(S s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Customer> findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Customer> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
