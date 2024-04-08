package org.example;

import org.example.model.Student;
import org.example.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("database-configuration");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            try {
                Student student = new Student();
                student.setFirstName("Alan");
                student.setLastName("Red");
                StudentRepository studentRepository = new StudentRepository(entityManager);
// add
                studentRepository.add(student);
                System.out.println("Added student " + student.toString());
//search
                student = studentRepository.find(student.getId());
                System.out.println("Found student " + student.toString());
//update
                student.setLastName("Demir");
                studentRepository.update(student);
                System.out.println("Updated student " + student.toString());
//delete
//studentRepository.delete(student);
//System.out.println("Deleted student " + student.toString());
            } finally {
                entityManager.close();
                entityManagerFactory.close();
            }
        }
    }
