package Lv3calculator;

public enum OperatorEnum {
    ADD('+') {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    SUB('-') {
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    },
    MUL('*') {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    },
    DIV('/') {
        @Override
        public int apply(int a, int b) {
            if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
            return a / b;
        }
    },
    MOD('%') {
        @Override
        public int apply(int a, int b) {
            return a % b;
        }
    },
    POW('^') {
        @Override
        public int apply(int a, int b) {
            if (b < 0) throw new IllegalArgumentException("음수 지수는 지원하지 않습니다.");
            return (int) Math.pow(a, b);
        }
    };

    private final char symbol;

    OperatorEnum(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract int apply(int a, int b);

    public static OperatorEnum fromChar(char ch) {
        for (OperatorEnum op : values()) {
            if (op.symbol == ch) return op;
        }
        throw new IllegalArgumentException("유효하지 않은 연산 기호입니다: " + ch);
    }
}