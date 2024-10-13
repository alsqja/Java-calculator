package lv2;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String operator;
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        int firstNumber;
        int secondNumber;
        double answerValue;
        label:
        while (true) {
            System.out.print("연산자를 입력하세요(exit: 종료, get: 결과 목록 출력, set: 결과 목록 수정, delete: 첫번째 결과 삭제): ");
            operator = sc.nextLine();

            switch (operator) {
                case "exit":
                    break label;
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
            }

            System.out.print("첫번째 양의 정수를 입력하세요: ");
            firstNumber = sc.nextInt();

            System.out.print("두번째 양의 정수를 입력하세요: ");
            secondNumber = sc.nextInt();

            sc.nextLine();  // 엔터 삭제

            answerValue = calculator.calculate(firstNumber, secondNumber, operator);
            System.out.println("answer = " + answerValue);
        }
        System.out.println("프로그램 종료");
    }
}
