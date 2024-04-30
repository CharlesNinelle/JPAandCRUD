package be.intecbrussel.notebooks.jpa;

import be.intecbrussel.notebooks.jpa.entity.Student;

public class App {
    public static void main(String[] args) {
        CRUDOperations crudOperations = new CRUDOperations();

        // Вставка сущности
        Student newStudent = new Student("John", "Doe", "john@doe.com");
        crudOperations.insertEntity(newStudent);

        // Поиск сущности
        Student foundStudent = crudOperations.findEntity(1); // Предполагается, что id=1 существует в базе данных
        System.out.println("Found student: " + foundStudent);

        // Обновление сущности
        foundStudent.setFirstName("Nikola");
        crudOperations.updateEntity(1, foundStudent); // Предполагается, что id=1 существует в  базе данных

        // Удаление сущности
        //crudOperations.removeEntity(1); // Предполагается, что id=1 существует в базе данных
    }
}
