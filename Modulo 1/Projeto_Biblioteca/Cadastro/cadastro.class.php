<?php
include_once "../conexao.php";
include "testeL.php";
class Cadastro{
    private $ID_User;
    private $email;
    private $senha;

    function __construct($ID_User){
        $this->ID_User = $ID_User;
    }
    function getID_User(){
        return $this->ID_User;
    }
    function getEmail(){
        return $this->email;
    }
    function setEmail($email){
        $this->email = $email;
    }

    function getSenha(){
        return $this->senha;
    }
    function setSenha($senha){
        $this->senha = $senha;
    }
    function inserirUsuario() {
        $database = new Conexao(); 
        $db = $database->getConnection(); 
        
        $sql = "INSERT INTO usuario (email, senha) VALUES (:email, :senha)";
        try {
            $stmt = $db->prepare($sql);

            $stmt->bindParam(':email', $this->email);
            $stmt->bindParam(':senha', $this->senha);
            
            $stmt->execute();
            return true;
            
        } catch (PDOException $e) {
            echo "Erro ao inserir usuario: " . $e->getMessage();
            return false;
        }
    }
}