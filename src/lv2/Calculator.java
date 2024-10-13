package lv2;

public class Calculator {
    private int firstNumber;
    private int secondNumber;

    private AbstractOperation operation;

    //  operation 을 정해주는 생성자
    public Calculator(AbstractOperation operation) {
        this.operation = operation;
    }

    //  parameter 가 없을 시 기본 생성자 overriding
    public Calculator() {
    }

    //  operation Setter
    public void setOperation(AbstractOperation operation) {
        this.operation = operation;
    }

    //  firstNumber Setter
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    //  secondNumber Setter
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    //  calculate method
    public double calculate() {
        double answer = 0;
        //	일단 answer에 연산 결과 담기
        try {
            answer = operation.operate(this.firstNumber, this.secondNumber);
        } catch (DivideByZero e) {
            //	DivideByZero 에러 throw 시 메세지 출력
            System.out.println(e.getMessage());
        }
        return answer;
    }
}
