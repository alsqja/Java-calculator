package advanced;

public class DivideOperation extends AbstractOperation<Number> {
    @Override
    public double operate(Number a, Number b) throws DivideByZero {
        // b == 0 일 경우
        if (b.doubleValue() == 0) {
            //  0으로 나누기 불가 예외 throw
            throw new DivideByZero();
        }
        return a.doubleValue() / b.doubleValue();
    }
}
