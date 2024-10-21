package lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Calculator {
    private final List<Double> answers = new ArrayList<>();

    //  answers Getter
    public List<Double> getAnswers() {
        return this.answers;
    }

    //  answers 가장 먼저 저당된 데이터 삭제 메서드
    public double deleteAnswer() {
        return this.answers.remove(0);
    }

    //  answers Setter
    public double setElemOfAnswers(int index, double value) {
        return this.answers.set(index, value);
    }

    public double calculate(int firstNum, int secondNum, String operator) {
        double answer = 0;
        switch (operator) {
            case "+" -> {
                answer = firstNum + secondNum;
            }
            case "-" -> {
                answer = firstNum - secondNum;
            }
            case "*" -> {
                answer = firstNum * secondNum;
            }
            case "/" -> {
                if (secondNum == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                answer = (double) firstNum / secondNum;
            }
            default -> throw new InputMismatchException("잘못된 연산자 입니다.");
        }
        this.answers.add(answer);
        return answer;
    }
}
