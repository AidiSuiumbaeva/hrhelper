package service;

import models.Person;
import models.enums.Position;

import java.util.List;

public interface DBHelper {

    Person savePerson(String name, int age, Double salary, Position position);

    List<Person> getSortedPerson(int answer);
}
