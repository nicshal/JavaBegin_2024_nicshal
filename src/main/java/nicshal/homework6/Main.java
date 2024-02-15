package nicshal.homework6;

public class Main {

    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat[] cats = {
                new Cat("Барсик", 15),
                new Cat("Мурзик", 25),
                new Cat("Васька", 30),
                new Cat("Пупсик", 35),
                new Cat("Мишка", 10),
                new Cat("Гришка", 21)
        };

        System.out.println("Приглашаем к тарелке");
        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }
    }

}