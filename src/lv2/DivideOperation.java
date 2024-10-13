package lv2;

public class DivideOperation extends AbstractOperation {
    @Override
    public double operate(int a, int b) throws DivideByZero {
        // b == 0 일 경우
        if (b == 0) {
            //  0으로 나누기 불가 예외 throw
            throw new DivideByZero();
        }
        return (double) a / b;
    }
}
