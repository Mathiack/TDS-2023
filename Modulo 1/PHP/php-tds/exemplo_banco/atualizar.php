<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feito</title>
</head>
<body>
    <?php
        include "pessoasbanco.class.php";
        $p = new Pessoas_banco();

        $nome = $_POST['nome'];
        $p->setNome($nome);
        $email = $_POST['email'];
        $p->setIdade($email);
        $nome = $_POST['idade'];
    ?>
</body>
</html>