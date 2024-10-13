package lv2;

import java.util.Scanner;

public class CalculatorApp {
    public static boolean start() throws BadInputException {
        //  parser 인스턴스 생성
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);

        System.out.println("연산자를 입력해주세요! exit을 입력하면 종료됩니다.");
        String operator = scanner.nextLine();
        //  exit 입력되었을 경우에만 loop 종료 true 반환
        if (operator.equals("exit")) {
            return true;
        }
        //  operator 예외 처리
        parser.parseOperator(operator);


        //  firstNumber, secondNumber 입력 후 예외 처리
        System.out.println("첫번째 숫자를 입력해주세요!");
        String firstInput = scanner.nextLine();
        parser.parseFirstNum(firstInput);

        System.out.println("두번째 숫자를 입력해주세요!");
        String secondInput = scanner.nextLine();
        parser.parseSecondNum(secondInput);

        System.out.println("연산 결과 : " + parser.executeCalculator());
        return false;
    }


}
