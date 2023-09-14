package service.impl;

import models.Person;
import models.enums.Position;
import service.DBHelper;
import service.MainService;

import java.util.Scanner;

public class MainServiceImpl implements MainService {

    Scanner scanner=new Scanner(System.in);

    DBHelper dbHelper=new DBHelperImpl();

    @Override
    public void start() {
        int mainAnswer=0;
        while (mainAnswer==0) {
            System.out.println("Выберите действие");
            System.out.println("1. Заведение новогo сотрудника");
            System.out.println("2. Просмотр списка");
            System.out.println("3. Анализ");
            int answer = scanner.nextInt();

            switch (answer) {
                case 1:
                    int result=addNewPerson();
                    if (result==1){
                        addNewPerson();
                    }else {
                        break;
                    }
                case 2:
                    viewPersonList();
                    break;
                case 3:
                    analize();
                    break;
                default:
                    throw new RuntimeException("Неверно указан ответ");

            }
        }
    }

    private void analize() {

    }

    private void viewPersonList() {
        System.out.println("Выберите способ сортировки");
        int answer=0;
        System.out.println("По имени 1");
        System.out.println("От новых к старым 2");
        System.out.println("От старых к новым 3");
        answer=scanner.nextInt();

        dbHelper.getSortedPerson(answer);

    }

    private int addNewPerson() {

            System.out.println("Укажите имя сотрудника");
            String name = scanner.next();
            System.out.println("Укажите возраст сотрудника");
            int age = scanner.nextInt();
            System.out.println("Укажите зарплату сотрудника");
            Double salary = scanner.nextDouble();
            System.out.println("Выберите позицию ");
            for (Position position : Position.values()) {
                System.out.println((position.getVal() + 1) + "." + position);
            }
            int positionVal = scanner.nextInt();
            Position position = Position.values()[positionVal - 1];
            Person person = dbHelper.savePerson(name, age, salary, position);
            System.out.println("Сотрудник удачно сохранен ");
            System.out.println(person);
            System.out.println("Хотите продолжить? ");
            System.out.println("да 0, нет 1");
            return scanner.nextInt();

    }
}
