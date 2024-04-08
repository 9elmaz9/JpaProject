package org.example.repository;

import org.example.model.Student;

import javax.persistence.*;


public class StudentRepository {
    private final EntityManager entityManager;
    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void add(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }
    public Student find(Long id) {
        return entityManager.find(Student.class, id);
    }
    public void update(Student student) {
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
    }
    public void delete(Student student) {
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }
}
//hello elmaz