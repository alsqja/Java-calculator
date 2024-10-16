package advanced;

public abstract class AbstractOperation<T extends Number> {
    //  추상 클래스 추상 메서드로 operate 선언
    public abstract double operate(T a, T b) throws DivideByZero;
}
