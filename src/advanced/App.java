package advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        int count = 0;
        label:
        while (true) {
            if (count > 0) {
                System.out.println("다음 행동을 입력하세요.");
                System.out.print("(calc: 한번 더 계산, exit: 종료, get: 결과 목록 출력, set: 결과 목록 수정, delete: 첫번째 결과 삭제, bigger: 결과 목록 중 입력 값보다 큰 값 출력): ");
                String next = sc.nextLine();

                switch (next) {
                    case "exit":
                        break label;
                    case "bigger":
                        System.out.print("값을 입력하세요.: ");
                        double inputValue = Double.parseDouble(sc.next());
                        sc.nextLine();
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
                        System.out.println("잘못 입력하셨습니다.");
                        continue;
                    }
                }
            }

            System.out.print("계산할 수식을 입력하세요: ");
            String input = sc.nextLine();

            try {
                double result = calculator.calculate(input);
                System.out.println("결과: " + result);
                count++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
