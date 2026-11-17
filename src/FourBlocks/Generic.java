package FourBlocks;

import java.io.Serializable;
import java.util.Arrays;

class Animal {
    private String name;
    public Animal(String name) { this.name = name; }
    public String getName() { return name; }
    @Override public String toString() { return "Animal(" + name + ")"; }
}
class Dog extends Animal implements Serializable {
    public Dog(String name) { super(name); }
    @Override public String toString() { return "Dog(" + getName() + ")"; }
}
class Triple<T extends Comparable<T>, V extends Animal & Serializable, K> {
    private T t; 
    private V v; 
    private K k;
    public Triple(T t, V v, K k) { 
        this.t = t; 
        this.v = v; 
        this.k = k; 
    }
    public T getT() { return t; }
    public V getV() { return v; }
    public K getK() { return k; }
    public void printClassNames() {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("V: " + v.getClass().getName());
        System.out.println("K: " + k.getClass().getName());
    }
}
class MinMax<T extends Comparable<T>> {
    private T[] array;
    public MinMax(T[] array) { 
        this.array = array; 
    }
    public T min() {
        T m = array[0];
        for (T x : array) if (x.compareTo(m) < 0) m = x;
        return m;
    }
    public T max() {
        T m = array[0];
        for (T x : array) if (x.compareTo(m) > 0) m = x;
        return m;
    }
}
class Calculator {
    public static <T extends Number, U extends Number> double sum(T a, U b) { return a.doubleValue() + b.doubleValue(); }
    public static <T extends Number, U extends Number> double multiply(T a, U b) { return a.doubleValue() * b.doubleValue(); }
    public static <T extends Number, U extends Number> double divide(T a, U b) { return a.doubleValue() / b.doubleValue(); }
    public static <T extends Number, U extends Number> double subtraction(T a, U b) { return a.doubleValue() - b.doubleValue(); }
}
class Matrix<T extends Number> {
    private T[][] data;
    private int rows, cols;
    public Matrix(T[][] data) {
        this.data = data;
        this.rows = data.length;
        this.cols = data[0].length;
    }
    public Matrix<Double> add(Matrix<T> other) {
        Double[][] result = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = data[i][j].doubleValue() + other.data[i][j].doubleValue();
            }
        }
        return new Matrix<>(result);
    }
    public Matrix<Double> multiply(Matrix<T> other) {
        Double[][] result = new Double[rows][other.cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double s = 0;
                for (int k = 0; k < cols; k++) {
                    s += data[i][k].doubleValue() * other.data[k][j].doubleValue();
                }
                result[i][j] = s;
            }
        }
        return new Matrix<>(result);
    }
    public void print() {
        for (T[] row : data) System.out.println(Arrays.toString(row));
    }
}
public class Generic {
    public static void main(String[] args) {
        System.out.println("1, 2, 3: Triple");
        Triple<String, Dog, Integer> triple = new Triple<>("hello", new Dog("Rex"), 42);
        triple.printClassNames();
        System.out.println(triple.getT() + " " + triple.getV() + " " + triple.getK());
        System.out.println("4: MinMax & Calculator");
        MinMax<Integer> mm = new MinMax<>(new Integer[]{5, 2, 9, 1, 7});
        System.out.println("min = " + mm.min() + ", max = " + mm.max());
        System.out.println("sum = " + Calculator.sum(3, 4.5));
        System.out.println("multiply = " + Calculator.multiply(2.5, 4));
        System.out.println("divide = " + Calculator.divide(10, 4));
        System.out.println("subtraction = " + Calculator.subtraction(10.5, 3));
        System.out.println("5: Matrix");
        Matrix<Double> a = new Matrix<>(new Double[][]{{1.0, 2.0}, {3.0, 4.0}});
        Matrix<Double> b = new Matrix<>(new Double[][]{{5.0, 6.0}, {7.0, 8.0}});
        System.out.println("A + B:");
        a.add(b).print();
        System.out.println("A * B:");
        a.multiply(b).print();
    }
}