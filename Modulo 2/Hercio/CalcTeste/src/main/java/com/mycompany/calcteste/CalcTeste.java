package com.mycompany.calcteste;

public class CalcTeste {

    public int soma(int a, int b) {
        return a + b;
    }

    public int subtrai(int a, int b) {
        return a - b;
    }
    
    public int mult(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return a / b;
    }
}
