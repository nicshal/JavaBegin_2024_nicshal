package nicshal.homework19;

public class Fruit {

    private final double weight;

    public Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return Fruit.class.getSimpleName() + '{' +
                "weight=" + weight +
                '}';
    }

}