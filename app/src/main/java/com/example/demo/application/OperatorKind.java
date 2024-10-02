package com.example.demo.application;

public enum OperatorKind {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");
    private final String symbol;
    OperatorKind(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
    public static OperatorKind fromSymbol(String symbol) {
        for (OperatorKind kind : values()) {
            if (kind.getSymbol().equals(symbol)) {
                return kind;
            }
        }
        throw new IllegalArgumentException("Unknown operator: " + symbol);
    }
}

