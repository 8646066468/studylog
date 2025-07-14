package Lv3calculator;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App3 {
    public static double inputPositiveNumber(Scanner scanner, String message) {
        double num ;
        while (true) {
            System.out.print(message);
            try {
                num = scanner.nextDouble();
                if (num <= 0) {
                    System.out.println("양의 숫자를 입력하세요.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하세요.");
                scanner.next();
            }
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator3<Double> ca = new Calculator3<>();//실수 전용 계산기

        System.out.println("간단한 계산기 프로그램입니다.");

        while (true) {
            double num1 = inputPositiveNumber(scanner, "첫 번째 양의 숫자를 입력하세요: ");
            // 연산자 입력
            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /, %, ^): ");
            char operator = scanner.next().charAt(0);
            double num2 = inputPositiveNumber(scanner, "두 번째 양의 숫자를 입력하세요: ");



            // 연산 수행
            try {
                OperatorEnum operatorType = OperatorEnum.fromChar(operator);
                double result = ca.calculate(num1, num2, operatorType);
                System.out.println("결과: " + result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
            }

            // 현재 저장된 연산 결과들 확인 (Getter 활용)
            // 현재 저장된 연산 결과들 확인 (Getter 활용)
            System.out.println("현재 저장된 연산 결과들: " + ca.getResults());

            // setter메서드 활용.
            System.out.print("연산 결과 리스트를 초기화(새로 설정)하시겠습니까? (y/n): ");
            String resetChoice = scanner.next();
            if (resetChoice.equalsIgnoreCase("y")) {
                List<Double> emptyList = new ArrayList<>();
                ca.setResults(emptyList);
                System.out.println("리스트 초기화 후 저장된 연산 결과들: " + ca.getResults());


                // getter 메서드 활용
            } else { // 초기화하지 않았을 경우에만 오래된 결과 삭제를 물어봄

                if (!ca.getResults().isEmpty()) {
                    System.out.print("가장 오래된 연산 결과를 삭제하시겠습니까? (y/n): ");
                    String removeChoice = scanner.next();
                    if (removeChoice.equalsIgnoreCase("y")) {
                        ca.removeFirstResult();
                        System.out.println("삭제 후 저장된 연산 결과들: " + ca.getResults());
                    }
                } else {
                    System.out.println("삭제할 연산 결과가 없습니다.");
                }
            }
            //구분선
            System.out.println("---");

            System.out.print("더 계산하시겠습니까(아무거나 입력시 계속 실행)? (exit 입력 시 종료): ");
            String continueChoice = scanner.next();
            if (continueChoice.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }

        scanner.close();
    }
}
