package nicshal.homework4;

import java.time.Year;

public class Main {

    public static final int CURRENT_YEAR = Year.now().getValue();

    public static void main(String[] args) {
        User[] users = {
                new User("Петров", "Петр", "Иванович", 1970, "petrov@mail.ru"),
                new User("Иванов", "Потап", "Владимирович", 2001, "ivan@mail.ru"),
                new User("Захаров", "Игнат", "Николаевич", 1977, "zahar@mail.ru"),
                new User("Дуров", "Борис", "Иванович", 2010, "dur@mail.ru"),
                new User("Кутузов", "Василий", "Петрович", 1950, "kutuz@mail.ru"),
                new User("Васин", "Вячеслав", "Алексеевич", 2011, "vas@mail.ru"),
                new User("Темников", "Алексей", "Иванович", 2009, "tem@mail.ru"),
                new User("Бубнов", "Константин", "Григорьевич", 1990, "buba@mail.ru"),
                new User("Пирогов", "Григорий", "Витальевич", 1983, "pirog@mail.ru"),
                new User("Носков", "Иван", "Потапович", 2005, "noskov@mail.ru"),
        };

        for (int i = 0; i < users.length; i++) {
            if ((CURRENT_YEAR - users[i].getBirthYear()) > 40) {
                users[i].printUser();
                System.out.println("---");
            }
        }

        Box testBox = new Box(5, 10, 15, "красный");
        testBox.printBox();
        testBox.setColor("зеленый");
        testBox.addContent("хлеб");
        testBox.setStatus(true);
        testBox.addContent("хлеб");
        testBox.printBox();
        testBox.addContent("колбаса");
        testBox.removeContent();
        testBox.addContent("колбаса");
        testBox.printBox();
    }
}