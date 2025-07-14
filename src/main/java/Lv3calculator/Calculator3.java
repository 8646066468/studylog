package Lv3calculator;

import java.util.ArrayList;
import java.util.List;
//제네릭 계산기 클래스
// 다양한 Number 타입(Double, Integer 등)에 대해 연산을 수행할 수 있도록 제네릭으로 설계
public class Calculator3<T extends Number> {
    // 계산 결과 저장 리스트
    private List<Double> results = new ArrayList<>();

    // 결과 리스트 복사본 반환 (외부에서 직접 수정 방지)
    public List<Double> getResults() {
        return new ArrayList<>(results);
    }

    // 결과 리스트 새로 설정 (초기화)
    public void setResults(List<Double> newResults) {
        this.results = new ArrayList<>(newResults);
        System.out.println("연산 결과 리스트가 초기화 되었습니다.");
    }

    // 계산 수행: OperatorEnum의 calculate() 호출
    // Number 타입의 값을 double로 변환하여 처리
    public double calculate(T num1, T num2, OperatorEnum operator) {
        double a = num1.doubleValue();
        double b = num2.doubleValue();
        double result = operator.calculate(a, b);
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
