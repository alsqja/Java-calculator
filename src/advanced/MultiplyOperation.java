package advanced;

public class MultiplyOperation extends AbstractOperation<Number> {
    @Override
    public double operate(Number a, Number b) {
        return a.doubleValue() * b.doubleValue();
    }
}
