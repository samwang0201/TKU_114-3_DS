import java.util.Stack;

public class BracketValidationSystem {

    public static void main(String[] args) {
        testExpression("()");
        testExpression("[]");
        testExpression("{}");
        testExpression("([])");
        testExpression("(a+b)");
        testExpression("([)]");
        testExpression("())");
        testExpression("(()");
    }

    public static void testExpression(String expression) {

        System.out.println("測試內容：" + expression);

        if (isValid(expression)) {
            System.out.println("括號配對正確");
        } else {
            System.out.println("括號配對錯誤");
        }

        System.out.println();
    }

    public static boolean isValid(String expression) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char current = expression.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            }

            else if (current == ')' || current == ']' || current == '}') {

                if (stack.isEmpty()) {
                    return false;
                }

                char leftBracket = stack.pop();

                if (!isMatchingPair(leftBracket, current)) {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }

    public static boolean isMatchingPair(
            char leftBracket, char rightBracket) {

        if (leftBracket == '(' && rightBracket == ')') {
            return true;
        }

        if (leftBracket == '[' && rightBracket == ']') {
            return true;
        }

        if (leftBracket == '{' && rightBracket == '}') {
            return true;
        }

        return false;
    }
}