package com.ciandt.feedfront;

import com.ciandt.feedfront.models.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class DAOTest {
    private EntityManager entityManager;

    public DAOTest(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> listar() {
        String jpql = "select e from Employee e";

        return entityManager.createQuery(jpql).getResultList();
    }

    public Employee buscar(String id) {
        return entityManager.find(Employee.class, id);
    }


    public Employee salvar(Employee employee) {
        entityManager.getTransaction().begin();

        entityManager.persist(employee);

        entityManager.getTransaction().commit();

        return employee;
    }

}