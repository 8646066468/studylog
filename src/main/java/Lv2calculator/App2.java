package Lv2calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator ca = new Calculator();

        System.out.println("간단한 계산기 프로그램입니다.");

        while (true) {
            int num1 = 0;
            while (true) {
                System.out.print("첫 번째 양의 정수를 입력하세요 (0 포함): ");
                try {
                    num1 = scanner.nextInt();
                    if (num1 >= 0) break;
                    else System.out.println("음수는 입력할 수 없습니다.");
                } catch (InputMismatchException e) {
                    System.out.println("정수를 입력하세요.");
                    scanner.next();
                }
            }

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /, %, ^): ");
            char operator = scanner.next().charAt(0);

            int num2 = 0;
            while (true) {
                System.out.print("두 번째 양의 정수를 입력하세요 (0 포함): ");
                try {
                    num2 = scanner.nextInt();
                    if (num2 >= 0) break;
                    else System.out.println("음수는 입력할 수 없습니다.");
                } catch (InputMismatchException e) {
                    System.out.println("정수를 입력하세요.");
                    scanner.next();
                }
            }

            try {
                int result = ca.cal(num1, num2, operator);
                System.out.println("연산 결과: " + result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("연산 오류: " + e.getMessage());
            }

            System.out.println("---");

            // 현재 저장된 연산 결과들 확인 (Getter 활용)
            System.out.println("현재 저장된 연산 결과들: " + ca.getResults());

            // --- Setter 메서드 활용 ---
            // 리스트 초기화는 항상 물어보고, 초기화되면 오래된 연산 결과 삭제는 건너뛰도록 합니다.
            System.out.print("연산 결과 리스트를 초기화(새로 설정)하시겠습니까? (y/n): ");
            String resetChoice = scanner.next();
            if (resetChoice.equalsIgnoreCase("y")) {
                List<Integer> emptyList = new ArrayList<>();
                ca.setResults(emptyList);
                System.out.println("리스트 초기화 후 저장된 연산 결과들: " + ca.getResults());
                // 리스트를 초기화를 하면 가장 오래된 결과 삭제는 묻지 않고 다음 반복으로 넘어갑니다.

                // --- getter 메서드 활용 ---
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