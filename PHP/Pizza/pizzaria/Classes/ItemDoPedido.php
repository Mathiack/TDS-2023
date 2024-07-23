<?php
class ItemDoPedido {
    private string $descricao;
    private float $valor;
    private string $tamanho;

    function setDescricao($descricao) {
        $this->descricao = $descricao;
    }
    function getDescricao() {
        return $this->descricao;
    }

    function setValor($valor) {
        $this->valor = $valor;
    }
    function getValor() {
        return $this->valor;
    }

    function setTamanho($tamanho) {
        $this->tamanho = $tamanho;
    }
    function getTamanho() {
        return $this->tamanho;
    }
}
?>