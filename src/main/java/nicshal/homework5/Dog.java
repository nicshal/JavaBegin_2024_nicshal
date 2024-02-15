package nicshal.homework5;

public class Dog extends Animal implements Swimming {

    public static final int SWIMMING_COST = 2;

    private int swimmingSpeed;

    public Dog(String name, int runningSpeed, int endurance, int swimmingSpeed) {
        super(name, runningSpeed, endurance);
        this.swimmingSpeed = swimmingSpeed;
    }

    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
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
                "Скорость плавания = " + swimmingSpeed + " м/с" +
                ", " + super.toString() +
                '}';
    }

}