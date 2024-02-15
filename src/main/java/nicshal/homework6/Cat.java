package nicshal.homework6;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public Cat(String name, int appetite) {
        this(name, appetite, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public void eat(Plate plate) {
        if (plate.removeFood(getAppetite())) {
            setAppetite(0);
            setSatiety(true);
        }
    }

    public void info() {
        System.out.println("Кот " + getName() + (isSatiety() ? " сыт" : " очень голодный"));
    }

    @Override
    public String toString() {
        return Cat.class.getSimpleName() + '{' +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }

}