package com.ciandt.feedfront;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ciandt.feedfront.models.Employee;

public class App {

    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("feedfront");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        System.out.println("Connected");
    }
}