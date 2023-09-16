package models;

import exceptions.AgeControlExc;
import exceptions.SalaryExc;
import models.enums.Position;

public class Person {
    private Long id;
    private String name;
    private int age;
    private Double salary;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    private Position position;

    public Person() {
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }

    public Person(Long id, String name, int age, Double salary, Position position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeControlExc {
        if (age<18){
            throw new AgeControlExc("Возраст не соответствует");
        }
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) throws SalaryExc {
        if(salary<0){
            throw new SalaryExc("Неверно введена сумма зарплаты. Она 0трицательная.Прошу быть внимательнее!!");
        }
        this.salary = salary;
    }
}
