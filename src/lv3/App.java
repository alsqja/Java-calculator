package lv3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();

        int count = 0;
        label:
        while (true) {
            if (count > 0) {
                System.out.println("다음 행동을 입력하세요.");
                System.out.print("(calc: 한번 더 계산, exit: 종료, get: 결과 목록 출력, set: 결과 목록 수정, delete: 첫번째 결과 삭제, bigger: 결과 목록 중 입력 값보다 큰 값 출력): ");
                String next = sc.next();

                switch (next) {
                    case "exit":
                        break label;
                    case "bigger":
                        System.out.print("값을 입력하세요.: ");
                        double inputValue = Double.parseDouble(sc.next());
                        List<Double> bigger = calculator.getLargerAnswers(inputValue);
                        System.out.println(bigger);
                        continue;
                    case "calc":
                        count = 0;
                        continue;
                    case "get":
                        double[] answers = calculator.getAnswers();
                        System.out.println(Arrays.toString(answers));
                        continue;
                    case "set": {
                        int index;
                        double value;
                        System.out.print("수정하실 인덱스를 입력해주세요: ");
                        index = sc.nextInt();
                        System.out.print("수정하실 값을 입력해주세요: ");
                        value = sc.nextInt();
                        sc.nextLine();
                        double answer = calculator.setAnswers(index, value);
                        System.out.println(answer + " -> " + value + " 수정 완료!");
                        continue;
                    }
                    case "delete": {
                        double answer = calculator.deleteAnswer();
                        System.out.println(answer + " 삭제 완료");
                        continue;
                    }
                    default: {
                        System.out.println("잘못된 입력입니다.");
                        continue;
                    }
                }
            }
            System.out.print("첫 번째 숫자를 입력하세요: ");
            String firstInput = sc.next();

            System.out.print("연산자를 입력하세요 (+, -, *, /): ");
            String operatorInput = sc.next();

            System.out.print("두 번째 숫자를 입력하세요: ");
            String secondInput = sc.next();

            // 입력된 값이 정수인지 실수인지 판별하여 적절한 타입 선택
            Number firstNumber = parseNumber(firstInput);
            Number secondNumber = parseNumber(secondInput);

            if (firstNumber == null || secondNumber == null) {
                System.out.println("잘못된 숫자 입력입니다.");
                return;
            }

            // 적절한 제네릭 타입으로 계산기 클래스 인스턴스화
            double result = calculator.calculate(firstNumber, secondNumber, operatorInput);
            System.out.println("결과: " + result);
            count++;
        }
        sc.close();
    }

    public static Number parseNumber(String input) {
        try {
            if (input.contains(".")) {
                return Double.parseDouble(input); // 소수점이 있으면 Double로 처리
            } else {
                return Integer.parseInt(input); // 정수면 Integer로 처리
            }
        } catch (NumberFormatException e) {
            return null; // 숫자 형식이 잘못된 경우 null 반환
        }
    }

}
