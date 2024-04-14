package nicshal.homework19;

import java.util.ArrayList;
import java.util.List;

import static nicshal.homework19.ApplicationConstants.*;

public class Box<T extends Fruit> {

    private List<T> fruitList = new ArrayList<>();
    private double capacity;

    public Box(int capacity) {
        this.capacity = capacity;
    }

    public List<T> getFruitList() {
        return fruitList;
    }

    public void setFruitList(List<T> fruitList) {
        this.fruitList = fruitList;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(T fruit) {
        if (getResidualCapacity() - fruit.getWeight() < -PRECISION) {
            throw new BoxDataException(String.format(BOX_RESIDUAL_CAPACITY_ERROR, fruit.getWeight(), getResidualCapacity()));
        }
        fruitList.add(fruit);
    }

    public double getWeight() {
        double weight = 0;
        for (T fruit : fruitList) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public double getResidualCapacity() {
        return capacity - getWeight();
    }

    public boolean compare(Box<? extends Fruit> box) {
        return Math.abs(getWeight() - box.getWeight()) <= PRECISION;
    }

    public void move(Box<? super T> box) {
        if (box.getResidualCapacity() - getWeight() < -PRECISION) {
            throw new BoxDataException(String.format(BOX_MOVE_ERROR, box.getResidualCapacity(), getWeight()));
        }
        for (T fruit : fruitList) {
            box.add(fruit);
        }
        setFruitList(new ArrayList<>());
    }

    @Override
    public String toString() {
        return Box.class.getSimpleName() + '{' +
                "fruitList=" + fruitList +
                ", capacity=" + capacity +
                '}';
    }

}