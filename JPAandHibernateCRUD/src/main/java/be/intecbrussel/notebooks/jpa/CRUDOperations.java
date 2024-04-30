package be.intecbrussel.notebooks.jpa;

import be.intecbrussel.notebooks.jpa.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CRUDOperations {
    private EntityManagerFactory entityManagerFactory;

    public CRUDOperations() {
        entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }

    public void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }

    public void insertEntity(Student student){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Student findEntity(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, id);
        entityManager.close();
        return student;
    }

    public void updateEntity(int id, Student updatedStudent) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Student existingStudent = entityManager.find(Student.class, id);
        if (existingStudent != null) {
            existingStudent.setFirstName(updatedStudent.getFirstName());
            existingStudent.setLastName(updatedStudent.getLastName());
            existingStudent.setEmail(updatedStudent.getEmail());
            entityManager.merge(existingStudent);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeEntity(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Student studentToRemove = entityManager.find(Student.class, id);
        if (studentToRemove != null) {
            entityManager.remove(studentToRemove);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
