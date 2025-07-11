package Lv1calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("간단한 계산기 프로그램입니다.");

        while (true) {
            int num1 = 0;
            while (true) {
                System.out.print("첫 번째 양의 정수를 입력하세요 (0 포함): ");
                if (sc.hasNextInt()) {
                    num1 = sc.nextInt();
                    if (num1 >= 0) {
                        break;
                    } else {
                        System.out.println("음수는 입력할 수 없습니다.");
                    }
                } else {
                    System.out.println("정수를 입력하세요.");
                    sc.next(); // 잘못된 입력 제거
                }
            }

            // 연산 기호 입력
            System.out.print("연산 기호를 입력하세요 (+, -, *, /, %, ^): ");
            char operator = sc.next().charAt(0);

            int num2 = 0;
            while (true) {
                System.out.print("두 번째 양의 정수를 입력하세요 (0 포함): ");
                if (sc.hasNextInt()) {
                    num2 = sc.nextInt();
                    if (num2 >= 0) {
                        break;
                    } else {
                        System.out.println("음수는 입력할 수 없습니다.");
                    }
                } else {
                    System.out.println("정수를 입력하세요.");
                    sc.next(); // 잘못된 입력 제거
                }
            }

            long result;
            try {
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = (long) num1 * num2; // 오버플로우 방지를 위해 long으로 형변환
                        break;
                    case '/':
                        if (num2 == 0) {
                            throw new ArithmeticException("0으로 나눌 수 없습니다.");
                        }
                        result = num1 / num2;
                        break;
                    case '%':
                        if (num2 == 0) {
                            throw new ArithmeticException("0으로 나눌 수 없습니다.");
                        }
                        result = num1 % num2;
                        break;
                    case '^':
                        if (num1 == 0 && num2 == 0) {
                            throw new IllegalArgumentException("0의 0승은 정의되지 않습니다.");
                        }
                        result = 1;
                        for (int i = 0; i < num2; i++) {
                            result *= num1;
                        }
                        break;
                    default:
                        System.out.println("올바른 연산 기호를 입력하세요. (+, -, *, /, %, ^)");
                        continue; // 올바르지 않은 연산자면 다시 입력받도록
                }
                System.out.println("연산 결과: " + result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("연산 오류: " + e.getMessage());
            }

            System.out.println("---");

            // 계산 종료 여부 확인
            System.out.print("계산기를 계속 사용하시겠습니까? (계속하려면 아무 키, 종료하려면 'exit' 입력): ");
            String ard = sc.next();
            if (ard.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }

        sc.close();
    }
}