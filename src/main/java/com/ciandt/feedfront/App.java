package com.ciandt.feedfront;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ciandt.feedfront.models.Employee;

public class App {

    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("feedfront");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            Employee employee1 = new Employee("JoÃ£o", "Silveira", "j.silveira@email.com");
            Employee employee2 = new Employee("JoÃ£o1", "Silveira", "j.silveira@email.com");
            Employee employee3 = new Employee("JoÃ£o2", "Silveira", "j.silveira@email.com");

            DAOTest daoTest = new DAOTest(entityManager);

//            daoTest.salvar(employee1);
//            daoTest.salvar(employee2);
//            daoTest.salvar(employee3);

            for (Employee e: daoTest.listar()) {
                System.out.println(e);
            }

            Employee employee = daoTest.buscar(employee1.getId());

            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }


        System.out.println("Connected");
    }
}