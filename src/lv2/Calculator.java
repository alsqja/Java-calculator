package lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Double> answers = new ArrayList<>();

    //  answers Getter
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

    public double calculate(int firstNum, int secondNum, String operator) {
        double answer;
        switch (operator) {
            case "+" -> {
                answer = firstNum + secondNum;
                this.answers.add(answer);
                return answer;
            }
            case "-" -> {
                answer = firstNum - secondNum;
                this.answers.add(answer);
                return answer;
            }
            case "*" -> {
                answer = firstNum * secondNum;
                this.answers.add(answer);
                return answer;
            }
            case "/" -> {
                answer = (double) firstNum / secondNum;
                this.answers.add(answer);
                return answer;
            }
        }
        return 0;
    }
}
