package nicshal.homework5;

public class Horse extends Animal implements Swimming {

    public static final int SWIMMING_COST = 4;

    private int swimmingSpeed;

    public Horse(String name, int runningSpeed, int endurance, int swimmingSpeed) {
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
        return Horse.class.getSimpleName() + " - лошадь обыкновенная";
    }

    @Override
    public double swim(int distance) {
        int newEndurance = Math.max(getEndurance() - distance * SWIMMING_COST, 0);
        setEndurance(newEndurance);
        return newEndurance > 0 ? (distance * 1.0) / getRunningSpeed() : -1;
    }

    @Override
    public String toString() {
        return Horse.class.getSimpleName() + '{' +
                "Скорость плавания = " + swimmingSpeed + " м/с" +
                ", " + super.toString() +
                '}';
    }

}