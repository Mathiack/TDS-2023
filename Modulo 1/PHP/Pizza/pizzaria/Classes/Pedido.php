<?php

class Pedido{
    private $total;
    private $taxaEntrega;
    private $dataHoraPedido;
    private Cliente $cliente;
    private array $itensDoPedido;

    function setCliente(Cliente $cliente) {
        $this->cliente = $cliente;
        $bairro = $this->cliente->getEndereco()->getBairro();
        if ($bairro == "centro") {
            $this->settaxaEntrega(10);
        } else if ($bairro == "periferia") {
            $this->settaxaEntrega(15);
        } else {
            $this->settaxaEntrega(67.005);
        }
    }
    function getCliente() {
        return $this->cliente;
    }

    function setTotal($total) {
        $this->total = $total;
    }
    function getTotal() {
        return $this->total;
    }

    function settaxaEntrega($taxaEntrega) {
        $this->taxaEntrega = $taxaEntrega;
    }
    function gettaxaEntrega() {
        return $this->taxaEntrega;
    }

    function setdataHoraPedido($dataHoraPedido) {
        $this->dataHoraPedido = $dataHoraPedido;
    }
    function getdataHoraPedido() {
        return $this->dataHoraPedido;
    }

    function setItens(array $itensDoPedido) {
        $this->itensDoPedido = $itensDoPedido; 
    }
    function getItens() {
        return $this->itensDoPedido;
    }
    
    function addItemDoPedido($itemDoPedido) {
        $this->itensDoPedido[] = $itemDoPedido;
    }
}
?>