package Lv3calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator3 {
    private List<Integer> results = new ArrayList<>();

    public List<Integer> getResults() {
        return new ArrayList<>(results);
    }

    public void setResults(List<Integer> newResults) {
        this.results = new ArrayList<>(newResults);
        System.out.println("연산 결과 리스트가 초기화 되었습니다.");
    }

    public int calculate(int num1, int num2, OperatorEnum operator) {
        int result = operator.apply(num1, num2);  // Enum이 계산 책임 담당
        results.add(result);
        return result;
    }

    public void removeFirstResult() {
        if (!results.isEmpty()) {
            results.remove(0);
            System.out.println("가장 오래된 연산 결과가 삭제되었습니다.");
        } else {
            System.out.println("저장된 연산 결과가 없습니다.");
        }
    }
}