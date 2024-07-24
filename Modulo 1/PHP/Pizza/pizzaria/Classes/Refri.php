<?php
class Refri{
    private string $marca;
    private string $sabor;
    private string $tipo;
    private float $valor;

    function setMarca($marca) {
        $this->marca = $marca;
    }
    function getMarca() {
        return $this->marca;
    }
    
    function setSabor($sabor) {
        $this->sabor = $sabor;
    }
    function getSabor() {
        return $this->sabor;
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
    
    /*function precoRefri() {
        $precobase = 0;
        if($tipo == "lata") {
            
        }    
    } */

}
?>