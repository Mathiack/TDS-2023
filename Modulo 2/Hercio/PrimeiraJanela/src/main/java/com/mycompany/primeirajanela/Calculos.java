package com.mycompany.primeirajanela;

public class Calculos {
    private Double numero1, numero2, calculo;

    public Double getNumero1() {
        return numero1;
    }

    public void setNumero1(Double numero1) {
        this.numero1 = numero1;
    }

    public Double getNumero2() {
        return numero2;
    }

    public void setNumero2(Double numero2) {
        this.numero2 = numero2;
    }

    public Double getCalculo() {
        return calculo;
    }

    public void setCalculo(Double calculo) {
        this.calculo = calculo;
    }
    
    public void soma() {
        this.setCalculo(this.numero1+this.numero2);
    }
    
    public void subtracao() {
        this.setCalculo(this.numero1-this.numero2);
    }
    
    public void divisao() {
        if (this.numero2 !=0) {
        this.setCalculo(this.numero1/this.numero2); }
        else {
            this.setCalculo(0.0);
        }
    }
    public void multiplicacao() {
        this.setCalculo(this.numero1*this.numero2);
    }
   
}