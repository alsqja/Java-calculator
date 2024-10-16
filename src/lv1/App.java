package lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        char operator;
        String scInput;
        do {
            Scanner sc = new Scanner(System.in);
            int firstNumber;
            int secondNumber;
            System.out.print("첫번째 양의 정수를 입력하세요: ");
            firstNumber = sc.nextInt();

            System.out.print("두번째 양의 정수를 입력하세요: ");
            secondNumber = sc.nextInt();

            sc.nextLine();  //  엔터 처리

            System.out.print("연산자를 입력하세요: ");
            scInput = sc.nextLine();
            operator = scInput.charAt(0);

            switch (operator) {
                case '+' -> System.out.println(firstNumber + secondNumber);
                case '-' -> System.out.println(firstNumber - secondNumber);
                case '*' -> System.out.println(firstNumber * secondNumber);
                case '/' -> {
                    if (secondNumber == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    System.out.println((double) firstNumber / secondNumber);
                }
                default -> System.out.println("지원하지 않는 연산자입니다.");
            }


        } while (!scInput.equals("exit"));
        System.out.println("프로그램 종료");
    }
}
