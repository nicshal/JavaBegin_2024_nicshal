package nicshal.homework19;

public class Apple extends Fruit {

    public Apple(double weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return Apple.class.getSimpleName() + '{' +
                super.toString() +
                '}';
    }

}