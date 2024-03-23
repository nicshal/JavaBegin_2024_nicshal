package nicshal.homework13;

import nicshal.homework9.Employee;

import java.util.function.BinaryOperator;

public class Operator<T, R> {

    private T name;
    private BinaryOperator<R> operator;

    public Operator(T name, BinaryOperator<R> interfase) {
        this.name = name;
        this.operator = interfase;
    }

    public T getName() {
        return name;
    }

    public BinaryOperator<R> getInterfase() {
        return operator;
    }

    @Override
    public String toString() {
        return Employee.class.getSimpleName() + '{' +
                "name=" + name +
                ", operator=" + operator +
                '}';
    }

}