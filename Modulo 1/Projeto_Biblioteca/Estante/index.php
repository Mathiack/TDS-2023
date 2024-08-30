<?php
    session_start();

    if (!isset($_SESSION['ID_User'])) {
        header('Location: login.php');
        exit();
    }
    
    $ID_User = $_SESSION['ID_User'];

    //var_dump($ID_User); 
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bem-Vindo</title>
    <link rel="stylesheet" href="../style.css">
    <style>
        * {
            font-family: monospace;
        }
        .btnSair {
            font-size: 20px;
            background-color: gray;
            padding: 3px;
            border-radius: 10px;
            margin: 10px;
        }
        div > a.btnSair {
            text-decoration: dashed;
            color: white;
        }
    </style>
</head>
<body>
    <div class="centralizado">
        <div class="titulo">
            <h1>Bem-Vindo</h1>
            <h2>À Sua Estante📚</h2>
        </div>
        <div class="optLivros">
            <div id="addLivro">
                <a href="../Ops/addLivros.php">Adicionar Livro📕</a>
            </div>
            <div id="verLivros">
                <a href="verLivros.php">Ver Livros📖</a>
            </div>
            <div class="btnSair">
                <a href="../Cadastro/sair.php" class="btnSair">Sair</a>
            </div>
        </div>
    </div>
</body>
</html>
