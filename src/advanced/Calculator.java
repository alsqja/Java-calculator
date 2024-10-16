package advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
    private final List<Double> answers = new ArrayList<>();
    private AbstractOperation<Number> operation;

    public double calculate(String formula) throws Exception {
        Parser parser = new Parser();
        List<String> postfix = parser.infixToPostfix(formula);
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            if (Parser.isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                double result = applyOperator(a, b, token);
                stack.push(result);
            }
        }
        double answer = stack.pop();
        answers.add(answer);

        return answer;
    }

    // 연산자에 따른 계산 수행
    public double applyOperator(double a, double b, String operator) throws Exception {
        AbstractOperation<Number> operation;
        switch (operator) {
            case "+" -> {
                operation = new AddOperation();
                return operation.operate(a, b);
            }
            case "-" -> {
                operation = new SubstractOperation();
                return operation.operate(a, b);
            }
            case "*" -> {
                operation = new MultiplyOperation();
                return operation.operate(a, b);
            }
            case "/" -> {
                operation = new DivideOperation();
                return operation.operate(a, b);
            }
            default -> throw new IllegalArgumentException("유효하지 않은 연산자입니다: " + operator);
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
