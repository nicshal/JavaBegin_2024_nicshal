package nicshal.homework5;

public class Main {

    public static void main(String[] args) {
        Dog dog1 = new Dog("Шарик", 2, 1, 20);
        Dog dog2 = new Dog("Бобик", 3, 2, 100);
        Cat cat1 = new Cat("Барсик", 1, 1, 15);
        Cat cat2 = new Cat("Мурзик", 2, 1, 25);
        Horse horse1 = new Horse("Буцефал", 7, 5, 500);
        Horse horse2 = new Horse("Гнедой", 12, 6, 1010);

        dog1.info();
        dog2.info();
        cat1.info();
        cat2.info();
        horse1.info();
        horse2.info();

        int distance = 5;
        double timeSpent = dog1.run(distance);
        if (timeSpent < 0) {
            System.out.println("Животное " + dog1.getAnimalType() + " по имени " + dog1.getName() + " устало и недобежало");
        } else {
            System.out.println("Животное " + dog1.getAnimalType() + " по имени " + dog1.getName() + " пробежало " + distance + "м за " + timeSpent + " секунд");
        }
        System.out.println("---");
        distance = 15;
        timeSpent = dog1.swim(distance);
        if (timeSpent < 0) {
            System.out.println("Животное " + dog1.getAnimalType() + " по имени " + dog1.getName() + " устало и недоплыло");
        } else {
            System.out.println("Животное " + dog1.getAnimalType() + " по имени " + dog1.getName() + " проплыло " + distance + "м за " + timeSpent + " секунд");
        }
        System.out.println("---");
        distance = 10;
        timeSpent = dog2.swim(distance);
        if (timeSpent < 0) {
            System.out.println("Животное " + dog2.getAnimalType() + " по имени " + dog2.getName() + " устало и недоплыло");
        } else {
            System.out.println("Животное " + dog2.getAnimalType() + " по имени " + dog2.getName() + " проплыло " + distance + "м за " + timeSpent + " секунд");
        }
        System.out.println("---");
        distance = 4;
        timeSpent = cat1.run(distance);
        if (timeSpent < 0) {
            System.out.println("Животное " + cat1.getAnimalType() + " по имени " + cat1.getName() + " устало и недобежало");
        } else {
            System.out.println("Животное " + cat1.getAnimalType() + " по имени " + cat1.getName() + " пробежало " + distance + "м за " + timeSpent + " секунд");
        }
        System.out.println("---");
        distance = 200;
        timeSpent = horse1.run(distance);
        if (timeSpent < 0) {
            System.out.println("Животное " + horse1.getAnimalType() + " по имени " + horse1.getName() + " устало и недобежало");
        } else {
            System.out.println("Животное " + horse1.getAnimalType() + " по имени " + horse1.getName() + " пробежало " + distance + "м за " + timeSpent + " секунд");
        }
        System.out.println("---");
        distance = 100;
        timeSpent = horse1.swim(distance);
        if (timeSpent < 0) {
            System.out.println("Животное " + horse1.getAnimalType() + " по имени " + horse1.getName() + " устало и недоплыло");
        } else {
            System.out.println("Животное " + horse1.getAnimalType() + " по имени " + horse1.getName() + " проплыло " + distance + "м за " + timeSpent + " секунд");
        }
        System.out.println("---");
        distance = 200;
        timeSpent = horse2.run(distance);
        if (timeSpent < 0) {
            System.out.println("Животное " + horse2.getAnimalType() + " по имени " + horse2.getName() + " устало и недобежало");
        } else {
            System.out.println("Животное " + horse2.getAnimalType() + " по имени " + horse2.getName() + " пробежало " + distance + "м за " + timeSpent + " секунд");
        }
        System.out.println("---");
        distance = 100;
        timeSpent = horse2.swim(distance);
        if (timeSpent < 0) {
            System.out.println("Животное " + horse2.getAnimalType() + " по имени " + horse2.getName() + " устало и недоплыло");
        } else {
            System.out.println("Животное " + horse2.getAnimalType() + " по имени " + horse2.getName() + " проплыло " + distance + "м за " + timeSpent + " секунд");
        }
        System.out.println("---");

        dog1.info();
        dog2.info();
        cat1.info();
        cat2.info();
        horse1.info();
        horse2.info();
    }

}