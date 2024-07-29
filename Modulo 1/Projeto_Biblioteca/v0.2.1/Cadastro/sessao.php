<?php


include_once "../conexao.php";
include "cadastro.class.php";

if ((!isset($_SESSION['email']) || !isset($_SESSION['senha']))) {
    
    unset($_SESSION['email']);
    unset($_SESSION['senha']);
    header('Location: login.php');
    exit(); // 
}
$logado = $_SESSION['ID_User'] ?? null;

if ($logado) {
    $cadastro = new Cadastro($logado);
    echo "ID do usuário logado: " . $logado;
} else {
    echo "Usuário não está logado.";
}