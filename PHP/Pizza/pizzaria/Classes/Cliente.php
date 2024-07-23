<?php
class Cliente {
    private string $nome;
    private string $contato;
    private Endereco $endereco;

    function setNome($nome) {
        $this->nome = $nome;
    }
    function getNome() {
        return $this->nome;
    }

    function setContato($contato) {
        $this->contato = $contato;
    }
    function getContato() {
        return $this->contato;
    }
    
    function setEndereco(Endereco $endereco) {
        $this->endereco = $endereco;
    }
    function getEndereco() {
        return $this->endereco;
    }
}
?>