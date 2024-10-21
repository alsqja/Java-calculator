package lv3;

import java.util.ArrayList;
import java.util.List;

enum OperType {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String operator;

    OperType(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static OperType fromOperator(String operator) throws IllegalArgumentException {
        for (OperType type : OperType.values()) {
            if (type.getOperator().equals(operator)) {
                return type;
            }
        }
        throw new IllegalArgumentException("해당하는 연산자가 없습니다.");
    }
}

public class ArithmeticCalculator<T extends Number> {
    private final List<Double> answers = new ArrayList<>();

    public double calculate(T firstNumber, T secondNumber, String operator) {
        switch (OperType.fromOperator(operator)) {
            case ADD -> {
                this.answers.add(firstNumber.doubleValue() + secondNumber.doubleValue());
                return firstNumber.doubleValue() + secondNumber.doubleValue();
            }
            case SUBTRACT -> {
                this.answers.add(firstNumber.doubleValue() - secondNumber.doubleValue());
                return firstNumber.doubleValue() - secondNumber.doubleValue();
            }
            case MULTIPLY -> {
                this.answers.add(firstNumber.doubleValue() * secondNumber.doubleValue());
                return firstNumber.doubleValue() * secondNumber.doubleValue();
            }
            case DIVIDE -> {
                if (secondNumber.doubleValue() == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                this.answers.add(firstNumber.doubleValue() / secondNumber.doubleValue());
                return firstNumber.doubleValue() / secondNumber.doubleValue();
            }
            default -> throw new UnsupportedOperationException("지원되지 않는 연산자입니다.");
        }
    }

    public double[] getAnswers() {
        double[] returns = new double[this.answers.size()];
        for (int i = 0; i < this.answers.size(); i++) {
            returns[i] = this.answers.get(i);
        }
        return returns;
    }

    //  answers 가장 먼저 저당된 데이터 삭제 메서드
    public double deleteAnswer() {
        return this.answers.remove(0);
    }

    //  answers Setter
    public double setAnswers(int index, double value) {
        return this.answers.set(index, value);
    }

    public List<Double> getLargerAnswers(double num) {
        return this.answers.stream().filter(el -> el > num).toList();
    }

}
