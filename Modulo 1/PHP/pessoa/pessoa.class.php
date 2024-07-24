<?php
class Pessoa {

    private $nome;
    private $idade;
    private $email;
    private $celular;
    private $hora;
    private $site;
    private $senha;
    private $nascimento;
    private $cor;
    private $filhos;
    private $sexo;
    private $estado;
    private $mensagem;

    function __construct($nome) {
        $this->nome = $nome;
    }

    public function setNome($nome) {
        $this->nome = $nome;
    }
    public function getNome() {
        return $this->nome;
    }

    public function setIdade($idade) {
        $this->idade = $idade;
    }
    public function getIdade() {
        return $this->idade;
    }

    public function setEmail($email) {
        $this->email = $email;
    }
    public function getEmail() {
        return $this->email;
    }

    public function setCelular($celular) {
        $this->celular = $celular;
    }
    public function getCelular() {
        return $this->celular;
    }

    public function setHora($hora) {
        $this->hora = $hora;
    }
    public function getHora() {
        return $this->hora;
    }

    public function setSite($site) {
        $this->site = $site;
    }
    public function getSite() {
        return $this->$site;
    }

    public function setSenha($senha) {
        $this->senha = $senha;
    }
    public function getSenha() {
        return $this->$senha;
    }

    public function setNascimento($nascimento) {
        $this->nascimento = $nascimento;
    }
    public function getNascimento() {
        return $this->$nascimento;
    }

    public function setCor($cor) {
        $this->cor = $cor;
    }
    public function getCor() {
        return $this->$cor;
    }
    
    public function setFilhos($filhos) {
        $this->filhos = $filhos;
    }
    public function getFilhos() {
        return $this->$filhos;
    }

    public function setSexo($sexo) {
        $this->sexo = $sexo;
    }
    public function getSexo() {
        return $this->$sexo;
    }

    public function setEstado($estado) {
        $this->estado = $estado;
    }
    public function getEstado() {
        return $this->$estado;
    }

    public function setMensagem($mensagem) {
        $this->mensagem = $mensagem;
    }
    public function getMensagem() {
        return $this->$mensagem;
    }

    public function tudo() {
        $nomedaPessoa   = $this->nome;
        $idade          = $this->idade;
        $email          = $this->email;
        $celular        = $this->celular;
        $hora           = $this->hora;
        $site           = $this->site;
        $senha          = $this->senha;
        $nascimento     = $this->nascimento;
        $cor            = $this->cor;
        $filhos         = $this->filhos;
        $sexo           = $this->sexo;
        $estado         = $this->estado;
        $mensagem       = $this->mensagem;


        return "Aoba fi, eu so o" . $nomedaPessoa . "!";
        return "Tenho " . $idade. "anos";
        return "Meu email é: " . $email . ".";
        return "Ei gata, meu número é: " .$celular ".";
        return "A hora do nosso encontro vai ser: " .$hora. ".";
        return "Um site que eu gosto é: " .$site. ".";
        return "Nasci em: " .$nascimento. ".";
        return "Gosto da cor: " .$cor. ".";
        return "Tenho: " .$filhos. "filhos.";
        return "Sou do sexo:" .$sexo. "(nada de todes comigo).";
        return "Sou de/do: " .$estado. ".";
        return "Uma mensagem que eu deixo é:" .$mensagem. ".";
    }

?>