package lv2;

public class DivideByZero extends Exception {
    public DivideByZero() {
        super("0으로 나누기 불가");
    }
}
