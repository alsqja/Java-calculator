package lv2;

public class App {
    public static void main(String[] args) {
        //  exit 입력 여부를 찾는 calculatedEnded
        boolean calculateEnded = false;

        //  exit 입력 전 까지 계속 계산 수행
        while (!calculateEnded) {
            try {
                calculateEnded = CalculatorApp.start();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
