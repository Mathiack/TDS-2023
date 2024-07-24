<?php
class Batatinha {
    private string $tamanho;
    private float $valor;
    
    function setTamanho($tamanho) {
        $this->tamanho = $tamanho;
    }
    function getTamanho() {
        return $this->tamanho;
    }

    function setValor($valor) {
        $this->valor = $valor;
    }
    function getValor() {
        return $this->valor;
    }
}
?>