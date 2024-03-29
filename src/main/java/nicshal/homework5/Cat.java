package nicshal.homework5;

public class Cat extends Animal {

    public Cat(String name, int runningSpeed, int endurance) {
        super(name, runningSpeed, endurance);
    }

    @Override
    public String getAnimalType() {
        return Cat.class.getSimpleName() + " - кошка обыкновенная";
    }

    @Override
    public String toString() {
        return Cat.class.getSimpleName() + '{' +
                super.toString() +
                '}';
    }

}