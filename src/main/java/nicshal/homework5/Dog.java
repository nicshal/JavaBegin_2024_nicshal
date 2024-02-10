package nicshal.homework5;

public class Dog extends Animal implements Swimming {

    public static final int SWIMMING_COST = 2;

    public Dog(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        super(name, runningSpeed, swimmingSpeed, endurance);
    }

    @Override
    public String getAnimalType() {
        return Dog.class.getSimpleName() + " - собака обыкновенная";
    }

    @Override
    public double swim(int distance) {
        int newEndurance = Math.max(getEndurance() - distance * SWIMMING_COST, 0);
        setEndurance(newEndurance);
        return newEndurance > 0 ? (distance * 1.0) / getRunningSpeed() : -1;
    }

    @Override
    public String toString() {
        return Dog.class.getSimpleName() + '{' +
                super.toString() +
                '}';
    }

}