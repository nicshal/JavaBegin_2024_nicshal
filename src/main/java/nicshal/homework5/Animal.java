package nicshal.homework5;

public abstract class Animal {

    public static final int RUNNING_COST = 1;

    private String name;
    private int runningSpeed;
    private int endurance;

    public Animal(String name, int runningSpeed, int endurance) {
        this.name = name;
        this.runningSpeed = runningSpeed;
        this.endurance = endurance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunningSpeed() {
        return runningSpeed;
    }

    public void setRunningSpeed(int runningSpeed) {
        this.runningSpeed = runningSpeed;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    abstract public String getAnimalType();

    public double run(int distance) {
        int newEndurance = Math.max(getEndurance() - distance * RUNNING_COST, 0);
        setEndurance(newEndurance);
        return newEndurance > 0 ? (distance * 1.0) / getRunningSpeed() : -1;
    }

    public void info() {
        System.out.println("Животное - " + getAnimalType());
        System.out.println("Состояние животного:" + this);
        if (endurance == 0) {
            System.out.println("Животное устало");
        }
        System.out.println("---");
    }

    @Override
    public String toString() {
        return Animal.class.getSimpleName() + '{' +
                "Имя = '" + name + '\'' +
                ", Скорость бега = " + runningSpeed + " м/с" +
                ", Выносливость = " + endurance + " ед." +
                '}';
    }

}