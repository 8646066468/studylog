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

    // 실제 계산 수행 (공통 메서드, switch-case로 분기)
    public int calculate(int a, int b) {
        switch (this) {
            case ADD:
                return a + b;
            case SUB:
                return a - b;
            case MUL:
                return a * b;
            case DIV:
                if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
                return a / b;
            case MOD:
                return a % b;
            case POW:
                if (b < 0) throw new IllegalArgumentException("음수 지수는 지원하지 않습니다.");
                return (int) Math.pow(a, b);
            default:
                throw new UnsupportedOperationException("지원하지 않는 연산자입니다.");
        }
    }
}
