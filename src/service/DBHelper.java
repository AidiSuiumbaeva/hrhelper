package service;

import exceptions.AgeControlExc;
import exceptions.SalaryExc;
import models.Person;
import models.enums.Position;

import java.util.List;
import java.util.Map;

public interface DBHelper {

    void addLocalPerson();

    Person savePerson(String name, int age, Double salary, Position position) throws AgeControlExc, SalaryExc;

    List<Person> getSortedPerson(int answer);

    Map<String,Integer> getMaxMinAge();
}
