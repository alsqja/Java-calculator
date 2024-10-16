package advanced;

public class AddOperation extends AbstractOperation<Number> {
    @Override
    public double operate(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }
}
