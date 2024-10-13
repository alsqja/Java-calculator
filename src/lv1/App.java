package lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String operator;
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
            operator = sc.nextLine();

            switch (operator) {
                case "+" -> System.out.println(firstNumber + secondNumber);
                case "-" -> System.out.println(firstNumber - secondNumber);
                case "*" -> System.out.println(firstNumber * secondNumber);
                case "/" -> System.out.println((double) firstNumber / secondNumber);
            }


        } while (!operator.equals("exit"));
        System.out.println("프로그램 종료");
    }
}
