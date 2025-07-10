package Lv2calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> results = new ArrayList<>();

    // Getter 메서드
    public List<Integer> getResults() {
        return new ArrayList<>(results);
    }

    // Setter
    // 간접 접근을 통해 필드를 새로운 리스트로 설정할 수 있도록 구현합니다.
    public void setResults(List<Integer> newResults) {

        this.results = new ArrayList<>(newResults);
        System.out.println("연산 결과 리스트가 초기화 되었습니다.");
    }



    public int cal(int num1, int num2, char operator) {
        int result;
        switch (operator) {
            case '+': result = add(num1, num2); break;
            case '-': result = sub(num1, num2); break;
            case '*': result = mul(num1, num2); break;
            case '/': result = div(num1, num2); break;
            case '%': result = mod(num1, num2); break;
            case '^': result = (int) pow(num1, num2); break;
            default: throw new IllegalArgumentException("유효하지 않은 연산 기호입니다: " + operator);
        }
        results.add(result);
        return result;
    }

    public int add(int a, int b) { return a + b; }
    public int sub(int a, int b) { return a - b; }
    public int mul(int a, int b) { return a * b; }
    public int div(int a, int b) {
        if (b == 0) { throw new ArithmeticException("0으로 나눌 수 없습니다."); }
        return a / b;
    }
    public int mod(int a, int b) { return a % b; }
    public long pow(int a, int intExp) {
        if (intExp < 0) { throw new IllegalArgumentException("음수 지수는 지원하지 않습니다."); }
        long res = 1;
        for (int i = 0; i < intExp; i++) { res *= a; }
        return res;
    }
    // removeFirstResult 메서드 (이전과 동일)
    public void removeFirstResult() {
        if (!results.isEmpty()) {
            results.remove(0);
            System.out.println("가장 오래된 연산 결과가 삭제되었습니다.");
        } else {
            System.out.println("저장된 연산 결과가 없습니다.");
        }
    }
}