package lv2;

public abstract class AbstractOperation {
    //	추상 클래스 추상 메서드로 operate 선언
    public abstract double operate(int a, int b) throws DivideByZero;
}
