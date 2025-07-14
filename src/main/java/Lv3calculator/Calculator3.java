package Lv3calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator3 {
    // 계산 결과 저장 리스트
    private List<Integer> results = new ArrayList<>();

    // 결과 리스트 복사본 반환 (외부에서 직접 수정 방지)
    public List<Integer> getResults() {
        return new ArrayList<>(results);
    }

    // 결과 리스트 새로 설정 (초기화)
    public void setResults(List<Integer> newResults) {
        this.results = new ArrayList<>(newResults);
        System.out.println("연산 결과 리스트가 초기화 되었습니다.");
    }

    // 계산 수행: OperatorEnum의 calculate() 호출
    public int calculate(int num1, int num2, OperatorEnum operator) {
        int result = operator.calculate(num1, num2);  // 변경: apply -> calculate
        results.add(result);
        return result;
    }

    // 가장 오래된 결과 삭제
    public void removeFirstResult() {
        if (!results.isEmpty()) {
            results.remove(0);
            System.out.println("가장 오래된 연산 결과가 삭제되었습니다.");
        } else {
            System.out.println("저장된 연산 결과가 없습니다.");
        }
    }
}
