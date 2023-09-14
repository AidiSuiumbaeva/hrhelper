package service.impl;

import models.Person;
import models.enums.Position;
import service.DBHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DBHelperImpl implements DBHelper {
    List<Person> personList=new ArrayList<>();
    Long idGenerate=1l;

    @Override
    public Person savePerson(String name, int age, Double salary, Position position) {
        Person person=new Person();
        person.setId(idGenerate++);
        person.setAge(age);
        person.setName(name);
        person.setSalary(salary);
        person.setPosition(position);

        personList.add(person);

        return person;
    }

    @Override
    public List<Person> getSortedPerson(int answer) {

        switch (answer){
            case 1:
                Collections.sort(personList,Comparator.comparing(Person::getName));
                break;
            case 2:
                Collections.sort(personList,Comparator.comparing(Person::getId));
                break;
            case 3:
                Collections.sort(personList,Comparator.comparing(Person::getId));
                Collections.reverse(personList);
        }

        return personList;
    }
}
