package nicshal.homework19;

public class Main {

    public static void main(String[] args) {
        Apple apple1 = new Apple(3.09);
        Apple apple2 = new Apple(2.44);
        Apple apple3 = new Apple(4.01);
        Apple apple4 = new Apple(1.1);
        Box<Apple> boxApple1 = new Box<>(100);
        boxApple1.add(apple1);
        boxApple1.add(apple2);
        boxApple1.add(apple3);
        boxApple1.add(apple4);

        Orange orange1 = new Orange(6.0);
        Orange orange2 = new Orange(4.64);
        Box<Orange> boxOrange1 = new Box<>(200);
        boxOrange1.add(orange1);
        boxOrange1.add(orange2);

        // проверяем равенство весов
        System.out.println(boxApple1.compare(boxOrange1));

        // проверяем неравенство весов
        Orange orange3 = new Orange(3.88);
        boxOrange1.add(orange3);
        System.out.println(boxApple1.compare(boxOrange1));

        // проверяем выход за границу коробки
        Apple apple5 = new Apple(95.01);
        try {
            boxApple1.add(apple5);
        } catch (BoxDataException ex) {
            System.out.println(ex.getMessage());
        }

        // проверяем пересыпку с недостатком места
        Box<Fruit> boxFruit1 = new Box<>(15);
        Orange orange4 = new Orange(7.77);
        boxFruit1.add(orange4);
        try {
            boxApple1.move(boxFruit1);
        } catch (BoxDataException ex) {
            System.out.println(ex.getMessage());
        }

        // проверяем пересыпку с недостатком места
        Box<Fruit> boxFruit2 = new Box<>(500);
        Orange orange5 = new Orange(7.77);
        boxFruit2.add(orange5);
        boxApple1.move(boxFruit2);
        System.out.println(boxFruit2);
        System.out.println(boxApple1);
    }

}