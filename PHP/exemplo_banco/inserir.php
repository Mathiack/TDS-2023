<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feito</title>
    <style>
        p {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, 50%);
            text-align: center;
        }
    </style>
</head>
<body>
    <?php
        include "pessoasbanco.class.php";

        $p = new Pessoas_banco();
        
        $nome = $_POST['nome'];
        $p->setNome($nome);
        $email = $_POST['email'];
        $p->setEmail($email);
        $idade = $_POST['idade'];
        $p->setIdade($idade);

        $p->inserirPessoa();

        echo $nome . " ";
        echo $email . " ";
        echo $idade . " ";
?>

</body>
</html>