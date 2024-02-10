package nicshal.homework5;

public class Cat extends Animal {

    public Cat(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        super(name, runningSpeed, swimmingSpeed, endurance);
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