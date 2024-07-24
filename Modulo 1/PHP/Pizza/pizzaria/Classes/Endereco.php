<?php
class Endereco {
    private string $rua;
    private string $bairro;
    private string $cidade;

    function setRua($rua) {
        $this->rua = $rua;
    }
    function getRua() {
        return $this->rua;
    }

    function setBairro($bairro) {
        $this->bairro = $bairro;
    }
    function getBairro() {
        return $this->bairro;
    }

    function setCidade($cidade) {
        $this->cidade = $cidade;
    }
    function getCidade() {
        return $this->cidade;
    }
}
?>