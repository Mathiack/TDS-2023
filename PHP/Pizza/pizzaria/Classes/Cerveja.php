<?php
class Cerveja{
    private string $marca;
    private string $tipo;
    private float $valor;

    function setMarca($marca) {
        $this->marcaa = $marca;
    }
    function getMarca() {
        return $this->marca;
    }

    function setTipo($tipo) {
        $this->tipo = $tipo;
    }
    function getTipo() {
        return $this->tipo;
    }

    function setValor($valor) {
        $this->valor = $valor;
    }
    function getValor() {
        return $this->valor;
    }
}
?>