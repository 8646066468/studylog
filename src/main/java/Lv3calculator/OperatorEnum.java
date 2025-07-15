package Lv3calculator;

public enum OperatorEnum {
    ADD('+'),
    SUB('-'),
    MUL('*'),
    DIV('/'),
    MOD('%'),
    POW('^');

    private final char symbol;

    // 생성자
    OperatorEnum(char symbol) {
        this.symbol = symbol;
    }

    // 기호 반환
    public char getSymbol() {
        return symbol;
    }

    // 연산자 문자로 enum 상수 찾기
    public static OperatorEnum fromChar(char ch) {
        for (OperatorEnum op : values()) {
            if (op.symbol == ch) return op;
        }
        throw new IllegalArgumentException("유효하지 않은 연산 기호입니다: " + ch);
    }

    // 실제 계산 수행
    //모든 연산을 double 타입으로 처리하여 실수 계산도 지원
    public double calculate(double a, double b) {
        return switch (this) {
            case ADD -> a + b;
            case SUB -> a - b;
            case MUL -> a * b;
            case DIV -> {
                if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
                yield a / b;
            }
            case MOD -> a % b;
            case POW -> {
                if (b < 0) throw new IllegalArgumentException("음수 지수는 지원하지 않습니다.");
                yield (int) Math.pow(a, b);
            }

        };
    }
}
