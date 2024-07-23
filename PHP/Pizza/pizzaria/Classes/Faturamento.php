<?php
class Faturamento {
    private $totalGeral = 0;
    private $totalMotoboy = 0;
    private $qtdItensDoPedido = 0;
    private $dataHoraPedido;
    
    function settotalGeral($totalGeral) {
        $this->totalGeral = $totalGeral;
    }
    function gettotalGeral() {
        return $this->totalGeral;
    }

    function settotalMotoboy($totalMotoboy) {
        $this->totalMotoboy = $totalMotoboy;
    }
    function gettotalMotoboy() {
        return $this->totalMotoboy;
    }

    function setqtdItensDoPedido($qtdItensDoPedido) {
        $this->qtdItensDoPedido = $qtdItensDoPedido;
    }
    function getqtdItensDoPedido() {
        return $this->qtdItensDoPedido;
    }

    function setdataHoraPedido($dataHoraPedido) {
        $this->dataHoraPedido = $dataHoraPedido;
    }
    function getdataHoraPedido() {
        return $this->dataHoraPedido;
    }

    function imprimirNota() {
        echo '--------------------------------------';
        echo '        Pizzaria Quase Pronto         ';
        echo '--------------------------------------';
        echo 'Cliente: ' . getCliente();
    }
    
}
?>