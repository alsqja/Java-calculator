package lv2;

import java.util.regex.Pattern;

public class Parser {
    //  +, -, *, / 중 해당하는 지 정규표현식
    private static final String OPERATION_REG = "[+\\-*/]";
    //  숫자 여부 정규표현식
    private static final String NUMBER_REG = "^[0-9]*$";

    private final Calculator calculator = new Calculator();

    public Parser parseFirstNum(String firstInput) throws BadInputException {
        // input이 비어있을 경우 에러 발생하는 것을 확인해 추가
        if (firstInput.isEmpty()) {
            throw new BadInputException("숫자");
        }
        //  input이 숫자가 아닐 경우 throw
        if (!Pattern.matches(NUMBER_REG, firstInput)) {
            throw new BadInputException("숫자");
        }

        //  carculator 인스턴스의 setFirstNumber로 firstNumber 수정
        this.calculator.setFirstNumber(Integer.parseInt(firstInput));
        return this;
    }

    public Parser parseSecondNum(String secondInput) throws BadInputException {
        if (secondInput.isEmpty()) {
            throw new BadInputException("숫자");
        }
        if (!Pattern.matches(NUMBER_REG, secondInput)) {
            throw new BadInputException("숫자");
        }
        this.calculator.setSecondNumber(Integer.parseInt(secondInput));
        return this;
    }

    public Parser parseOperator(String operationInput) throws BadInputException {
        //  연산 기호가 아닐 경우 throws
        if (!Pattern.matches(OPERATION_REG, operationInput)) {
            throw new BadInputException("연산자");
        }
        //  연산 기호에 따라 calculator setOperation으로 operation 클래스 변경
        switch (operationInput) {
            case "+" -> this.calculator.setOperation(new AddOperation());
            case "-" -> this.calculator.setOperation(new SubstractOperation());
            case "*" -> this.calculator.setOperation(new MultiplyOperation());
            default -> this.calculator.setOperation(new DivideOperation());
        }
        return this;
    }

    public double executeCalculator() {
        //  계산 실행
        return calculator.calculate();
    }
}
