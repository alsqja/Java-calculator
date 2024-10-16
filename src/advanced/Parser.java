package advanced;

import java.util.*;

public class Parser {
    public List<String> infixToPostfix(String expression) {
        List<String> output = new ArrayList<>(); // 후위 표기식 결과
        Stack<String> operators = new Stack<>(); // 연산자 스택

        // 연산자 우선순위 정의
        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);

        StringTokenizer tokens = new StringTokenizer(expression, "()+-*/", true); // 수식을 기호로 토큰화

        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken().trim();

            if (token.isEmpty()) {
                continue;
            }

            // 숫자인 경우 출력
            if (isNumeric(token)) {
                output.add(token);
            }
            // 왼쪽 괄호 '('인 경우 연산자 스택에 push
            else if (token.equals("(")) {
                operators.push(token);
            }
            // 오른쪽 괄호 ')'인 경우, '('를 만날 때까지 연산자를 출력
            else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                if (!operators.isEmpty() && operators.peek().equals("(")) {
                    operators.pop(); // '(' 제거
                }
            }
            // 연산자인 경우
            else if (precedence.containsKey(token)) {
                while (!operators.isEmpty() && !operators.peek().equals("(")
                        && precedence.get(operators.peek()) >= precedence.get(token)) {
                    output.add(operators.pop());
                }
                operators.push(token); // 현재 연산자를 스택에 push
            }
        }

        // 스택에 남아 있는 모든 연산자를 출력
        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        return output;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
