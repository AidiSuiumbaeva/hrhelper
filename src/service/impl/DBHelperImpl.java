package service.impl;

import exceptions.AgeControlExc;
import exceptions.SalaryExc;
import models.Person;
import models.enums.Position;
import service.DBHelper;

import java.util.*;

public class DBHelperImpl implements DBHelper {
    List<Person> personList=new ArrayList<>();


    Long idGenerate=5l;

    @Override
    public void addLocalPerson() {
        personList.add(new Person(1l,"Aidai",23,100000d,Position.DEVELOPER));
        personList.add(new Person(2l,"Aibek",16,1000d,Position.MANAGER));
        personList.add(new Person(3l,"Jazgul",20,130000d,Position.CEO));
        personList.add(new Person(4l,"Timur",18,18000d,Position.SELLER));
    }

    @Override
    public Person savePerson(String name, int age, Double salary, Position position) throws AgeControlExc, SalaryExc {
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

    @Override
    public Map<String, Integer> getMaxMinAge() {
        Map<String,Integer> result=new HashMap<>();

        Person max=personList.stream().max((o1, o2) -> { if(o1.getAge()==o2.getAge()){
            return 0;
        }else if(o1.getAge()>o2.getAge()){
            return 1;
        }else {
            return -1;
        } }).orElse(null);

        Person min=personList.stream().max((o1, o2) -> { if(o1.getAge()==o2.getAge()){
            return 0;
        }else if(o1.getAge()>o2.getAge()){
            return -1;
        }else {
            return 1;
        } }).orElse(null);

        result.put("Максимальный возраст у "+max.getName(),max.getAge());
        result.put("Минимальный возраст у "+min.getName(),min.getAge());


        return result;
    }
}
